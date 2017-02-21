
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class player// is an array of pieces
{
   piece[] pieces = new piece[4]; 
   public player (int num, tile[] homeArray )
   {
       for(int i = 0; i < 4; i++)
       {
           pieces[i] = new piece(num, homeArray[i].getX(), homeArray[i].getY());
           
        }
       
       
   }
   public void draw(Graphics page)
   {
       for(int i = 0; i < 4; i++)
       {
           pieces[i].draw(page);
           
        }
       
    }
}
