package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class Codec {

    Map<String,String>hm;

    public Codec() {

        this.hm = new HashMap<>();
    }

    public String encode(String longUrl) {
        String hashCode=longUrl.hashCode()+"";
        hm.put(hashCode,longUrl);
        return hashCode;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hm.get(shortUrl);

    }
}
