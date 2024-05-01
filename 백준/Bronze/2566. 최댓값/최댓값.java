import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int maxVal = -1;
		int r = 0;
		int c = 0;
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n>maxVal) {
					maxVal = n;
					r=i;
					c=j;
				}
			}
		}
		
		System.out.println(maxVal);
		System.out.println((r+1)+" "+(c+1));
	}

}