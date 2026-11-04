import java.awt.*; // Importing the AWT (Abstract Window Toolkit) package, which provides classes for creating graphical user interfaces (GUIs) and handling events in Java. The asterisk (*) indicates that all classes in the java.awt package are being imported.
import java.awt.event.*; // Contains classes and interfaces used to handle events (user interactions) in Java programs
import java.util.ArrayList; // 
import java.util.Random; 
// Importing the Random class from the java.util package, which provides METHODS for generating random numbers.
// The Random class will be used to generate random positions for the pipe
import javax.swing.*; // Importing the Swing package, which provides classes for creating GUI components in Java.
// The asterisk (*) indicates that all classes in the javax.swing package are being imported.
// .* means that something will be imported from the package and is not specified unless done so


public class BaguetteBird extends JPanel implements ActionListener{
    int boardWidth = 360; // Width of the game board
    int boardHeight = 640; // Height of the game board

    //Images
    Image backgroundImg;
    Image birdImg;  
    Image topPipeImg;
    Image bottomPipeImg;
    
    //Bird
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;

    int birdWidth = 100;
    int birdHeight = 100;

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

         Bird(Image img ) {
            this.img = img; 
        }

    }



//Game logic

Bird bird;
int velocityY = -6;

Timer gameLoop;


    BaguetteBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight)); // Sets the preferred size of the JPanel to the specified width and height
        // setBackground(Color.blue); 


        //load imagaes  
        backgroundImg = new ImageIcon(getClass().getResource("./Pixel Paris Baguette Skyline.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./Bautee.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./1.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./2.png")).getImage();
        
        //Bird
        bird = new Bird(birdImg);


        //Game timer

        gameLoop = new Timer(1000/60, this); //1000/60 = 16.67 which is 60 FPS
        gameLoop.start(); // Starts the game loop timer; triggers the actionPerformed method at regular intervals 
        // (every 16.67 milliseconds) to update the game state and repaint the panel.

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Calls the paintComponent method of the superclass (JPanel) to ensure that the panel is properly rendered before adding custom graphics.
        draw(g); // Calls the draw method to render the game elements on the panel
    }

    public void draw(Graphics g) {
        System.out.println("draw");
       //background
       g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null); 

       //bird 
       g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null); // Draws the bird image at the specified position (bird.x, bird.y) with the specified width and height (bird.width, bird.height) on the panel. The last parameter (null) indicates that no image observer is used.
    }

    public void move() {
        //bird
        bird.y += velocityY
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint(); // Calls the repaint method to request a repaint of the JPanel, 
        //Triggers the paintComponent method and update the game graphics on the screen.
    }


}