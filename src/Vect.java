/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author Ivan
 */
public class Vect {

    private double x;
    private double y;

    public Vect(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    static Vect sub(Vect v, Vect v2) {
        return new Vect(v.x - v2.x, v.y - v2.y);
    }

    void mult(double val) {
        x *= val;
        y *= val;
    }

    void normalize() {
        double mag = mag();
        if (mag != 0) {
            x /= mag;
            y /= mag;
        }
    }

    void div(double val) {
        x /= val;
        y /= val;
    }

    double mag() {
        return sqrt(pow(x, 2) + pow(y, 2));
    }

    public String toString() {
        return "Vector: X:" + x + " Y: " + y;
    }
}
