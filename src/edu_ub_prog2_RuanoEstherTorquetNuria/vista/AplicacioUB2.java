package edu_ub_prog2_RuanoEstherTorquetNuria.vista;
import edu.ub.prog2.RuanoEstherTorquetNuria.controlador.Controlador;
import edu.ub.prog2.utils.*;
import java.util.List;
import java.util.Scanner;

/**
 * @author Esther Ruano Hortoneda
 * @author Nuria Torquet Luna
 * La classe AplicacioUB conté la lògica del programa. Crea un objecte del tipus
 * Menu i un del tipus Controlador. Cada opció del menu respon a un mètode la classe
 * Controlador.
 * AplicacioUB recull la informació per fer les crides pertinents als mètodes
 * de Controlador.
 * És la classe amb la qual interactua l'usuari.
 */
public class AplicacioUB2 {
    /**
     * Atributs de la classe, creem variable de referència de tipus controlador
     * per a la crida de mètodes, tres enums per a gestionar les opcions del menú i
     * les respectives descripcions de cada element dels enums.
     */
    //Atributs
    private Controlador controlador;
    
    static private enum OpcionsMenuPrincipal {GESTIO_BIBLIOTECA, GUARDAR_DADES, RECUPERAR_DADES, SORTIR};
    static private enum OpcionsFitxer {ADD_FITXER, SHOW_BIBLIOTECA, REMOVE_FITXER, TORNAR_ENRERE};
    static private enum OpcionsTipusFitxer {ADD_VIDEO, ADD_AUDIO, TORNAR_ENRERE};
    
    // Descripcio del menu principal
    private static String[] descMenuPrincipal={
        "Gestió biblioteca",
        "Guardar dades",
        "Recuperar dades",
        "Sortir"
    };

    // Descripció subMenu
    private static String[] descFitxer={
        "Afegir fitxer multimèdia a la biblioteca",
        "Mostrar biblioteca",
        "Eliminar fitxer multimèdia",
        "Tornar enrere"
    };
    
    // Descripció subSubMenu
    private static String[] descTipusFitxer={
        "Afegir vídeo",
        "Afegir àudio",
        "Tornar enrere"
    };
    
    /**
     * Constructor sense paràmentres o s'instancia el controlador.
     */
    public AplicacioUB2(){
        //AplicacioUB2 (component vista) declararà un atribut de tipus Controlador que haurà de ser inicialitzat en el constructor de AplicacioUB2. 
        controlador = new Controlador();
    }
    
    /**
     * Mètode principal:
     * Crea l'Scanner, instancia l'aplicacioUB1 i crida al mètode manager d'aquesta.
     * {@link #manager(java.util.Scanner)}
     */
    public void gestioAplicacioUB(){
        // atributs i variables
        Scanner sc = new Scanner(System.in);
        // Creem un objecte principal
        this.manager(sc);
    }
    
    /**
     * El mètode manager s'encarrega de la gestió del menú principal. Inicialitzem
     * l'objecte menu amb l'enum OpcionsMenuPrincipal i cridem el mètode 
     * setDescripcions de la classe Menu per tal d'associar cada descripció amb
     * l'element de l'enum corresponent. A continuació imprimim les opcions,
     * inicialitzem una variable del tipus OpcionsMenuPrincipal i demanem a l'usuari
     * que n'esculli una. Cridem els mètodes privats de suport depenent de l'opció
     * escollida.
     */
    private void manager(Scanner sc) {

        // Creem l'objecte per al menu. Li passem com a primer parametre el nom del menu
        Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu Principal",OpcionsMenuPrincipal.values());

        // Assignem la descripcio de les opcions
        menu.setDescripcions(descMenuPrincipal);

        // Obtenim una opcio des del menu i fem les accions pertinents
        OpcionsMenuPrincipal opcio = null;
        do {
            // Mostrem les opcions del menu
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=(OpcionsMenuPrincipal)menu.getOpcio(sc);
            
            // Fem les accions necessaries
            switch(opcio) {
                case GESTIO_BIBLIOTECA:
                    // Mostrem un missatge indicant que s'ha triat aquesta opcio
                    System.out.println("Has triat l'opció 1: Gestió biblioteca");
                    //implementar opcio: crida al subMenu
                    managerMenuSecundari(sc);
                    break;
                case GUARDAR_DADES:
                    // Mostrem un missatge indicant que s'ha triat aquesta opcio
                    System.out.println("Has triat l'opció 2: Guardar dades");
                    //implementar opcio: guardar dades
                    guardarDades(sc);
                    break;
                case RECUPERAR_DADES:
                    // Mostrem un missatge indicant que s'ha triat aquesta opcio
                    System.out.println("Has triat l'opció 3: Recuperar dades");
                    //implementar opcio: crecuperar dades
                    recuperarDades(sc);
                    break;
                case SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }
        } while(opcio!=OpcionsMenuPrincipal.SORTIR);
    }

