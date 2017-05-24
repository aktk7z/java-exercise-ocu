package stu.ocu.java;

public class MinAndMax {
    // 課題4-2(最大値と最小値)
    public static void main(String[] args) {
        // Size=5の配列用意
        int[] aryInput = new int[5];

        System.out.println("5つの整数(1〜100まで)を入力してください");
        // 入力受付ループ
        for (int i = 0; i < aryInput.length; i++) {
            System.out.print("Number" + (i + 1) + ":");
            aryInput[i] = Keyboard.intValue();
            // 範囲内の入力を保証する
            if (aryInput[i] < 1 || aryInput[i] > 100) {
                System.out.println("範囲外の数字です。再度1〜100の範囲で値を入れてください．");
                i--;
                continue;
            }
        }
        // とりあえず最初の要素を最大・最小値にする
        int numberMin = aryInput[0];
        int numberMax = numberMin;

        for (int i = 0; i < aryInput.length; i++) {
            // 最小値探索
            if (numberMin >= aryInput[i]) {
                numberMin = aryInput[i];
            }
            // 最大値探索
            if (numberMax <= aryInput[i]) {
                numberMax = aryInput[i];
            }
        }
        // 結果出力
        System.out.println(String.format("最大：%d", numberMax));
        System.out.println(String.format("最小：%d", numberMin));
    }
}
