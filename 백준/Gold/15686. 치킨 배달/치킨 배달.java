import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] arr;
	static List<Point> tmp = new ArrayList<>();
	static List<Point> home = new ArrayList<>();
	static List<Point> chicken = new ArrayList<>();
	static int m;
	static int res = 125000;
	
	static int checkdistance() {
		int r=0;
		for(int i=0,size1=home.size();i<size1;i++) {
			Point p1 = home.get(i);
			int x1=p1.x;
			int y1=p1.y;
			int dis=125000;
			for(int j=0,size2=tmp.size();j<size2;j++) {
				Point p2 = tmp.get(j);
				int x2=p2.x;
				int y2=p2.y;
				int temp = Math.abs(x1-x2)+Math.abs(y1-y2);
				if(dis>temp) {
					dis=temp;
				}
			}
			r+=dis;
		}
		return r;
	}
	
	static void perm(int idx,int start) {
		if(idx==m) {
			int temp = checkdistance();
			if(res>temp) {
				res=temp;
			}
		}
		for(int i=start,size=chicken.size();i<size;i++) {
			tmp.add(chicken.get(i));
			perm(idx+1,i+1);
			tmp.remove(idx);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					home.add(new Point(i,j));
				}else if(arr[i][j]==2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		
		perm(0,0);

		System.out.println(res);

	}

}