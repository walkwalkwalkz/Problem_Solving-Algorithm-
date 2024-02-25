import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static char[][] arr;
	
	static void rec(int x, int y, int n){
		if(n==1) {
			arr[x][y]='*';
			return;
		}
		
		int gap=n/3;
		
		rec(x,y,gap);
		rec(x,y+gap,gap);
		rec(x,y+2*gap,gap);
		
		rec(x+gap,y,gap);
		rec(x+gap,y+2*gap,gap);
		
		rec(x+2*gap,y,gap);
		rec(x+2*gap,y+gap,gap);
		rec(x+2*gap,y+2*gap,gap);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		rec(0,0,N);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]!='*') sb.append(" ");
				else sb.append(arr[i][j]+"");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}