package Parser;
import app.token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParserContext {
    private static final Map<Character, ParserStrategy> strategyMap = new HashMap();
    static  {
        strategyMap.put(')',new ParCloseParser());
        strategyMap.put('(',new ParOpenParcer());
        strategyMap.put('+',new PlusParser());
        strategyMap.put('*',new MultiplyParser());
        strategyMap.put('/',new DivideParser());
        strategyMap.put('-',new MinusParser());
        strategyMap.put('0', new NumberParser());
        strategyMap.put('1', new NumberParser());
        strategyMap.put('2', new NumberParser());
        strategyMap.put('3', new NumberParser());
        strategyMap.put('4', new NumberParser());
        strategyMap.put('5', new NumberParser());
        strategyMap.put('6', new NumberParser());
        strategyMap.put('7', new NumberParser());
        strategyMap.put('8', new NumberParser());
        strategyMap.put('9', new NumberParser());

    }
    public static ArrayList tokenize(String input)
    {
        ArrayList<token> exp = new ArrayList();
        for(int i=0;i<input.length();i++)
        {

            ParserStrategy strategy= strategyMap.get(input.charAt(i));
            strategy.parse(input,exp,i);

        }
        return exp;
    }

}
