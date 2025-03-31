import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        for(int i=0; i<N; i++){
            boolean isGroupWord = true;

            String st = br.readLine();
            Set<Character> hs = new HashSet<>();
            for(int j=0; j<st.length(); j++){
                if(j>0 && st.charAt(j)==st.charAt(j-1)){
                    continue;
                }
                if(hs.contains(st.charAt(j))){
                    isGroupWord = false;
                    break;
                }
                hs.add(st.charAt(j));
            }
            if(isGroupWord) count+=1;
            
        }
        System.out.println(count);
    }
}