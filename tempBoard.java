<<<<<<< HEAD

/**
 * Write a description of class tempBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class tempBoard extends JPanel
{
    //instance fields
    tile[] tileArray = new tile[60];

    tile[] blue = new tile [4];
    tile[] green = new tile [4];
    tile[] red = new tile [4];
    tile[] yellow = new tile [4];
    
    tile[] blueSafe = new tile [6];
    tile[] greenSafe = new tile [6];
    tile[] redSafe = new tile [6];
    tile[] yellowSafe = new tile [6];

    int pieceLocationX, pieceLocationY;
    public JButton button;
    public Deck deck;
    final int BLUE_PLAYER = 0;
    final int GREEN_PLAYER = 1;
    final int RED_PLAYER = 2;
    final int YELLOW_PLAYER = 3;

    piece[] pieceArray = new piece[4];

    piece bluePiece, greenPiece, redPiece, yellowPiece;
    //conctructor
    public tempBoard() {
        //setLayout(new BorderLayout());
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        /*
        c.anchor = GridBagConstraints.LAST_LINE_START;
        card = new Card();
        add(card, c);
         */

        //creating the graphical objects
        setPreferredSize(new Dimension(1980,1080));
        //for loop for creating the amount of tiles 9 at this point
        int y=0;
        int x = 0;
        int colour = 0;
        for(int i = 0; i <= 14; i++) {
            tileArray[i]= new tile(x, y,colour);
            x++;
        }
        for(int i = 15; i <= 29; i++) {
            tileArray[i]= new tile(x, y,colour);
            y++;
        }
        for(int i = 30; i <= 44; i++) {
            tileArray[i]= new tile(x, y,colour);
            x--;
        }
        for(int i = 45; i <= 59; i++) {
            tileArray[i]= new tile(x, y,colour);
            y--;
        }
        //print blue base
        colour = 1;
        x = 4;
        y= 2;
        for(int i = 0; i <= 1; i++) {
            blue[i]= new tile(x, y,colour);
            x++;
        }
        x=4;
        y++;
        for(int i = 2; i <= 3; i++) {
            blue[i]= new tile(x, y,colour);
            x++;
        }
        //print green base
        colour=2;
        x=12;
        y=4;
        for(int i = 0; i <= 1; i++) {
            green[i]= new tile(x, y,colour);
            x++;
        }
        x=12;
        y++;
        for(int i = 2; i <= green.length-1; i++) {
            green[i]= new tile(x, y,colour);
            x++;
        }
        //print red base
        colour=3;
        x = 10;
        y= 12;
        for(int i = 0; i <= 1; i++) {
            red[i]= new tile(x, y,colour);
            x++;
        }
        x=10;
        y++;
        for(int i = 2; i <= 3; i++) {
            red[i]= new tile(x, y,colour);
            x++;
        }
        //print yellow base
        colour=4;
        x=2;
        y=10;
        for(int i = 0; i <= 1; i++) {
            yellow[i]= new tile(x, y,colour);
            x++;
        }
        x=2;
        y++;
        for(int i = 2; i <= green.length-1; i++) {
            yellow[i]= new tile(x, y,colour);
            x++;
        }
        
        
        //Print safe zone
        
        //blue
        x=2;
        y=1;
        colour=1;
        for(int i = 0; i <= blueSafe.length-1; i++) {
            blueSafe[i]= new tile(x, y,colour);
            y++;
        }
        //green
        x=14;
        y=2;
        colour=2;
        for(int i = 0; i <= greenSafe.length-1; i++) {
            greenSafe[i]= new tile(x, y,colour);
            x--;
        }
        //yellow
        x=13;
        y=14;
        colour=3;
        for(int i = 0; i <= redSafe.length-1; i++) {
            redSafe[i]= new tile(x, y,colour);
            y--;
        }
        //red
        x=1;
        y=13;
        colour=4;
        for(int i = 0; i <= yellowSafe.length-1; i++) {
            yellowSafe[i]= new tile(x, y,colour);
            x++;
        }
        
        
        bluePiece = new piece(BLUE_PLAYER, tileArray);
        pieceArray[BLUE_PLAYER]= bluePiece;

        greenPiece = new piece(GREEN_PLAYER, tileArray);
        pieceArray[GREEN_PLAYER]= greenPiece;

        redPiece = new piece(RED_PLAYER, tileArray);
        pieceArray[RED_PLAYER]= redPiece;

        yellowPiece = new piece(YELLOW_PLAYER, tileArray);
        pieceArray[YELLOW_PLAYER]= yellowPiece;

        deck = new Deck();

        //creating the button
        c.anchor = GridBagConstraints.LAST_LINE_END;
        button = new JButton("Advance the piece");
        button.addActionListener(new buttonListener());       
        button.setSize(new Dimension(200, 50));
        add(button, c);
    }

    public  void paintComponent(Graphics page) {
        //painting the components
        super.paintComponent(page);
        for(int i = 0; i <= 59; i++) {
            tileArray[i].draw(page);
        } 
        for(int i = 0; i <= blue.length-1; i++) {
            blue[i].draw(page);
        } 
        for(int i = 0; i <= green.length-1; i++) {
            green[i].draw(page);
        } 
        for(int i = 0; i <= red.length-1; i++) {
            red[i].draw(page);
        } 
         for(int i = 0; i <= yellow.length-1; i++) {
            yellow[i].draw(page);
        } 
        for(int i = 0; i <= blueSafe.length-1; i++) {
            blueSafe[i].draw(page);
        } 
        for(int i = 0; i <= greenSafe.length-1; i++) {
            greenSafe[i].draw(page);
        } 
        for(int i = 0; i <= redSafe.length-1; i++) {
            redSafe[i].draw(page);
        } 
         for(int i = 0; i <= yellowSafe.length-1; i++) {
            yellowSafe[i].draw(page);
        } 
        bluePiece.draw(page);
        greenPiece.draw(page);
        redPiece.draw(page);
        yellowPiece.draw(page);
    }
    public class buttonListener implements ActionListener 
    {
        int state = 0;
        public void actionPerformed ( ActionEvent e) 
        {
            // temoporary variable so the moving engline knows how many
            int temp = deck.Draw().getValue();
            //finitie state machine description
            // the state starts at 0 which corresponds to the blue player
            // after he/she has taken thier turn it will move the state to the next one
            //signifying the next player
            if(tileArray[pieceArray[state].getNextSpot(temp)].getOccupation()== -1)
            {
                // thes its current tile to empty
                tileArray[pieceArray[state].locationValue].removePiece();
                //updates the location value in the piece to the new one
                pieceArray[state].setlocationValue(pieceArray[state].getNextSpot(temp));
                // updates the graphical corrdinates
                pieceArray[state].updateX(tileArray[pieceArray[state].locationValue].getX());//tileArray[pieceLocationX].getX());
                pieceArray[state].updateY(tileArray[pieceArray[state].locationValue].getY());//tileArray[pieceLocationY].getY());
                //sets the current spot its at to occupied
                tileArray[pieceArray[state].locationValue].setOccupation(state);
                //repaints the panel
                repaint();
                state++;
                if(state > 3)
                    state = 0;
            }
            else
                System.out.println("DEBUG: that place was occypied please draw again");
        }
    }
