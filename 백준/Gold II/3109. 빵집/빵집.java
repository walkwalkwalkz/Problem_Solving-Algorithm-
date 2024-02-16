import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r,c;
	static char arr[][];
	static int cnt;
	
	static int[] dx = {-1,0,1};
	
	static boolean dfs(int x,int y) {
		if(y==c-1) {
			cnt+=1;
			return true;
		}
		
		for(int i=0;i<3;i++) {
			int xx = x + dx[i];
			int yy = y + 1;
			if((xx>=0)&&(xx<r)&&(yy>=0)&&(yy<c)&&(arr[xx][yy]=='.')) {
				arr[xx][yy]='x';
				if(dfs(xx,yy)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		for(int i=0;i<r;i++) {
			String s = br.readLine();
			for(int j=0;j<c;j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0;i<r;i++) {
			dfs(i,0);
		}
		
		System.out.println(cnt);
	}

}