import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                if(s.charAt(i) == ')') return false;
                stack.push(s.charAt(i));
            } else {
                if(isRight(stack.peek(), s.charAt(i))){
                    stack.pop();
                } else stack.push(s.charAt(i));
            }
            //System.out.println(stack);
        }

        return stack.isEmpty();
    }
    private boolean isRight(char pk, char now){
        if(pk == '(') return (now == ')');
        return false;
    }
}