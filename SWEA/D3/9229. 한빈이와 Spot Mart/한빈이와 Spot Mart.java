import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] arr;
	static int res;
	static int n,m;
	
	static void comb(int depth, int start, int sum) {
		if(sum>m) return;
		if(depth==2) {
			if(sum>res) {
				res=sum;
			}
			return;
		}
		
		for(int i=start;i<n;i++) {
			comb(depth+1,i+1,sum+arr[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			res = -1;
			comb(0,0,0);
			System.out.println("#"+t+" "+res);
			
		}
	}

}