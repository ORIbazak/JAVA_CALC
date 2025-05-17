package app;
import Parser.ParserContext;
import Solver.SolverContext;

import java.util.ArrayList;

public class calculator {

    public double calc(String str)
    {
        ArrayList exp = ParserContext.tokenize(str);
        token t = Solve(exp);
        return t.value;


    }
    public token Solve(ArrayList<token> exp)
    {
        if(exp.size()==1)
            return exp.getFirst();
        ArrayList<token> lst = new ArrayList<>();
        for(int i=0; i<exp.size(); i++) {
            if (exp.get(i).token_type == t_type.param & exp.get(i).type == ')') {
                int j = i - 1;
                while (exp.get(j).token_type != t_type.param && exp.get(j).type != '(') {
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
        token answer = SolverContext.solve(exp.get(i), exp.get(i + 2),exp.get(i + 1));

        if(exp.size()<=3)  return answer;
        ArrayList<token> temp = new ArrayList<>();
        temp.add(answer);
        temp.addAll(exp.subList(3, exp.size()));
        return calc_plus_minus(temp);

    }




    public token calc_kefel_hiluk(ArrayList<token> exp)
    {
        if(exp.size()==1) return exp.getFirst();
        int i =0;
        ArrayList<token> temp = new ArrayList<>();
        while(i<exp.size()-1)
        {
            if (exp.get(i+1).token_type== t_type.operation){
            if(exp.get(i+1).type== '/'||exp.get(i+1).type== '*') {
                for(int a =0;a<i;a++) { temp.add(exp.get(a)); }

                token answer = SolverContext.solve(exp.get(i), exp.get(i + 2),exp.get(i + 1));
                temp.add(answer);
                if (i + 3 < exp.size())  temp.addAll(exp.subList(i + 3, exp.size()));
                return calc_kefel_hiluk(temp);
            }
            }
            i++;
        }
        return calc_plus_minus(exp);

    }
}
