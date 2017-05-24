package stu.ocu.java;

public class DistanceMatrix {
    // 課題4-1(距離マトリックス)
    public static void main(String[] args) {
        // 距離データの初期化
        int[] array_dist = {0, 1, 3, 4, 9};
        // ヘッダ部をプリントアウト（見栄えを良くする為にスペースを少し入れる）
        System.out.print("  ");
        for (int i = 0; i < array_dist.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("-----------");
        // 二重ループを使ってボディ部をプリントアウト
        for (int i = 0; i < array_dist.length; i++) {
            System.out.print(i + ":");
            for (int j = 0; j < array_dist.length; j++) {
                // 二駅間の距離を計算:減算して絶対値を取ればOK
                System.out.print(Math.abs(array_dist[j] - array_dist[i]) + " ");
            }
            System.out.println();
        }
    }
}
