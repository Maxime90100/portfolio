/************************
 * THEVENEAU Maxime
 * TURCHETTO Mael
 * S1A1
 * Jeu du Jeton Manquant
 ************************/
import java.util.Scanner;
import java.util.Arrays;

public class Jeton {
    static final Scanner input = new Scanner(System.in);
    public static String[] state;
    static final String CASEVIDE = "...";
    static final int NCASES = 21;
    static final int NLIGNES = 6;
    static final String[] COULEURS = { "B", "R" };
    static final int[] tabBleu = new int[NCASES];
    static final int[] tabRouge = new int[NCASES];
    static int scoreBleus = 0;
    static int scoreRouges = 0;

    // Code couleur pour le texte
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    static boolean estOui(char reponse) {
        return "yYoO".indexOf(reponse) != -1;
    }

    public static void main(String[] args){

        boolean newDeal;
        System.out.println("Jouer seul ? ");
        char reponse = input.next().charAt(0);
        boolean single = estOui(reponse);
        do {
            if (single) {
                System.out.println("Le mode solo n'est pas encore disponible !");
                System.exit(0);
            }
            else{
                initJeu();
                jeu();
            }
            score();
            System.out.println("Nouvelle partie ? ");
            reponse = input.next().charAt(0);
            newDeal = estOui(reponse);

        } while (newDeal);
        System.out.println("Bye Bye !");
        System.exit(0);

    }

    /**
     * Joue au Jeu en alternant les tours entre les BLEUS et les ROUGES
     * Fin lorsqu'il ne reste qu'une seule case vide
     */
    public static void jeu(){
        int val = 1;
        int nbTour = 0;
        int idCaseJouee = 0; //
        String player;
        boolean valid;

        while (nbTour < NCASES - 1) {
            if (nbTour%2 == 0)
                player = "Bleu";
            else
                player = "Rouge";

            System.out.println("Joueur " + player + ", sur quelle case placez-vous votre jeton " + val + " ? ");
            while (!input.hasNextInt()){    // test si l'entrer clavier est de type int
                input.nextLine();
                System.out.println("Ceci n'est pas un numero !");
                input.nextLine();
            }
            idCaseJouee = input.nextInt();

            valid = jouer(COULEURS[nbTour%2], val, idCaseJouee);

            if (!valid)         // recommence la boucle sans la finir si la case jouer est invalide (déjà utilisée)
                continue;
            nbTour++;
            if(nbTour%2 == 0)   // Augmente la valeure des jetons si tour pair
                val++;
        }
    }

    /**
     * Calcule le score des BLEUS et des ROUGES
     */
    public static void score(){
        int sumR = sommeVoisins("R");
        int sumB = sommeVoisins("B");

        if (sumB < sumR) {
            System.out.println("Les bleus gagnent : " + sumB + "-" + sumR + " !");
            scoreBleus += 1;
        } else if (sumB == sumR)
            System.out.println("Egalite : " + sumB + " partout !");
        else {
            System.out.println("Les rouges gagnent : " + sumR + "-" + sumB + " !");
            scoreRouges += 1;
        }
        System.out.println(ANSI_BLUE + "SCORE BLEU : " + scoreBleus +ANSI_RESET);
        System.out.println(ANSI_RED + "SCORE ROUGE : " + scoreRouges + ANSI_RESET);
    }

    /**
     * Initialise le jeu avec CASEVIDE à chaque case
     */
    public static void initJeu() {
        state = new String[NCASES];
        for (int i = 0; i < NCASES; i++)
            state[i] = CASEVIDE;
        for (int i = 0; i < NCASES; i++) {
            tabRouge[i] = 0;
            tabBleu[i] = 0;
        }
        afficheJeu();
    }

