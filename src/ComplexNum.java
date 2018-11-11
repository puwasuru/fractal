
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puwasuru
 */
public class ComplexNum {

    private double real;
    private double imaginary;

    public ComplexNum(){
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    public ComplexNum(double a, double b){
        this.real = a;
        this.imaginary = b;

    }

    public static ComplexNum add(ComplexNum z1, ComplexNum z2){
        return new ComplexNum(z1.real + z2.real , z1.imaginary + z2.imaginary);
    }

    public static ComplexNum sqr(ComplexNum z){
        double _real = (z.real*z.real)-(z.imaginary*z.imaginary);
        double _imaginary = 2*z.real*z.imaginary;
        return new ComplexNum(_real,_imaginary);
    }

    public static double norm(ComplexNum z){
        return (z.real*z.real) + (z.imaginary*z.imaginary);
    }

    public static void show(ComplexNum z){
        System.out.println(z.real + "   " + z.imaginary);
    }

}
