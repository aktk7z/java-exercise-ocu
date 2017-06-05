package stu.ocu.java.adv;

public class DiceSample {
    // 演習(Diceクラス) -- 呼び出し用Mainクラス
    public static void main(String[] args) {
        Dice d1 = new Dice();
        Dice d2 = new Dice();
        // まずコンストラクタの動きを検証
        System.out.println("---インスタンス化の直後---");
        for (int i = 0; i < 5; i++) {
            // 表示する
            System.out.println((i + 1) + "回目: " + d1.getPip() + ", " + d2.getPip());
        }
        System.out.println("---throwDiceメソッド呼び出し---");
        for (int i = 0; i < 5; i++) {
            // 2つとも投げて...
            d1.throwDice();
            d2.throwDice();
            // 表示する
            System.out.println((i + 1) + "回目: " + d1.getPip() + ", " + d2.getPip());
        }
    }
}
