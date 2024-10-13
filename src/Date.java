public class Date {
    /**
     * L'année
     **/
    private int annee;
    /**
     * Le mois
     **/
    private int mois;
    /**
     * Le jour
     **/
    private int jour;

    /**
     * Crée une date par défaut (ma fête :))
     */
    public Date() {
        annee = 2004;
        mois = 10;
        jour = 22;
    }

    /**
     * Crée une date avec l'année, le mois et le jour
     *
     * @param annee L'année
     * @param mois  Le mois
     * @param jour  Le jour
     */
    public Date(int annee, int mois, int jour) {
        this.annee = annee;
        this.mois = mois;
        this.jour = jour;
    }

    public String toString() {
        return jour + "/" + mois + "/" + annee;
    }
}
