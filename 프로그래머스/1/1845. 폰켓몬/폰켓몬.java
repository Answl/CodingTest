import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }   
        
        return (set.size() > size)? size : set.size();
    }
}