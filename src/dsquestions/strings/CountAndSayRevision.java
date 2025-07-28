package dsquestions.strings;

public class CountAndSayRevision {
    public static String countAndSay(int n) {
        String digits=String.valueOf(n);
        StringBuilder result=new StringBuilder();
        int i=0;
        int count=1;
        while (i<digits.length()-1){
            if(digits.charAt(i)==digits.charAt(i+1)){
                int j=i+1;
                while (digits.charAt(i)==digits.charAt(j)){
                    j++;
                    count++;
                }
                result.append(count).append(digits.charAt(i));
                i=j;
                count=1;
            }
            else {
                result.append(digits.charAt(i));
                i++;
            }
        }
        if(count==1){
            result.append(digits.charAt(digits.length()-1));
        }
        else {
            result.append(count).append(digits.charAt(digits.length()-1));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
