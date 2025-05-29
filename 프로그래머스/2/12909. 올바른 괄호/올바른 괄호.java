import java.util.*;
class Solution {
    static String OPEN = "(";
    static String CLOSE = ")";
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i<s.length(); i++){
            //여는거
            if(OPEN.indexOf(s.charAt(i)) >= 0) stack.push(s.charAt(i));
            //닫는거 -> 여는짝 있으면 pop
            else if(CLOSE.indexOf(s.charAt(i)) >= 0){
                 if(stack.isEmpty() || !isPair(stack.pop(), s.charAt(i))) return false;
            }
        }
        return stack.isEmpty();
    }
    private boolean isPair(char a, char b){
        return OPEN.indexOf(a) == CLOSE.indexOf(b);
    }
}