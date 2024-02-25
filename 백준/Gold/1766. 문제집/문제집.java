import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] indegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		indegree = new int[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			indegree[B]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1;i<N+1;i++) {
			if(indegree[i]==0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			
			System.out.print(cur+" ");
			
			for(int i=0,size=list[cur].size();i<size;i++) {
				indegree[list[cur].get(i)]--;
				if(indegree[list[cur].get(i)]==0) pq.add(list[cur].get(i));
			}
		}
	}

}