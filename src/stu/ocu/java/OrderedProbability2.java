package stu.ocu.java;

public class OrderedProbability2 {
    // 課題5-2(メソッド2)
    public static void main(String[] args) {
        int n = 4;
        int ntrial = 100000;        // 試行の回数
        int nordered = 0;        // 昇順になっていた回数
        // ntrial回試行する
        for (int ti = 0; ti < ntrial; ti++) {
            // 大きさnの配列に乱数で0から1までの値を代入
            double[] data = new double[n];
            for (int di = 0; di < data.length; di++) {
                data[di] = Math.random();
            }
            // 昇順になっていたら nordered の値を +1
            if (IsOrdered(data)) {
                //System.out.println(java.util.Arrays.toString(data));
                nordered++;
            }
        }
        System.out.println("昇順になった回数: " + nordered);
        System.out.println("昇順になる確率は " + (double) nordered / ntrial);
    }

    /**
     * 配列の先頭から，昇順に並んでいるかチェック
     * @param data
     * @return 判定結果 昇順：True
     */
    private static boolean IsOrdered(double[] data) {
        boolean ordered = true;
        for (int di = 0; di < data.length - 1; di++) {
            if (data[di] > data[di + 1]) {
                // 昇順になっていない場所を発見した場合
                ordered = false;
                break;
            }
        }
        return  ordered;
    }
}
