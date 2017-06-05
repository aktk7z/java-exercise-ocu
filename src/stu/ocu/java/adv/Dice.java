package stu.ocu.java.adv;

// 演習(Diceクラス)
public class Dice {
    // int型のインスタンス変数で，サイコロの目(1〜6)を記憶しておく
    private int rolls;

    /**
     * コンストラクタ
     * 処理：乱数によってサイコロを1回振る
     */
    public Dice() {
        throwDice();
    }

    /**
     * サイコロを1回振るメソッド（点数範囲１～６）
     */
    public void throwDice() {
        rolls = (int) (Math.random() * 6 + 1);
    }

    /**
     * 現在のサイコロの目を取得するメソッド
     *
     * @return 現在のサイコロの目
     */
    public int getPip() {
        return this.rolls;
    }
}
