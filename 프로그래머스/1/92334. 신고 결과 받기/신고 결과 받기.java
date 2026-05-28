import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> mm = new LinkedHashMap<>();
        for(String i : id_list) {
            map.put(i, new HashSet<>());
            mm.put(i, 0);
        }
        
        for(String r : report){
            String tmp1 = r.split(" ")[0];
            String tmp2 = r.split(" ")[1];
            map.get(tmp2).add(tmp1);
        }
        
        for(String key : map.keySet()){
            if(map.get(key).size() >= k){
                for(String s : map.get(key)){
                    mm.put(s, mm.get(s)+1);
                }
            }
        }
        //System.out.println(mm);
        int i=0;
        for(String key : mm.keySet()){
            answer[i++] = mm.get(key);
        }
        
        return answer;
    }
}