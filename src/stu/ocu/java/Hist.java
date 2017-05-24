package stu.ocu.java;

import java.util.Arrays;

public class Hist {
    // 課題4-3 (ヒストグラム)
    public static void main(String[] args) {
        // ヒストグラム配列
        int[] aryScoreList = new int[11];

        System.out.println("点数(0〜100まで)を入力してください");
        System.out.println("※:-1入力された時点で入力の終わりとする");

        // 入力受付ループ（無限ループ）
        while (true) {
            System.out.print("点数" + ":");
            // 入力点数
            int inputScore = Keyboard.intValue();
            // -1が入力されたら受付終了
            if (inputScore == -1) {
                break;
            }
            // 範囲内の入力を保証する
            if (inputScore < 0 || inputScore > 100) {
                System.out.println("範囲外の数字です。再度0〜100の範囲で値を入れてください．");
                continue;
            }
            // x * 10点台のxを計算（切り捨て）
            int scoreLevel = (int) Math.floor(inputScore / 10);
            // x * 10点台の統計
            aryScoreList[scoreLevel]++;
        }
        // 結果出力ループ
        for (int i = 0; i < aryScoreList.length; i++) {
            if (i == 10) {
                // 100点の場合「100点：」で表示する
                System.out.print(i * 10 + "点：");
            } else {
                System.out.print(i * 10 + "点台：");
            }
            for (int j = 0; j < aryScoreList[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
