package Parser;

import app.t_type;
import app.token;

import java.util.ArrayList;

import static Parser.ParserUtil.extract_number;

public class NumberParser implements ParserStrategy {
    @Override
    public int parse(String text, ArrayList<token> exp, int index) {
        token t = new token();
        double val =  extract_number(text,index);
        t.value =val;
        t.token_type = t_type.num;
        if (val%1 !=0)
        {
            index+= String.valueOf(val).length()-1;
        }
        else
        {
            int intval = (int) val;
            index += String.valueOf(intval).length()-1;
        }
        exp.add(t);
        return index;
    }
}
