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
}