import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] arr;
	
	static void makeset() {
		arr = new int[n+1];
		for(int i=1;i<n+1;i++) {
			arr[i]=i;
		}
	}
	
	static int find(int a) {
		if(arr[a]==a) return a;
		
		return arr[a]=find(arr[a]);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return false;
		
		arr[a]=b;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		makeset();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		int[] countarr = new int[n+1];
		for(int i=1;i<n+1;i++) {
			countarr[find(i)]++;
		}
		
		long res=1;
		for(int c : countarr) {
			if(c!=0) res=(res*c)%1000000007;
		}
		System.out.println(res);
	}

}