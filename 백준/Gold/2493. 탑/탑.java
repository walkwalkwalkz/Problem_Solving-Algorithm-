import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> s = new Stack<Integer>();
		int[] res = new int[n];
		s.add(n-1);
		
		for(int i=n-2;i>=0;i--) {
			while((!s.isEmpty())&&arr[s.peek()]<=arr[i]) {
				res[s.pop()]=i+1;
			}
			s.add(i);
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(res[i]+" ");
		}
	}

}