import java.util.*;

public class OBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] keys = new int[n];
        for (int i = 0; i < n; i++) keys[i] = sc.nextInt();
        double[] p = new double[n];
        for (int i = 0; i < n; i++) p[i] = sc.nextDouble();
        double[] q = new double[n + 1];
        for (int i = 0; i <= n; i++) q[i] = sc.nextDouble();
        double[][] e = new double[n + 2][n + 1];
        double[][] w = new double[n + 2][n + 1];
        int[][] root = new int[n + 1][n + 1];
        for (int i = 1; i <= n + 1; i++) {
            e[i][i - 1] = q[i - 1];
            w[i][i - 1] = q[i - 1];
        }
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                e[i][j] = Double.MAX_VALUE;
                w[i][j] = w[i][j - 1] + p[j - 1] + q[j];
                for (int r = i; r <= j; r++) {
                    double t = e[i][r - 1] + e[r + 1][j] + w[i][j];
                    if (t < e[i][j]) {
                        e[i][j] = t;
                        root[i][j] = r;
                    }
                }
            }
        }
        System.out.printf("%.4f", e[1][n]);

        sc.close();
    }
}
