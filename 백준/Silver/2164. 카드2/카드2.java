import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i=1;i<N+1;i++) {
			q.add(i);
		}
		while(q.size()>1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.peek());
	}

}