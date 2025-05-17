package Parser;

import app.token;
import app.t_type;

import java.util.ArrayList;

import static java.lang.Character.isDigit;

public class ParOpenParcer implements ParserStrategy {
    @Override
    public int parse(String text, ArrayList<token> exp, int index) {
        if(isDigit(text.charAt(index-1))) {
            token t2 = new token();
            t2.type = '*';
            t2.token_type = t_type.operation;
            exp.add(t2);
        }
        token t=new token() ;
        t.token_type = t_type.param;
        t.type = '(';
        exp.add(t);


            return index;
    }


}
