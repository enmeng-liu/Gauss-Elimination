package main;

import java.util.ArrayList;
import java.util.List;

public class TestMatrix {

    public static void main(String[] args){
        ArrayList<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction("2/3"));
        fractions.add(new Fraction("1"));
        fractions.add(new Fraction("1"));
        fractions.add(new Fraction("1/4"));
        fractions.add(new Fraction("6"));
        fractions.add(new Fraction("2"));
        fractions.add(new Fraction("1"));
        fractions.add(new Fraction("-1/9"));
        fractions.add(new Fraction("-2"));
        fractions.add(new Fraction("2/5"));
        fractions.add(new Fraction("1"));
        fractions.add(new Fraction("7"));
        Matrix matrix = new Matrix(3, 3, 4, fractions);
        System.out.println(matrix.toString());
        System.out.println("The above matrix is an echelon? " + matrix.isEchelon());
        System.out.println("The above matrix is an reduced echelon? " + matrix.isReducedEchelon());

        matrix.changePivotToOne(0);
        System.out.println(matrix.toString());
        System.out.println("The above matrix is an echelon? " + matrix.isEchelon());
        System.out.println("The above matrix is an reduced echelon? " + matrix.isReducedEchelon());

        matrix.addOneRowToAnother(0, 1, new Fraction("-6"));
        System.out.println(matrix.toString());
        System.out.println("The above matrix is an echelon? " + matrix.isEchelon());
        System.out.println("The above matrix is an reduced echelon? " + matrix.isReducedEchelon());

        matrix.addOneRowToAnother(0, 2, new Fraction("2"));
        System.out.println(matrix.toString());
        System.out.println("The above matrix is an echelon? " + matrix.isEchelon());
        System.out.println("The above matrix is an reduced echelon? " + matrix.isReducedEchelon());

        matrix.changePivotToOne(1);
        System.out.println(matrix.toString());
        System.out.println("The above matrix is an echelon? " + matrix.isEchelon());
        System.out.println("The above matrix is an reduced echelon? " + matrix.isReducedEchelon());

        matrix.addOneRowToAnother(1, 0, new Fraction("-3/2"));
        System.out.println(matrix.toString());
        System.out.println("The above matrix is an echelon? " + matrix.isEchelon());
        System.out.println("The above matrix is an reduced echelon? " + matrix.isReducedEchelon());

        matrix.addOneRowToAnother(1, 2, new Fraction("-17/5"));
        System.out.println(matrix.toString());
        System.out.println("The above matrix is an echelon? " + matrix.isEchelon());
        System.out.println("The above matrix is an reduced echelon? " + matrix.isReducedEchelon());

        matrix.changePivotToOne(2);
        System.out.println(matrix.toString());
        System.out.println("The above matrix is an echelon? " + matrix.isEchelon());
        System.out.println("The above matrix is an reduced echelon? " + matrix.isReducedEchelon());

        matrix.addOneRowToAnother(2, 0, new Fraction("3/14"));
        System.out.println(matrix.toString());
        System.out.println("The above matrix is an echelon? " + matrix.isEchelon());
        System.out.println("The above matrix is an reduced echelon? " + matrix.isReducedEchelon());

        matrix.addOneRowToAnother(2, 1, new Fraction("-8/7"));
        System.out.println(matrix.toString());
        System.out.println("The above matrix is an echelon? " + matrix.isEchelon());
        System.out.println("The above matrix is an reduced echelon? " + matrix.isReducedEchelon());





    }
}
