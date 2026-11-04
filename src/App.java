import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
       int boardWidth = 360; // Width of the game board
       int boardHeight = 640; //Height of the game board
        JFrame frame = new JFrame ("Baguette Bird"); 
// Generates a new JFrame 
//JFrame is a class used to create GUI components
       //  frame.setVisible(true); // Makes the JFrame visible on the screen
        frame.setSize(boardWidth, boardHeight); 
        frame.setLocationRelativeTo (null); // Centers the JFrame on the screen by setting its location relative to null. 
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 


        BaguetteBird baguetteBird = new BaguetteBird(); //Function call to the BaguetteBird class
        // Creates a new instance of the BaguetteBird JPanel. This JPanel will be added to the JFrame to display the game board
        //JPanel is a class used to create a container for other GUI components.
        //JFrame generates the window for the game
        //BaguetteBird JPanel will be used to display the game and handle interactions.
        frame.add(baguetteBird);
        frame.pack(); // Want it to be 640 x 360 not including the title bar
        frame.setVisible(true);



    }
}
