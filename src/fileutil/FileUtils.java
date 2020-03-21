package fileutil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FileUtils {
	
	public static List<List<String>> getPossibleDuplicates(final String path){
		HashMap<Long,List<String>> allFiles=doBfsAndStore(path);
		if(allFiles==null)
			return null;
		Set<Long> keys=allFiles.keySet();
		List<List<String>> duplicateKeys=new ArrayList<>();
		for(Long key:keys) {
			if(allFiles.get(key).size()>=2)
				duplicateKeys.add(allFiles.get(key));
		}
		return duplicateKeys;
	}
	
	private static HashMap<Long,List<String>> doBfsAndStore(final String BASE_PATH){
		Queue<File> queue=new LinkedList<>();
		HashMap<Long,List<String>> hMap=new HashMap<>();
		File root=new File(BASE_PATH);
		if(!root.exists())
			return null;
		queue.add(root);
		while(!queue.isEmpty()) {
			File file=queue.poll();
			if(file.isFile()) {
				if(hMap.containsKey(file.length())) {
					hMap.get(file.length()).add(file.getPath());
				}
				else {
					List<String> s=new ArrayList<>();
					s.add(file.getPath());
					hMap.put(file.length(), s);
				}
			}
			else {
				File[] filleArray=file.listFiles();
				if(filleArray!=null) {
					for(File fileItem:filleArray)
						queue.add(fileItem);
				}
			}
		}
		return hMap;
	}

}
