import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,D;
	static int[][] arr;
	static int[] data;
	static int[] dx = {0,-1,0};
	static int[] dy = {-1,0,1};
	static int[][] copyarr;
	static int res=0;
	static int h;
	
	static int[] bfs(int x, int y) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> dq = new ArrayDeque<int[]>();
		dq.offer(new int[] {x-1,y,1});
		visited[x-1][y]=true;
		
		while(!dq.isEmpty()) {
			int[] xy = dq.poll();
			
			if(xy[2]>D) break;
			
			if(copyarr[xy[0]][xy[1]]==1) {
				return new int[] {xy[0],xy[1]};
			}
			
			for(int i=0;i<3;i++) {
				int xx = xy[0] + dx[i];
				int yy = xy[1] + dy[i];
				if((xx>=0)&&(xx<N)&&(yy>=0)&&(yy<M)&&(visited[xx][yy]==false)) {
					dq.offer(new int[] {xx,yy,xy[2]+1});
					visited[xx][yy]=true;
				}
			}
		}
		
		return new int[] {-1,-1};
		
	}
	
	static void move(int k) {
		for(int i=N-2;i>=N-h+k;i--) {
			for(int j=0;j<M;j++) {
				copyarr[i+1][j]=copyarr[i][j];
				copyarr[i][j]=0;
			}
		}
	}
	
	static void combi(int cnt,int start) {
		if(cnt==3) {
			int sum=0;
			copyarr = new int[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					copyarr[i][j] = arr[i][j];
				}
			}
			for(int j=0;j<h;j++) {
				List<int[]> list = new ArrayList<>();
				for(int i=0;i<3;i++) {
					list.add(bfs(N,data[i]));
				}
				
				for(int i=0;i<3;i++) {
					int[] tmp = list.get(i);
					if(tmp[0]==-1) {
						continue;
					}else if(copyarr[tmp[0]][tmp[1]]==1) {
						sum+=1;
						copyarr[tmp[0]][tmp[1]]=0;
					}
				}
				move(j);
			}
			if(res<sum) {
				res=sum;
			}
			return;
		}
		
		for(int i=start;i<M;i++) {
			data[cnt]=i;
			combi(cnt+1,i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		top:
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1) {
					h=N-i;
					break top;
				}
			}
		}

		data = new int[3]; 
		combi(0,0);
		System.out.println(res);
	}

}