import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int W,H;
    static int[][] arr;
    static int[][][] visited;
    static ArrayDeque<int[]> dq;

    static int[] dx1 = {0,0,-1,1};
    static int[] dy1 = {-1,1,0,0};

    static int[] dx2 = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy2 = {-2,-1,1,2,2,1,-1,-2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        arr = new int[H][W];
        for(int i=0;i<H;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dq = new ArrayDeque<>();
        dq.add(new int[] {0,0,K});
        visited = new int[H][W][K+1];
        visited[0][0][K]=1;
        
        while(!dq.isEmpty()) {
            int[] xyk = dq.poll();

            if((xyk[0]==H-1)&&(xyk[1]==W-1)) {
            	break;
            }
            
            for(int i=0;i<4;i++) {
        		int xx = dx1[i] + xyk[0];
        		int yy = dy1[i] + xyk[1];
        		if((0<=xx)&&(H>xx)&&(0<=yy)&&(W>yy)&&(arr[xx][yy]==0)&&(visited[xx][yy][xyk[2]]==0)) {
        			dq.add(new int[] {xx,yy,xyk[2]});
        			visited[xx][yy][xyk[2]]=visited[xyk[0]][xyk[1]][xyk[2]]+1;
        		}
        	}
            
            if(xyk[2]!=0) {
            	for(int i=0;i<8;i++) {
            		int xx = dx2[i] + xyk[0];
            		int yy = dy2[i] + xyk[1];
            		if((0<=xx)&&(H>xx)&&(0<=yy)&&(W>yy)&&(arr[xx][yy]==0)&&(xyk[2]>0)&&(visited[xx][yy][xyk[2]-1]==0)) {
            			dq.add(new int[] {xx,yy,xyk[2]-1});
            			visited[xx][yy][xyk[2]-1]=visited[xyk[0]][xyk[1]][xyk[2]]+1;
            		}
            	}
            }
        }
        
//        for(int i=0;i<H;i++) {
//        	for(int j=0;j<W;j++) {
//        		System.out.print(Arrays.toString(visited[i][j])+" ");
//        	}
//        	System.out.println();
//        }
        
        int res=1200001;
        for(int i=0;i<=K;i++) {
        	if(visited[H-1][W-1][i]!=0&&res>visited[H-1][W-1][i]) res=visited[H-1][W-1][i];
        }
        
        if(res==1200001) {
        	System.out.println(-1);
        }else {
        	System.out.println(res-1);
        }

    }

}