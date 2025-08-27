import java.util.*;
// 간선 중심 + union find 알고리즘
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0; 
        
        // 초기 parent 배열 생성
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        // 간선 비용 기준 정렬
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        
        int idx = 0; // costs
        int count = 0; // 선택된 간선 수
        
        while(true){
            if(union( costs[idx][0], costs[idx][1])){
                answer += costs[idx][2];
                count++;
                if(count == n-1) break;
            }
            idx++;
        }
        
        return answer;
    }
    
    private int findSet(int x){
        if(parent[x] == x) return x; // parent 자기자신
        // return findSet(parent[x]);
        return parent[x] = findSet(parent[x]); // 배열의 갱신 + 값 찾기
    }
    
    private boolean union(int x, int y){
        int px = findSet(x), py = findSet(y);
        
        if(px == py) return false;
        
        if(px < py) parent[py] = px;
        else parent[px] = py;
        return true;
    }
}