import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L,C;
	static String[] arr;
	
	static void dfs(int depth, int start, int v, int c, String s) {
		if(depth==L-1&&c<1) return;
		
		if(depth==L) {
			if((v>=1)&&(c>=2)) System.out.println(s);
			return;
		}
		
		for(int i=start;i<C;i++) {
			if(arr[i].equals("a")||arr[i].equals("e")||arr[i].equals("i")||arr[i].equals("o")||arr[i].equals("u")) {
				dfs(depth+1,i+1,v+1,c,s+arr[i]);
			}else {
				dfs(depth+1,i+1,v,c+1,s+arr[i]);
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = br.readLine().split(" ");
		Arrays.sort(arr);
		
		dfs(0,0,0,0,"");

	}

}