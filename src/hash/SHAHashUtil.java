package hash;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAHashUtil {

	private MessageDigest md;
	private static SHAHashUtil hashUtil; 

	private SHAHashUtil() {
		try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("cannot initialize SHA-512 hash function", e);
        }
	}
	
	public static SHAHashUtil getInstance() {
		if(hashUtil==null)
			hashUtil=new SHAHashUtil();
		return hashUtil;
	}
	
	public String makeHashLean(File infile) throws IOException {
        RandomAccessFile file = new RandomAccessFile(infile, "r");

        int buffSize = 1024*1024;
        byte[] buffer = new byte[buffSize];
        long read = 0;
        
        long offset = file.length();
        int unitsize;
        while (read < offset) {
            unitsize = (int) (((offset - read) >= buffSize) ? buffSize: (offset - read));
            file.read(buffer, 0, unitsize);
            md.update(buffer, 0, unitsize);
            read += unitsize;
        }

        file.close();
        String hash = new BigInteger(1, md.digest()).toString(16);
        return hash;
   }
	

}
