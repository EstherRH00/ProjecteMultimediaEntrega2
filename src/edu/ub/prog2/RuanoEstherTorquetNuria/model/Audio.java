
package edu.ub.prog2.RuanoEstherTorquetNuria.model;

import edu.ub.prog2.RuanoEstherTorquetNuria.controlador.Reproductor;
import java.io.File;

/**
 * @author Esther Ruano Hortoneda
 * @author Nuria Torquet Luna
 *
 * Audio hereta de la classe FitxerReproduible i s'encarrega d'especificar un tipus
 * de FitxerMultimedia concret. La classe consta dels atributs propis de la classe,
 * del constructor i d'un mètode, reproduir() que encara no està implementat.
 */

public class Audio extends FitxerReproduible {
    /**
     * Com a atributs propis de la classe Audio disposem:
     * - File fitxerImatge, variable de referència que mostrarà la imatge de la
     * caràtula o una per defecte.
     * - int kbps, emmagatzema la qualitat de l'àudio expressada en kilobits per segon.
     */
    private File fitxerImatge;
    private int kbps;

    /**
     * Constructor de la classe Audio.
     * Atributs que enviem al constructor File
     * @param cami -->que correspondria al path
     * Atributs que enviem al constructor FitxerMultimedia
     * @param nom -->descripcio del fitxer
     * Atributs que enviem al constructor FitxerReproduible
     * @param codec
     * @param durada
     * @param r
     * Atributs pròpis de la classe Audio
     * @param kbps
     * @param fitxerImatge
     */
    public Audio(String cami, File fitxerImatge, String nom, String codec, 
            float durada, int kbps, Reproductor r) {
        //nom correspon a la descripcio del fitxer
        super(cami, nom, codec, durada, r); //el constructor de FitxerReproduible crida al de FitxerMultimedia
        this.fitxerImatge = fitxerImatge;
        this.kbps = kbps;
    }

    /**
     * Mètode que implementa el mètode reproduir() de la classe FitxerReproduible
     * En aquest llliurament no se'ns requereix la seva imlementació
     */
    @Override
    protected void reproduir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
