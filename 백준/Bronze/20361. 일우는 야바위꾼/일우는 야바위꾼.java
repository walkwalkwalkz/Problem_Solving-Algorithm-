import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,X,C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=1;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<C;i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				if(X==A) {
					X=B;
				}else if(X==B) {
					X=A;
				}
			}
			
			System.out.println(X);
		}
	}

}