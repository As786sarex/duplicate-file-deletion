package driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class COG2001 {

	public static void main(String[] args) throws IOException {
		final BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(reader.readLine());
		HashMap<Integer,Integer> mp=new HashMap<>();
		while(t-->0) {
			long fTotal=0;
			long dTotal=0;
			int n=Integer.parseInt(reader.readLine());
			String[] str=reader.readLine().split(" ");
			int p=Integer.parseInt(str[0]);
			int q=Integer.parseInt(str[1]);
			StringTokenizer kTok=new StringTokenizer(reader.readLine())
					,aTok=new StringTokenizer(reader.readLine())
					,sTok=new StringTokenizer(reader.readLine());
			char[] bs=reader.readLine().toCharArray();
			
			for (int i = 0; i < n; i++) {
				int s=Integer.parseInt(sTok.nextToken());
				mp.put(s, mp.getOrDefault(s, 0)+1);
			}
			for (int i = 0; i < n; i++) {
				int k=Integer.parseInt(kTok.nextToken());
				int a=Integer.parseInt(aTok.nextToken());
				int kpa=k+a;
				if(bs[i]=='1') {
					if(mp.containsKey(kpa)) {
						if(mp.get(kpa)>1)
							mp.put(kpa, mp.get(kpa)-1);
						else
							mp.remove(kpa);
						dTotal += ((long)k*p) + ((long)a*q);
					}
				}
				else {
					if(mp.containsKey(kpa)) {
						if(mp.get(kpa)>1)
							mp.put(kpa, mp.get(kpa)-1);
						else
							mp.remove(kpa);
						fTotal += ((long)k*p) + ((long)a*q);
					}
				}
			}
			
			System.out.println(fTotal>dTotal?"Frost":"DustinKiller");
			mp.clear();
		}
	}

}

/*
2
3
3 2
1 2 3
1 2 4
2 4 6
100
4
4 3
1 2 3 4
4 3 2 1
5 5 5 6
0110
*/
