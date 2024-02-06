import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,r;
	static int[][] arr;
	
	static void rotate() {
		int idx=0;
		int h = n;
		int w = m;
		int x,y;
		while(h>0 && w>0) {
			Queue<Integer> q = new ArrayDeque<Integer>();
			x=idx;
			y=idx;
			q.add(arr[x][y]);
			for(int i=0;i<w-1;i++) {
				y+=1;
				q.add(arr[x][y]);
				
			}
			for(int i=0;i<h-1;i++) {
				x+=1;
				q.add(arr[x][y]);
			}
			for(int i=0;i<w-1;i++) {
				y-=1;
				q.add(arr[x][y]);
			}
			for(int i=0;i<h-2;i++) {
				x-=1;
				q.add(arr[x][y]);
			}
			
			for(int i=0;i<r;i++) {
				q.add(q.poll());
			}
			
			x=idx;
			y=idx;
			arr[x][y]=q.poll();
			for(int i=0;i<w-1;i++) {
				y+=1;
				arr[x][y]=q.poll();
				
			}
			for(int i=0;i<h-1;i++) {
				x+=1;
				arr[x][y]=q.poll();
			}
			for(int i=0;i<w-1;i++) {
				y-=1;
				arr[x][y]=q.poll();
			}
			for(int i=0;i<h-2;i++) {
				x-=1;
				arr[x][y]=q.poll();
			}
			
			idx+=1;
			h-=2;
			w-=2;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotate();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}