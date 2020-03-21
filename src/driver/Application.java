package driver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fileutil.FileUtils;
import hash.SHAHashUtil;

public class Application {
	private static final String path="D:\\digitalImageProcessing";
	private final SHAHashUtil hashUtil;
	
	
	public Application() {
		hashUtil=SHAHashUtil.getInstance();
	}


	public static void main(String[] args) throws IOException {
		
		List<String> deletedFiles=new Application().delete(path);
		System.out.println(deletedFiles.size()+" Duplicate Deleted Files : \n");
		for(String s : deletedFiles) {
			System.out.println(s);
		}
	}
	
	
	public List<String> delete(final String path) throws IOException {
		List<List<String>> allFilesList=FileUtils.getPossibleDuplicates(path);
		System.out.println("Scan completed");
		List<String> deletedFiles=new ArrayList<>();
		for(List<String> stringList:allFilesList) {
			for (int i = 0; i < stringList.size()-1; i++) {
				if(stringList.get(i)==null)
					continue;
				File f1=new File(stringList.get(i));
				String f1Digest=hashUtil.makeHashLean(f1);
				for(int j=i+1;j<stringList.size();j++) {
					if(stringList.get(j)==null)
						continue;
					File f2=new File(stringList.get(j));
					
					String f2Digest=hashUtil.makeHashLean(f2);
					if(f1Digest.equals(f2Digest)) {
						f2.delete();
						deletedFiles.add(stringList.get(j));
						stringList.set(j, null);
					}
				}
			}
		}
		return deletedFiles;
	}
}
