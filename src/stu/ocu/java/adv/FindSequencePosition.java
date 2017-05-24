package stu.ocu.java.adv;

public class FindSequencePosition {
    // 課題6-1
    public static void main(String[] args) {
        // メソッドテスト
        int[] data = {1, 2, 3, 2, 3, 4};  // 比較対象の配列

        int[] seq1 = {1, 2, 3};
        System.out.println(Find(data, seq1)); // 0 を返す((1, 2, 3) は dataの0番目から存在)
        int[] seq2 = {2, 3};
        System.out.println(Find(data, seq2)); // 1 を返す((2, 3) はdataの1番目と3番目にあるが，先頭に近いのは1番目)
        int[] seq3 = {2, 1};
        System.out.println(Find(data, seq3)); // -1 を返す((2, 1) は存在しない)
        int[] seq4 = {3, 4, 5};
        System.out.println(Find(data, seq4)); // -1 を返す((3, 4, 5) は存在しない)
        int[] seq5 = {3, 2};
        System.out.println(Find(data, seq5)); // 2 を返す((3, 2) は dataの2番目から存在)
        int[] seq6 = {3, 4};
        System.out.println(Find(data, seq6)); // 4 を返す((3, 4) は dataの4番目から存在)
        int[] seq7 = {4, 5};
        System.out.println(Find(data, seq7)); // -1 を返す((4, 5) は存在しない)
        int[] seq8 = {4, 5, 6, 7, 9, 9, 12};
        System.out.println(Find(data, seq8)); // -1 を返す(比較対象よりサイズが大きい)
        int[] seq9 = {1, 2, 3, 2, 3, 4};
        System.out.println(Find(data, seq9)); // 0 を返す(ピッタリ)
    }

    /**
     * 配列の指定された位置から，シーケンスがマッチするか(一致するか)どうかを判定するメソッド
     * @param data
     * @param seq
     * @return 位置を表す添字
     */
    private static int Find(int[] data, int[] seq) {
        // 配列よりシーケンスのほうが長かったら-1を返す
        if (seq.length > data.length) {
            return -1;
        }
        // マッチする位置(添字)を探す
        for (int i = 0; i < data.length; i++) {
            boolean isSeqExist = Match(data, seq, i);
            if (isSeqExist) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 配列の指定された位置から，シーケンスがマッチするか(一致するか)どうかを判定するメソッド
     * @param data
     * @param seq
     * @param base
     * @return
     */
    private static boolean Match(int[] data, int[] seq, int base) {
        if (seq.length + base <= data.length) {
            for (int si = 0; si < seq.length; si++) {
                if (data[base + si] != seq[si]) {
                    return false;
                }
            }
        } else {
            // 比較範囲超過の場合は直接falseを返す
            return false;
        }
        return true;
    }
}
