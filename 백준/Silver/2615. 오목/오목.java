import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] data = new int[21][21];
	static final int STARTIDX = 1, ENDIDX = 19;
	
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		
		br = new BufferedReader(new InputStreamReader(System.in));	
		
		for(int i = STARTIDX; i <= ENDIDX; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = STARTIDX; j <= ENDIDX; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = STARTIDX; i <= ENDIDX; i++) {
			for(int j = STARTIDX; j <= ENDIDX; j++) {
		
				// 가로
				if(j >= STARTIDX + 2 && j <= ENDIDX - 2) if(checkWin(i, j, 0, 1)) return;
				
				// 세로
				if(i >= STARTIDX + 2 && i <= ENDIDX - 2) if(checkWin(i, j, 1, 0)) return;
				
				
				if(i >= STARTIDX + 2 && i <= ENDIDX - 2 && j >= STARTIDX + 2 && j <= ENDIDX - 2) {					
					// 좌상우하
					if(checkWin(i, j, 1, 1)) return;
					
					// 좌하우상
					if(checkWin(i, j, -1, 1)) return;
				}
			}
		}
		
		System.out.print(0);
	
	}

	private static boolean checkWin(int centerI, int centerJ, int di, int dj) {
		
		int center = data[centerI][centerJ];
		
		if(center == 0) return false;
		
		for(int i = -2; i <= 2; i++) {
			if(center != data[centerI + di*i][centerJ + dj*i]) return false;
		}
		
		if(center != data[centerI + (-3)*di][centerJ + (-3)*dj] && center != data[centerI + (3)*di][centerJ + (3)*dj]) {
			System.out.println(data[centerI][centerJ]);
			int ansI = centerI + (-2) * di;
			int ansJ = centerJ + (-2) * dj;
			System.out.print(ansI + " " + ansJ);
			return true;
		}
		
		return false;
		
	}
}