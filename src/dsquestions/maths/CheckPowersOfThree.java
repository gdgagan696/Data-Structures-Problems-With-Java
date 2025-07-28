package dsquestions.maths;

public class CheckPowersOfThree {

    public static boolean checkPowersOfThree(int n) {
        StringBuilder sb=new StringBuilder();
        while (n>0){
            sb.append(n%3+"");
            n=n/3;
        }
        String res=sb.reverse().toString();
        return  res.contains("2");
    }

    public static void main(String[]args){
        System.out.println(checkPowersOfThree(12));

    }
}
