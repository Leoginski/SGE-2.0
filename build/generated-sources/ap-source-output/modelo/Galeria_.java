package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Album;
import modelo.Evento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-11T08:10:00")
@StaticMetamodel(Galeria.class)
public class Galeria_ { 

    public static volatile SingularAttribute<Galeria, Evento> eventoid;
    public static volatile SingularAttribute<Galeria, String> data;
    public static volatile SingularAttribute<Galeria, Integer> idGaleria;
    public static volatile CollectionAttribute<Galeria, Album> albumCollection;

}