

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
public class Fractal {



    public static void main(String [] args) throws InterruptedException {

        try{
            //this block execute if user have given all arguments

            // check the fractal type
            if(args[0].equalsIgnoreCase("Mandelbrot")){
                try{

                    // store arguments in variables
                    float xpositive = Float.parseFloat(args[1]);
                    float xnegative = Float.parseFloat(args[2]);
                    float ypositive = Float.parseFloat(args[3]);
                    float ynegative = Float.parseFloat(args[4]);
                    int iteration = Integer.parseInt(args[5]);

                    // create 4 threads
                    Thread thread1 = new Thread(new MandelbrotThread(xpositive,xnegative,ypositive,ynegative,iteration,0,400,0,400));
                    Thread thread2 = new Thread(new MandelbrotThread(xpositive,xnegative,ypositive,ynegative,iteration,0,400,400,800));
                    Thread thread3 = new Thread(new MandelbrotThread(xpositive,xnegative,ypositive,ynegative,iteration,400,800,0,400));
                    Thread thread4 = new Thread(new MandelbrotThread(xpositive,xnegative,ypositive,ynegative,iteration,400,800,400,800));

                    //start all the threads
                    thread1.start();thread2.start();thread3.start(); thread4.start();

                    // stop the main thread untill all other threads are terminated
                    thread1.join();thread2.join();thread3.join();thread4.join();

                    // Create a frame
                    Frame frame = new Frame("Mandelbrot");

                    // paint the canvas with suitable colors
                    for (int row = 0; row < 800; row++) {
                        for (int col = 0; col < 800; col++) {

                            if (MandelbrotThread.mittarray[row][col] < MandelbrotThread.maxiteration) {
                                (Frame.image).setRGB(col, row, ColorScheme.getColor("mandelbrot", MandelbrotThread.mittarray[row][col], MandelbrotThread.maxiteration));
                            } else {
                                (Frame.image).setRGB(col, row, 0);
                            }

                        }
                    }

                    // add the canvs to the frame
                    (Frame.frame).add(new JLabel(new ImageIcon(Frame.image)));
                    (Frame.frame).pack();
                    (Frame.frame).setVisible(true);

                }catch(ArrayIndexOutOfBoundsException e){

                    try{
                        //this block execute if user have given only 4 arguments(not include maximum iteration)

                        float xpositive = Float.parseFloat(args[1]);
                        float xnegative = Float.parseFloat(args[2]);
                        float ypositive = Float.parseFloat(args[3]);
                        float ynegative = Float.parseFloat(args[4]);

                        Thread thread1 = new Thread(new MandelbrotThread(xpositive,xnegative,ypositive,ynegative,0,400,0,400));
                        Thread thread2 = new Thread(new MandelbrotThread(xpositive,xnegative,ypositive,ynegative,0,400,400,800));
                        Thread thread3 = new Thread(new MandelbrotThread(xpositive,xnegative,ypositive,ynegative,400,800,0,400));
                        Thread thread4 = new Thread(new MandelbrotThread(xpositive,xnegative,ypositive,ynegative,400,800,400,800));

                        thread1.start();thread2.start();thread3.start(); thread4.start();
                        thread1.join();thread2.join();thread3.join();thread4.join();

                        Frame frame = new Frame("Mandelbrot");

                        for (int row = 0; row < 800; row++) {
                            for (int col = 0; col < 800; col++) {

                                if (MandelbrotThread.mittarray[row][col] < MandelbrotThread.maxiteration) {
                                    (Frame.image).setRGB(col, row, ColorScheme.getColor("mandelbrot", MandelbrotThread.mittarray[row][col], MandelbrotThread.maxiteration));
                                } else {
                                    (Frame.image).setRGB(col, row, 0);
                                }

                            }
                        }

                        (Frame.frame).add(new JLabel(new ImageIcon(Frame.image)));
                        (Frame.frame).pack();
                        (Frame.frame).setVisible(true);

                    }catch(ArrayIndexOutOfBoundsException er){

                        //this block execute if user have only the fractal name (Mandelbrot)

                        Thread thread1 = new Thread(new MandelbrotThread(0,400,0,400));
                        Thread thread2 = new Thread(new MandelbrotThread(0,400,400,800));
                        Thread thread3 = new Thread(new MandelbrotThread(400,800,0,400));
                        Thread thread4 = new Thread(new MandelbrotThread(400,800,400,800));

                        thread1.start();thread2.start();thread3.start(); thread4.start();
                        thread1.join();thread2.join();thread3.join();thread4.join();

                        Frame frame = new Frame("Mandelbrot");

                        for (int row = 0; row < 800; row++) {
                            for (int col = 0; col < 800; col++) {

                                if (MandelbrotThread.mittarray[row][col] < MandelbrotThread.maxiteration) {
                                    (Frame.image).setRGB(col, row, ColorScheme.getColor("mandelbrot", MandelbrotThread.mittarray[row][col], MandelbrotThread.maxiteration));
                                } else {
                                    (Frame.image).setRGB(col, row, 0);
                                }

                            }
                        }

                        frame.add(new JLabel(new ImageIcon(Frame.image)));
                        frame.pack();
                        frame.setVisible(true);

                    }
                }
                // check wheather the given fractal is julia
            }else if(args[0].equalsIgnoreCase("Julia")){
                try{
                    //this block execute if user have given all arguments(constant and iteration)

                    // gets the constant complex number and store in variables
                    double creal = Double.parseDouble(args[1]);
                    double cimm = Double.parseDouble(args[2]);
                    // gets the maximum iteration
                    int iteration = Integer.parseInt(args[3]);

                    // create 4 threads
                    Thread thread1 = new Thread(new JuliaThread(creal,cimm,iteration,0,400,0,400));
                    Thread thread2 = new Thread(new JuliaThread(creal,cimm,iteration,0,400,400,800));
                    Thread thread3 = new Thread(new JuliaThread(creal,cimm,iteration,400,800,0,400));
                    Thread thread4 = new Thread(new JuliaThread(creal,cimm,iteration,400,800,400,800));

                    //start all the threads
                    thread1.start();thread2.start();thread3.start(); thread4.start();

                    // stop the main thread untill all other threads are terminated
                    thread1.join();thread2.join();thread3.join();thread4.join();

                    // Create a frame
                    Frame frame = new Frame("Julia");

                    // paint the canvas with suitable colors
                    for (int row = 0; row < 800; row++) {
                        for (int col = 0; col < 800; col++) {

                            if (JuliaThread.jittarray[row][col] < JuliaThread.maxiteration) {
                                (Frame.image).setRGB(col, row, ColorScheme.getColor("julia", JuliaThread.jittarray[row][col], JuliaThread.maxiteration));
                            } else {
                                (Frame.image).setRGB(col, row, 0);
                            }


                        }
                    }

                    // add the canvs to the frame
                    (Frame.frame).add(new JLabel(new ImageIcon(Frame.image)));
                    (Frame.frame).pack();
                    (Frame.frame).setVisible(true);



                }catch(ArrayIndexOutOfBoundsException e){
                    try{
                        //this block execute if user enters only the constant complex number

                        double creal = Double.parseDouble(args[1]);
                        double cimm = Double.parseDouble(args[2]);

                        Thread thread1 = new Thread(new JuliaThread(creal,cimm,0,400,0,400));
                        Thread thread2 = new Thread(new JuliaThread(creal,cimm,0,400,400,800));
                        Thread thread3 = new Thread(new JuliaThread(creal,cimm,400,800,0,400));
                        Thread thread4 = new Thread(new JuliaThread(creal,cimm,400,800,400,800));

                        thread1.start();thread2.start();thread3.start(); thread4.start();
                        thread1.join();thread2.join();thread3.join();thread4.join();

                        Frame frame = new Frame("Julia");

                        for (int row = 0; row < 800; row++) {
                            for (int col = 0; col < 800; col++) {

                                if (JuliaThread.jittarray[row][col] < JuliaThread.maxiteration) {
                                    (Frame.image).setRGB(col, row, ColorScheme.getColor("julia", JuliaThread.jittarray[row][col], JuliaThread.maxiteration));
                                } else {
                                    (Frame.image).setRGB(col, row, 0);
                                }


                            }
                        }

                        (Frame.frame).add(new JLabel(new ImageIcon(Frame.image)));
                        (Frame.frame).pack();
                        (Frame.frame).setVisible(true);

                    }catch(ArrayIndexOutOfBoundsException er){

                        // this block execute if user enters only the fractal name

                        Thread thread1 = new Thread(new JuliaThread(0,400,0,400));
                        Thread thread2 = new Thread(new JuliaThread(0,400,400,800));
                        Thread thread3 = new Thread(new JuliaThread(400,800,0,400));
                        Thread thread4 = new Thread(new JuliaThread(400,800,400,800));

                        thread1.start();thread2.start();thread3.start(); thread4.start();
                        thread1.join();thread2.join();thread3.join();thread4.join();

                        Frame frame = new Frame("Julia");

                        for (int row = 0; row < 800; row++) {
                            for (int col = 0; col < 800; col++) {

                                if (JuliaThread.jittarray[row][col] < JuliaThread.maxiteration) {
                                    (Frame.image).setRGB(col, row, ColorScheme.getColor("julia", JuliaThread.jittarray[row][col], JuliaThread.maxiteration));
                                } else {
                                    (Frame.image).setRGB(col, row, 0);
                                }


                            }
                        }

                        (Frame.frame).add(new JLabel(new ImageIcon(Frame.image)));
                        (Frame.frame).pack();
                        (Frame.frame).setVisible(true);

                    }
                }

            }else{
                // if the fractal name is not correct
                System.out.println("Must give the correct fractal name");
            }

        }catch(ArrayIndexOutOfBoundsException e){
            // if no. of argument are not as specifed in lab sheet
            System.out.println("Must give correct arguments");
        }
    }


}
