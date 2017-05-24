package stu.ocu.java;

import java.util.Arrays;

public class MinAndMax_Advanced {
    // 課題4-2(最大値と最小値_少し高度なバージョン)
    public static void main(String[] args) {
        // Size=10の配列用意
        int[] array_input = new int[10];

        System.out.println("整数(1〜100まで)を入力してください");
        System.out.println("ルール1:0入力された時点で入力の終わりとする");
        System.out.println("ルール2:数字10個まで入力できる");

        // 入力受付ループ
        for (int i = 0; i < array_input.length; i++) {
            System.out.print("Number" + (i + 1) + ":");
            array_input[i] = Keyboard.intValue();
            // 0が入力されたら受付終了
            if (array_input[i] == 0) {
                break;
            }
            // 範囲内の入力を保証する
            if (array_input[i] < 1 || array_input[i] > 100) {
                System.out.println("範囲外の数字です。再度1〜100の範囲で値を入れてください．");
                i--;
                continue;
            }
        }
        // とりあえず最初の要素を最大・最小値にする
        int numberMin = array_input[0];
        int numberMax = numberMin;

        for (int i = 0; i < array_input.length; i++) {
            // 最小値探索
            if (numberMin >= array_input[i] && array_input[i] != 0) {
                numberMin = array_input[i];
            }
            // 最大値探索
            if (numberMax <= array_input[i]) {
                numberMax = array_input[i];
            }
        }
        // 結果出力
        System.out.println(String.format("最大：%d", numberMax));
        System.out.println(String.format("最小：%d", numberMin));
    }
}
