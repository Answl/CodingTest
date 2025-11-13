import javax.swing.table.TableCellEditor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for(int j=0; j<n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String word1 = st.nextToken(), word2 = st.nextToken();
                map.put(word2, map.getOrDefault(word2, 0) + 1);
            }
            //System.out.println(map);

            sum = 1;
            for(String key: map.keySet()){
                sum *= (map.get(key)+1);
            }

            sb.append(sum-1).append("\n");
        }
        System.out.print(sb);
    }
}