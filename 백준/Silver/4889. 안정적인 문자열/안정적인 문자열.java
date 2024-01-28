import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Stream;


/*
백준 안정적인문자열 4889 S1
시작 시간 : 24-01-29 08:20
종료 시간 : 24-01-29
실행시간 : ms


고려사항

*/

public class Main {

	static String line;
	static char[] data = {'{','}','{','}','{','}'};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCaseNum = 1;
		line = br.readLine();
		while(line.toCharArray()[0] != '-') {
			data = line.toCharArray();
			
			boolean mustAllClose = false;
			int openNum = 0;
			int ans = 0;
			int n = data.length;
			
			for(int i = 0; i < n; i++) {
				if(mustAllClose) {
					if(data[i] == '{') {
						ans++;
					}
					continue;
				}
				
				if(openNum == 0 && data[i] == '}') {
					ans++;
					openNum++;
					continue;
				}
				
				if(n-i == openNum) {
					if(data[i] == '{') {
						ans++;
					}
					mustAllClose = true;
					continue;
				}
				
				if(data[i] == '}'){
					openNum--;
				}else if(data[i] == '{') {
					openNum++;
				}
			}
			
			
			System.out.println(testCaseNum + ". " + ans);
			testCaseNum++;
			line = br.readLine();
		}
		
		
	}
}