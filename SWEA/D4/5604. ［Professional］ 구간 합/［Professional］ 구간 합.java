import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	static HashMap<Long, Long> hm = new HashMap<>();
	
	static long f(long n) {
		if(hm.containsKey(n)) return hm.get(n);
		
		long V = (long) Math.pow(10, (Long.toString(n)).length()-1);
		long G = n/V*(n%V+1)+f(n%V);
		hm.put(n,f(n-1-n%V)+G);
		
		return hm.get(n);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long tmpsum=0L;
		for(long i=0;i<10;i++) {
			tmpsum+=i;
			hm.put(i, tmpsum);
		}
		
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			long res=0;
			if(a==0) {
				res = f(b) - f(a);
			}else {
				res = f(b) - f(a-1);
			}
			
			System.out.println("#"+t+" "+res);
		}

	}

}