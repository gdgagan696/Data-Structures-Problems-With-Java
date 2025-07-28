package dsquestions.strings;

public class DefangingIPAddress {

    public static String defangIPaddr(String address) {
        if (address.length() == 0) {
            return address;
        }
        return address.replaceAll("\\.", "[.]");


    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));

    }
}