    /**
     * Affiche le plateau de jeu en mode texte
     */
    public static void afficheJeu() {
        System.out.print("\033[H\033[2J");  // clear la console à chaque tour
        System.out.flush();
        int n = 0;
        for (int i = 1; i <= NLIGNES; i++) {
            System.out.print(i + ": \t");

            for (int space = 1; space <= NLIGNES - i; ++space)  // créer les espaces pour une forme pyramidale
                System.out.print("  ");

            for (int j = 0; j < i; j++) {
                if (state[n].charAt(0) == 'B')                  // attribut la couleur bleu
                    System.out.print(ANSI_BLUE_BACKGROUND);

                else if (state[n].charAt(0) == 'R')             // attribut la couleur rouge
                    System.out.print(ANSI_RED_BACKGROUND);

                System.out.print(state[n]);                     // affiche le jeton

                if (state[n].length() == 2)                     // ajoute un espace si 2 caractères
                    System.out.print(" ");
                System.out.print(ANSI_RESET + " ");             // reset l'attribut couleur
                n++;
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Place un jeton sur le plateau, si possible.
     *
     * @param couleur couleur du jeton : COULEURS[0] ou COULEURS[1]
     * @param val     valeur faciale du jeton
     * @param pos     position (indice) de l'emplacement où placer le jeton
     * @return true si le jeton a pu être posé, false sinon.
     */
    public static boolean jouer(String couleur, int val, int pos) {
        int position = pos - 1;
        if (position < 0 || position > 20) {                    // test si la case existe
            System.out.println("Cette case n'existe pas !");
            return false;
        }
        if (!(state[position].equals(CASEVIDE))) {              // test si la case est déjà attribuée
            System.out.println("La case numero " + pos + " est deja attribuee !");
            return false;
        } else {
            if (couleur.equals("B"))        // insert la valeur du jeton dans son tableau en fonction de sa couleur
                tabBleu[position] = val;
            else
                tabRouge[position] = val;
            state[position] = couleur + Integer.toString(val);
            afficheJeu();
            return true;
        }
    }

    /**
     * Retourne l'indice de la case débutant la ligne idLigne
     *
     * @param idLigne indice de la ligne. La première ligne est la ligne #0.
     * @return l'indice de la case la plus à gauche de la ligne
     */
    public static int idDebutLigne(int idLigne) {
        int debut = 0;
        for (int i = 0; i <= idLigne; i++) {
            debut += i;
        }
        return (debut);
    }

    /**
     * Retourne l'indice de la case terminant la ligne idLigne
     *
     * @param idLigne indice de la ligne. La première ligne est la ligne #0.
     * @return l'indice de la case la plus à droite de la ligne
     */
    public static int idFinLigne(int idLigne) {
        return (idDebutLigne(idLigne) + idLigne);
    }

    /**
     * Renvoie la case du jeton manquant
     */
    public static int getIdVide() {
        int vide = 0;
        while (!(state[vide].equals(CASEVIDE)))
            vide += 1;
        return (vide - 1);
    }

    /**
     * Renvoie la ligne de la case vide
     *
     * @param vide indice de la case vide.
     * @return la ligne de la case vide.
     */
    public static int getIdLigneVide(int vide) {
        int c = 0;
        for (int i = 1; i <= NLIGNES; i++) {
            for (int j = 0; j < i; j++) {
                if (c == vide) {
                    return i - 1;
                }
                c += 1;
            }
        }
        return 0;
    }

    /**
     * fait la somme des poids des voisins de couleur col
     * (6 voisins au maximum)
     *
     * @param col couleur des voisins considérés
     * @return somme des poids
     */
    public static int sommeVoisins(String col) {
        int vide = getIdVide() + 1;
        int ligneVide = getIdLigneVide(vide);
        int result = 0;
        int[] tabCouleur;

        if (col.equals("R"))
            tabCouleur = Arrays.copyOf(tabRouge, tabRouge.length);
        else                                                            // associe []tabCouleur au tableau de la couleur désirée
            tabCouleur = Arrays.copyOf(tabBleu, tabBleu.length);

        if (vide > idDebutLigne(ligneVide))     // valeure case gauche
            result += tabCouleur[vide - 1];
        if (vide < idFinLigne(ligneVide))       // valeure case droite
            result += tabCouleur[vide + 1];

        if ((ligneVide) > 0) {      // test si ligne au dessus
            if ((vide - ligneVide) - 1 >= idDebutLigne(ligneVide - 1))  // valeure case haut gauche
                result += tabCouleur[(vide - ligneVide) - 1];
            if ((vide - ligneVide) <= idFinLigne(ligneVide - 1))        // valeure case haut droite
                result += tabCouleur[(vide - ligneVide)];
        }
        if ((ligneVide) < NLIGNES - 1) {    // test si ligne au dessus
            result += tabCouleur[vide + ligneVide + 1];     // valeure case bas gauche
            result += tabCouleur[vide + ligneVide + 2];     // valeure case bas droite
        }
        return result;
    }

    /**
     * Renvoie le prochain coup à jouer pour les rouges
     * Algo naïf = la première case dispo
     *
     * @return id de la case
     */
    public static int iaRouge() {
        /*
         * Écire un véritable code sachant jouer.
         * La ligne du return ci-dessous doit donc naturellement aussi être ré-écrite.
         * Cette version ne permet que de reproduire le fonctionnement à 2 joueurs
         * tout en conservant l'appel à la fonction,
         * cela peut s'avérer utile lors du développement.
         */
        return Integer.parseInt(input.next());
    }
}
