package dsquestions.Dsstudy1;

public class TotalMoney {
    public static int totalMoney(int n) {
        int total=1;
        int start=1;
        int prev=1;
        for (int i=2;i<=n;i++){
            if(i%7==1){
                start=prev+1;
                prev++;
                total += start;
            }
            else {
                total += ++start;
            }

        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }
}
