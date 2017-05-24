package stu.ocu.java.adv;

import java.util.Arrays;

public class Eratosthenes {
    // エラトステネスの篩(演習問題)
    public static void main(String[] args) {
        // 素数だけ true にした配列を得る
        boolean[] arySieve = Sieve(1000);

        // 素数の表示 (10個表示するごとに改行)
        int n = 0;
        for (int i = 0; i < arySieve.length; i++) {
            if (arySieve[i]) {
                System.out.print(i);
                n++;
                if (n % 10 == 0) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }

    /**
     * nより小さい(n未満の)全ての素数を見つけるメソッド
     * アルゴリズム：エラトステネスの篩
     *
     * @param n
     * @return 処理後の配列(添字が素数の要素だけTrueになっている)
     */
    private static boolean[] Sieve(int n) {
        // 全ての要素には最初 false が入っているので、全部Trueにする
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // 添字0と1の要素は対象外なので、falseにしておく(もっといいやり方があるはず...)
        isPrime[0] = false;
        isPrime[1] = false;
        // 最大数の平方根を求める
        double nSqrt = Math.sqrt(n - 1);
        // 配列内で探す
        for (int i = 2; i < nSqrt; i++) {
            for (int j = 2; i * j < n; j++) {
                //  iの倍数をふるい落とす
                isPrime[i * j] = false;
            }
        }
        return isPrime;
    }
}
