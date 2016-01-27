import java.util.HashMap;

/**
 * Created by bharatbatra on 1/3/16.
 */
public class StringQuestions {

    static HashMap<String, String> dictionary = new HashMap<>();

    public static void main(String args[])
    {
        String word = "alchemy";
        dictionary.put("alchemy", "+");
        dictionary.put("lchemya", "+");
        dictionary.put("chemlay", "+");
        dictionary.put("hemylac", "+");
        dictionary.put("mechy", "+");


        checkAllCombos(word);

    }

    public static void checkAllCombos(String word)
    {
        String feedback = wordCombos("", word);
    }

    public static String wordCombos(String pre, String rem)
    {
        String ret;
        if(rem.length()<2)
        {
            ret = pre + rem;
            if(dictionary.containsKey(ret))
                System.out.println(ret);
            return ret;
        }
        for (int i = 0; i<rem.length(); i++)
        {
            String newPre= pre + rem.charAt(i);
            String temp = rem.substring(0,i) + rem.substring(i+1,rem.length());
            ret = wordCombos(newPre , temp);
        }
        return "done";

    }
}
