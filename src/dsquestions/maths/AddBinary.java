package dsquestions.maths;

public class AddBinary {
    public static String addBinary(String a, String b) {

        StringBuilder result=new StringBuilder();
       int i=a.length()-1;
       int j=b.length()-1;
       int carry=0;
       while (i>=0 || j>=0){
           char ch1=i>=0?a.charAt(i--):'0';
           char ch2=j>=0?b.charAt(j--):'0';
           int x=Integer.parseInt(ch1+"");
           int y=Integer.parseInt(ch2+"");
           int sum = x + y + carry;
           if(sum>1){
               carry=1;
               result.append(sum%2);
           }
           else {
               carry=0;
               result.append(sum);
           }
       }
       if (carry>0){
           result.append(carry);
       }
       return result.reverse().toString();
    }
    public static void main(String[]args){
        System.out.println(addBinary("11","1"));
    }
}
