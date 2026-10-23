class Solution {
    static int t;
    static int count = 0;
    public int solution(int[] numbers, int target) {
        t = target;
        //System.out.println(target);
        dfs(0, 0, numbers);
        return count;
    }
    private void dfs(int sum, int depth, int[] numbers){
        if(depth == numbers.length){
            //System.out.println(sum);
            if(sum == t) count++;
            return;
        }
        
        dfs(sum-numbers[depth], depth+1, numbers);
        dfs(sum+numbers[depth], depth+1, numbers);
    }
}