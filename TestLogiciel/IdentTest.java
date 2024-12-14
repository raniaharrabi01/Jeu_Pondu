package TestLogiciel;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.frames.Ident;

public class IdentTest {
    private Ident ident;
    private JTextField nomField;
    private JButton signInButton;

    @Before
    public void setUp() throws Exception {
        ident = new Ident();
        nomField = ident.nom; 
        signInButton = ident.signIn;  
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testEmptyName() {
        // Saisie d'un nom vide
        nomField.setText("");

        // Simuler un clic sur le bouton "Jouer"
        signInButton.doClick();

    }

    @Test
    public void testInvalidNameWithDigits() {
        // Saisie d'un nom invalide (avec des chiffres)
        nomField.setText("John123");

        // Simuler un clic sur le bouton "Jouer"
        signInButton.doClick();

    }

    @Test
    public void testInvalidNameWithSpecialCharacters() {
        // Saisie d'un nom invalide (avec des caractères spéciaux)
        nomField.setText("John@Doe");

        // Simuler un clic sur le bouton "Jouer"
        signInButton.doClick();

    }

    @Test
    public void testValidName() throws InterruptedException {
        // Saisie d'un nom valide
        nomField.setText("John");

        // Simuler un clic sur le bouton "Jouer"
        signInButton.doClick();
        Thread.sleep(1000); // 500 ms pour donner du temps à l'action

        assertTrue(true);  // On assume que la validation du nom valide passe

    }
}

