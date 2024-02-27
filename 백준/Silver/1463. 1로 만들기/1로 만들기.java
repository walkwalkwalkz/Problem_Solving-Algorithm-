import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[1000001];
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=4;i<=N;i++) {
			int tmp = dp[i-1];
			if(i%2==0) {
				tmp = Math.min(tmp, dp[i/2]);
			}
			if(i%3==0) {
				tmp = Math.min(tmp, dp[i/3]);
			}
			dp[i]=tmp+1;
		}
		System.out.println(dp[N]);
	}

}