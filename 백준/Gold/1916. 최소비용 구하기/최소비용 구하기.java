import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int a,b,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int[] visited = new int[N+1];
		List<int []>[] arr = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr[a].add(new int[] {b,c});
		}
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		PriorityQueue<int []> pq = new PriorityQueue<>((a1,a2) -> (a1[1]-a2[1]));
		pq.add(new int[] {a,1});
		
		while(!pq.isEmpty()) {
			int[] x = pq.poll();
			if(visited[x[0]]!=0) continue;
			
			visited[x[0]]=x[1];
			if(x[0]==b) {
				System.out.println(x[1]-1);
				break;
			}
			
			for(int[] xx : arr[x[0]]) {
				if(visited[xx[0]]==0) {
					pq.add(new int[] {xx[0],x[1]+xx[1]});
				}
			}
		}
	}

}