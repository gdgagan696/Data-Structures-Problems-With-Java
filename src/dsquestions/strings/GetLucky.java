package dsquestions.strings;

public class GetLucky {
    public static int getLucky(String s, int k) {
        String num="";
        for (char c:s.toCharArray()){
            num+=c-'a'+1;
        }
        while (k-->0){
            long sum=0;
            for (char ch:num.toCharArray()){
                sum+=Integer.parseInt(ch+"");
            }
            num=sum+"";
        }
        return Integer.parseInt(num);
    }

    public static void main(String[] args) {

        System.out.println(getLucky("leetcode",2));
    }

}
