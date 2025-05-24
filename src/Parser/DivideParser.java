package Parser;

import app.t_type;
import app.token;

import java.util.ArrayList;

public class DivideParser implements ParserStrategy {

    @Override
    public int parse(String text, ArrayList<token> exp, int index) {
        token t= new token();
        t.type = '/';
        t.token_type = t_type.operation;
        exp.add(t);
        return index;
    }
}
