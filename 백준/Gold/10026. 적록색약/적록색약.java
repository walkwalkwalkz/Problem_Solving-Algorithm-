import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int N;
	static char[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new char[N][N];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		int res1=0;
		int res2=0;
		
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==false) {
					res1+=1;
					bfs1(i,j);
				}
			}
		}
		
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==false) {
					res2+=1;
					bfs2(i,j);
				}
			}
		}
		
		System.out.println(res1+" "+res2);
	}
	
	static void bfs1(int a, int b) {
		Deque<int[]> dq = new ArrayDeque<int[]>();
		
		dq.add(new int[] {a,b});
		visited[a][b]=true;
		
		while(!dq.isEmpty()) {
			int[] xy = dq.poll();
			
			for(int i=0;i<4;i++) {
				int x = xy[0] + dx[i];
				int y = xy[1] + dy[i];
				if((x>=0)&&(y>=0)&&(x<N)&&(y<N)&&(!visited[x][y])&&(arr[a][b]==arr[x][y])) {
					visited[x][y]=true;
					dq.add(new int[] {x,y});
				}
			}
		}
	}
	
	static void bfs2(int a, int b) {
		Deque<int[]> dq = new ArrayDeque<int[]>();
		
		dq.add(new int[] {a,b});
		visited[a][b]=true;
		
		while(!dq.isEmpty()) {
			int[] xy = dq.poll();
			
			for(int i=0;i<4;i++) {
				int x = xy[0] + dx[i];
				int y = xy[1] + dy[i];
				if((x>=0)&&(y>=0)&&(x<N)&&(y<N)&&(!visited[x][y])&&((arr[a][b]==arr[x][y])||(arr[a][b]=='R'&&arr[x][y]=='G')||(arr[a][b]=='G'&&arr[x][y]=='R'))) {
					visited[x][y]=true;
					dq.add(new int[] {x,y});
				}
			}
		}
	}

}