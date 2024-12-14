package src.frames;

import javax.swing.*;

import src.buttons.ButtonRounded;
import src.models.Utilisateur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ident extends JFrame {

    ImageIcon pondu;
    JLabel backgroundImage;
    JButton home;
    JLabel homeLabel;
    JLabel bienvenue;
    JLabel nomJoueur;
    public JTextField nom;
    ButtonRounded cancel;
    public ButtonRounded signIn;

    public Ident() {
        super("jeu de pondu");

        Color myColor = new Color(145, 223, 62);

        // Background image
        pondu = new ImageIcon(this.getClass().getResource("/src/images/principale.jpg"));
        backgroundImage = new JLabel(pondu);
        backgroundImage.setSize(1000, 1000);

        // Button to go home
        ImageIcon buttonHomeIcon = new ImageIcon("src/images/home.png");
        home = new JButton(null, buttonHomeIcon);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setBounds(30, 30, buttonHomeIcon.getIconWidth(), buttonHomeIcon.getIconHeight());
        homeLabel = new JLabel("HOME");
        homeLabel.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        homeLabel.setForeground(Color.WHITE);
        homeLabel.setBounds(30, 30, 100, 100);
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();  // Close the current window
                Principale p = new Principale();  // Open home page
            }
        });

        // Welcome label
        bienvenue = new JLabel("BIENVENUE !");
        bienvenue.setFont(new Font(Font.SERIF, Font.BOLD, 27));
        bienvenue.setForeground(myColor);
        bienvenue.setBounds(120, 150, 300, 100);

        // Label for player name
        nomJoueur = new JLabel("Nom Joueur :");
        nomJoueur.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        nomJoueur.setForeground(Color.white);
        nomJoueur.setBounds(50, 220, 300, 100);

        // Text field for name
        nom = new JTextField();
        nom.setPreferredSize(new Dimension(200, 10));
        nom.setBounds(50, 300, 300, 30);
        nom.setBackground(Color.white);
        nom.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        nom.setForeground(Color.black);

        // Button to start the game
        signIn = new ButtonRounded("Jouer");
        signIn.setBounds(120, 370, 145, 30);
        signIn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Validation du nom : il doit être non vide et ne contenir que des lettres alphabétiques
                String joueurNom = nom.getText().trim();  // Enlever les espaces éventuels avant et après le nom
                // Vérifier si le nom est vide ou contient des caractères non alphabétiques
                if (joueurNom.equals("")) {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer votre nom !");
                } else if (!joueurNom.matches("[a-zA-Z]+")) {  // Vérifie si le nom contient uniquement des lettres alphabétiques
                    JOptionPane.showMessageDialog(null, "Le nom doit contenir uniquement des lettres alphabétiques !");
                } else {
                    // Si le nom est valide, procéder au jeu
                    Utilisateur utilisateur = new Utilisateur(joueurNom);
                    utilisateur.setUtilisateur(utilisateur);
                    dispose();  // Fermer la fenêtre actuelle
                    Secondaire s = new Secondaire();  // Passer à la fenêtre suivante (jeu)
                }
            }
        });
        

        // Adding components to background
        backgroundImage.add(home);
        backgroundImage.add(homeLabel);
        backgroundImage.add(bienvenue);
        backgroundImage.add(nomJoueur);
        backgroundImage.add(nom);
        backgroundImage.add(signIn);
        
        
        // Add background image to the frame
        this.add(backgroundImage);

        // Set frame properties
        this.setSize(410, 680);
        this.setVisible(true);
        this.setLocation(570, 90);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
}
