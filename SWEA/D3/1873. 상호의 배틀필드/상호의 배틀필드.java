import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int h,w,N;
    static char[][] arr;
    static int mx,my;     //전차위치
    static int sx,sy;     //바라보는 방향
    static String ent;    //입력
    static StringBuilder sb = new StringBuilder();
    
    static void shoot(int x, int y, int dx, int dy) {
    	while(true) {
    		x = x + dx;
    		y = y + dy;
    		if(x<0||y<0||x>=h||y>=w||arr[x][y]=='#') {
    			break;
    		}
    		if(arr[x][y]=='*') {
    			arr[x][y]='.';
    			break;
    		}
    	}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());
        for(int t=1;t<=tc;t++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            arr = new char[h][w];

            for(int i=0;i<h;i++) {
                String s = br.readLine();
                for(int j=0;j<w;j++) {
                    arr[i][j] = s.charAt(j);
                    if(arr[i][j]=='<'||arr[i][j]=='^'||arr[i][j]=='v'||arr[i][j]=='>') {
                        mx = i;
                        my = j;
                        if(arr[i][j]=='<') {
                        	sx=0;
                        	sy=-1;
                        }else if(arr[i][j]=='^') {
                        	sx=-1;
                        	sy=0;
                        }else if(arr[i][j]=='v') {
                        	sx=1;
                        	sy=0;
                        }else {
                        	sx=0;
                        	sy=1;
                        }
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            ent = br.readLine();

            for(int i=0;i<N;i++) {
            	char c = ent.charAt(i);
            	if(c=='S') {
            		shoot(mx,my,sx,sy);
            	}else{
            		if(c=='U') {
	            		sx=-1;
	            		sy=0;
	            		arr[mx][my]='^';
	            	}else if(c=='D') {
	            		sx=1;
	            		sy=0;
	            		arr[mx][my]='v';
	            	}else if(c=='L') {
	            		sx=0;
	            		sy=-1;
	            		arr[mx][my]='<';
	            	}else {
	            		sx=0;
	            		sy=1;
	            		arr[mx][my]='>';
	            	}
	            	
	            	int xx = mx + sx;
	            	int yy = my + sy;
	            	if(xx>=0&&xx<h&&yy>=0&&yy<w&&arr[xx][yy]=='.') {
	            		arr[xx][yy]=arr[mx][my];
	            		arr[mx][my]='.';
	            		mx=xx;
	            		my=yy;
	            	}
            	}
            }
            sb.append("#"+t+" ");
            for(int i=0;i<h;i++) {
            	for(int j=0;j<w;j++) {
            		sb.append(arr[i][j]);
            	}
            	sb.append("\n");
            }
        }
        System.out.println(sb);
    }

}