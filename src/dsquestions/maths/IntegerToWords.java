package dsquestions.maths;

import java.util.*;

public class IntegerToWords {
    Map<Integer, String> ones = new HashMap<>() {{
        put(1, "One");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
        put(10, "Ten");
        put(11, "Eleven");
        put(12, "Twelve");
        put(13, "Thirteen");
        put(14, "Fourteen");
        put(15, "Fifteen");
        put(16, "Sixteen");
        put(17, "Seventeen");
        put(18, "Eighteen");
        put(19, "Nineteen");
    }};
    Map<Integer, String> tens = new HashMap<>() {{
        put(20, "Twenty");
        put(30, "Thirty");
        put(40, "Forty");
        put(50, "Fifty");
        put(60, "Sixty");
        put(70, "Seventy");
        put(80, "Eighty");
        put(90, "Ninety");
    }};

    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        String[]postfix={"", " Thousand"," Million"," Billion"};
        int i=0;
        List<String> result=new ArrayList<>();
        while (num>0){
            int digits=num%1000;
            String temp=getString(digits);
            if(!temp.isEmpty()){
                temp=temp+postfix[i];
                result.add(temp);
            }

            num=num/1000;
            i++;
        }
        Collections.reverse(result);
        return String.join(" ",result);

    }
    public String getString(int num){
        List<String>result=new ArrayList<>();
        int hundreds=num/100;
        if(hundreds>0){
            result.add(ones.get(hundreds)+" Hundred");
        }
        int lastTwo=num%100;
        if(lastTwo>=20){
            int ten=lastTwo/10;
            int one=lastTwo%10;
            result.add(tens.get(ten*10));
            if(one>0){
                result.add(ones.get(one));
            }
        }
        else if(lastTwo!=0) {
            result.add(ones.get(lastTwo));
        }
        return String.join(" ",result);

    }
}
