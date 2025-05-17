package Parser;

import app.t_type;
import app.token;

import java.util.ArrayList;

public class ParserUtil {
    public static double extract_number (String str, int index)
    {
        double val=0;
        String temp="";
        while(index<str.length() && !isOperator(str.charAt(index))&&!isParam(str.charAt(index)))
        {
            temp+= str.charAt(index);
            index++;
        }
        val=Double.parseDouble(temp);

        return val;

    }
    public static boolean isOperator(char c)
    {
        return (c == '/' || c == '*' || c =='+'|| c=='-' );
    }
    public static boolean isParam(char c)
    {
        return (c == '(' || c == ')');
    }

    public static void push_minus_one(ArrayList<token> exp)
    {
        token t1 = new token();
        t1.token_type = t_type.num;
        t1.value=-1;
        token t2 = new token();
        exp.add(t1);
        t2.token_type = t_type.operation;
        t2.type = '*';
        exp.add(t2);
    }
}
