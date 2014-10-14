package javahtmlgenerator;

import javax.swing.JFrame;

/**
 * The HTMLGeneratorGUI class displays the Application Frame.
 * @author Keith McKiernan
 * @date 01/04/14
 */
public class HTMLGeneratorGUI 
{
    public static void main(String[] args) 
    {     
        JFrame frame = new JFrame();
        frame.setSize(900, 740);
        frame.setTitle("HTML File Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create an object of the JavaHTMLGenerator class and add it to the frame
        JavaHTMLGenerator myJavaHTMLGenerator = new JavaHTMLGenerator();
        myJavaHTMLGenerator.setLayout(null);
        frame.add(myJavaHTMLGenerator);       
                
        // Don't Allow Frame Resizing
        frame.setResizable(false);
        
        // Display The Frame
        frame.setVisible(true);
    }
}
