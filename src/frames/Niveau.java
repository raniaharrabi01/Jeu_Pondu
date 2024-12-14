package src.frames;
import javax.swing.*;

import src.buttons.ButtonRoundedAlphabet;
import src.models.Utilisateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Niveau extends JFrame  {
        
        JLabel NomJoueur ;
        JLabel JoueurConnecte ;

        public JLabel backgroundImage ;
        public ImageIcon ponduDebut ;
        private ImageIcon pondu ;
        
        private JButton home;
        private JLabel homeLabel ;
        private JButton TryAgain;
        private JLabel TryAgainLabel ;

        public String  motMystere ;
        String ch ="";
        public JLabel motLabel;
        public int nbEssais = 6;
        public boolean lettresDevinees [];
        JLabel labelInsert;
        private String[] Mots;
        public int score;
        Utilisateur utilisateurC;

        
     
    public Niveau (String niveau)
    {
        
        super("jeu de pondu");

         Color myColor = new Color(145, 223, 62);

        JoueurConnecte = new JLabel("JOUEUR :");
        JoueurConnecte.setFont(new Font(Font.SERIF, Font.BOLD, 19));
        JoueurConnecte.setForeground(myColor);
        JoueurConnecte.setBounds(80, 5, 300,100);

        NomJoueur = new JLabel(utilisateurC.getNomUtilisateurConnecte());
        NomJoueur.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        NomJoueur.setForeground(Color.WHITE);
        NomJoueur.setBounds(190, 4, 100,100);
        NomJoueur.setHorizontalAlignment(SwingConstants.CENTER);

        // Creation de liste des mot mystére
        if (niveau.equals("facile"))
        {
            Mots = new String[]  {"CONCEPTION","DEFAUT","CODAGE","VERIFICATION","LOGICIEL","MODELE","TEST","VALIDATION","CONDITION","METHODE","TECHNIQUE","CRUCIAL","COMPILATEUR","MODULE","QUALITE"};
        }

        else if (niveau.equals("normale"))
        {
            Mots = new String[] {"AMONT","AVAL","TESTABILITE","MAINTENABILITE","FLEXIBILITE","INTEROPERABILITE","REUTILISABILITE","PORTABILITE","EXTRACTION","ABSTRACTION","SCRIPT", "SORTIE"};
        }

        else
        {
            Mots = new String[] {"DATAFLOW","STIMULER","COMPORTEMENT","DYNAMIQUE","STATIQUE","ANALYSE","CORRECTION","ECHEC","ESTIMATION","JUNIT","STATIC","SCENARIO","DOMAINE","ORACLE","MECANISME"};
        }

        // Créer le mot mystère 

        Random random = new Random();
        motMystere = Mots[random.nextInt(Mots.length)];
        //System.out.println(motMystere);

        // Créer label selon la taille de mot mystére

        motLabel = new JLabel();
        motLabel.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        motLabel.setForeground(Color.WHITE);
        for (int i=0 ; i<motMystere.length() ;i++) {ch = ch+"_"+" ";}
        motLabel.setText(ch);
        motLabel.setBounds(87,350,200,100);
        motLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lettresDevinees = new boolean[motMystere.length()];
        
        
        //background image

        ponduDebut = new ImageIcon(this.getClass().getResource("/src/images/potence.jpg"));
        backgroundImage = new JLabel(ponduDebut);
        backgroundImage.setSize(1000,1000);

        // traitement button home et try again 

        ImageIcon buttonHomeIcon = new ImageIcon (this.getClass().getResource("/src/images/home.png"));
        home = new JButton (null,buttonHomeIcon);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setBounds(30,30,buttonHomeIcon.getIconWidth(),buttonHomeIcon.getIconHeight());
        homeLabel = new JLabel("HOME");
        homeLabel.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        homeLabel.setForeground(Color.WHITE);
        homeLabel.setBounds(30, 30, 100,100);

        // action de icon Home
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   JFrame oldFrame = (JFrame) ((JButton) e.getSource()).getTopLevelAncestor();
                   oldFrame.dispose();
                   Principale p = new Principale();
             }
        });


        ImageIcon buttonTryAgainIcon = new ImageIcon (this.getClass().getResource("/src/images/refresh.png"));
        TryAgain = new JButton (null,buttonTryAgainIcon);
        TryAgain.setBorderPainted(false);
        TryAgain.setContentAreaFilled(false);
        TryAgain.setBounds(340,30,buttonTryAgainIcon.getIconWidth(),buttonTryAgainIcon.getIconHeight());
        TryAgainLabel = new JLabel("AGAIN");
        TryAgainLabel.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        TryAgainLabel.setForeground(Color.WHITE);
        TryAgainLabel.setBounds(340, 27, 100,100);

        // action de icon TryAgain
        TryAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   JFrame oldFrame = (JFrame) ((JButton) e.getSource()).getTopLevelAncestor();
                   oldFrame.dispose();
                   Niveau p = new Niveau(niveau);
             }
        });

        // score initiale 10 points
        score = 12;
        // traitement buttons alphabetique 

        int x = 30;
        int y = 450;
        int cmp = 0;
        int totale = 0;
        int buttonWidth = 44;
        int buttonHeight = 35;

        for(char c = 'A'; c <= 'Z'; c++) {

            ButtonRoundedAlphabet button = new ButtonRoundedAlphabet(String.valueOf(c));
            button.setBounds(x, y, buttonWidth,buttonHeight );
            cmp++;
            totale++;
            backgroundImage.add(button);

            x += buttonWidth + 3;
            if (cmp > 6) {
                cmp=0;
                x = 30;
                y += 38;
            }

            if (totale>20)
            {
                totale=0;
                x = 70;
            }

            //Ajouter un écouteur d'événements ActionListener
            button.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e)      
                {
                    ButtonRoundedAlphabet b = (ButtonRoundedAlphabet) e.getSource();
                    String lettre = b.getText();
                    boolean lettreTrouvee = false;
                    StringBuilder sb = new StringBuilder();
                   
                    for (int i = 0; i < motMystere.length(); i++) {
                        if (motMystere.charAt(i) == lettre.charAt(0)) {
                            lettresDevinees[i] = true;
                            lettreTrouvee = true;
                        }
                    }
                   
                    if (motComplet()) {
                        dispose();
                        Utilisateur utilisateur = utilisateurC.getUtilisateur();
                        utilisateur.ajouterScore(score, niveau);
                        System.out.println("niveau globale => " + utilisateur.getScore(niveau));
                        Gain g = new Gain(motMystere, score);
                    }

                    if (!lettreTrouvee) {
                        nbEssais--;
                        score -= 2; 
                        if (nbEssais==5)
                        {
                            //background image
                           // System.out.println(nbEssais);
                            pondu= new ImageIcon(this.getClass().getResource("/src/images/Erreur0.jpg"));
                            backgroundImage.setIcon(pondu);
                        }

                        if (nbEssais==4)
                        {
                            //background image
                            //System.out.println(nbEssais);
                            pondu= new ImageIcon(this.getClass().getResource("/src/images/Erreur1.jpg"));
                            backgroundImage.setIcon(pondu);
                        }

                        if (nbEssais==3)
                        {
                            //background image
                            //System.out.println(nbEssais);
                            pondu= new ImageIcon(this.getClass().getResource("/src/images/Erreur2.jpg"));
                            backgroundImage.setIcon(pondu);
                        }

                        if (nbEssais==2)
                        {
                            //background image
                            //System.out.println(nbEssais);
                            pondu= new ImageIcon(this.getClass().getResource("/src/images/Erreur3.jpg"));
                            backgroundImage.setIcon(pondu);
                        }

                        if (nbEssais==1)
                        {
                            //background image
                            //System.out.println(nbEssais);
                            pondu= new ImageIcon(this.getClass().getResource("/src/images/Erreur4.jpg"));
                            backgroundImage.setIcon(pondu);
                        }

                        if (nbEssais==0)
                        {
                            dispose();
                            perte p = new perte(motMystere,score); 
                        }
                    }
                    
                    for (int i = 0; i < motMystere.length(); i++) {
                        if (lettresDevinees[i]) {
                            sb.append(motMystere.charAt(i));
                        } else {
                            sb.append("_");
                        }
                        sb.append(" ");
                    }
                    motLabel.setText(sb.toString());
                    
                    }   
             });
        }
        
        
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
        backgroundImage.add(TryAgain);
        backgroundImage.add(motLabel);
        backgroundImage.add(homeLabel);
        backgroundImage.add(TryAgainLabel);
        backgroundImage.add(NomJoueur);
        backgroundImage.add(JoueurConnecte);
        this.add(backgroundImage);
                
        //frame
        this.setSize(410,680);
        this.setVisible(true);
        this.setLocation(570, 90);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }
    public
     boolean motComplet() {
        for (boolean lettreTrouvee : lettresDevinees) {
            if (!lettreTrouvee) {
                return false;
            }
        }
        return true;
    }
    
}
