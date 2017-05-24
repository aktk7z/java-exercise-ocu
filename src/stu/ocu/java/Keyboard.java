package stu.ocu.java;
import java.io.*;

// $Id: Keyboard.java,v 1.1 2003/04/11 06:04:04 k-abe Exp $

/**
 * キーボード入力のための補助クラス.
 */
public class Keyboard {
    static BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));

    // new によってインスタンスを生成できないようにする
    private Keyboard() {
    }

    /**
     * キーボードからint型の整数を入力する.
     *
     * @return キーボードから入力された整数値
     */
    public static int intValue() {
        int val = -1;
        boolean done = false;
        while (!done) {
            try {
                String line = in.readLine();
                if (line == null) {
                    return -1;
                }
                val = (new Integer(line)).intValue();
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("数を入れてください!");
            } catch (Exception e) {
                System.out.println("Exception: " + e);
                System.exit(0);
            }
        }
        return val;
    }

    /**
     * キーボードからlong型の整数を入力する.
     *
     * @return キーボードから入力された整数値
     */
    public static long longValue() {
        long val = -1;
        boolean done = false;
        while (!done) {
            try {
                String line = in.readLine();
                if (line == null) {
                    return -1;
                }
                val = (new Integer(line)).intValue();
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("数を入れてください!");
            } catch (Exception e) {
                System.out.println("Exception: " + e);
                System.exit(0);
            }
        }
        return val;
    }

    /**
     * キーボードからfloat型の実数を入力する.
     *
     * @return キーボードから入力された実数値
     */
    public static float floatValue() {
        float val = -1;
        boolean done = false;
        while (!done) {
            try {
                String line = in.readLine();
                if (line == null) {
                    return -1;
                }
                val = (new Float(line)).floatValue();
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("数を入れてください!");
            } catch (Exception e) {
                System.out.println("Exception: " + e);
                System.exit(0);
            }
        }
        return val;
    }

    /**
     * キーボードからdouble型の実数を入力する.
     *
     * @return キーボードから入力された実数値
     */
    public static double doubleValue() {
        double val = -1;
        boolean done = false;
        while (!done) {
            try {
                String line = in.readLine();
                if (line == null) {
                    return -1;
                }
                val = (new Double(line)).doubleValue();
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("数を入れてください!");
            } catch (Exception e) {
                System.out.println("Exception: " + e);
                System.exit(0);
            }
        }
        return val;
    }

    /**
     * キーボードからString型の文字列を入力する.
     *
     * @return キーボードから入力された文字列
     */
    public static String stringValue() {
        String val = null;
        boolean done = false;
        while (!done) {
            try {
                val = in.readLine();
                done = true;
            } catch (Exception e) {
                System.out.println("Exception: " + e);
                System.exit(0);
            }
        }
        return val;
    }
}