class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        //마지막 집 안가
        int[][] dp1 = new int[money.length][2];
        dp1[0][0] = 0; dp1[0][1] = money[0];
        
        //첫번째 집 안가
        int[][] dp2 = new int[money.length][2];
        dp2[0][0] = 0; dp2[0][1] = 0;
        
        for(int i=1; i<money.length; i++){
            dp1[i][0] = Math.max(dp1[i-1][0], dp1[i-1][1]);
            dp1[i][1] = dp1[i-1][0] + money[i];
            
            dp2[i][0] = Math.max(dp2[i-1][0], dp2[i-1][1]);
            dp2[i][1] = dp2[i-1][0] + money[i];
        }
        
        answer = Math.max(dp1[money.length-1][0], 
                          Math.max(dp2[money.length-1][0], dp2[money.length-1][1]));
        
        return answer;
    }
}