package dsquestions.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {

    private int timeToLive;
    Map<String, Integer> hm;

    public AuthenticationManager(int timeToLive) {

        this.timeToLive = timeToLive;
        hm = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {

        hm.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {

        if (!hm.containsKey(tokenId)) {
            return;
        }
        if (hm.get(tokenId) <= currentTime) {
            return;
        }
        hm.put(tokenId, currentTime + timeToLive);

    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (int time : hm.values()) {
            if (time > currentTime) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        AuthenticationManager authenticationManager=new AuthenticationManager(5);
        authenticationManager.renew("aaa",1);
        authenticationManager.generate("aaa",2);
        System.out.println(authenticationManager.countUnexpiredTokens(6));
        authenticationManager.generate("bbb",7);
        authenticationManager.renew("aaa",8);
        authenticationManager.renew("bbb",10);
        System.out.println(authenticationManager.countUnexpiredTokens(15));
    }

}
