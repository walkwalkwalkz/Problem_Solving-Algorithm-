import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int cnt=0;
		int size = s.length();
		for(int i=0;i<size;i++) {
			if(s.charAt(i)=='a') cnt++;
		}
		
		int res=1000;
		for(int i=0;i<size;i++) {
			int tmp=0;
			for(int j=0;j<cnt;j++) {
				if(s.charAt((i+j)%size)=='b') tmp++;
			}
			if(res>tmp) res=tmp;
		}
		System.out.println(res);
	}

}