package app;

import java.util.List;

public class validator
{
    static List<Character> tavs = List.of('1','2','3','4','5','6','7','8','9','(',
            '/','+','-','*','.',')');
    public static boolean IsValid(String str)
    {
        if(str.charAt(0) == ')') return false; //first param close
        if(str.charAt(str.length()-1) == '(') return false; //last open
        if (isOperator(str.charAt(str.length()-1))) return false; //last is operator
        if(str.charAt(0) == '+' || // first is operator other then minus
        str.charAt(0) =='*' ||str.charAt(0) == '/') return false;
        int open_counter=0; int close_counter=0;
        for(int index =0; index < str.length()-1; index++)
        {
            char ch1 = str.charAt(index);
            char ch2 = str.charAt(index+1);
            if(ch1 =='/' && ch2=='0') return false;
            if(ch1 =='('&&ch2==')') return false;
            if(ch1=='(') open_counter++;//count how manby parameters
            if((isOperator(ch1)&&isOperator(ch2))&& ch2!='-' ) return false;
            if(ch2==')') close_counter++;

        }
        //check for wrongs tavs
        for(int index =0; index < str.length(); index++)
            if(!tavs.contains(str.charAt(index))) return false;
        if(close_counter!=open_counter) return false;
        return true;
    }

    public static boolean isOperator(char c)  {return c=='+' || c=='-' || c=='/' || c=='*';}

}
