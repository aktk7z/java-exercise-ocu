package stu.ocu.java.adv;

import stu.ocu.java.Keyboard;

public class Palindrome {
    // 課題8-2(回文判定)
    public static void main(String[] args) {
        while (true) {
            // 入力受付
            System.out.print("文字列を入力してください: ");
            String inputStr = Keyboard.stringValue();
            // 入力しない場合は要求し続ける
            if (inputStr.trim().length() == 0) {
                continue;
            }
            // 回文が入力されるまで、逃がさないΣ(； ・`д・´)
            if (IsPalindrome(inputStr)) {
                System.out.println("回文です。さらばです(ToT)/~~~");
                break;
            } else {
                System.out.println("回文ではありません。 踊り続けー！");
            }
        }
    }
    /**
     * 回文判定メソッド
     * @param inputStr
     * @return
     */
    private static boolean IsPalindrome(String inputStr) {
        // まず逆順にする
        String revStr = Reverse(inputStr);

        System.out.printf("逆順にすると，[%s] です．", revStr);
        System.out.println();

        return revStr.equals(inputStr) ? true : false;
    }
    /**
     * 文字列を反転する
     * @param inputStr
     * @return
     */
    private static String Reverse(String inputStr) {
        /**
         * StringBuilder使えば簡単にできるが、あえて車輪作ってみる
         *
         * StringBuilder sb = new StringBuilder(inputStr);
         * String revStr = sb.reverse().toString();
         *
         * */
        char[] orgChars = inputStr.toCharArray();
        char[] revChars = new char[inputStr.length()];

        for (int i = revChars.length - 1; i >= 0; i--) {
            revChars[i] = orgChars[orgChars.length - i -1];
        }

        // Char型は、Unicodeで保存しているため、String.valueOf()で文字列取得
        return String.valueOf(revChars);
    }
}
