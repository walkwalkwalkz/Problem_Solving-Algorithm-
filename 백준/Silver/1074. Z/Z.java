import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 Z 1074 **
시작 시간 : 24-01-22 20:20
중지 :
종료 시간 : 24-01-22 -----
실행시간 : --ms

고려사항

 */

public class Main {

    static int N, r, c;
    static int result;
    public static void main(String[] args) throws IOException {

        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        foo(r, c, N);
        System.out.println(result);
    }

    private static void foo(int r, int c, int n) {

        int sector = 0;
        if(n == 1){
            if(c==1) sector += 1;
            if(r==1) sector += 2;
            result += sector;
            return;
        }

        int midIdx = (int)Math.pow(2, n-1);
        if(c >= midIdx) sector += 1;
        if(r >= midIdx) sector += 2;

        result += sector * (int)Math.pow(Math.pow(2, n-1), 2);

        if(r >= midIdx) r -= midIdx;
        if(c >= midIdx) c -= midIdx;

        foo(r, c, n-1);
    }
}