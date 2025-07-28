package dsquestions.arrays;

public class CountSeniors {
    public static int countSeniors(String[] details) {
        int res=0;
        for (String str:details){
            int age=Integer.parseInt(str.substring(11,13));
            if(age>60)res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String[]details={"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(countSeniors(details));

    }
}
