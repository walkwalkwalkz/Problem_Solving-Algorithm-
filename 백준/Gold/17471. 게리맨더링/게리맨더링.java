import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] pop;
	static List<Integer>[] arr;
	static int checked[];
	static int res = 10001;
	static int total;
	static int[] parents;
	
	static void makeset() {
		parents = new int[N];
		for(int i=0;i<N;i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(a==parents[a]) return a;
		
		return parents[a]=find(parents[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a<b) parents[a]=b;
		else parents[b]=a;
	}
	
	static void combi(int idx, int start, int cnt) {
		if(idx==0) {
			if(res>Math.abs(cnt-(total-cnt))) {
				makeset();
				
				for(int i=0;i<N;i++) {
					for(int j=0,size=arr[i].size();j<size;j++) {
						if(checked[i]==checked[arr[i].get(j)]) {
							union(i,arr[i].get(j));
						}
					}
				}
				
				int tmp=0;
				for(int i=0;i<N;i++) {
					if(i==parents[i]) tmp++;
				}
				
				if(tmp==2) {
//					System.out.println(res);
//					System.out.println(Arrays.toString(checked));
//					System.out.println(Arrays.toString(parents));
					res=Math.abs(cnt-(total-cnt));
				}
			}
			
			return;
		}
		
		for(int i=start;i<N;i++) {
			checked[i]=1;
			combi(idx-1,i+1,cnt+pop[i]);
			checked[i]=0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		pop = new int[N];
		checked = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pop[i]=Integer.parseInt(st.nextToken());
			total+=pop[i];
		}
		
		arr = new ArrayList[N];
		for(int i=0;i<N;i++) {
			arr[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for(int j=0;j<m;j++) {
				int num = Integer.parseInt(st.nextToken())-1;
				arr[i].add(num);
			}
		}
		
		for(int i=1;i<N;i++) {
			combi(i,0,0);
		}
		
		if(res==10001) System.out.println(-1);
		else System.out.println(res);
	}
}