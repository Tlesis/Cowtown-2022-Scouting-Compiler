package org.usd232.robotics;

public class CompilerMain {

    public static void main(String args[]) {
        try {
            for (String arg : args) {
                new Reader(arg).print();
                System.out.println("------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
