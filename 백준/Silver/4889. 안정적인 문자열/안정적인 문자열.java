import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i=1;
        while(true){
            int res=0;
            List<Character> stack = new ArrayList<Character>();
            String s = sc.next();
            if(s.charAt(0)=='-'){
                break;
            }
            for(int j=0,size=s.length();j<size;j++){
                if(s.charAt(j)=='{'){
                    stack.add('{');
                }else{
                    if(stack.size()>0){
                        stack.remove(stack.size()-1);
                    }else{
                        res+=1;
                        stack.add('}');
                    }
                }
            }
            System.out.printf("%d. %d%n",i,res+(stack.size()/2));
            i++;
        }
    }
}