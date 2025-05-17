package Parser;

import app.t_type;
import app.token;

import java.util.ArrayList;

import static Parser.ParserUtil.isOperator;
import static Parser.ParserUtil.push_minus_one;

public class MinusParser implements ParserStrategy {
    @Override
    public int parse(String text, ArrayList<token> exp, int index) {
        if(index==0) push_minus_one(exp);
        //first char is minus, replacting it with -1*
        else if(isOperator(text.charAt(index-1))||exp.get(index-1).token_type==t_type.param)
        {
            token t = new token();
            push_minus_one(exp);
            t.token_type = t_type.operation;
            t.type = '*';

        }
        else
        {
            token t = new token();
            t.token_type = t_type.operation;
            t.type = '-';
            exp.add(t);
        }

        return index;


    }
}
