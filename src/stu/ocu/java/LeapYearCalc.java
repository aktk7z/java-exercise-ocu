package stu.ocu.java;

public class LeapYearCalc {
    // うるう年計算プログラム
    public static void main(String[] args) {
        // 入力受付
        System.out.print("西暦を入力してください: ");
        int inputYear = Keyboard.intValue();

        // うるう年判断フラグを用意
        boolean isLeapYear = false;
        // 4で割り切れる年はうるう年である
        if (inputYear % 4 == 0) {
            isLeapYear = true;
            // ただし、100で割り切れる年はうるう年ではない
            if (inputYear % 100 == 0) {
                isLeapYear = false;
                // が、400で割り切れる年はうるう年である
                if (inputYear % 400 == 0) {
                    isLeapYear = true;
                }
            }
        }

        // 出力メッセージの組立
        String msgIsLeap = "%d年はうるう年です。";
        String msgNotLeap = "%d年はうるう年ではありません。";
        String msgResult;

        msgResult = isLeapYear ? String.format(msgIsLeap, inputYear) : String.format(msgNotLeap, inputYear);
        // 結果出力
        System.out.println(msgResult);
    }
}
