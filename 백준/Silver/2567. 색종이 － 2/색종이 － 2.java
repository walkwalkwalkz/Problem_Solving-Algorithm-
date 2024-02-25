import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr = new int[100][100];
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j=a;j<a+10;j++) {
				for(int k=b;k<b+10;k++) {
					arr[j][k]=1;
				}
			}
		}
		
		int res=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]==1) {
					int cnt=0;
					for(int k=0;k<4;k++) {
						int xx = dx[k] + i;
						int yy = dy[k] + j;
						if((xx>=0)&&(xx<100)&&(yy>=0)&&(yy<100)&&(arr[xx][yy]==1)) cnt++;
					}
					res+=4-cnt;
				}
			}
		}
		
		System.out.println(res);
		
	}

}