import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


/*
백준 잃어버린괄호 1541 --
시작 시간 : 24-01-23 09:30
종료 시간 : 24-01-22 -----
실행시간 : --ms


고려사항

*/

public class Main {

	static String str;
	static ArrayList<Integer> nums = new ArrayList<>();
	static ArrayList<Character> ops = new ArrayList<>();
 	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		String charNum = "";

		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '+' || c == '-') {
				nums.add(Integer.parseInt(charNum));
				charNum = "";
				ops.add(c);
			} else {
				charNum += c;
			}
		}
		nums.add(Integer.parseInt(charNum));

		int minSum = nums.get(0);
		boolean hasMinus = false;
		for(int i = 0; i < ops.size(); i++) {
			if(!hasMinus) hasMinus = ops.get(i) == '-' ? true : false;
			
			if(hasMinus) {
				minSum -= nums.get(i+1);
			}
			else {
				minSum += nums.get(i+1);   
			}
		}

		System.out.println(minSum);
	}
}