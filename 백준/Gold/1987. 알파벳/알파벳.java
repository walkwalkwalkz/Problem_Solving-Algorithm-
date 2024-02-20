import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
    static int R,C;
    static char[][] arr;
//    static HashSet<Character> hs = new HashSet<Character>();
    static int[] alph = new int[26];
    static int[][] visited;
    static int res;
    
    static void dfs(int x,int y,int cnt) {
    	if(cnt>res) {
    		res=cnt;
    	}
    	
    	for(int i=0;i<4;i++) {
    		int xx = x + dx[i];
    		int yy = y + dy[i];
//    		if((0<=xx)&&(0<=yy)&&(xx<R)&&(yy<C)&&(!hs.contains(arr[xx][yy]))&&(visited[xx][yy]==0)) {
    		if((0<=xx)&&(0<=yy)&&(xx<R)&&(yy<C)&&(alph[arr[xx][yy]-'A']==0)&&(visited[xx][yy]==0)) {
    			visited[xx][yy]=1;
//    			hs.add(arr[xx][yy]);
    			alph[arr[xx][yy]-'A']=1;
    			dfs(xx,yy,cnt+1);
//    			hs.remove(arr[xx][yy]);
    			alph[arr[xx][yy]-'A']=0;
    			visited[xx][yy]=0;
    		}
    	}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new char[R][C];
        visited = new int[R][C];
        for(int i=0; i<R;i++) {
            String s = br.readLine();
            for(int j=0; j<C;j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        
//        hs.add(arr[0][0]);
        alph[arr[0][0]-'A']=1;
        dfs(0,0,1);
        
        System.out.println(res);
        
    }

}