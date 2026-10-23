import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(String[][] clothes) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String[] c : clothes){
            if(!map.containsKey(c[1])) map.put(c[1], new ArrayList<>());
            map.get(c[1]).add(c[0]);
        }
        
        int[] cloth = new int[map.size()]; int i=0;
        for(String m : map.keySet()){
            cloth[i++] = map.get(m).size();
        }
        System.out.println(Arrays.toString(cloth));
        
        comb(cloth, 0, 1);
        
        return answer-1;
    }
    
    private void comb(int[] cloth, int start, int mul){
        answer += mul;
        
        for(int i=start; i<cloth.length; i++){
            comb(cloth, i+1, mul*cloth[i]);
        }
    }
}