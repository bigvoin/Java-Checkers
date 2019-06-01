import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class square extends JButton
{  

      int row;
      int collumn;
      String image;
      
      public void setRow(int r)    // set the user integer to the variable row
      {
          this.row = r;    
      }

      public void setCollumn(int c)  // set the user integer to the variable collumn
      {
          this.collumn = c;
      }

      public int getRow()   // return the variable saved in the variable row
      {
          return row;
      }

      public int getCol()   // return the collumn
      {
          return collumn;
      }

      public void setImage(String userImage) // set the string from the user to the variable image
      {
          image = userImage;
      }

      public String getImage()  // return the image saved in the variable image
      {
          return image;
      }

    public void move(square s)
    {
       s.setImage(image);
       image = "white";  
    }

     public square(int r,int c,String i)   // create a constructor representing our square button
      {
          row = r;
          collumn = c;  
          image  = i;                   
      }
}

                 
                 