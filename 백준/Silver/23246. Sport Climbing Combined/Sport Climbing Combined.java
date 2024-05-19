import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] num = new int[n][4];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0, number = 1;
		StringBuilder sb = new StringBuilder();
		while(true) {
			int answer = 0, w = 0;
			boolean flag = false;
			for(int i = 0; i < n; i++) {
				int check = num[i][1] * num[i][2] * num[i][3];
				
				if(check == number && num[i][0] != 0) {
					int sum = num[w][1] + num[w][2] + num[w][3];
					if(answer == 0) {
						answer = num[i][0];
						w = i;
					}
					else {
						int sumi = num[i][1] + num[i][2] + num[i][3];
						flag = true;
						if(sumi < sum) {
							answer = num[i][0];
							w = i;
						}
						else if(sumi == sum && answer > num[i][0]){
							answer = num[i][0];
							w = i;
						}
					}
				}
			}
			if(answer != 0) {
				num[w][0] = 0;
				sb.append(answer).append(" ");
				count++;
			}
			
			if(count == 3) {
				break;
			}
			
			if(!flag) {
				number++;
			}
		}
		System.out.print(sb);
	}
}