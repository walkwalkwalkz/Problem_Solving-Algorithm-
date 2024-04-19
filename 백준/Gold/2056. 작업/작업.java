import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		List<Integer>[] arr = new ArrayList[N+1];
		int[] time = new int[N+1];
		int[] indegree = new int[N+1];
		Deque<Integer> dq = new ArrayDeque<>();
		int[] visited = new int[N+1];
		for(int i=1;i<N+1;i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i]=t;
			
			int cnt = Integer.parseInt(st.nextToken());
			indegree[i]=cnt;
			if(cnt==0) {
				dq.add(i);
				visited[i]=t;
			}
			else {
				for(int j=0; j<cnt;j++) {
					int tmp = Integer.parseInt(st.nextToken());
					arr[tmp].add(i);
				}
			}
		}

		while(!dq.isEmpty()) {
			int x = dq.poll();
			for(int a : arr[x]) {
				if(visited[a]<visited[x]+time[a]) visited[a]=visited[x]+time[a];
				indegree[a]--;
				if(indegree[a]==0) {
					dq.add(a);
				}
			}

		}
		
		int res=0;
		for(int v : visited) {
			if (res<v) res=v;
		}
		System.out.println(res);
	}

}