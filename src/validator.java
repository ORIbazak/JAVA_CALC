public class validator
{
    public boolean IsValid(String str)
    {
        if(str.charAt(0) == constants.PARAM_CLOSE) return false; //first param close
        if(str.charAt(str.length()-1) == constants.PARAM_OPEN) return false; //last open
        if (isOperator(str.charAt(str.length()-1))) return false; //last is operator
        if(str.charAt(0) == constants.PLUS || // first is operator other then minus
        str.charAt(0) ==constants.MULTIPLY ||str.charAt(0) == constants.DIVIDE) return false;
        int open_counter=0; int close_counter=0;
        for(int index =0; index < str.length()-1; index++)
        {
            char ch1 = str.charAt(index);
            char ch2 = str.charAt(index+1);
            if(ch1 ==constants.DIVIDE && ch2=='0') return false;
            if(ch1 ==constants.PARAM_OPEN&&ch2==constants.PARAM_CLOSE) return false;
            if(ch1==constants.PARAM_OPEN) open_counter++;//count how manby parameters
            if((isOperator(ch1)&&isOperator(ch2))||ch2==constants.MINUS ) return false;
            if(ch2==constants.PARAM_CLOSE) close_counter++;

        }
        if(close_counter!=open_counter) return false;
        return true;
    }

    public boolean isOperator(char c)  {return c==constants.PLUS || c==constants.MINUS || c==constants.DIVIDE || c==constants.MULTIPLY;}

}
