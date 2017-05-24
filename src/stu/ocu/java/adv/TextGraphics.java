package stu.ocu.java.adv;

// 演習(テキストグラフィックス)
public class TextGraphics {
    // クラス変数の宣言
    // final は，変数の値が書き変わらないことを示す．
    private final static int WIDTH = 40;    // 横幅の定義
    private final static int HEIGHT = 30;    // 高さの定義
    // WIDTH x HEIGHT の2次元配列を確保
    private static boolean[][] canvas = new boolean[WIDTH][HEIGHT];

    // 以下，メソッド定義
    public static void main(String[] args) {
        System.out.println("Screen width: " + WIDTH);
        System.out.println("Screen height: " + HEIGHT);

        box(3, 3, 8, 4);
        boxFill(14, 3, 8, 4);
        circle(10, 15, 7);
        circleFill(30, 15, 7);
        display();
    }

    // 指定された配列を表示する
    // 左上が原点で，Y軸は下方向に増加する点に注意すること
    private static void display() {
        // 上側のルーラー表示
        System.out.print("  ");
        for (int x = 0; x < WIDTH; x++) {
            System.out.print(x % 10);
        }
        System.out.println();
        System.out.print("  ");
        for (int x = 0; x < WIDTH; x++) {
            System.out.print("-");
        }
        System.out.println();
        for (int y = 0; y < HEIGHT; y++) {
            // 左側のルーラー表示
            System.out.print(y % 10 + "|");
            // 配列の値に応じて * か . を表示
            for (int x = 0; x < WIDTH; x++) {
                if (canvas[x][y]) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    // 指定された座標が点を打つ (ただし領域の中に入っているときのみ)
    private static void set(int x, int y) {
        if (inArea(x, y)) {
            canvas[x][y] = true;
        }
    }

    // 指定された座標が領域内かどうか判定する
    private static boolean inArea(int x, int y) {
        if (x < 0 || WIDTH <= x) {
            return false;
        }
        if (y < 0 || HEIGHT <= y) {
            return false;
        }
        return true;
    }

    // (x, y)から幅 width，高さ height の塗りつぶした長方形を描画する
    private static void boxFill(int x, int y, int width,
                                int height) {
        for (int yy = 0; yy < height; yy++) {
            for (int xx = 0; xx < width; xx++) {
                set(x + xx, y + yy);
            }
        }
    }

    // (x, y)から幅 width，高さ height の塗りつぶしていない長方形を描画する
    private static void box(int x, int y, int width,
                            int height) {
        for (int yy = 0; yy < height; yy++) {
            set(x, y + yy);
            set(x + width - 1, y + yy);
        }
        for (int xx = 0; xx < width; xx++) {
            set(x + xx, y);
            set(x + xx, y + height - 1);
        }
    }

    // 中心 (cx, cy)，半径 radius の塗りつぶした円を描画する
    private static void circleFill(int cx, int cy,
                                   int radius) {
        for (int y = -radius; y <= radius; y++) {
            for (int x = -radius; x <= radius; x++) {
                if (x * x + y * y <= radius * radius) {
                    set(cx + x, cy + y);
                }
            }
        }
    }

    // 中心 (cx, cy)，半径 radius の塗りつぶしていない円を描画する
    private static void circle(int cx, int cy, int radius) {
        for (int theta = 0; theta < 360; theta++) {
            int x = (int) (Math.cos(Math.toRadians(theta)) * radius);
            int y = (int) (Math.sin(Math.toRadians(theta)) * radius);
            set(cx + x, cy + y);
        }
    }
}
