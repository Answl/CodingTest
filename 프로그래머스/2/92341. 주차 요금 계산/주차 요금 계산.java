import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> list = new ArrayList<>();
        
        int bt = fees[0], bf = fees[1], t = fees[2], f = fees[3];
        
        Map<String, List<Integer>> map = new TreeMap<>(); 
        for(String r : records){
            String key = r.split(" ")[1];
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(Integer.parseInt(r.split(" ")[0].split(":")[0])*60 + 
                            Integer.parseInt(r.split(" ")[0].split(":")[1]));
        }
        // System.out.println(map);
        
        for(String m : map.keySet()){
            int count = 0;
            if(map.get(m).size() % 2 == 0){
                for(int i=0; i<map.get(m).size(); i+=2){
                    count += map.get(m).get(i+1) - map.get(m).get(i);
                }
            } else {
                map.get(m).add(23*60 + 59);
                for(int i=0; i<map.get(m).size(); i+=2){
                    count += map.get(m).get(i+1) - map.get(m).get(i);
                }
            }
            // System.out.println(count);
            if(count > bt){
                if((count - bt)%t==0) list.add(bf + ((count - bt)/t) * f);
                else list.add(bf + ((count - bt)/t+1) * f);
            } else {
                list.add(bf);
            }
        }
        
        int[] answer = new int[list.size()];
        int i = 0;
        for(int l : list) answer[i++] = l;
        
        return answer;
    }
}