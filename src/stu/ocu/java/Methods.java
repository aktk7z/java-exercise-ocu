package stu.ocu.java;

public class Methods {
    // 課題5-1(メソッド1)
    public static void main(String[] args) {
        // 出力テスト
        System.out.println(Max3(1, 2, 3));
        System.out.println(Max3(1, 3, 2));
        System.out.println(Max3(2, 1, 3));
        System.out.println(Max3(2, 3, 1));
        System.out.println(Max3(3, 1, 2));
        System.out.println(Max3(3, 2, 1));

        for (double r = 1.0; r <= 10.0; r += 1) {
            System.out.println("r = " + r + ", area = " + CircleArea(r)
                    + ", volume = " + SphereVolume(r));
        }
    }
    /**
     * 円の半径(double)を引数として受け取り，円の面積を返す(returnする)メソッド
     * @param radius 半径
     * @return 円の面積
     */
    private static double CircleArea(double radius) {
        // 円の面積 = 半径の平方 × 円周率
        return Math.pow(radius, 2.0) * Math.PI;
    }
    /**
     * 球の半径(double)を引数として受け取り，球の体積を返すメソッド
     * @param radius 半径
     * @return 球の体積
     */
    private static double SphereVolume(double radius) {
        // 球の体積 = 4/3 × π × 半径の3乗
        // ※注意：4/3で書くと整数間の計算と見なすため(計算結果が1)、4.0/3.0にしないと正しく計算できない
        return 4.0/3.0 * Math.PI * Math.pow(radius, 3.0);
    }
    /**
     * 3つの数(int)を引数として受け取り，その最大値を返すメソッド
     * @param eins 1つ目の数
     * @param zwei 2つ目の数
     * @param drei 3つ目の数
     * @return 最大値
     */
    private static int Max3(int eins, int zwei, int drei) {
        // まず数字1と2を比較
        int maximum = zwei > eins ? zwei : eins;
        // 数字2と3を比較
        return drei > maximum ? drei : maximum;
    }
}
