import java.util.Arrays;

public class TableauDynamique {
    private int taille = 0;
    private int nbElements = 0;
    private double[] contenu;

    /**
     * Constructeur
     */
    public TableauDynamique(int taille) {
        this.taille = taille;
        contenu = new double[taille];
    }


    // accesseurs
    public int getTaille() {
        return taille;
    }

    public int getNbElements() {
        return nbElements;
    }

    public double[] getContenu() {
        return contenu.clone();
    }

    public double getElement(int position) {
        return contenu[position];
    }

    public boolean estVide() {
        return nbElements == 0;
    }


    // Méthodes publiques (interface de la classe)

    public String toString() {
        String affichage;

        affichage = "Taille : " + this.taille + "\nÉléments : " + this.nbElements + "\nContenu : " + Arrays.toString(this.contenu);

        return affichage;
    }

    /**
     * Insère un élément à la fin
     *
     * @param element l'élément à ajouter
     */
    public void ajouter(double element) {
        if (nbElements < taille) {
            contenu[nbElements] = element;
            nbElements++;
        }
    }

    /**
     * Insère un élément dans le tableau à la position indiquée
     *
     * @param element  élément à ajouter
     * @param position indice de la position d'insertion
     */
    public void inserer(double element, int position) {
        // on doit pouvoir déplacer les éléments pour faire de la place

        // validation
        if (position >= 0 && position <= taille - 1) {
            if (nbElements < taille) {
                decalerDroite(position, nbElements);
                contenu[position] = element;
                if (position <= nbElements)
                    nbElements++;
                else
                    nbElements = position + 1;
            }
        }
    }

    /**
     * Retire un élément du tableau à la position indiquée
     *
     * @param position indice de l'élément à retirer
     */

    public void retirer(int position) {
        if (position >= 0 && position < nbElements) {
            decalerGauche(position, nbElements);
            nbElements--;
        }
    }

    /**
     * Trie le tableau en place selon la méthode du tri par Insertion
     */
    public void triInsertion() {
        /* Strategie : pour chaque position (occuppée) du tableau
                       mémoriser la valeur
                       décaler à droite jusqu'à la bonne position
                       insérer la valeur
         */
        for (int i = 0; i < nbElements; i++) {
            double memo = contenu[i];

            // trouver la bonne position
            int positionInsertion = i;
            for (int j = 0; j < i; j++) {
                if (contenu[j] >= memo) {
                    positionInsertion = j;
                    break;
                }
            }
            decalerDroite(positionInsertion, i);
            contenu[positionInsertion] = memo;
        }
    }

    /**
     * Trie le tableau en place selon la méthode du tri par sélection
     */
    public void triSelection() {
        /* Stratégie : pour chaque position (occuppée) du tableau
                        trouver l'indice de l'élément minimum pas encore trié
                        permuter cet élément avec l'élément courant
         */
        for (int i = 0; i <= nbElements - 2; i++) {
            int indiceMin = indiceDuMinimum(i, nbElements);

            // permuter contenu[i] et contenu[indiceMin
            double temp = contenu[indiceMin];
            contenu[indiceMin] = contenu[i];
            contenu[i] = temp;
        }
    }

    /**
     * Recherche dichotomique d'une donnée cible dans un tableau trié
     *
     * @param element le tableau à fouiller
     * @return l'indice de l'élément si trouvé, -1 sinon
     */
    public int fouilleBinaire(double element) {
        /* Stratégie :
            comparer l'élément recherché avec l'élément central du sous-tableau
            éliminer la moitié gauche du sous-tableau si l'élément est plus grand
            éliminer la moitié droite du sous-tableau si l'élément est plus petit
         */
        int gauche = 0;
        int droite = nbElements;
        int milieu = 0;

        while (gauche < droite) {
            milieu = (gauche + droite) / 2;
            if (contenu[milieu] < element) {
                gauche = milieu + 1;
            } else {
                droite = milieu;
            }
        }

        // comparaison de réels, attention il faut un seuil de tolérance puisque
        // la répartition des réels n'est pas uniforme.
        if (contenu[gauche] > element - 0.0001 && contenu[gauche] < element + 0.0001) {
            // l'indice de la valeur recherchée est stocké dans la variable gauche
            return gauche;
        } else {
            // l'élément n'est pas présent dans le tableau
            return -1;
        }
    }


    // Méthodes privées (détails d'implémentation cachés)

    /**
     * Retourne l'indice de l'élément de valeur minimale dans le sous-tableau
     * compris entre les indices debut et fin.
     *
     * @param debut indice de départ du sous-tableau.
     * @param fin   indice de fin du sous-tableau.
     * @return indice de l'élément de valeur minimale.
     */
    private int indiceDuMinimum(int debut, int fin) {
        double valeurMin = contenu[debut];
        int indiceMin = debut;

        for (int i = debut; i < fin; i++) {
            if (contenu[i] < valeurMin) {
                valeurMin = contenu[i];
                indiceMin = i;
            }
        }
        return indiceMin;
    }

    /**
     * Décale tous les éléments d'un tableau entre les indices départ et fin d'une
     * position vers la droite. Modifie le tableau en place.
     *
     * @param debut la borne d'indice bas
     * @param fin   la borne d'indice haut
     */
    private void decalerDroite(int debut, int fin) {
        /* Stratégie :
            À partir de fin, copier chaque élément vers la position suivante
            du tableau. Parcours inverse.
         */
        for (int i = fin - 1; i >= debut; i--) {
            contenu[i + 1] = contenu[i];
        }
    }

    /**
     * Décale tous les éléments d'un tableau entre les indices départ et fin d'une
     * position vers la droite. Modifie le tableau en place.
     *
     * @param debut la borne d'indice bas
     * @param fin   la borne d'indice haut
     */
    private void decalerGauche(int debut, int fin) {
        /* Stratégie :
            Copier chaque élément vers l'élément précédent, en commençant à
            la position départ+1 jusqu'à fin
         */
        for (int i = debut + 1; i <= fin; i++) {
            contenu[i - 1] = contenu[i];
        }
    }

}