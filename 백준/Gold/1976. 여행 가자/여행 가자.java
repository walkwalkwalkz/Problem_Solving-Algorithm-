import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	static int N,M;
	static int[] parents;
	
	static void make() {
		parents = new int[N+1];
		
		for(int i=1;i<N+1;i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(a==parents[a]) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a<b) {
			parents[b]=a;
		}else {
			parents[a]=b;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		make();
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==1) {
					union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int pre = Integer.parseInt(st.nextToken());
		int flag=0;
		for(int i=1;i<M;i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(find(cur)==find(pre)) {
				pre=cur;
			}else {
				flag=1;
				break;
			}
		}
		
		if(flag==0) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

}