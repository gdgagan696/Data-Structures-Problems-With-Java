package dsquestions.strings;

public class StringToInteger_ATOI {
    public static int myAtoi(String s) {
        long res=0;
        Boolean positive=null;
        s=s.trim();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                res=res*10+(ch-'0');
                if((positive==null || positive) && res>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if((positive!=null && !positive) && -1*res <Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
            else if((ch=='-' || ch=='+') && i==0){
                if(positive!=null)break;
                positive=ch=='+';
            }
            else {
                break;
            }
        }
        res=positive==null || positive?res:-1*res;

        return (int)res;
    }

    public static void main(String[]args){
        System.out.println(myAtoi("42"));
    }
}
