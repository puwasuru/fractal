
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puwasuru
 */
public class ColorScheme {

    public ColorScheme(){}

    // a static method to get a collor according to the iteration

    public static int getColor(String set, int iteration, int maxiteration){
        if(set.equals("mandelbrot")){
            return Color.HSBtoRGB((float) iteration / 256, 1.0f, iteration / (8.0f + (float) iteration));

        }else{
            return Color.HSBtoRGB((25f*iteration/maxiteration)/2,(25f*iteration/maxiteration), (25f*iteration/maxiteration));

        }
    }

}

