import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

	static int N;
	static Integer[] data;
	
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		data = new Integer[N];
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(data, Collections.reverseOrder());
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			sum += data[i] * (i + 1); 
		}
		
		System.out.println(sum);
	}
}