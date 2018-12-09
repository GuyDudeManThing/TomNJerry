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


}

class MazeFrame extends JFrame implements ActionListener 
{
    private ArrayList<MazeTile> tileList;

    public MazeFrame()
    {
        setBounds(200,200,1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel contactGridPanel = new JPanel();
        contentPane.add(contactGridPanel, BorderLayout.CENTER);
        contactGridPanel.setLayout(new GridLayout(12,12));

        tileList = new ArrayList<MazeTile>();

        for(int i=1; i<145; i++) 
        {
            MazeTile tile = new MazeTile();

            tileList.add(tile);
            contactGridPanel.add(tile);
        }
    }



    public void actionPerformed(ActionEvent e) 
    {

    }
}