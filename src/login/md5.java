package login;

import java.math.BigInteger;
import java.security.MessageDigest;

public class md5 {
    public static String md(String pw) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pw.getBytes("UTF-8"));
            return new BigInteger(1, m.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
