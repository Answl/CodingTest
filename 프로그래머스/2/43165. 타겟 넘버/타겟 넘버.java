class Solution {
    public int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return count;
    }
    
    private void dfs(int sum, int depth, int[] numbers, int target){
        if(depth == numbers.length){
           if(target == sum) {
                count++;
            }
            return;
        }
        int num = numbers[depth];
        //+
        dfs(sum+num, depth+1, numbers, target);
        
        //-
        dfs(sum-num, depth+1, numbers, target);
    }
}