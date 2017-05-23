package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Album;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-11T08:10:00")
@StaticMetamodel(Fotos.class)
public class Fotos_ { 

    public static volatile SingularAttribute<Fotos, Integer> idFoto;
    public static volatile SingularAttribute<Fotos, byte[]> arquivo;
    public static volatile SingularAttribute<Fotos, Album> albumid;

}