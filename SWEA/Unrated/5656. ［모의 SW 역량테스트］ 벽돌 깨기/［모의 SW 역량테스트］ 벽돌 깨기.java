import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    static int N,W,H;
    static int[] numbers;
    static int[][] arr;
    static int[][] copyarr;
    static int res;

    static void breakblock() {
        for(int num : numbers) {
            int idx=-1;
            for(int i=0;i<H;i++) {
                if(copyarr[i][num]!=0) {
                    idx=i;
                    break;
                }
            }

            if(idx==-1) continue;

            Deque<int[]> dq = new ArrayDeque<>();
            dq.add(new int[] {idx,num,copyarr[idx][num]});
            copyarr[idx][num]=0;

            while(!dq.isEmpty()) {
                int[] xy = dq.poll();
                int x = xy[0];
                int y = xy[1];
                int tmp = xy[2] - 1;

                int i = 1;
                while(tmp>=i && y-i>=0) {
                    if(copyarr[x][y-i]!=0) {
                    	dq.add(new int[] {x,y-i,copyarr[x][y-i]});
                    	copyarr[x][y-i]=0;
                    }
                    i++;
                }

                i = 1;
                while(tmp>=i && y+i<W) {
                    if(copyarr[x][y+i]!=0) {
                    	dq.add(new int[] {x,y+i,copyarr[x][y+i]});
                    	copyarr[x][y+i]=0;
                    }
                    i++;
                }

                i = 1;
                while(tmp>=i && x-i>=0) {
                    if(copyarr[x-i][y]!=0) {
                    	dq.add(new int[] {x-i,y,copyarr[x-i][y]});
                    	copyarr[x-i][y]=0;
                    }
                    i++;
                }

                i = 1;
                while(tmp>=i && x+i<H) {
                    if(copyarr[x+i][y]!=0) {
                    	dq.add(new int[] {x+i,y,copyarr[x+i][y]});
                    	copyarr[x+i][y]=0;
                    }
                    i++;
                }
            }
            
            for(int i=0;i<W;i++) {
            	Stack<Integer> stack = new Stack<>();
            	for(int j=0;j<H;j++) {
            		if(copyarr[j][i]!=0) {
            			stack.add(copyarr[j][i]);
            			copyarr[j][i]=0;
            		}
            	}
            		
            	int k=H-1;
            	while(!stack.isEmpty()) {
            		copyarr[k][i]=stack.pop();
            		k--;
            	}
            }

        }
        int cnt=0;
        for(int i=0;i<H;i++) {
            for(int j=0;j<W;j++) {
                if(copyarr[i][j]!=0) cnt++;
            }
        }

        if(res>cnt)
        {
            res=cnt;
        }
    }

    static void rec(int l) {
        if(l==N) {

            for(int i=0;i<H;i++) {
                for(int j=0;j<W;j++) {
                    copyarr[i][j] = arr[i][j];
                }
            }
            breakblock();

            return;
        }

        for(int i=0;i<W;i++) {
            numbers[l]=i;
            rec(l+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());

        for(int t=1;t<tc+1;t++) {
            res=1000;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            numbers = new int[N];
            arr = new int[H][W];
            copyarr = new int[H][W];

            for(int i=0;i<H;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            rec(0);
            System.out.println("#"+t+" "+res);
        }

}
}