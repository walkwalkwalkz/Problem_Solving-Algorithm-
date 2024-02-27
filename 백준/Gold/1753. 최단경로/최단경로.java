import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] arr = new ArrayList[V+1];
		for(int i=1;i<V+1;i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			arr[u].add(new int[] {v,w});
		}
		
		int[] res = new int[V+1];
		for(int i=1;i<V+1;i++) {
			res[i] = 200001;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->(o1[1]-o2[1]));
		pq.add(new int[] {K,0});
		
		while(!pq.isEmpty()) {
			int[] vw = pq.poll();
			
			if(res[vw[0]]!=200001) continue;
			res[vw[0]] = vw[1];
			
			for(int i=0,size=arr[vw[0]].size();i<size;i++) {
				if(res[arr[vw[0]].get(i)[0]]==200001) {
					pq.add(new int[] {arr[vw[0]].get(i)[0],arr[vw[0]].get(i)[1]+vw[1]});
				}
			}
		}
		
		for(int i=1;i<V+1;i++) {
			if(res[i]==200001) System.out.println("INF");
			else System.out.println(res[i]);
		}
		
	}

}