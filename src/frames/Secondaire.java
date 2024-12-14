package src.frames;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.border.*;

import src.buttons.ButtonRounded;
import src.models.Utilisateur;

import java.awt.*;
import java.awt.Component.*;
import java.awt.*;
import java.awt.event.*;

public class Secondaire extends JFrame {

        ImageIcon pondu ;
        JLabel backgroundImage ; 
        JButton home;
        JLabel homeLabel;
        JButton Back;
        JLabel BackLabel;
        JLabel NomJoueur ;
        JLabel JoueurConnecte ;
        ButtonRounded facile ;
        ButtonRounded difficile ;
        ButtonRounded normale ;
        Utilisateur utilisateur;



        public Secondaire ()
        {
                super("jeu de pondu");
                Color myColor = new Color(145, 223, 62);

                JoueurConnecte = new JLabel("JOUEUR :");
                JoueurConnecte.setFont(new Font(Font.SERIF, Font.BOLD, 19));
                JoueurConnecte.setForeground(myColor);
                JoueurConnecte.setBounds(80, 5, 300,100);

                NomJoueur = new JLabel(utilisateur.getNomUtilisateurConnecte());
                NomJoueur.setFont(new Font(Font.SERIF, Font.BOLD, 24));
                NomJoueur.setForeground(Color.WHITE);
                NomJoueur.setBounds(190, 4, 100,100);
                NomJoueur.setHorizontalAlignment(SwingConstants.CENTER);
   

                //background image

                pondu = new ImageIcon(this.getClass().getResource("/src/images/principale.jpg"));
                backgroundImage = new JLabel(pondu);
                backgroundImage.setSize(1000,1000);
                

                // les bouttons
                ImageIcon buttonHomeIcon = new ImageIcon ("src/images/home.png");
                home = new JButton (null,buttonHomeIcon);
                home.setBorderPainted(false);
                home.setContentAreaFilled(false);
                home.setBounds(30,30,buttonHomeIcon.getIconWidth(),buttonHomeIcon.getIconHeight());

                homeLabel = new JLabel("HOME");
                homeLabel.setFont(new Font(Font.SERIF, Font.BOLD, 10));
                homeLabel.setForeground(Color.WHITE);
                homeLabel.setBounds(30, 30, 100,100);

                ImageIcon buttonBackIcon = new ImageIcon ("src/images/back.png");
                Back = new JButton (null,buttonBackIcon);
                Back.setBorderPainted(false);
                Back.setContentAreaFilled(false);
                Back.setBounds(340,30,buttonBackIcon.getIconWidth(),buttonBackIcon.getIconHeight());
                BackLabel = new JLabel("BACK");
                BackLabel.setFont(new Font(Font.SERIF, Font.BOLD, 10));
                BackLabel.setForeground(Color.WHITE);
                BackLabel.setBounds(340, 27, 100,100);
                Back.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                               dispose();
                               Ident i = new Ident();
                         }
                 });

                facile = new ButtonRounded("FACILE");
                facile.setBounds(98,230,200,50);
                facile.addActionListener(new ActionListener() {
                        public void actionPerformed (ActionEvent e)
                        {
                                JFrame oldFrame = (JFrame) ((JButton) e.getSource()).getTopLevelAncestor();
                                oldFrame.dispose();
                                Niveau s = new Niveau("facile") ;
                        }
                });

                facile.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                            ButtonRounded b = (ButtonRounded) e.getSource();
                            b.setBackground(new Color(145, 223, 62));
                        }
                        public void mouseExited(MouseEvent e) {
                            ButtonRounded b = (ButtonRounded) e.getSource();
                            b.setBackground(Color.white);
                        }
                    });
                 
                normale = new ButtonRounded("NORMALE");
                normale.setBounds(98,290,200,50);
                normale.addActionListener(new ActionListener() {
                        public void actionPerformed (ActionEvent e)
                        {
                                JFrame oldFrame = (JFrame) ((JButton) e.getSource()).getTopLevelAncestor();
                                oldFrame.dispose();
                                Niveau s = new Niveau("normale") ;
                        }
                });

                difficile = new ButtonRounded("DIFFICILE");
                difficile.setBounds(98,350,200,50);
                difficile.addActionListener(new ActionListener() {
                        public void actionPerformed (ActionEvent e)
                        {
                                JFrame oldFrame = (JFrame) ((JButton) e.getSource()).getTopLevelAncestor();
                                oldFrame.dispose();
                                Niveau s = new Niveau("difficile") ;
                        }
                });
                
                // action 
                home.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                              JFrame oldFrame = (JFrame) ((JButton) e.getSource()).getTopLevelAncestor();
                              oldFrame.dispose();
                              Principale p = new Principale();
                        }
                });

                
                addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave the Game?", "Close", JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.YES_OPTION) {
                                System.exit(0); // exit the application
                            }
                            else {
                                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // do nothing and let the user continue using the frame
                            }
                        }
                    });
                    
                backgroundImage.add(home);
                backgroundImage.add(facile);
                backgroundImage.add(normale);
                backgroundImage.add(difficile);
                backgroundImage.add(homeLabel);
                backgroundImage.add(Back);
                backgroundImage.add(BackLabel);
                backgroundImage.add(NomJoueur);
                backgroundImage.add(JoueurConnecte);
                this.add(backgroundImage);
                
                //frame
                this.setSize(410,680);
                this.setVisible(true);
                this.setLocation(570, 90);
                this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        }    
}