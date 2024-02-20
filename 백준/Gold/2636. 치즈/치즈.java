import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<int[]> dq = new ArrayDeque<int[]>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n][m];
		arr = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dq.add(new int[] {0,0});
		visited[0][0] = true;
		int time=0;
		int precnt=0;
		while(!dq.isEmpty()) {
			Queue<int[]> tmpdq = new ArrayDeque<int[]>();
			int cnt=0;
			while(!dq.isEmpty()) {
				int[] xy = dq.poll();
				
				
				for(int i=0;i<4;i++) {
					int x = xy[0] + dx[i];
					int y = xy[1] + dy[i];
					if((x>=0)&&(y>=0)&&(x<n)&&(y<m)&&(!visited[x][y])) {
						visited[x][y]=true;
						if(arr[x][y]==0) {
							dq.add(new int[] {x,y});
						}else {
							cnt+=1;
							tmpdq.add(new int[] {x,y});
						}
					}
				}
			}
			
			if(cnt == 0)
				break;
			
			precnt=cnt;
			time++;

			dq=tmpdq;
			
		
		}

		
		System.out.println(time);
		System.out.println(precnt);
		
	}

}