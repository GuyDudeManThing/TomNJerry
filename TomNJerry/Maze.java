import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container; 
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;



class MazeTile extends JButton 
{
        
        MazeTile()
        {
            super();
        }

        MazeTile(int TileColor, int PlayerLocation, int EnemyLocation, int FinishLocation)
        {
            setBackground(Color.BLACK);
            if (TileColor == 14 || TileColor == 15 || TileColor == 16 || TileColor == 23 || TileColor == 27 || TileColor == 31 || TileColor == 32 || TileColor == 33 || TileColor == 34 || TileColor == 35 || TileColor == 39 || TileColor == 40 || TileColor == 41 || TileColor == 42 || TileColor == 43 || TileColor == 46 || TileColor == 50 || TileColor == 51 || TileColor == 55 || TileColor == 57 || TileColor == 58 || TileColor == 62 || TileColor == 67 || TileColor == 69 || TileColor == 70 || TileColor == 74 || TileColor == 76 || TileColor == 77 || TileColor == 79 || TileColor == 82 || TileColor == 86 || TileColor == 89 || TileColor == 91 || TileColor == 94 || TileColor == 98 || TileColor == 99 || TileColor == 101 ||  TileColor == 102 ||TileColor == 103 || TileColor == 106 || TileColor == 111 || TileColor == 113 || TileColor == 115 || TileColor == 116 || TileColor == 117 || TileColor == 118 || TileColor == 122 || TileColor == 123 || TileColor == 124 || TileColor == 125 || TileColor == 130 || TileColor == 131)
            {
                setBackground(Color.WHITE);
                setText(" ");
            }

            if (TileColor == PlayerLocation)
            {
                setBackground(Color.BLUE);
            }

            if (TileColor == EnemyLocation)
            {
                setBackground(Color.RED);
            }

            if (TileColor == FinishLocation)
            {
                setBackground(Color.YELLOW);
            }
        }
}

class Maze extends JFrame implements ActionListener 
{

    private ArrayList<MazeTile> tileList;
    private int Player = 14;
    private int Enemy = 103;
    private int Finish = 131;
    Maze()
    {

        setBounds(200,200,1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel MazeGridPanel = new JPanel();
        contentPane.add(MazeGridPanel, BorderLayout.CENTER);
        MazeGridPanel.setLayout(new GridLayout(12, 12));

        tileList = new ArrayList<MazeTile>();

        for(int i = 1; i<145; i++) 
        {
            MazeTile tile = new MazeTile(i,Player, Enemy, Finish);
            tileList.add(tile);
            MazeGridPanel.add(tile);
        }

    }

    public void actionPerformed(ActionEvent e) 
    {
    }  

}
