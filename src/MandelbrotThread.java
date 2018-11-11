
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puwasuru
 */
public class MandelbrotThread implements Runnable {

    public static int maxiteration;

    // variables to store region of interest
    private float xnegative;
    private float ynegative;
    private float xpositive;
    private float ypositive;

    public static int [][] mittarray = new int [800][800]; // shared 2-d array

    // region that each thread need to work on
    private int rowend;
    private int rowstart;
    private int colend;
    private int colstart;

    // size of canvas
    private int height = 800;
    private int width = 800;

    public MandelbrotThread(int rowstart, int rowend, int colstart, int colend){
        this.maxiteration = 1000;
        this.xpositive = (float)1;
        this.ypositive = (float)1;
        this.xnegative = (float)-1;
        this.ynegative = (float)-1;

        this.rowend = rowend;
        this.rowstart = rowstart;
        this.colstart = colstart;
        this.colend = colend;
    }

    public MandelbrotThread(float xpositive, float xnegative, float ypositive, float ynegative,int rowstart, int rowend, int colstart, int colend){
        this.maxiteration = 1000;
        this.xpositive = xpositive;
        this.ypositive = ypositive;
        this.xnegative = xnegative;
        this.ynegative = ynegative;

        this.rowend = rowend;
        this.rowstart = rowstart;
        this.colstart = colstart;
        this.colend = colend;

    }

    public MandelbrotThread(float xpositive, float xnegative, float ypositive, float ynegative, int iteration, int rowstart, int rowend, int colstart, int colend) {
        this.maxiteration = iteration;
        this.xpositive = xpositive;
        this.ypositive = ypositive;
        this.xnegative = xnegative;
        this.ynegative = ynegative;

        this.rowend = rowend;
        this.rowstart = rowstart;
        this.colstart = colstart;
        this.colend = colend;
    }

    public void run() {

        //get each pixel and check wheather that pixel diverge

        for (int row = rowstart; row < rowend; row++) {
            for (int col = colstart; col < colend; col++) {

                // mapping pixels to the complex plain
                double c_im = (double) (this.ypositive - ((this.ypositive - this.ynegative) / this.height * row));
                double c_re = (double) (this.xnegative - ((this.xnegative - this.xpositive) / this.width * col));

                ComplexNum zn = new ComplexNum();
                ComplexNum c = new ComplexNum(c_re,c_im);

                int iterations = 0;
                // check wheather complex number remain on the region
                while (ComplexNum.norm(zn) < 4 && iterations < maxiteration) {

                    zn=ComplexNum.add(ComplexNum.sqr(zn),c);
                    iterations++;
                }

                // no. of iteration are stored in a 2-d array
                mittarray[row][col]= iterations;

            }
        }

    }


}
