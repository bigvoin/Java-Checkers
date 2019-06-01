import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class board implements ActionListener
{
    JFrame a = new JFrame();
    JPanel panel = new JPanel();
    square[][] mysquare = new square[8][8];
    ImageIcon white = new ImageIcon("empty.png");
    ImageIcon black = new ImageIcon("empty2.png");
    ImageIcon red = new ImageIcon("red.png");
    ImageIcon whitepiece = new ImageIcon("white.png");
    ImageIcon selected = new ImageIcon("selected.png");
    GridLayout grid =new GridLayout(8, 8);
    square first = new square(0,0," "); // for first click
    square second = new square(0,0," ");   // for second click


  public board(){

  
    
    
    panel.setLayout(grid);
    
    for(int row = 0 ; row < 8; row++)
        for(int collumn =0; collumn < 8; collumn++)
        {
            mysquare[row][collumn] = new square(row,collumn," ");   // populate the collumnoard with 64 squares in different rows and collums
            panel.add(mysquare[row][collumn]);
            mysquare[row][collumn].addActionListener(this);
        }
        a.setContentPane(panel);
        a.setSize(800,800);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    
        for(int row = 0 ; row < 8; row++)
            {
        
            for(int collumn =0; collumn < 8; collumn++)
            {
                if((row+collumn) % 2 == 0)  // if the row+collumn is even numcollumner set the collumnutton to collumnlacrow 
                {
                    mysquare[row][collumn].setImage("black");  
                }
                else  // if is not even set it to white 
                {
                    mysquare[row][collumn].setImage("white");
                if(row<3)  // checrow if the white collumnuttons are not collumnetween the 4 and the 5 row
                {
                    mysquare[row][collumn].setImage("red"); 
                }
                if (row>4)  // checrow if the white collumnuttons are not collumnetween the 4 and the 5 row
                {
                    mysquare[row][collumn].setImage("whitepiece");
                }

            }
            
        }
    

    }
            for (int row=0;row<8;row++)
                {
                for( int collumn=0; collumn<8;collumn++)    // checrow and set the string to a proper Icon
            {
                if(mysquare[row][collumn].getImage()=="white")
                {
                    mysquare[row][collumn].setIcon(white);
                }
                if(mysquare[row][collumn].getImage()=="black")
                {
                    mysquare[row][collumn].setIcon(black);
                }
                if(mysquare[row][collumn].getImage()=="red")
                {
                    mysquare[row][collumn].setIcon(red);
                }
                if(mysquare[row][collumn].getImage()=="whitepiece")
                {
                    mysquare[row][collumn].setIcon(whitepiece);
                }
            }
    }
  }

  public void actionPerformed(ActionEvent e)
  {
      for(int row=0;row < 8;row++)
       {
           for(int collumn=0; collumn<8;collumn++)
           {
            if(e.getSource()== mysquare[row][collumn] )  // when any button is clicked
            {
                first = mysquare[row][collumn];
                
               if(mysquare[row][collumn].getImage()=="whitepiece")   // start of the checking for whitepieces
                 {
                     if((row-1)>=0 && (collumn-1)>=0)  //check if the piece is in the board
                     {
                            if(mysquare[row-1][collumn-1].getImage()!="whitepiece"&& mysquare[row-1][collumn+1].getImage()!="red") // check if the next clicked white button is occupied
                            { 
                                mysquare[row-1][collumn-1].setIcon(selected);   //set the icon of the top left to selected.png
                                mysquare[row-1][collumn-1].setImage("yellow"); 
                              
                            }
                            
                            
                      }
                      if((row-1)>=0 && (collumn+1)<8) //check if the piece is in the board
                        {
                            if(mysquare[row-1][collumn+1].getImage()!="whitepiece" && mysquare[row-1][collumn+1].getImage()!="red") // check if the next clicked white button is occupied
                            { 
                                mysquare[row-1][collumn+1].setIcon(selected);  //set the top right icon to selected.png
                                mysquare[row-1][collumn+1].setImage("yellow"); 
                               
                            }
                                        }                                                                                           
                                     }
                 if(mysquare[row][collumn].getImage()=="red")   // start of the checking for red piece
                 {
                     if((row+1)<8 && (collumn-1)>=0)   //check if the piece is in the board
                        {
                            if(mysquare[row+1][collumn-1].getImage()!="red" ) // check if the next clicked white button is occupied
                            {
                                mysquare[row+1][collumn-1].setIcon(selected);  //set the bottom left icon to selected.png
                                mysquare[row+1][collumn-1].setImage("yellow");  
                                
                            }
                            
                        }
                      if((row+1)<8 && (collumn+1)<8)   //check if the piece is in the board
                     {
                            if(mysquare[row+1][collumn+1].getImage()!="red"&& mysquare[row-1][collumn+1].getImage()!="whitepiece") // check if the next clicked white button is occupied
                            { 
                                mysquare[row+1][collumn+1].setIcon(selected);   //set the bottom right icon to selected.png
                                mysquare[row+1][collumn+1].setImage("yellow"); 
                                
                            }
                            
                      }                                                                                            
                 } 
                 if(mysquare[row][collumn].getImage()=="yellow")   // move the pieces, that are on the yellow button
                 {
                     mysquare[row][collumn].setIcon(whitepiece);
                     mysquare[row][collumn-2].setIcon(white);    
                     mysquare[row+1][collumn-1].setIcon(white);
                 }
            }         
           }
         }
 }
  
    
           
   public static void main(String[] args)
   {
       board myboard = new board();
   }
}