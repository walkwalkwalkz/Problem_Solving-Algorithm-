import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<tc+1;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int [N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int res=0;
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					int tmp=0;
					for(int k=0;k<M;k++) {
						for(int l=0;l<M;l++) {
							tmp+=arr[i+k][j+l];
						}
					}
					if(res<tmp) {
						res=tmp;
					}
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}

}