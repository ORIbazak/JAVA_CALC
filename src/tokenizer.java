import java.util.ArrayList;
public class tokenizer {


    public ArrayList<token> tokenize(String str) {
        ArrayList<token> exp=new ArrayList<token>();
        for (int i = 0; i < str.length(); i++)
        {
            token t = new token();
            switch (str.charAt(i))
            {
                case constants.DIVIDE -> {
                    t.token_type = t_type.operation;
                    t.type = Type.divide;
                }
                case constants.MULTIPLY -> {
                    t.token_type = t_type.operation;
                    t.type = Type.multiply;
                    // code block
                    break;
                }
                case constants.MINUS -> {
                    if(i==0)
                    { //first char is minus, replacting it with -1*
                        push_minus_one(exp);
                        t.token_type = t_type.operation;
                        t.type = Type.multiply;
                        break;

                    }
                    else if(isOperator(str.charAt(i-1))||exp.get(i-1).token_type==t_type.param)
                    {
                        push_minus_one(exp);
                        t.token_type = t_type.operation;
                        t.type = Type.multiply;
                        break;
                    }
                    else
                    t.token_type = t_type.operation;
                    t.type = Type.minus;
                    // code block
                    break;
                }
                case constants.PLUS -> {
                    t.token_type =t_type.operation;
                    t.type = Type.plus;
                    // code block
                    break;
                }
                case constants.PARAM_OPEN -> {
                    t.token_type =t_type.param;
                    t.type = Type.open_param;
                    // code block
                    break;
                }
                case constants.PARAM_CLOSE -> {
                    t.token_type =t_type.param;
                    t.type = Type.close_param;
                    break;
                }

                default ->
                {
                    double val = extract_number(str,i);
                    t.value =val;
                    t.token_type = t_type.num;
                    if (val%1 !=0)
                    {
                        i+= String.valueOf(val).length()-1;
                    }
                    else
                    {
                        int intval = (int) val;
                        i += String.valueOf(intval).length()-1;
                    }
                }
            }
            exp.add(t);






        }

        return exp;
    }
    public double extract_number (String str, int index)
    {
        double val=0;
        String temp="";
        while(index<str.length() && !isOperator(str.charAt(index))&&str.charAt(index)!=constants.PARAM_CLOSE)
        {
            temp+= str.charAt(index);
            index++;
        }
        val=Double.parseDouble(temp);

        return val;

    }
    public void push_minus_one(ArrayList<token> exp)
    {
        token t = new token();
        t.token_type = t_type.num;
        t.value=-1;
        exp.add(t);
    }
    public boolean isOperator(char c)
    {
        return (c == constants.DIVIDE || c == constants.MULTIPLY || c == constants.MINUS || c == constants.PLUS );
    }

}