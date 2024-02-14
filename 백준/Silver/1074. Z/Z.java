import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
실행시간 : 1ms
메모리 : 
*/

public class Main {

	static long N, R, C;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		System.out.println(foo((int)Math.pow(2, N) , 0));
		
	}

	private static long foo(long size, long cnt) {

		if(size == 2) { 
			int val = 0;
			if(R == 0 && C == 0) val = 0;
			if(R == 0 && C == 1) val = 1;
			if(R == 1 && C == 0) val = 2;
			if(R == 1 && C == 1) val = 3;
			
			return cnt + val;
		}
		
		long half = size / 2;
		// 좌상
		if(R < half && C < half) {
			return foo(half, cnt);
		}
		
		// 우상
		else if(R < half && C >= half) {
			C -= half;
			return foo(half, cnt + half*half);
		}
		
		// 좌하
		else if(R >= half && C < half) {
			R -= half;
			return foo(half, cnt + 2*half*half);
		}
		
		// 우하
		else {
			R -= half;
			C -= half;
			return foo(half, cnt + 3*half*half);
		}
		
		
	}		
	
}