import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int count = 0;

        String[] st_cro = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for(String cro : st_cro){
            st = st.replace(cro, "A");
        }
        System.out.println(st.length());
    }
}