package stu.ocu.java.adv;
/*
 * 分数クラス (負の数には対応していない)
 */
public class Fraction {
    long numerator;    // 分子
    long dominator;    // 分母

    // コンストラクタ
    public Fraction(long n, long d) {
        numerator = n;
        dominator = d;
    }

    // コンストラクタ
    public Fraction(long n) {
        // 下の2行の代わりに this(n, 1); と書いてもよい
        // 上のコンストラクタを指定した引数で呼び出すことになる
        numerator = n;
        dominator = 1;
    }

    // doubleに変換する
    public double toDouble() {
        return (double)numerator / dominator;
    }

    // 分数の加算．thisに対してanotherで指定された分数を加算する
    public Fraction add(Fraction another) {
        // a/b + c/d = (ad+bc)/bd を使って加算する
        // 分母の計算
        // another.dominator は，anotherの指すインスタンスのインスタンス変数
        // のdominatorを意味する
        long dom = dominator * another.dominator;
        // 分子の計算
        long num = numerator * another.dominator
                + dominator * another.numerator;
        dominator = dom;
        numerator = num;
        reduce();        // 約分する
        // this を return している理由は，
        // a = a + b + c を計算するとき，
        // a.add(b).add(c) のように書けるようにするため．
        return this;
    }

    // 分数の引き算
    public Fraction sub(Fraction another) {
        long dom = dominator * another.dominator;
        long num = numerator * another.dominator
                - dominator * another.numerator;
        dominator = dom;
        numerator = num;
        reduce();
        return this;
    }

    // 分数の乗算
    public Fraction mul(Fraction another) {
        // a/b + c/d = ac/bd を使って乗算する
        long dom = dominator * another.dominator;
        long num = numerator * another.numerator;
        dominator = dom;
        numerator = num;

        reduce();
        return this;
    }

    // 分数の除算
    public Fraction div(Fraction another) {
        // (a/b) / (c/d) = ad / bc を使って除算する
        long dom = dominator * another.numerator;
        long num = numerator * another.dominator;
        dominator = dom;
        numerator = num;

        reduce();
        return this;
    }

    /**
     * 文字列に変換
     * 注意：インスタンスのtoString()メソッドをオーバーライド(override)している
     */
    public String toString() {
        // 分母が1だったら，分子だけ表示
        if (dominator == 1) {
            return "(" + numerator + ")";
        }
        // そうでなければ，(a/b) の形
        return "(" + numerator + "/" + dominator + ")";
    }

    // 約分する
    private void reduce() {
        // 分母，分子を最大公約数で割る
        long gcd = gcd(numerator, dominator);
        numerator /= gcd;
        dominator /= gcd;
    }

    // 逆数にする
    public Fraction inverse() {
        long tmp = dominator;
        dominator = numerator;
        numerator = tmp;

        return this;
    }

    // ユークリッドの互除法を用いて最大公約数を求める
    // クラスメソッドにしてある
    private static long gcd(long a, long b) {
        while (a > 0 && b > 0) {  // a, bともに0より大きい
            if (a > b) {
                a = a % b;        // a > b のとき
            } else {
                b = b % a;        // a <= b のとき
            }
            if (a == 0) {         // a が 0 ならば答えは b
                return b;
            } else if (b == 0) {  // b が 0 ならば答えは a
                return a;
            }
        }
        return -1;
    }
}