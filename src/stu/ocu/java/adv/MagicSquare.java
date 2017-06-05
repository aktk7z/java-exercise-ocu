package stu.ocu.java.adv;

import stu.ocu.java.Keyboard;

/*
 * 奇数 x 奇数の魔方陣を生成するプログラム
 * (演習問題 7-1)
 */
public class MagicSquare {
    // 魔方陣の大きさ
    private static int size;
    // 2次元配列
    private static int[][] matrix;

    public static void main(String[] args) {
        // 魔方陣のサイズ
        System.out.print("魔方陣のサイズを入力(3以上の奇数): ");
        size = Keyboard.intValue();
        // 奇数でない場合はエラーとして終了
        if (size % 2 != 1 || size < 3) {
            // System.exit(..) はプログラムを終了するためのメソッド．
            // 引数は，プログラムの終了コードで，0 は正常終了，0でない値は異常終了を示す．
            System.out.println("サイズが奇数でないか，3未満です");
            System.exit(1);
        }
        // matrix を確保
        // sizeが分からないと new できないので，ここで new している．
        matrix = new int[size][size];
        // 次に数を入れる座標
        int x, y;
        // 最初の座標を代入する (一番上の段の真ん中)
        // X座標は size / 2
        // size = 3 の場合，x = 3 / 2 = 1 になる．X方向の添え字は0〜2なので，真ん中は1 でよい．
        x = size / 2;
        // Y座標は0(一番上)
        y = 0;
        // 1から順番に値を詰めていく
        for (int n = 1; n <= size * size; n++) {
            System.out.println("Set " + n + " to (" + x + ", " + y + ")");
            matrix[x][y] = n;
            // 魔方陣の表示
            Display();
            // 次の位置を計算する．
            // moveメソッドはxとyの2つの値を返すために，要素数2のintの配列を返している
            int[] xy = Move(x, y);
            x = xy[0];    // 配列の0番目は x
            y = xy[1];    // 配列の1番目は y
        }
    }

    // 魔方陣を表示する
    private static void Display() {
        for (int y = 0; y < size; y++) {
            DrawBorder();
            for (int x = 0; x < size; x++) {
                System.out.printf("|%2d", matrix[x][y]);
            }
            System.out.print("|");
            System.out.println();
            if (y == size - 1) {
                DrawBorder();
            }
        }
    }

    // 魔方陣の罫線を描く
    private static void DrawBorder() {
        for (int i = 0; i < size; i++) {
            System.out.print("+--");
        }
        System.out.print("+");
        System.out.println();
    }

    /*
     * 魔方陣上で，(x, y)の次の場所を計算する．結果は，2要素のint配列で返す．
     * 配列の0番目の要素が x, 1番目の要素がy．
     */
    private static int[] Move(int x, int y) {
        /*
         * (x, y)の右上の枠の座標(nx, ny)を求める．
         * このとき，左右，上下の境界は繋がっているものとみなす．
         *            -> X方向
         *      +-----+-----+
         *      |     |nx,ny|
         * |    +-----+-----+
         * v    | x,y |     |
         * Y方向 +-----+-----+
         *
         * nx は基本的に x + 1 だが，一番右の枠の右は一番左になるので，
         * 剰余(%)を使った次の式で計算する．この形はよく出てくるので暗記するべき．
         */
        int nx = (x + 1) % size;
        /*
         * Y軸は下方向に増えるので，ny は基本的に y - 1 だが，一番上の枠の上は
         * 一番下になるので，これも剰余を使った式で計算する．
         * ny = (y - 1) % size だと，y = 0 のとき ny = -1 % size になるが，
         * size >=2 のとき，-1 % size == -1 になってしまう (-1 ÷ size = 0 余り -1)．
         * これだと具合が悪いので size を足してから剰余を計算する．
         * この形も良く出てくるので暗記するべき．
         */
        int ny = (y - 1 + size) % size;
        // 右上の枠(nx, ny)が空いていれば，その座標を返す．
        if (matrix[nx][ny] == 0) {
            // 0番目に nx を，1番目に ny を入れた配列を生成し，return する．
            return new int[]{nx, ny};
            // 上の行は見慣れない書き方だが，
            // int[] xy = {nx, ny};
            // return xy;
            // と等価
        }
        // 右上の枠が空いていない場合，(x, y)の下の枠の座標を返す．
        return new int[]{x, (y + 1) % size};
    }
}
