class Solution {
    public int solution(int n, int k) {
        int num = n / 10;
        int drink = k - num;
        
        return n * 12000 + drink * 2000;
    }
}