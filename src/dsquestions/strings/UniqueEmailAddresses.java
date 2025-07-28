package dsquestions.strings;

import java.util.HashSet;

public class UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {
        HashSet<String>hashSet=new HashSet<>();
        for(String email:emails){
            String atTheRatePart=email.substring(email.indexOf("@"));
            int index=email.indexOf("+");
            String tempEmail="";
            if(index>-1) {
                tempEmail = email.substring(0, index).replaceAll("\\.", "").concat(atTheRatePart);
            }
            else{
                tempEmail=email.substring(0,email.indexOf("@")).replaceAll("\\.","").concat(atTheRatePart);
            }
            if(!hashSet.contains(tempEmail)){
                hashSet.add(tempEmail);
            }
        }
        return hashSet.size();

    }

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"}));

    }
}