    /**
     * Gestió del subMenu, mateix raonament que amb manager()
     */
    private void managerMenuSecundari(Scanner sc) {

        // Creem l'objecte per al menu. Li passem com a primer parametre el nom del menu
        Menu<OpcionsFitxer> menu = new Menu<>("Menu Secundari 1", OpcionsFitxer.values());

        // Assignem la descripcio de les opcions
        menu.setDescripcions(descFitxer);
        
        OpcionsFitxer opcio = null;
        
        // Mostrem les opcions del menu
        do{
            menu.mostrarMenu();
        

        // Demanem una opcio
        opcio = (OpcionsFitxer)menu.getOpcio(sc);

        // Fem les accions necessaries
        //Com que no té opció "tornar enrere", només l'executem una vegada
        switch (opcio) {
            case ADD_FITXER:
                // Mostrem un missatge indicant que s'ha triat aquesta opcio
                System.out.println("Has triat l'opció 1.1: Afegir fitxer multimèdia a la biblioteca");
                //implementar opcio: crida al subSubMenu
                managerMenuTerciari(sc);
                break;
            case SHOW_BIBLIOTECA:
                // Mostrem un missatge indicant que s'ha triat aquesta opcio
                System.out.println("Has triat l'opció 1.2: Mostrar biblioteca");
                //implementar opcio: mostrar biblioteca
                List<String> aux = controlador.mostrarBiblioteca();
                System.out.println(aux);
                break;
            case REMOVE_FITXER:
                // Mostrem un missatge indicant que s'ha triat aquesta opcio
                System.out.println("Has triat l'opció 1.3: Eliminar fitxer multimèdia");
                //implementar opcio: eliminar fitxer
                removeFitxer(sc);
                break;
            case TORNAR_ENRERE:
                // Mostrem un missatge indicant que s'ha triat aquesta opcio
                System.out.println("Has triat l'opció 1.4: Tronar al menú principal");
                break;
            }
            } while(opcio!=OpcionsFitxer.TORNAR_ENRERE);
    }


        


     /**
     * Gestió del subMenu, mateix raonament que amb manager()
     */
    private void managerMenuTerciari(Scanner sc) {

        // Creem l'objecte per al menu. Li passem com a primer parametre el nom del menu
        Menu<OpcionsTipusFitxer> menu = new Menu<>("Menu Terciari 1",OpcionsTipusFitxer.values());

        // Assignem la descripcio de les opcions
        menu.setDescripcions(descTipusFitxer);

        // Obtenim una opcio des del menu i fem les accions pertinents
        OpcionsTipusFitxer opcio = null;
        do {
            // Mostrem les opcions del menu
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=(OpcionsTipusFitxer)menu.getOpcio(sc);

            // Fem les accions necessaries
            switch(opcio) {
                case ADD_VIDEO:
                    // Mostrem un missatge indicant que s'ha triat aquesta opcio
                    System.out.println("Has triat l'opció 1.1.1: Afegir vídeo");
                    //implementar opcio: afegir video
                    addVideo(sc);
                    break;
                case ADD_AUDIO:
                    // Mostrem un missatge indicant que s'ha triat aquesta opcio
                    System.out.println("Has triat l'opció 1.1.2: Afegir àudio");
                    //implementar opcio: afegir audio
                    addAudio(sc);
                    break;
                case TORNAR_ENRERE:
                    // Mostrem un missatge indicant que s'ha triat aquesta opcio
                    System.out.println("Has triat l'opció 1.1.3: Tronar al menú anterior");
                    break;
            }
        } while(opcio!=OpcionsTipusFitxer.TORNAR_ENRERE);
    }

    
    /*********************************************************************/
    /*************  Metodes per guardar/recuperar les dades  *************/
    /*********************************************************************/  
    
