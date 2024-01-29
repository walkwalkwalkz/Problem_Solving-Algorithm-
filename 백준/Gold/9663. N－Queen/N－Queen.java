import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
백준 N-Queen 9663 G4
시작 시간 : 24-01-29 14:20
종료 시간 : 24-01-29 
실행시간 : --ms


고려사항

*/

public class Main {

	static int[][] data;
	static int N;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		
//		for (boolean[] row : data) {
//            Arrays.fill(row, true);
//        }
		
		dfs(0);
		
		System.out.println(ans);
	}

	private static void dfs(int depth) {
		
		if(depth == N) {
			ans++;
			return;
		}
		
		for(int h = 0; h < N; h++) {
			if(data[depth][h] == 0) {
				
//				data[depth][i]++;
				
				for(int tempDep = depth+1, side = 1; tempDep < N; tempDep++, side++) {
					data[tempDep][h]++;
					if(h-side >= 0) data[tempDep][h-side]++;
					if(h+side < N) data[tempDep][h+side]++;
				}
				
				dfs(depth+1);
				
//				data[depth][i]--;
				
				for(int tempDep = depth+1, side = 1; tempDep < N; tempDep++, side++) {
					data[tempDep][h]--;
					if(h-side >= 0) data[tempDep][h-side]--;
					if(h+side < N) data[tempDep][h+side]--;
				}
			}
		}
	}
}
