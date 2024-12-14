package src.frames;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;




public class Principale extends JFrame {
    
    private ImageIcon pondu ;
    private JLabel backgroundImage ;
    private JButton start ;

    public Principale ()
    {    
        
        super("jeu de pondu");
        
        //background image

        pondu = new ImageIcon(this.getClass().getResource("/src/images/principale.jpg"));
        backgroundImage = new JLabel(pondu);
        backgroundImage.setSize(1000,1000);

        // traitement button

        ImageIcon buttonStartIcon = new ImageIcon ("src/images/icon.png");
        start = new JButton (null,buttonStartIcon);
        start.setBorderPainted(false);
        start.setContentAreaFilled(false);
        start.setBounds(80,180,buttonStartIcon.getIconWidth(),buttonStartIcon.getIconHeight());

        // action 
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Ident s = new Ident() ;
            }
        });
        // action ama mel keybord

        start.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    dispose();
                    Secondaire s = new Secondaire() ;
                    
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave the Game?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0); // exit the application
                }
                else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // do nothing and let the user continue using the frame
                }
            }
        });
            
        //ajout des elements dans le frame
        backgroundImage.add(start);
        this.add(backgroundImage);
        
        //frame
        this.setSize(410,680);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocation(570, 90);

        

    }

}