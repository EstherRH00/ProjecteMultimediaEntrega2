/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.RuanoEstherTorquetNuria.model;

import edu.ub.prog2.RuanoEstherTorquetNuria.controlador.Reproductor;
import edu.ub.prog2.utils.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Esther Ruano Hortoneda
 * @author Nuria Torquet Luna
 * 
 * Classe amb la que interactua controlador per a poder gestionar els fitxers de
 * la carpetaFitxers mitjançant la classe BibliotecaFitxers.
 * S'encarrega de crear objectes Audio o Video per tal d'afegir-los a l'ArrayList carpeta
 * que conté l'objecte biblioteca per herència, eliminar-los i retornar les seves característiques com a Strings. A més,
 * compta amb els mètodes guardarDadesDisc i carregarDadesDisc, que s'encarregan de 
 * serialitzar i desserialitzar els fitxers.
 */
public class Dades implements Serializable{
    /**
     * Creem variables de referència per a la classe BibliotecaFitxersMultimedia
     */
    private BibliotecaFitxersMultimedia biblioteca;
    
    /**
     * Constructor de la classe Dades, inicialitzem la biblioteca
     */
    public Dades(){
        biblioteca = new BibliotecaFitxersMultimedia();
    }
    
    /**
     * Mètode per afegir un vídeo a la carpetaFitxers mitjançant la crida al 
     * mètode addFitxers sobreescrit a BibliotecaFitxers. Creem un obj de tipus
     * video amb els paràmetres del mètode afegirFitxer i cridem al mètode addFitxer
     * de BibliotecaFitxers, sobreescrit per a que no puguem introduir un vídeo
     * que no es troba en el disc o que ja existeix a la carpetaFitxers. 
     * P.t. llança AplicacioException en cas de produir-se alguna de les excepcions
     * esmentades.
     * @param path
     * @param nomVideo
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @param reproductor
     * @throws AplicacioException en cas de no poder afegir el fitxer
     */
    public void afegirVideo(String path, String nomVideo, String codec, 
            float durada, int alcada, int amplada, float fps, Reproductor reproductor) throws AplicacioException {
        
        biblioteca.addFitxer(new Video(path, nomVideo, codec, durada, alcada, amplada, fps, reproductor));
    }
    
    /**
     * Mateix raonament que amb el mètode afegirVideo
     * @param cami
     * @param camiImatge
     * @param nomAudio
     * @param codec
     * @param durada
     * @param kbps
     * @param reproductor
     * @throws AplicacioException en cas de no poder afegir el fitxer
     */
    public void afegirAudio(String cami, String camiImatge, String nomAudio, 
            String codec, float durada, int kbps, Reproductor reproductor) throws AplicacioException {
        File fitxerImatge = new File(camiImatge);
        Audio a = new Audio(cami, fitxerImatge, nomAudio, codec, durada, kbps, reproductor);
        biblioteca.addFitxer(a);
    }
    /**
     * Mètode per esborrar un fitxer de la carpetaFitxers mitjançant l'objecte 
     * biblioteca. Cridem al mètode removeFitxers de la classe CarpetaFitxers,
     * ja que no es troba sobreescrit. Llancem una excepció si la posició del
     * fitxer no és correcta(excedeix nombre de fitxers o nombre negatiu).
   
     * @param id -->posició del fitxer en la carpeta
     * @throws AplicacioException 
     */
    public void	esborrarFitxer(int id) throws AplicacioException{
        biblioteca.removeFitxer(id);
    }
    
     /**
     * Mètode per retornar una Llista amb tantes posicions com fitxers tingui la
     * biblioteca. Cada posició és un String amb la informació d'un fitxer
     * 
     * @return List
     */
    public List<String> mostrarBiblioteca() {//la capçalera del mètode hauria de ser List<String>
        List<String> aux;
        if (biblioteca.getSize() == 0) {
            String s = "\nNo hi ha cap fitxer!\n";
            aux = new ArrayList<String>(1);
            aux.add(s);
        } else {
            aux = new ArrayList<String>(biblioteca.getSize() + 1);
            aux.add("\nLlista de fitxers\n====================\n\n");
            for (int i = 0; i < biblioteca.getSize(); i++) {
                try {
                    aux.add(biblioteca.getAt(i).toString() + "\n");
                } catch (AplicacioException e) {
                    //Mai hauria de rebre una excepció, però la estructura try-catch 
                    //és necessaria igual
                }
            }
        }
        return aux;
    }
    
    /*****************************************************************/
    /*********************  Persistència de dades  *******************/
    /*****************************************************************/
    
    
    /**
     * Mètode per serialitzar les dades del projecte. Creem fitxer on guardarem
     * les dades transfotmades en un stream de bytes, l'introduïm en un objecte
     * del tipus FileOutputStream i aquest al seu torn també és passat com a paràmetre
     * al constructor d'un objecte ObjectutputStream. Un cop creat, hi escrivim
     * la informació de l'objecte amb el que el crida(controlador) i tanquem ambdòs
     * streams. En cas d'error, llancem una AplicacioException
     * @param file
     * @throws AplicacioException
     * 
     */
    public void guardarDadesDisc(String file) throws AplicacioException{
        try{
            File fitxer	= new File(file);
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            oos.close();
            fout.close();
        }catch(Exception s){
            throw new AplicacioException("Les dades no s'han pogut guardar amb éxit");
        }
    } 
        
    
    
    /**
     * Mètode per deserialitzar les dades d'un fitxer. Passem com a paràmetre el
     * path del fitxer, creem el file amb aquest path i l'introduïm com a paràmetre
     * per al constructor d'un objecte FileInputStream. Aquest l'utilitem com a paràmetre
     * per a ObjectInputStream i llegim els bytes de l'objecte. El retorn(un objecte
     * del tipus Object) és sotmès a un downcasting per a transformar-lo en tipus
     * Dades. Tanquem els dos streams i retornem data.
     * @param file
     * @return data
     * @throws AplicacioException

     */
    public static Dades carregarDadesDisc(String file) throws AplicacioException{
        try{
            Dades data = null;
            File fitxer = new File(file);
            FileInputStream fin = new FileInputStream(fitxer);
            ObjectInputStream input = new ObjectInputStream(fin);
            data = (Dades) input.readObject();
            input.close();
            fin.close();
            return data;
        }catch(Exception c){
           throw new AplicacioException("Les dades no s'han pogut recuperar amb éxit");
        }
                   
 
    }
}
