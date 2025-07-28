package dsquestions.strings;

public class ComplexNumberMultiply {
    public static String complexNumberMultiply(String a, String b) {

        int real=0;
        int imaginary=0;
        int plusIndex1=a.indexOf("+");
        int iotaIndex1=a.indexOf("i");
        int plusIndex2=b.indexOf("+");
        int iotaIndex2=b.indexOf("i");
        int r1=Integer.parseInt(a.substring(0,plusIndex1))*Integer.parseInt(b.substring(0,plusIndex2));
        int r2=Integer.parseInt(a.substring(plusIndex1+1,iotaIndex1))*Integer.parseInt(b.substring(plusIndex2+1,iotaIndex2));
        real=r1-r2;
        int i1=Integer.parseInt(a.substring(0,plusIndex1))*Integer.parseInt(b.substring(plusIndex2+1,iotaIndex2));
        int i2=Integer.parseInt(a.substring(plusIndex1+1,iotaIndex1))*Integer.parseInt(b.substring(0,plusIndex2));
        imaginary=i1+i2;
        String result=real+"+"+imaginary+"i";
        return result;

    }

    public static void main(String[]args){
        System.out.println(complexNumberMultiply("1+1i","1+1i"));
        System.out.println(complexNumberMultiply("1+-1i","1+-1i"));

    }
}
