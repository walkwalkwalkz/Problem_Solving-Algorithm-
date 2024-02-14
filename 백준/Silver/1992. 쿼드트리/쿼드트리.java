import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static char[][] arr;
	
	static void quadTree(int x, int y, int size) {
		char tmp = arr[x][y];
		int b=0;
		
		loop1:
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(tmp!=arr[i][j]) {
					b=1;
					break loop1;
				}
			}
		}
		if(b==0) {
			System.out.print(tmp);
			return;
		}
		
		size=size/2;
		
		System.out.print("(");
		quadTree(x,y,size);
		quadTree(x,y+size,size);
		quadTree(x+size,y,size);
		quadTree(x+size,y+size,size);
		System.out.print(")");
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		quadTree(0,0,N);
	}

}