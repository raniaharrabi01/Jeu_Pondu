package src.models;

public class Utilisateur {
    private String nom;
    private Integer scoreFacile;
    private Integer scoreNormale;
    private Integer scoreDifficile;
    private static Utilisateur utilisateurConnecte;

    
    public Utilisateur(String nom) {
        this.nom = nom;
        this.scoreFacile = 0;
        this.scoreNormale = 0;
        this.scoreDifficile = 0;
    }
    
    public String getNom()
    {
    	return nom;
    }

    public void ajouterScore(Integer score, String type) {
        switch (type) {
            case "facile":
                this.scoreFacile += score; break;
            case "normale":
                this.scoreNormale += score; break;
            case "difficile":
                this.scoreDifficile += score; break;
        }
    }
    
    public void setNom (String n)
    {
    	nom=n;
    }
    
    public Integer getScore(String type) {
        switch (type) {
            case "facile":
                return this.scoreFacile;
            case "normale":
                return this.scoreNormale;
            case "difficile":
            default:
                return this.scoreDifficile;
        }
    }
    public static void setNomUtilisateuConnected (String nom)
    {
    	utilisateurConnecte.setNom (nom);
    }
    
    public static void setUtilisateur (Utilisateur utilisateur)
    {
    	utilisateurConnecte = utilisateur;
    }

    public static Utilisateur getUtilisateur ()
    {
        return utilisateurConnecte;
    }

    public static String getNomUtilisateurConnecte  ()
    {
        return utilisateurConnecte.getNom();
    }
}
