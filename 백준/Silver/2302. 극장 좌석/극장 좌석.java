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
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		
		int[] dp = new int[N+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<N+1;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		int res=1;
		int idx=0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			res*=dp[tmp-idx-1];
			idx=tmp;
		}
		res*=dp[N-idx];
		System.out.println(res);
		
	}

}