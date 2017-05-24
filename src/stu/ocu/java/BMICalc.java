package stu.ocu.java;

public class BMICalc {
    // BMI計算プログラム
    public static void main(String[] args) {
        // 変数準備
        System.out.print("身長(単位：m)を入力してください: ");
        double height = Keyboard.doubleValue();
        System.out.print("体重(単位：kg)を入力してください: ");
        double weight = Keyboard.doubleValue();

        // BMI計算式：BMI = 体重(kg) / ( 身長(m) * 身長(m) )
        double bmi = weight / Math.pow(height, 2);

        if (bmi < 20) {
            // 結果出力
            System.out.println("痩せている");
        } else if (bmi >= 20 && bmi < 24) {
            System.out.println("正常");
        } else if (bmi >= 24 && bmi < 26.5) {
            System.out.println("やや肥満");
        } else if (bmi >= 26.5) {
            System.out.println("肥満");
        }
    }
}
