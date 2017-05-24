package stu.ocu.java;

public class ParkingCharge {
    // 駐車料金計算
    public static void main(String[] args) {
        System.out.print("駐車時間を入力してください（単位：分）: ");
        int parkingTime = Keyboard.intValue();
        int charge = 1000;

        int overCharge = 300;
        int overTime = parkingTime - 60;

        if (overTime > 0) {
            charge += overCharge;
            while (overTime - 30 > 0) {
                charge += overCharge;
                overTime -= 30;
            }
        }
        System.out.println(String.format("駐車料金は%d円です。", charge));
    }
}
