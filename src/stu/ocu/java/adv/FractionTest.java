package stu.ocu.java.adv;

public class FractionTest {
    public static void main(String[] args) {
        // fSum = 0;
        Fraction fSum = new Fraction(0);
        // fDiffValue = 1/10 -- 差分値;
        Fraction fDiffValue = new Fraction(1, 10);

        // 加算部
        System.out.println("----加算部----");
        for (int i = 0; i < 50; i++) {
            // fSum += fDiffValue
            fSum.add(fDiffValue);
            // 分数形式と小数形式で表示
            System.out.println(fSum + ", " + fSum.toDouble());
        }

        // 減算部 fSub = 10
        Fraction fSub = new Fraction(10);
        System.out.println("----減算部----");
        for (int i = 0; i < 50; i++) {
            // fSum += fDiffValue
            fSub.sub(fDiffValue);
            // 分数形式と小数形式で表示
            System.out.println(fSub + ", " + fSub.toDouble());
        }

        // 乗算部 fMul = 0.3
        Fraction fMul = new Fraction(3,10);
        // fDiffValue = 2;
        fDiffValue = new Fraction(2);
        System.out.println("----乗算部----");
        for (int i = 0; i < 50; i++) {
            // fSum += fDiffValue
            fMul.mul(fDiffValue);
            // 分数形式と小数形式で表示
            System.out.println(fMul + ", " + fMul.toDouble());
        }

        // 逆数メソッドテスト
        Fraction fInverse = new Fraction(2, 3);  // fInverse = (2/3)
        fInverse.inverse();            // 逆数にする
        System.out.println("----逆数テスト----");
        System.out.println(fInverse);  // (3/2)が表示される

        // 除算部 fDiv = 5000
        Fraction fDiv = new Fraction(5000);
        System.out.println("----除算部----");
        for (int i = 0; i < 50; i++) {
            // fSum += fDiffValue
            fDiv.div(fDiffValue);
            // 分数形式と小数形式で表示
            System.out.println(fDiv + ", " + fDiv.toDouble());
        }

        // 1 + 1 / (2 + 1/2) の計算
        Fraction fSumDiv = new Fraction(1);
        // 演算子の右側を (2 + 1/2) の逆数で求める
        fDiffValue = new Fraction(2).add(new Fraction(1,2)).inverse();
        // 演算子の左側 + 右側
        fSumDiv.add(fDiffValue);
        // 分数形式と小数形式で表示
        System.out.println("----1 + 1 / (2 + 1/2)----");
        System.out.println(fSumDiv + ", " + fSumDiv.toDouble());
    }
}