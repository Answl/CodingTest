import java.util.*;

class Solution {
    static List<Integer> answer = new ArrayList<>();
    static int size = 0;
    public String[] solution(String[][] tickets) {
        //String[] answer = {};
        size = tickets.length;
        Arrays.sort(tickets, (a,b) -> {
            return a[1].compareTo(b[1]);
        });
        //System.out.println(Arrays.deepToString(tickets));
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] t : tickets){
            if(!map.containsKey(t[0])) map.put(t[0], map.size());
            
            if(!map.containsKey(t[1])) map.put(t[1], map.size());
        }
        //System.out.println(map);
        
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0; i<map.size(); i++) list.add(new ArrayList<>());
        for(String[] t : tickets){ 
            list.get(map.get(t[0])).add(new int[]{map.get(t[1]),1});
        }
        //System.out.println(list);
        answer.add(map.get("ICN"));
        boolean v = dfs(map.get("ICN"), list, 1);
        //System.out.println(answer);
        
        
        
        
        String[] result = new String[answer.size()];
        
        for(int i=0; i<answer.size(); i++){
            for(String key : map.keySet()){
                if(map.get(key) == answer.get(i)) {
                    result[i] = key;
                    break;
                }
            }
        }
        
        return result;
    }
    private boolean dfs(int start, List<List<int[]>> list, int sum){
        
        boolean flag =false;
        for(int[] l : list.get(start)){
            if(l[1] == 1) flag = true;
        }
        if(!flag && sum == size+1) {
            System.out.println(answer);
            return true;
        }
        
        
        for(int[] l : list.get(start)){
            if(l[1] == 0) continue;
            
            l[1] = 0;
            answer.add(l[0]);
            //answer.add(l[0]);
            if(dfs(l[0], list, sum+1)) return true;
            answer.remove(answer.size()-1);
            l[1] = 1;
        }
        return false;
    }
}