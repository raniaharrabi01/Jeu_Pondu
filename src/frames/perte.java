package src.frames;
import javax.swing.*;
import java.io.IOException;

import src.buttons.ButtonRounded;
import src.models.Utilisateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class perte extends JFrame {

    private ImageIcon ponduPerte ;
    private JLabel backgroundImage ;
    JLabel NomJoueur ;
    JLabel JoueurConnecte ;
    private JButton home;
    private JLabel homeLabel;
    private JButton TryAgain;
    private JLabel TryAgainLabel;
    private JLabel result ;
    private ButtonRounded Recherche ;
    private JLabel scoreLabel;
    private JLabel scores;
    Utilisateur utilisateur;


    public perte (String mot ,Integer score)
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
        ponduPerte = new ImageIcon(this.getClass().getResource("/src/images/perdu.jpg"));
        backgroundImage = new JLabel(ponduPerte);
        backgroundImage.setSize(1000,1000);

        // Créer label pour la resulat
        result = new JLabel();
        result.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        result.setForeground(Color.WHITE);
        result.setText(mot);
        result.setBounds(87,350,200,100);
        result.setHorizontalAlignment(SwingConstants.CENTER);
        
        // traitement button
        ImageIcon buttonHomeIcon = new ImageIcon ("src/images/home.png");
        home = new JButton (null,buttonHomeIcon);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setBounds(30,30,buttonHomeIcon.getIconWidth(),buttonHomeIcon.getIconHeight());

        homeLabel = new JLabel();
        homeLabel.setForeground(Color.WHITE);
        homeLabel.setText("HOME");
        homeLabel.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        homeLabel.setBounds(30, 30, 100,100);

        ImageIcon buttonTryAgainIcon = new ImageIcon ("src/images/refresh.png");
        TryAgain = new JButton (null,buttonTryAgainIcon);
        TryAgain.setBorderPainted(false);
        TryAgain.setContentAreaFilled(false);
        TryAgain.setBounds(340,30,buttonTryAgainIcon.getIconWidth(),buttonTryAgainIcon.getIconHeight());
        TryAgainLabel = new JLabel("AGAIN");
        TryAgainLabel.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        TryAgainLabel.setForeground(Color.WHITE);
        TryAgainLabel.setBounds(340, 27, 100,100);
        
        scoreLabel = new JLabel();
        scoreLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setText("Score : ");
        scoreLabel.setBounds(81,370,200,100);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        scores = new JLabel();
        scores.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        scores.setForeground(Color.WHITE);
        scores.setText(score.toString());
        scores.setBounds(130,370,200,100);
        scores.setHorizontalAlignment(SwingConstants.CENTER);

        String ch ="Recherche GOOGLE de "+"'"+mot+"'" ;
        Recherche=new ButtonRounded(ch);
        Recherche.setBounds(29, 510,350, 30);
        Recherche.setFont(new Font("SERIF", Font.BOLD, 14));
        Recherche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome https://www.google.com/search?q=" + mot +"+IN+TEST+LOGICIEL"});
                } catch (RuntimeException ex) {
                    System.out.println(ex);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
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
        
        // action de icon TryAgain
        TryAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   JFrame oldFrame = (JFrame) ((JButton) e.getSource()).getTopLevelAncestor();
                   oldFrame.dispose();
                   Secondaire s = new Secondaire ();
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

        //ajout des elements dans le frame
        backgroundImage.add(home);
        backgroundImage.add(homeLabel);
        backgroundImage.add(TryAgain);
        backgroundImage.add(TryAgainLabel);
        backgroundImage.add(result);
        backgroundImage.add(Recherche);
        backgroundImage.add(NomJoueur);
        backgroundImage.add(scoreLabel);
        backgroundImage.add(scores);
        backgroundImage.add(JoueurConnecte);
        this.add(backgroundImage);
        
        //frame
        this.setSize(410,680);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocation(570, 90);
    }
    
}

    

