
package edu.ub.prog2.RuanoEstherTorquetNuria.controlador;

import edu.ub.prog2.RuanoEstherTorquetNuria.model.Dades;

import edu.ub.prog2.utils.*;
import java.util.ArrayList;
import java.util.List;



/**
 * @author Esther Ruano Hortoneda
 * @author Nuria Torquet Luna
 *
 * Controlador s'encarrega de fer crides als mètodes a la classe Dades del
 * package model. La seva finalitat és que l'usuari no pugui accedir directament
 * a cap classe de model.
 * {@link edu.ub.prog2.RuanoEstherTorquetNuria.model.Dades [Classe d'on provenen els mètodes]}
 *
 */
public class Controlador {
    
    /**
     * Variable de referencia del tipus Dades amb la que cridarem als mètodes de
     * classe.
     * Reproductor amb el qual cridarem als metodes per afegir fitxers reproduibles
     * de la classe Dades
     */
    private Dades dades;
    private Reproductor r;
   
    /**
     * Constructor de la classe, inicialitza objecte de la classe Dades i el reproductor.
     */
    public Controlador() {
        dades = new Dades();
        r = new Reproductor();
    }
    
    /**
     * Crida al mètode afegirVideo de la classe Dades. En cas de rebre una
     * excepció, la llança altre cop.
     *
     * @param path
     * @param nomVideo
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @throws AplicacioException
     */
    public void afegirVideo(String path, String nomVideo, String codec, 
            float durada, int alcada, int amplada, float fps) throws AplicacioException {
            dades.afegirVideo(path, nomVideo, codec, durada, alcada, amplada, fps, r);
      
    }
    
    /**
     * Crida al mètode afegirAudio de la classe Dades. En cas de rebre una
     * excepció la llança altre cop.
     *
     * @param cami
     * @param camiImatge
     * @param nomAudio
     * @param codec
     * @param durada
     * @param kbps
     * @throws AplicacioException
     */
    public void afegirAudio(String cami, String camiImatge, String nomAudio, 
            String codec, float durada, int kbps) throws AplicacioException {  
            dades.afegirAudio(cami, camiImatge, nomAudio, codec, durada,kbps, r);
        
    }

   /**
     * Crida al mètode mostrarBiblioteca de la Classe Dades
     * 
     * @return List
     */
    public List<String> mostrarBiblioteca() {//la capçalera del mètode hauria de ser List<String>
        return dades.mostrarBiblioteca();
    }
    
    /**
     * Crida al mètode esborrarFitxer de la classe Dades. En cas de rebre una
     * excepció la llança altre cop.
     *
     * @param id
     * @throws AplicacioException
     */
    public void	esborrarFitxer(int id) throws AplicacioException{
            dades.esborrarFitxer(id);
    }
    
    /**
     * Crida al mètode guardarDadesDisc de la classe Dades. En cas de rebre una
     * excepció la llança altre cop.
     *
     * @param camiDesti
     * @throws AplicacioException
     */
    public void guardarDadesDisc(String camiDesti) throws AplicacioException{
            dades.guardarDadesDisc(camiDesti);
       
    }
    
    /**
     * Crida al mètode carregarDadesDisc de la classe Dades. Aquest actualitza
     * el contingut de dades.
     * En cas de rebre una excepció la llança altre cop.
     *
     * @param camiOrigen
     * @throws AplicacioException
     */
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException{
        dades = Dades.carregarDadesDisc(camiOrigen);
       
    }
    
}
