import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        String[] array = br.readLine().split("");

        int start = 0;
        int end = 0;
        int result = 0;

        int blackNum = 0;
        int whiteNum = 0;

        while (end < n) {
            if (array[end].equals("B")) {
                blackNum++;
            } else if (array[end].equals("W")) {
                whiteNum++;
            }
            
            while (blackNum > b && start <= end) {
                if (array[start].equals("B")) {
                    blackNum--;
                } else if (array[start].equals("W")) {
                    whiteNum--;
                }
                start++;
            }

            if (blackNum <= b && whiteNum >= w) {
                result = Math.max(result, end - start + 1);
            }
            
            end++;
        }
        System.out.println(result);
    }
}
