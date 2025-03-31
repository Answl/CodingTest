import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initialString = br.readLine();  // 초기 문자열 입력
        int M = Integer.parseInt(br.readLine()); // 명령어 개수 입력
        
        LinkedList<Character> editor = new LinkedList<>();
        for (char ch : initialString.toCharArray()) {
            editor.add(ch);  // 초기 문자열을 LinkedList에 삽입
        }

        ListIterator<Character> cursor = editor.listIterator(editor.size()); // 커서를 맨 뒤로 이동
        
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char op = command.charAt(0);

            switch (op) {
                case 'L':  // 왼쪽 이동
                    if (cursor.hasPrevious()) cursor.previous();
                    break;
                case 'D':  // 오른쪽 이동
                    if (cursor.hasNext()) cursor.next();
                    break;
                case 'B':  // 왼쪽 문자 삭제
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P':  // 문자 추가
                    char addChar = command.charAt(2);
                    cursor.add(addChar);
                    break;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char ch : editor) {
            result.append(ch);
        }
        
        System.out.println(result);
    }
}
