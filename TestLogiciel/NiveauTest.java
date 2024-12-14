package TestLogiciel;

import org.junit.Before;
import org.junit.Test;
import src.buttons.ButtonRoundedAlphabet;
import src.frames.Niveau;
import src.models.Utilisateur;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import static org.junit.Assert.assertEquals;

public class NiveauTest {

    private Niveau niveauFacile;
    private Utilisateur utilisateur;

    @Before
    public void setUp() {
        // Initialisation de l'utilisateur
        utilisateur = new Utilisateur(null);
        utilisateur.setNom("Test User");
        utilisateur.setUtilisateur(utilisateur); 
        // Initialiser le niveau (mode facile)
        niveauFacile = new Niveau("facile");
        niveauFacile.motMystere = "TEST";  // Définir le mot mystère
        niveauFacile.nbEssais = 6;            // Définir les essais restants
        niveauFacile.score = 12;              // Définir le score initial
        niveauFacile.lettresDevinees = new boolean[niveauFacile.motMystere.length()];
    }

   @Test
    public void testLetterGuessIncorrectDisplaysBodyPart() throws InterruptedException {
        assertEquals("Test User", utilisateur.getNom());

        // Définir un mot mystère et configurer le niveau
        niveauFacile.motMystere = "TEST";
        niveauFacile.nbEssais = 6; 
        niveauFacile.lettresDevinees = new boolean[niveauFacile.motMystere.length()];
        niveauFacile.score = 12; 
        niveauFacile.ponduDebut = new ImageIcon("src/images/potence.jpg");

        // Simuler un bouton avec une lettre incorrecte
        ButtonRoundedAlphabet incorrectButton = new ButtonRoundedAlphabet("K");

        // Ajouter un écouteur au bouton
        incorrectButton.addActionListener(e -> {
            char lettre = incorrectButton.getText().charAt(0);
            boolean lettreTrouvee = false;

            // Vérifier la lettre dans le mot mystère
            for (int i = 0; i < niveauFacile.motMystere.length(); i++) {
                if (niveauFacile.motMystere.charAt(i) == lettre) {
                    niveauFacile.lettresDevinees[i] = true;
                    lettreTrouvee = true;
                }
            }

            // Si lettre incorrecte, réduire essais et changer image
            if (!lettreTrouvee) {
                niveauFacile.nbEssais--;
                niveauFacile.score -= 2;
                
                System.out.println("Essais après action : " + niveauFacile.nbEssais);
                System.out.println("Score après action : " + niveauFacile.score);                 
                System.out.println("Lettre incorrecte. Afficher partie du corps :");

                switch (niveauFacile.nbEssais) {
                    case 5:
                        System.out.println("Affichage : tête");
                        niveauFacile.backgroundImage.setIcon(new ImageIcon("src/images/Erreur0.jpg"));
                        break;
                    case 4:
                        System.out.println("Affichage : corps");
                        niveauFacile.backgroundImage.setIcon(new ImageIcon("src/images/Erreur1.jpg"));
                        break;
                    case 3:
                        System.out.println("Affichage : bras gauche");
                        niveauFacile.backgroundImage.setIcon(new ImageIcon("src/images/Erreur2.jpg"));
                        break;
                    case 2:
                        System.out.println("Affichage : bras droit");
                        niveauFacile.backgroundImage.setIcon(new ImageIcon("src/images/Erreur3.jpg"));
                        break;
                    case 1:
                        System.out.println("Affichage : jambe gauche");
                        niveauFacile.backgroundImage.setIcon(new ImageIcon("src/images/Erreur4.jpg"));
                        break;
                    case 0:
                        System.out.println("Affichage : jambe droite. Perte !");
                        break;
                }
            }

            // Mettre à jour l'affichage du mot
            StringBuilder affichage = new StringBuilder();
            for (int i = 0; i < niveauFacile.motMystere.length(); i++) {
                if (niveauFacile.lettresDevinees[i]) {
                    affichage.append(niveauFacile.motMystere.charAt(i));
                } else {
                    affichage.append("_");
                }
                if (i < niveauFacile.motMystere.length() - 1) {
                    affichage.append(" ");
                }
            }
            niveauFacile.motLabel.setText(affichage.toString());
        });

        ActionEvent actionEvent = new ActionEvent(incorrectButton, ActionEvent.ACTION_PERFORMED, null);
        incorrectButton.getActionListeners()[0].actionPerformed(actionEvent);
        
        Thread.sleep(3000); 


        // Vérifier les résultats
        assertEquals(5, niveauFacile.nbEssais); 
        assertEquals(10, niveauFacile.score); 
        assertEquals("_ _ _ _", niveauFacile.motLabel.getText()); 
    }


    
    @Test
    public void testLetterGuessCorrect() throws InterruptedException {
        // Assurez-vous que l'utilisateur est correctement configuré
        assertEquals("Test User", utilisateur.getNom());

        // Simuler le bouton avec une lettre correcte
        ButtonRoundedAlphabet incorrectButton = new ButtonRoundedAlphabet("E");
        

        System.out.println("Essais avant action : " + niveauFacile.nbEssais); 

        // Simuler l'appui sur le bouton (action)
        incorrectButton.addActionListener(e -> {
            char lettre = incorrectButton.getText().charAt(0);
            boolean lettreTrouvee = false;

            // Parcourir le mot mystère pour vérifier si la lettre est correcte
            for (int i = 0; i < niveauFacile.motMystere.length(); i++) {
                if (niveauFacile.motMystere.charAt(i) == lettre) {
                    niveauFacile.lettresDevinees[i] = true;
                    lettreTrouvee = true;
                }
            }

            // Si la lettre a été trouvée, ne fait rien
            if (lettreTrouvee) {
                System.out.println("Lettre correcte, pas de réduction des essais");
            } 
       
            System.out.println("Essais après action : " + niveauFacile.nbEssais); 
            System.out.println("Score après action : " + niveauFacile.score); 


            // Mettre à jour l'affichage du mot
            StringBuilder affichage = new StringBuilder();
            for (int i = 0; i < niveauFacile.motMystere.length(); i++) {
                if (niveauFacile.lettresDevinees[i]) {
                    affichage.append(niveauFacile.motMystere.charAt(i));
                } else {
                    affichage.append("_");
                }
                if (i < niveauFacile.motMystere.length() - 1) {
                    affichage.append(" ");
                }
            }
            niveauFacile.motLabel.setText(affichage.toString());
        });

        // Déclencher l'événement de manière explicite
        ActionEvent actionEvent = new ActionEvent(incorrectButton, ActionEvent.ACTION_PERFORMED, null);
        incorrectButton.getActionListeners()[0].actionPerformed(actionEvent);
        
        Thread.sleep(3000);
        
        // Vérification après l'action
        assertEquals(6, niveauFacile.nbEssais);    
        assertEquals(12, niveauFacile.score);     
        assertEquals("_ E _ _", niveauFacile.motLabel.getText()); 
    }
}
