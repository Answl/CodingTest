import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int count = 0;

        ArrayList<String> als = new ArrayList<>(Arrays.asList("c=","c-","dz=","d-","lj","nj","s=","z="));
        for(int i=0; i<st.length(); i++){
            String st_word = "" + st.charAt(i);
            if(i+1 < st.length()) st_word += st.charAt(i+1);
            
            if(i+2 < st.length() && st_word.equals("dz") && st.charAt(i+2)=='='){
                i+=2;
                count++;
            }else if(als.contains(st_word)) {
                i++;
                count++;
            }else{
                count++;
            }
        }

        System.out.println(count);
    }
}