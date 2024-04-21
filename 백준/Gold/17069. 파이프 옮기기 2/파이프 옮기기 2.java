import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		long[][][] dp = new long[N][N][3];
		for(int i=1;i<N;i++) {
			if(arr[0][i]==1) break;
			dp[0][i][0]=1;
		}
		
		for(int i=1;i<N;i++) {
			for(int j=2;j<N;j++) {
				if(arr[i][j]==1) continue;
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
				dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
				if(arr[i-1][j]==0 && arr[i][j-1]==0) dp[i][j][1] = dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
			}
		}
		
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(Arrays.toString(dp[i][j]));
//			}
//			System.out.println();
//		}
	}
}