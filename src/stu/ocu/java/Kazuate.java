package stu.ocu.java;

public class Kazuate {
    // 数当てゲーム
    public static void main(String[] args) {
        // 乱数を作成
        int targetNumber = (int) (Math.random() * 100);
        // ユーザーの入力を待つ
        System.out.println("0〜99の範囲で値を入れてください．");
        System.out.print("Number:");
        int inputNumber = InputChecker(Keyboard.intValue());

        // 回数Counterの初期化
        int cInput = 1;
        // ループ処理
        while (inputNumber != targetNumber) {

            cInput++;
            // 惜しい入力パターン
            if (++inputNumber == targetNumber || --inputNumber == targetNumber) {
                System.out.println("惜しい！目標数字が再計算されました");
                System.out.print("Number:");
                inputNumber = InputChecker(Keyboard.intValue());
                // 目標数字再計算
                targetNumber = (int) (Math.random() * 100);

                continue;
            }
            if (targetNumber > inputNumber) {
                System.out.println(String.format("%dより大きいです", inputNumber));
                System.out.print("Number:");
                inputNumber = InputChecker(Keyboard.intValue());
            } else {
                System.out.println(String.format("%dより小さいです", inputNumber));
                System.out.print("Number:");
                inputNumber = InputChecker(Keyboard.intValue());
            }
        }

        // 最終結果出力
        System.out.println(String.format("%d回目で正解！", cInput));
    }

    // 入力チェック用メソッド
    public static int InputChecker(int inputNumber) {
        // 範囲外の入力をはじく
        while (inputNumber < 0 || inputNumber > 99) {
            System.out.println("範囲外の数字です。再度0〜99の範囲で値を入れてください．");
            System.out.print("Number:");
            inputNumber = Keyboard.intValue();
        }
        return inputNumber;
    }
}
