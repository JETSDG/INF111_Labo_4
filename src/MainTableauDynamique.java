import java.util.Arrays;

public class MainTableauDynamique {
    public static void main(String[] args) {
        TableauDynamique tab = new TableauDynamique(2);
        System.out.println(tab);
        /*
        System.out.println("Taille : " + tab.getTaille());
        System.out.println("Elements : " + tab.getNbElements());
        System.out.println("Contenu :" + Arrays.toString(tab.getContenu()));
         */

        tab.ajouter(17.0);
        tab.ajouter(3.12);
        tab.ajouter(-75.23);
        System.out.println();
        System.out.println(tab);
        /*
        System.out.println("Taille : " + tab.getTaille());
        System.out.println("Elements : " + tab.getNbElements());
        System.out.println("Contenu :" + Arrays.toString(tab.getContenu()));
         */

        tab.inserer(22.22, 2);
        tab.inserer(33.33, 3);
        System.out.println();
        System.out.println(tab);
        /*
        System.out.println("Taille : " + tab.getTaille());
        System.out.println("Elements : " + tab.getNbElements());
        System.out.println("Contenu :" + Arrays.toString(tab.getContenu()));
         */

        tab.inserer(22.22, 6);
        System.out.println();
        System.out.println(tab);
        /*
        System.out.println("Taille : " + tab.getTaille());
        System.out.println("Elements : " + tab.getNbElements());
        System.out.println("Contenu :" + Arrays.toString(tab.getContenu()));
         */

        tab.inserer(22.22, 17);
        System.out.println();
        System.out.println(tab);
        /*
        System.out.println("Taille : " + tab.getTaille());
        System.out.println("Elements : " + tab.getNbElements());
        System.out.println("Contenu :" + Arrays.toString(tab.getContenu()));
         */

        tab.retirer(17);
        System.out.println();
        System.out.println(tab);
        /*
        System.out.println("Taille : " + tab.getTaille());
        System.out.println("Elements : " + tab.getNbElements());
        System.out.println("Contenu :" + Arrays.toString(tab.getContenu()));
         */

        tab.retirer(5);
        System.out.println();
        System.out.println(tab);
        /*
        System.out.println("Taille : " + tab.getTaille());
        System.out.println("Elements : " + tab.getNbElements());
        System.out.println("Contenu :" + Arrays.toString(tab.getContenu()));
         */

//        tab.triInsertion();
//        System.out.println();
//        System.out.println("Taille : " + tab.getTaille());
//        System.out.println("Elements : " + tab.getNbElements());
//        System.out.println("Contenu :" + Arrays.toString(tab.getContenu()));

        tab.triSelection();
        System.out.println();
        System.out.println(tab);
        /*
        System.out.println("Taille : " + tab.getTaille());
        System.out.println("Elements : " + tab.getNbElements());
        System.out.println("Contenu :" + Arrays.toString(tab.getContenu()));
         */

        System.out.println();
        System.out.println(tab.fouilleBinaire(3.12));
        System.out.println(tab.fouilleBinaire(254.1));

    }
}