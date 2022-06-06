package com.epam.rd.autotasks;

public class QuadraticEquation {

    public String solve(double a, double b, double c) {

        if (a == 0.0) throw new IllegalArgumentException();

        double discriminant = Math.pow(b, 2) - 4 * a * c;
        double xOne = (-b + Math.sqrt(discriminant)) / (2 * a);
        double xtwo = (-b - Math.sqrt(discriminant)) / (2 * a);

        if (discriminant > 0) return String.format("%s %s", xOne, xtwo);

        else if (discriminant == 0) return String.format("%s", xOne);

        else return "no roots";
    }
}
