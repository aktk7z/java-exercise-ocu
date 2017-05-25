package stu.ocu.java.adv;

import stu.ocu.java.Keyboard;

public class Shiritori3 {
    // ひながら入力チェック用正規表現
    public static final String MATCH_HIRAGANA = "^[\\u3040-\\u309F]+$";
    // 課題8-1(しりとり3)
    public static void main(String[] args) {
        System.out.println("しりとりをしましょう～ 最初はしりとりの「り」からです。");

        // 比較用にSize = 2のChar配列作成
        // compareChars[0]：直前の単語の最後の文字
        // compareChars[1]：入力された単語の頭文字
        char[] compareChars = new char[2];
        // スタート文字に「り」を設定
        compareChars[0] = 'り';

        while (true) {
            System.out.print("単語: ");
            // 入力受付
            String inputStr = Keyboard.stringValue();
            // ひながら入力チェック
            if (!ValidHinagana(inputStr)) {
                System.out.println("ひながらOnlyで入力お願いします～");
                continue;
            }
            // 入力チェック
            if (Judgment(inputStr, compareChars)) {
                // 「ん」が来たらアウトー
                if (GetLastChar(inputStr) == 'ん') {
                    System.out.println("あなたの負け");
                    break;
                } else {
                    System.out.println("判定OKです！");
                    System.out.printf("次は「%C」から始まることばを入れてください", compareChars[0]);
                    System.out.println();
                    continue;
                }
            } else {
                // ルール違反の場合
                System.out.printf("「%C」から始まることばを入れてください", compareChars[0]);
                System.out.println();
                continue;
            }
        }
    }
    /**
     * 入力された文字列はひながらのみかどうかを正規表現で(範囲)チェックするメソッド
     *
     * @param inputStr
     * @return
     */
    private static boolean ValidHinagana(String inputStr) {
        return inputStr.matches(MATCH_HIRAGANA) ? true : false;
    }
    /**
     * しりとり判定
     * @param inputStr
     * @param compareChars
     * @return
     */
    private static boolean Judgment(String inputStr, char[] compareChars) {
        // 入力が空の場合は直接にfalse判定
        if (inputStr.length() == 0) return false;
        // 入力された単語の頭文字を取得
        compareChars[1] = GetFirstChar(inputStr);
        // しりとりできているかどうかを検証
        if (compareChars[0] == compareChars[1]) {
            // しりとりできている場合、入力された単語の最後の文字を配列の0番目に上書き保存
            compareChars[0] = GetLastChar(inputStr);
            compareChars[1] = ' ';
            return true;
        } else {
            return false;
        }
    }
    /**
     * 文字列の頭文字を取得
     * @param inputStr
     * @return
     */
    private static char GetFirstChar(String inputStr) {
        return inputStr.substring(0).toCharArray()[0];
    }
    /**
     * 文字列の末尾を取得
     * @param inputStr
     * @return
     */
    private static char GetLastChar(String inputStr) {
        return inputStr.substring(inputStr.length() - 1).toCharArray()[0];
    }
}