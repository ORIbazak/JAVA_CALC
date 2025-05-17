package Parser;

import app.t_type;
import app.token;

import java.util.ArrayList;

public class ParCloseParser implements ParserStrategy {
    @Override
    public int parse(String text, ArrayList<token> exp, int index) {
        token t=new token() ;
        t.token_type = t_type.param;
        t.type = ')';
        exp.add(t);
        return index;
    }
}
