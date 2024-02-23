import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	static int[] arr;
	static int N,d,k,c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<k;i++) {
			if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
			else map.put(arr[i], 1);
		}
		int sum = map.size();
		int max = 0;
		int flag=0;
		if(!map.containsKey(c)) flag=1;
		
		max = sum + flag;
		
		for(int i=0;i<N-1;i++) {
			if(map.get(arr[i])==1) {
				map.remove(arr[i]);
				sum--;
				if(arr[i]==c) flag=1;
			}else {
				map.put(arr[i], map.get(arr[i])-1);
			}
			
			if(map.containsKey(arr[(i+k)%N])) {
				map.put(arr[(i+k)%N], map.get(arr[(i+k)%N])+1);
			}else {
				map.put(arr[(i+k)%N], 1);
				sum++;
				if(arr[(i+k)%N]==c) flag=0;
				max=Math.max(max, sum+flag);
			}
		}
		
		System.out.println(max);
	}

}