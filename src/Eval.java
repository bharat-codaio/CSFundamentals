import java.util.Stack;

/**
 * Created by bharatbatra on 12/31/15.
 */
/*
 Write a function called eval, which takes a string and   returns a boolean. This string is allowed 6 different characters: 0, 1, &, |, (, and ). Eval should evaluate the string as a boolean expression, where 0 is false, 1 is true, & is an and, and | is an or. An example string might look like "(0 | (1 | 0)) & (1 & ((1 | 0) & 0))"
Tags:	technical

 */
public class Eval
{
    public static void main(String args[])
    {
        String exp = "(1|(0|0)&(1&1)&1)";//(1&0)
        System.out.print(exp + "=");
        System.out.print(evaluate(exp));

    }

   static boolean evaluate(String exp) {
        boolean isValid = false;
        Stack evalStack = new Stack();
        for (int i = 0; i < exp.length(); i++) {
            char curr =exp.charAt(i);
            if(curr!=')') {
                evalStack.push(curr);
                System.out.println(evalStack.toString());
            }
            else
            {
                String midExp = "";
                while(curr!='(')
                {
                    System.out.println(evalStack.toString());
                    curr = (char)evalStack.pop();

                    midExp+=curr;
                }
                try {
                    evalStack.push(returnVal(midExp));
                }catch(Exception e)
                {
                    e.printStackTrace();
                }



            }


        }
       if(evalStack.size()==1)
       {
           if(evalStack.pop()=='1')
           {
               isValid = true;
           }
       }
        return isValid;
    }

    static char returnVal(String exp) throws Exception
    {
        int t1 = -1;
        int t2 = -1;
        int result = -1;
        char op = '#';

        for(int i = 0; i<exp.length();i++)
        {
            char curr = exp.charAt(i);


            if( curr == '&' || curr == '|')
            {
                op = curr;
            }

            if( curr == '0' || curr == '1')
            {
                if(t1 == -1 )
                {
                    if(curr =='1')
                        t1 = 1;
                    else
                        t1 = 0;
                }
                else
                {
                    if(curr =='1')
                        t2 = 1;
                    else
                        t2 = 0;
                }
            }
            if( t1!=-1 && t2!=-1)
            {
                System.out.println("Evaluating mid EXP" + exp);
                System.out.println("t1 : " + t1 + " t2 : " + t2);

                if(op == '&')
                {
                    t1 = result = t1 * t2;
                }
                else if(op == '|')
                {
                    result = t1 + t2;
                    t1 = (result>0)?1:0;
                }

            }
        }
        if(result == 0)
        {
            return '0';
        }
        else if(result >0)
        {
            return '1';
        }
        else throw new Exception("Unable to Parse");

    }


}
