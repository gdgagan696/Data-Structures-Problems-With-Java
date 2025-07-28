package dsquestions.strings;

import java.util.Map;

public class CompareVersionRevision {
    public static int compareVersion(String version1, String version2) {
        String []ver1=version1.split("\\.");
        String []ver2=version2.split("\\.");
        int n= Math.max(ver1.length,ver2.length);
        for(int i=0;i<n;i++){
            int num1=0;
            int num2=0;
            if(i>=ver1.length){
                num1=0;
            }
            else {
                num1=Integer.parseInt(ver1[i]);
            }
            if(i>=ver2.length){
                num2=0;
            }
            else {
                num2=Integer.parseInt(ver2[i]);
            }
            if(num1>num2){
                return 1;
            }
            else if(num1<num2){
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01","1.001"));
        System.out.println(compareVersion("1.0","1.0.0"));
        System.out.println(compareVersion("0.1","1.1"));
    }
}
