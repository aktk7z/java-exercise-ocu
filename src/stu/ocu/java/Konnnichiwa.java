package stu.ocu.java;

public class Konnnichiwa {

    public static void main(String[] args) {
	    // Hello, World
        String msg = "こんにちは";
        // print出力
        for (char ch : msg.toCharArray()) {
            System.out.print(ch);
        }
        // println出力
        System.out.println();
        for (char ch : msg.toCharArray()) {
            System.out.println(ch);
        }
    }
}
