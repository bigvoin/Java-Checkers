import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class myboard
{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton[][] square = new JButton[8][8];
    ImageIcon w = new ImageIcon("empty.png");
    ImageIcon b = new ImageIcon("empty2.png");
    ImageIcon rp = new ImageIcon("red.png");
    ImageIcon wp = new ImageIcon("white.png");
    
 
    public myboard()
    {
        panel.setLayout(new GridLayout(8, 8));
        frame.setContentPane(panel);
        frame.setSize(700,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        for(int r = 0; r < 8; r++)
        {
            for(int c = 0; c < 8; c++)
            {
                
                if ((c % 2 == 1 && r % 2 == 1) || (c % 2 == 0 && r % 2 == 0)) {
                    square[r][c] = new JButton();
                    square[r][c].setIcon(b);
                    panel.add(square[r][c]);
                } 
                else {
                    square[r][c] = new JButton();
                    square[r][c].setIcon(w);
                    panel.add(square[r][c]);
                    if(r<3)
                    {
                        square[r][c].setIcon(rp);
                    }
                    if(r>4)
                    {
                        square[r][c].setIcon(wp);
                    }
                }
            
            }
    }


    }
    public static void main(String[] args)
    {
        myboard board = new myboard();
    }
}