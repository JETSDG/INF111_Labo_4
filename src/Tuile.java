public class Tuile {
    /**
     * La lettre
     **/
    private char lettre;
    /**
     * La valeur
     **/
    private int valeur;

    /**
     * Construit une tuile avec une lettre et une valeur
     *
     * @param lettre La lettre
     * @param valeur La valeur
     */
    public Tuile(char lettre, int valeur) {
        this.lettre = lettre;
        this.valeur = valeur;
    }

    /**
     * Affiche les caractéristiques de la tuile dans un format clair
     */
    public void afficheTuile() {
        System.out.println(lettre + " : " + valeur);
    }

    public char getLettre() {
        return lettre;
    }

    public int getValeur() {
        return valeur;
    }

    public void setLettre(char lettre) {
        this.lettre = lettre;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
