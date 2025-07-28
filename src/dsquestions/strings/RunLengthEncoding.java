package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class RunLengthEncoding {
    public String encode(String str)
    {
        int n = str.length();
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            result.append(str.charAt(i)).append(count);
        }
        return result.toString();
    }
    public static void main(String[]args){

    }
}
