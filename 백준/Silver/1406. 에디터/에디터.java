import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int M = Integer.parseInt(br.readLine());
        
        LinkedList<Character> st_list = new LinkedList<>();
        for (char ch : st.toCharArray()){
            st_list.add(ch);
        }

        ListIterator<Character> cur = st_list.listIterator(st_list.size());
        for(int i=0; i<M; i++){
            String oneLine = br.readLine();
            char c = oneLine.charAt(0);

            switch(c){
                case 'L':
                    if(cur.hasPrevious()){
                        cur.previous();
                    }
                    break;
                case 'D':
                    if(cur.hasNext()){
                        cur.next();
                    }
                    break;
                case 'B':
                    if(cur.hasPrevious()){
                        cur.previous();
                        cur.remove();
                    }
                    break;
                case 'P':
                    cur.add(oneLine.charAt(2));
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (char ch : st_list){
            bw.write(ch);
        }
        bw.flush();
        bw.close();
    }
}