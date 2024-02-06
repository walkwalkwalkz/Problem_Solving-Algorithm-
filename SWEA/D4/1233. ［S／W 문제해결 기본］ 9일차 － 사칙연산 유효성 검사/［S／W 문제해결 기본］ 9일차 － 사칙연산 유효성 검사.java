import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1;t<=10;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int flag = 1;
			
			for(int i=0;i<n;i++) {
				String[] arr = br.readLine().split(" ");
				if(flag==1) {
					int size = arr.length;
					char c = arr[1].charAt(0);
					if(Character.isDigit(c)) {
						if(size>2) {
							flag=0;
						}
					}else {
						if(size<4) {
							flag=0;
						}
					}
				}
			}
			System.out.println("#"+t+" "+flag);
			
		}
	}

}