import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,bit;
	static int stn=(1<<10)-1;
	
	static void cal(int tmp) {
		while(tmp>0) {
			bit|=1<<(tmp%10);
			tmp=tmp/10;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int turn = Integer.parseInt(st.nextToken());
		for(int t=1;t<=turn;t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			bit=0;
			int num = 1;
			while(true) {
				int tmp = n*num;
				cal(tmp);
				if(bit==stn) {
					sb.append("#"+t+" "+tmp+"\n");
					break;
				}
				num++;
			}
		}
		System.out.println(sb);
	}

}