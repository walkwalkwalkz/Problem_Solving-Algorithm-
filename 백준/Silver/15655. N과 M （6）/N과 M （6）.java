import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] numbers;
	static int[] data;
	
	static void combi(int depth, int start) {
		if(depth==M) {
			for(int d : data) {
				System.out.print(d+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<N;i++) {
			data[depth]=numbers[i];
			combi(depth+1,i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		data = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		combi(0,0);
	}

}