=======
/**
 * Write a description of class tempBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class tempBoard extends JPanel
{
    //instance fields
    tile[] tileArray = new tile[60];
    
    int pieceLocationX, pieceLocationY;
    public JButton button;
    public Deck deck;
    final int BLUE_PLAYER = 0;
    final int GREEN_PLAYER = 1;
    final int RED_PLAYER = 2;
    final int YELLOW_PLAYER = 3;
    
    piece[] pieceArray = new piece[4];
    
    
    piece bluePiece, greenPiece, redPiece, yellowPiece;
    //conctructor
    public tempBoard() {
        //setLayout(new BorderLayout());
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        /*
        c.anchor = GridBagConstraints.LAST_LINE_START;
        card = new Card();
        add(card, c);
        */

        //creating the graphical objects
        setPreferredSize(new Dimension(1980,1080));
        //for loop for creating the amount of tiles 9 at this point
        int y=0;
        int x = 0;
        for(int i = 0; i <= 14; i++) {
            tileArray[i]= new tile(x, y);
            x++;
        }
        for(int i = 15; i <= 29; i++) {
            tileArray[i]= new tile(x, y);
            y++;
        }
        for(int i = 30; i <= 44; i++) {
            tileArray[i]= new tile(x, y);
            x--;
        }
        for(int i = 45; i <= 59; i++) {
            tileArray[i]= new tile(x, y);
            y--;
        }
        bluePiece = new piece(BLUE_PLAYER, tileArray);
        pieceArray[BLUE_PLAYER]= bluePiece;
        
        greenPiece = new piece(GREEN_PLAYER, tileArray);
        pieceArray[GREEN_PLAYER]= greenPiece;
        
        redPiece = new piece(RED_PLAYER, tileArray);
        pieceArray[RED_PLAYER]= redPiece;
        
        yellowPiece = new piece(YELLOW_PLAYER, tileArray);
        pieceArray[YELLOW_PLAYER]= yellowPiece;
        
        deck = new Deck();
        
        //creating the button
        c.anchor = GridBagConstraints.LAST_LINE_END;
        button = new JButton("Advance the piece");
        button.addActionListener(new buttonListener());       
        button.setSize(new Dimension(200, 50));
        add(button, c);
    }

    public  void paintComponent(Graphics page) {
        //painting the components
        super.paintComponent(page);
        for(int i = 0; i <= 59; i++) {
            tileArray[i].draw(page);
        } 

        bluePiece.draw(page);
        greenPiece.draw(page);
        redPiece.draw(page);
        yellowPiece.draw(page);
    }
    public class buttonListener implements ActionListener 
    {
        int state = 0;
        public void actionPerformed ( ActionEvent e) 
        {
            // temoporary variable so the moving engline knows how many
            int temp = deck.Draw().getValue();
            //finitie state machine description
            // the state starts at 0 which corresponds to the blue player
            // after he/she has taken thier turn it will move the state to the next one
            //signifying the next player
            
            
            
                if ((pieceArray[state].locationValue + temp) >= 60) 
                    pieceArray[state].locationValue = ((pieceArray[state].locationValue += temp) - 60);
                else 
                {
                    pieceArray[state].locationValue += temp;
               
                    //advacing and looping through the small board
                
                    for(int times = 0; times < temp; times++) {
                    if(pieceLocationX != 60) {
                    pieceLocationX = pieceLocationX + 1;
                    } else {
                    pieceLocationX = 0;
                    }
                    }
                
    
                
                    if (pieceLocationX>=15 && pieceLocationX<=29)
                    {
                        pieceLocationY = (pieceLocationX - 15) * 5;
                    }
                    if (pieceLocationX>= 29 && pieceLocationX<=44)
                    {
                        pieceLocationY = 15;
                    }
                    if (pieceLocationX>=44 && pieceLocationX<=59)
                    {
                        pieceLocationY = 60 - pieceLocationY;
                    }
                    //updates the location of the piece
                    pieceArray[state].updateX(tileArray[pieceArray[state].locationValue].getX());//tileArray[pieceLocationX].getX());
                    pieceArray[state].updateY(tileArray[pieceArray[state].locationValue].getY());//tileArray[pieceLocationY].getY());
                    //repaints the panel
                    repaint();
                    state++;
                    if(state > 3)
                    state = 0;
            }
        }
    }
>>>>>>> origin/Board--addition-of-the--extra-spaces
}