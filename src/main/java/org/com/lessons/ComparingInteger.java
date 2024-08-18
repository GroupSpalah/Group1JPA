package org.com.lessons;

public class ComparingInteger {
    public static void main(String[] args) {
        /**
         * -128 - 127
         */
        Integer i1 = new Integer(5);
        Integer i2 = new Integer(5);

        System.out.println("i1 == i2 = " + (i1 == i2));

        Integer v1 = 15;
        Integer v2 = 15;

        System.out.println(v1 == v2);

        Integer v3 = 157;
        Integer v4 = 157;

        System.out.println(v3 == v4);


    }
}
