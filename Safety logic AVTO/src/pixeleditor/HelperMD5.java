package pixeleditor;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public class HelperMD5 {
	
	public static String md5(String s) {
		   try {
		        final MessageDigest md5 = MessageDigest.getInstance("MD5");
		        md5.reset();
		        final byte[] array = md5.digest(s.getBytes(Charset.forName("UTF8")));
		        StringBuilder sb = new StringBuilder();
		        for (int i = 0; i < array.length; i++) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } 
		   catch (java.security.NoSuchAlgorithmException ex) {
			   ex.printStackTrace();
		   }
		    return null;
		}
 

}
