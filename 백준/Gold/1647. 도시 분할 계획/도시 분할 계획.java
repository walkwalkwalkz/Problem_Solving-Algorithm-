import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] parents;
	static ArrayList<int[]> list;
	
	static void make() {
		parents = new int[N+1];
		for(int i=0;i<N+1;i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(a==parents[a]) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return false;
		
		parents[a]=b;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {a,b,c});
		}
		
		make();
		Collections.sort(list, (o1,o2)->(o1[2]-o2[2]));
		int cnt=0;
		int res=0;
		for(int i=0,size=list.size();i<M;i++) {
			if(union(list.get(i)[0],list.get(i)[1])) {
				cnt+=1;
				res+=list.get(i)[2];
				
				if(cnt==N-2) break;
			}
		}
		
		if(N==2) res=0;
		System.out.println(res);
		
	}

}