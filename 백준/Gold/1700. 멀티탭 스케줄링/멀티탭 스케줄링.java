import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Integer>> appliances = new ArrayList<>();
        for(int i=0; i<=K; i++){
            appliances.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int[] orders = new int[K];
        for(int i=0, j=0; i<K; i++){
            int appliance = Integer.parseInt(st.nextToken());
            appliances.get(appliance).add(j++);
            orders[i] = appliance;
        }

        int count = 0;
        List<Integer> holls = new ArrayList<>();
        for(int i=0; i<K; i++){
            // System.out.println(holls);
            if(holls.contains(orders[i])){
                appliances.get(orders[i]).remove(0);
                continue;
            }
            
            if(holls.size() < N) {
                holls.add(orders[i]);
                appliances.get(orders[i]).remove(0);
                continue;
            }

            int max = -1, hollIdx = 0, idx = 0;
            for(int holl : holls){
                //더이상 나오지 않거나, 가장 앞인데 마지막에 나오는 거 빼기
                if(appliances.get(holl).size() == 0){
                    max = 100;
                    hollIdx = idx;
                } else {
                    int hollRecent = appliances.get(holl).get(0);
                    if(max < hollRecent) {
                        max = hollRecent;
                        hollIdx = idx;
                    }
                }

                idx++;
            }
            holls.remove(hollIdx);
            count ++;

            holls.add(orders[i]);
            appliances.get(orders[i]).remove(0);
        }

        System.out.println(count);
    }
}