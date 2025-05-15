import java.util.ArrayList;

public class calculator {
    tokenizer  tnizer = new tokenizer();

    public double calc(String str)
    {
        ArrayList<token> exp = tnizer.tokenize(str);
        token t = Solve(exp);
        return t.value;


    }
    public token Solve(ArrayList<token> exp)
    {
        if(exp.size()==1)
            return exp.getFirst();
        ArrayList<token> lst = new ArrayList<>();
        for(int i=0; i<exp.size(); i++) {
            if (exp.get(i).token_type == t_type.param & exp.get(i).type == Type.close_param) {
                int j = i - 1;
                while (exp.get(j).token_type != t_type.param && exp.get(j).type != Type.open_param) {
                    j--;
                }
                    for (int a = 0; a < j; a++) { lst.add(exp.get(a)); }
                    ArrayList<token> temp = new ArrayList<>();
                    for(int b= j+1;b<i; b++) { temp.add(exp.get(b)); }
                    lst.add(Solve(temp));
                    for(int c = i+1;c<exp.size();c++) { lst.add(exp.get(c)); }
                return Solve(lst);

            }
        }
        return calc_kefel_hiluk(exp);
    }
    public token calc_plus_minus(ArrayList<token> exp)
    {
        if(exp.size()==1) return exp.getFirst();
        int i =0;
        double ans = 0;
        token answer = new token();
        answer.token_type=t_type.num;
        token first = exp.get(0);
        token second = exp.get(2);
        token op = exp.get(1);
        ans = calc_value(first,second,op);
        answer.value=ans;
        if(exp.size()<=3)  return answer;
        ArrayList<token> temp = new ArrayList<>();
        temp.add(answer);
        temp.addAll(exp.subList(3, exp.size()));
        return calc_plus_minus(temp);

    }
    public double calc_value(token t1, token t2,token op)
    {
        double ans = 0;
        Type opType = op.type;
        double val1 = t1.value;
        double val2 = t2.value;
        ans = switch (opType) {
            case plus -> val1 + val2;
            case minus -> val1 - val2;
            case multiply -> val1 * val2;
            case divide -> val1 / val2;
            default -> ans;
        };
        return ans;
    }
    public token calc_kefel_hiluk(ArrayList<token> exp)
    {
        if(exp.size()==1) return exp.getFirst();
        int i =0;
        ArrayList<token> temp = new ArrayList<>();
        while(i<exp.size()-1)
        {
            if (exp.get(i+1).token_type==t_type.operation){
            if(exp.get(i+1).type==Type.divide||exp.get(i+1).type==Type.multiply) {
                for(int a =0;a<i;a++) { temp.add(exp.get(a)); }
                token first = exp.get(i);
                token second = exp.get(i + 2);
                token op = exp.get(i + 1);
                double ans = calc_value(first, second, op);
                token answer = new token();
                answer.token_type = t_type.num;
                answer.value = ans;
                temp.add(answer);
                if (i + 3 < exp.size())
                    temp.addAll(exp.subList(i + 3, exp.size()));
                return calc_kefel_hiluk(temp);
            }
            }
            i++;
        }
        return calc_plus_minus(exp);

    }
}
