
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puwasuru
 */
public class Frame extends JFrame {

    public static JFrame frame;
    public int width = 800;
    public int height = 800;
    public static BufferedImage image;


    public Frame(String set){
        frame = new JFrame(set);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

}
