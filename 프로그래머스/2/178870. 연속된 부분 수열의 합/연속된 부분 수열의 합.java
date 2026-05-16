import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int l = 0; int r = 0; 
        int sum = sequence[l];
        
        List<int[]> list = new ArrayList<>();
        while(r<sequence.length || l <= r){
            if(sum >= k) {
                if(sum == k) list.add(new int[]{l, r, Math.abs(l-r)});
                sum -= sequence[l];
                l++;
            } else if(sum < k){
                if(r+1 == sequence.length) break;
                
                r++;
                sum += sequence[r];
            }
        }
        
        Collections.sort(list, (a,b) -> {
            if(a[2] == b[2]) return a[0] - b[0];
            return a[2] - b[2];
        });
        
        return new int[]{list.get(0)[0], list.get(0)[1]};
    }
}