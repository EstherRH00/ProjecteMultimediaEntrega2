package edu.ub.prog2.RuanoEstherTorquetNuria.controlador;

import edu.ub.prog2.utils.ReproductorBasic;
import java.io.Serializable;

/**
 * @author Esther Ruano Hortoneda
 * @author Nuria Torquet luna
 * La classe Reproductor és una subclasse de la superclasse ReproductorBasic.
 * En aquest llirament no se'ns requereix la seva implementació.
 */
public class Reproductor extends ReproductorBasic implements Serializable {
    public Reproductor(){
        super("C:\\Program Files\\VideoLAN\\VLC");//direcció on es troba l'executable VLC
    }
}
