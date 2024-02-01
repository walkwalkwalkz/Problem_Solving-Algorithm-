import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class SB{
	int st;
	int sb;
	SB(int st, int sb){
		this.st = st;
		this.sb = sb;
	}
}

public class Main {
	
	static List<SB> arr = new ArrayList<SB>();
	static int res = 1000000000;
	static boolean[] isSelected;
	static int n;
	
	static void subset(int idx,int ss, int bb) {
		if(idx == n) {
			if(ss==1&&bb==0) {
				return;
			}
			int tmp = Math.abs(ss-bb);
			if(res>tmp) {
				res=tmp;
			}
			return;
		}
		
		isSelected[idx]=true;
		subset(idx+1,ss*arr.get(idx).st,bb+arr.get(idx).sb);
		isSelected[idx]=false;
		subset(idx+1,ss,bb);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.add(new SB(s,b));
		}
		
		isSelected = new boolean[n];
		subset(0,1,0);
		System.out.println(res);
	}

}