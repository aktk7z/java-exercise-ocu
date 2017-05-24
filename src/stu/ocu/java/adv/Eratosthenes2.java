package stu.ocu.java.adv;

import java.util.Arrays;

public class Eratosthenes2 {
    // エラトステネスの篩(課題6-2)
    public static void main(String[] args) {
        // 素数だけ true にした配列を得る
        boolean[] sieve = Sieve(1000);
        // boolean配列を完全にマッピング出来た(n番目の要素 = n番目の素数)int配列に変換
        int[] primes = Convert(sieve);

        // 素数の表示 (10個表示するごとに改行)
        int n = 0;
        System.out.println("2~999の素数は以下の通りです：");
        for (int i = 0; i < primes.length; i++) {
            System.out.print((i + 1) + "番目の素数：" + primes[i]);
            n++;
            if (n % 10 == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
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

    /**
     * n番目の要素がn番目の素数になっているような配列に変換するメソッド
     *
     * @param sieve booleanまみれの配列
     * @return 素数が詰め込まれたint配列
     */
    private static int[] Convert(boolean[] sieve) {
        // 素数の個数を数える
        int cprime = 0;
        for (boolean isPrime : sieve) {
            if (isPrime) cprime++;
        }
        // 新しい完全素数の配列を生成
        int[] primes = new int[cprime];
        // 素数を primes に詰めていく
        int pi = 0;
        for (int si = 0; si < sieve.length; si++) {
            if (sieve[si]) {
                primes[pi] = si;
                pi++;
            }
        }
        return primes;
    }
}