    /**
     * Demanem a l'usuari el camí on vol guardar el seu fitxer.
     * Intentem cridar el mètode destinat a aquesta funció de la classe
     * controlador. En cas de reportar-se qualsevol error, és rep un error
     * de la classe AplicacioException
     * @param sc 
     */
    private void guardarDades(Scanner sc) {
        String camiDesti;
        
        System.out.println("On vols guardar les dades? ");
        camiDesti = sc.nextLine();
        try {
            controlador.guardarDadesDisc(camiDesti);
            System.out.println("Dades guardades amb èxit!\n");
        } catch (AplicacioException e) {
            System.out.println(e.getMessage());
        
    }
    }
    /**
     * El mateix raonament que amb guardarDades()
     * @param sc 
     */
    private void recuperarDades(Scanner sc) {
        String camiOrigen;
        
        System.out.println("Introdueix el camí d'on vols recuperar les dades");
        camiOrigen = sc.nextLine();
        try {
            controlador.carregarDadesDisc(camiOrigen);
            System.out.println("Dades recuperades amb èxit!\n");
        } catch (AplicacioException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    /*********************************************************************/
    /*****************  Metodes per gestionar fitxers  *******************/
    /*********************************************************************/  
    
    /**
     * Mètode de suport per a esborrar fitxer de la carpetaFitxers. Donem dues opcions,
     * si l'usuari coneix l'índex del fitxer simplement demanem que introdueixi
     * l'índex i cridem el mètode pertinent de la classe Controlador.
     * En cas contrari, imprimim tots els elements de la carpetaFitxers amb el
     * mètode mostrarCarpeta de Controlador i a continuació demanem l'índex.
     * En tot moment, si reportem qualsevol error, tenim l'estructura try-catch
     * en la crida dels mètodes de Controlador per tal d'imprimir l'error que s'ha
     * reportat. Si l'usuari no introdueix una de les dues lletres(S o N) se li
     * demana indefinidament que introdueixi N o S fins que fagi cas.
     * @param sc 
     */
    private void removeFitxer(Scanner sc){
        String tria;
        int index;
        
        System.out.println("Conèixes l'índex del fitxer que vols eliminar? (S/N)");
        tria = sc.next();
        while(!tria.equals("S") && !tria.equals("N")){
            System.out.println("Introdueix S o N");
            tria = sc.next();
        }
        if (tria.equals("N")) {
            controlador.mostrarBiblioteca();
        }
        System.out.println("Introdueix l'índex");
        index = sc.nextInt();
        try{
            controlador.esborrarFitxer(index);
            System.out.println("Fitxer eliminat amb èxit!\n");
        } catch (AplicacioException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Mètode de suport per a afegir un vídeo a la carpetaFitxers. Demanem a
     * l'usuari els atributs corresponents al vídeo(cami, descripcio, codec, durada...)
     * i provem de cridar el mètode afegirVideo de la classe Controlador. En cas
     * de no ser possible, tenim l'estructura try-catch per gestionar l'excepció
     * i imprimir l'error per pantalla.
     * @param sc 
     */
    private void addVideo(Scanner sc){
        String cami, codec, descripcio;
        float durada, fps;
        int amplada, alcada;

        System.out.println("Introdueix el camí del vídeo");
        cami = sc.nextLine();
        System.out.println("Introdueix la descripció del vídeo");
        descripcio = sc.nextLine(); 
        System.out.println("Introdueix el codec del vídeo");
        codec = sc.nextLine();
        System.out.println("Introdueix la durada del vídeo");
        durada = sc.nextFloat();
        System.out.println("Introdueix l'alçada i l'amplada del vídeo, separats per espais");
        alcada = sc.nextInt();
        amplada = sc.nextInt();
        System.out.println("Introdueix les fps del vídeo");
        fps = sc.nextFloat();
        
        try {
            controlador.afegirVideo(cami,descripcio, codec,  durada, alcada, amplada, fps);
            System.out.println("Fitxer afegit amb èxit!\n");
        } catch (AplicacioException e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Mètode de suport per a afegir un àudio a la carpetaFitxers. Demanem a
     * l'usuari els atributs corresponents al vídeo(cami, descripcio, codec, durada...)
     * i provem de cridar el mètode afegirVideo de la classe Controlador. En cas
     * de no ser possible, tenim l'estructura try-catch per gestionar l'excepció
     * i imprimir l'error per pantalla.
     * @param sc 
     */

    private void addAudio(Scanner sc){
        String cami, camiImatge, codec, descripcio;
        float durada;
        int kbps;
        
        System.out.println("Introdueix el camí de l'àudio");
        cami = sc.nextLine();
        System.out.println("Introdueix el camí de la imatge de l'àudio");
        camiImatge = sc.nextLine();
        System.out.println("Introdueix la descripció de l'àudio");
        descripcio = sc.nextLine(); 
        System.out.println("Introdueix el codec de l'àudio");
        codec = sc.nextLine();
        System.out.println("Introdueix la durada del vídeo");
        durada = sc.nextFloat();
        System.out.println("Introdueix els kbps de l'àudio");
        kbps = sc.nextInt();
        
        try {
            controlador.afegirAudio(cami, camiImatge, descripcio, codec,  durada, kbps);
            System.out.println("Fitxer afegit amb èxit!\n");
        } catch (AplicacioException e) {
            System.out.println(e.getMessage());
        }
    }
     
}

        