import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	static int n,m;
	static int[] parents;
	
	static void makeset() {
		parents = new int[n];
		for(int i=0;i<n;i++) {
			parents[i]=i;
		}
		
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		
		return parents[a]=find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return true;
		
		parents[a]=b;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		makeset();
		int res=0;
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(union(a,b)) {
				res=i;
				break;
			}
		}
		System.out.println(res);
	}

}