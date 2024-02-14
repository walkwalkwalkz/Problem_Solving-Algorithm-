import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,r,c;
	
	static boolean Z(int x, int y, int length,int cnt) {
		if(x==r&&y==c) {
			System.out.println(cnt);
			return true;
		}
		
		if((r<x)||(r>=x+length)||(c<y)||(c>=y+length)) {
			return false;
		}
		
		if(length==1) {
			return false;
		}
		
		if(Z(x,y,length/2,cnt)) return true;
		if(Z(x,y+length/2,length/2,cnt+(length/2)*(length/2))) return true;
		if(Z(x+length/2,y,length/2,cnt+(length/2)*(length/2)*2)) return true;
		if(Z(x+length/2,y+length/2,length/2,cnt+(length/2)*(length/2)*3)) return true;
		
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		Z(0,0,1<<N,0);
	}

}