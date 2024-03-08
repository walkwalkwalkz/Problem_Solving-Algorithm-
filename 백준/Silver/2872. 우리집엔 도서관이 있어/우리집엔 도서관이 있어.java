import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int tmp=n;
		int res=0;
		for(int i=n-1;i>=0;i--) {
			if(arr[i]==tmp) {
				res++;
				tmp--;
			}
		}
		System.out.println(n-res);
	}

}