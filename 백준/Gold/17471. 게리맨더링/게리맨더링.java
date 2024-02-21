import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] p;
    static List<Integer>[] arr;
    static int[] checked;
    static int[] pop;
    static int total;
    static int res = 1000;
    static int[] parents;
    
    static void makeset() {
    	for(int i=1;i<=N;i++) {
    		parents[i]=i;
    	}
    }
    
    static int find(int a) {
    	if(a==parents[a]) return a;
    	
    	return parents[a] = find(parents[a]);
    }
    
    static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	
    	if(a<b) parents[b]=a;
        else parents[a]=b;
    		
    }
    
    static void comb(int idx, int start, int cnt) {

        if(idx==0) {
//            System.out.println(Arrays.toString(checked));
            if(res>Math.abs(cnt-(total-cnt))) {
            	parents = new int[N+1];
            	makeset();
            	
            	for(int i=1;i<=N;i++) {
            		for(int j=0,size=arr[i].size();j<size;j++) {
            			if(checked[i]==checked[arr[i].get(j)]) {
            				union(i,arr[i].get(j));
            			}
            		}
            	}
            	int tmp=0;
            	for(int i=1;i<=N;i++) {
            		if(parents[i]==i) tmp++;
            	}
            	
            	if(tmp==2) res=Math.abs(cnt-(total-cnt));
            }
            return;
        }

        for(int i=start;i<=N;i++) {
//            data[idx]=i;
            checked[i]=1;
            comb(idx-1,i+1,cnt+pop[i]);
            checked[i]=0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        checked = new int[N+1];
        pop = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            pop[i] = Integer.parseInt(st.nextToken());
            total += pop[i];
        }

        arr = new ArrayList[N+1];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            arr[i] = new ArrayList<Integer>();

            for(int j=0;j<size;j++) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=1;i<((N+1)/2)+1;i++) {
            comb(i,1,0);
        }
        if(res==1000) res=-1;
        System.out.println(res);
    }

}