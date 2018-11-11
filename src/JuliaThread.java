/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puwasuru
 */
public class JuliaThread implements Runnable {

    public static int maxiteration=1000;
    private double con_re;
    private double con_im;

    // variables to store region of interest
    private float xnegative=-1;
    private float ynegative=-1;
    private float xpositive=1;
    private float ypositive=1;

    public static int [][] jittarray = new int [800][800];// shared 2-d array

    // region that each thread need to work on
    private int rowend;
    private int rowstart;
    private int colend;
    private int colstart;

    // size of canvas
    private int height = 800;
    private int width = 800;

    public JuliaThread(int rowstart, int rowend, int colstart, int colend) {

        this.con_re = -0.4;
        this.con_im = 0.6;

        this.rowend = rowend;
        this.rowstart = rowstart;
        this.colstart = colstart;
        this.colend = colend;
    }

    public JuliaThread(double con_re, double con_im, int rowstart, int rowend, int colstart, int colend) {

        this.con_re = con_re;
        this.con_im = con_im;

        this.rowend = rowend;
        this.rowstart = rowstart;
        this.colstart = colstart;
        this.colend = colend;

    }

    public JuliaThread(double con_re, double con_im, int iteration, int rowstart, int rowend, int colstart, int colend) {

        this.con_re = con_re;
        this.con_im = con_im;
        this.maxiteration = iteration;

        this.rowend = rowend;
        this.rowstart = rowstart;
        this.colstart = colstart;
        this.colend = colend;

    }

    public void run() {

        //get each pixel and check wheather that pixel diverge

        for (int row = rowstart; row < rowend; row++) {
            for (int col = colstart; col < colend; col++) {

                // mapping each pixel to the complex plain
                double c_im = (double) (this.ypositive - ((this.ypositive - this.ynegative) / this.height * row));
                double c_re = (double) (this.xnegative - ((this.xnegative - this.xpositive) / this.width * col));

                ComplexNum zn = new ComplexNum(c_re,c_im);
                ComplexNum c = new ComplexNum(con_re,con_im);

                int iterations = 0;
                // check wheather complex number remain on the region
                while (ComplexNum.norm(zn) < 4 && iterations < maxiteration) {

                    zn=ComplexNum.add(ComplexNum.sqr(zn),c);
                    iterations++;
                }

                // no. of iteration are stored in a 2-d array
                jittarray[row][col]= iterations;

            }
        }

    }

}
