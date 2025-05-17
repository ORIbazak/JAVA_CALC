package Parser;
import app.token;

import java.util.ArrayList;

public interface ParserStrategy {
     int parse(String text, ArrayList<token> exp, int index);
}
