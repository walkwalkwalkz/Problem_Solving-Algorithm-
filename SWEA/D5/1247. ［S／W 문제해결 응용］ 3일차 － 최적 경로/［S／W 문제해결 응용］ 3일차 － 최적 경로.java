import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int N;
	static int[] numbers;
	static int sx,sy,ex,ey;
	static int[] orders;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			
			arr = new int[N][2];
			orders = new int[N];
			for(int i=0; i<N; i++) {
				arr[i][0]=Integer.parseInt(st.nextToken());
				arr[i][1]=Integer.parseInt(st.nextToken());
				orders[i]=i;
			}
			
			res = 2000;
			do {
				dfs(sx,sy,0,0);
			} while (np(orders));
			
			System.out.println("#"+t+" "+res);
		}
	}
	
	static void dfs(int x, int y, int depth, int sum) {
		if(res<sum) {
			return;
		}
		if(depth==N+1) {
			res = sum;
			return;
		}
		
		if(depth==N) {
			dfs(ex,ey,depth+1,sum+Math.abs(x-ex)+Math.abs(y-ey));
		}else {
			dfs(arr[orders[depth]][0],arr[orders[depth]][1],depth+1,sum+Math.abs(x-arr[orders[depth]][0])+Math.abs(y-arr[orders[depth]][1]));
		}
	}
	
	static boolean np(int[] p) {
		int N = p.length - 1;
		
		int i = N;
		while(i>0 && p[i-1]>=p[i]) i--;
		
		if(i==0) return false;
		
		int j = N;
		while(p[i-1]>=p[j]) j--;
		
		swap(p,i-1,j);
		
		int k = N;
		while(i<k) swap(p,i++,k--);
		
		return true;
	}
	
	static void swap(int[] p, int i, int j) {
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}
	

}