import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[] avg = new double[N];

        for (int i = 0; i < N; i++) {
            avg[i] = Double.parseDouble(br.readLine());
        }
        for (int people = 1; people <= 10000; people++) {
            boolean allOk = true;
            for (int i = 0; i < N && allOk; i++) {
                boolean ok = false;
                for (int sum = 0; sum <= people * 10; sum++) {
                    double trueAvg = (double) sum / people;
                    double floored = Math.floor(trueAvg * 1000) / 1000.0;

                    // 핵심: 버림 기준 → avg[i] ≤ trueAvg < avg[i] + 0.001
                    if (trueAvg + 1e-9 >= avg[i] && trueAvg < avg[i] + 0.001 - 1e-9) {
                        ok = true;
                        break;
                    }
                }
                if (!ok) allOk = false;
            }
            if (allOk) {
                System.out.println(people);
                return;
            }
        }
    }
}
