import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int M,N,K;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static ArrayList<Integer> area = new ArrayList<>();
	
	static void bfs(int x, int y) {
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {x,y});
		arr[x][y]=1;
		
		int tmp=0;
		while(!dq.isEmpty()) {
			int[] xy = dq.poll();
			tmp++;
			
			for(int i=0;i<4;i++) {
				int xx = xy[0] + dx[i];
				int yy = xy[1] + dy[i];
				if((0<=xx)&&(N>xx)&&(0<=yy)&&(M>yy)&&(arr[xx][yy]==0)) {
					arr[xx][yy]=1;
					dq.add(new int[] {xx,yy});
				}
			}
		}
		
		area.add(tmp);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			for(int j=x1;j<x2;j++) {
				for(int k=y1;k<y2;k++) {
					arr[j][k]=1;
				}
			}	
		}
	
		int res=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0) {
					bfs(i,j);
				}
			}
		}	
		Collections.sort(area);
		System.out.println(area.size());
		for(int i=0,size=area.size();i<size;i++) {
			System.out.print(area.get(i)+" ");
		}
		
	}

}