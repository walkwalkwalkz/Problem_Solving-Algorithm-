import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int cnt=0;
	
	static void dfs(int d, int x, int y) {
		if(x==N-1 && y==N-1) {
			cnt+=1;
			return;
		}
		
		if(d==0) {
			if(y+1<N && arr[x][y+1]==0) {
				dfs(0,x,y+1);
				if(x+1<N && arr[x+1][y]==0 && arr[x+1][y+1]==0) dfs(2,x+1,y+1);
			}
		}else if(d==1) {
			if(x+1<N && arr[x+1][y]==0) {
				dfs(1,x+1,y);
				if(y+1<N && arr[x][y+1]==0 && arr[x+1][y+1]==0) dfs(2,x+1,y+1);
			}
		}else {
			if(y+1<N && arr[x][y+1]==0) dfs(0,x,y+1);
			if(x+1<N && arr[x+1][y]==0) dfs(1,x+1,y);
			if(x+1<N && y+1<N && arr[x+1][y]==0 && arr[x][y+1]==0 && arr[x+1][y+1]==0) dfs(2,x+1,y+1);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,1);
		
		System.out.println(cnt);
	}

}