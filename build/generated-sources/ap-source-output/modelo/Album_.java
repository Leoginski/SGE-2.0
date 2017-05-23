package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Fotos;
import modelo.Galeria;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-11T08:10:00")
@StaticMetamodel(Album.class)
public class Album_ { 

    public static volatile SingularAttribute<Album, String> desricao;
    public static volatile SingularAttribute<Album, String> titulo;
    public static volatile SingularAttribute<Album, Integer> idAlbum;
    public static volatile CollectionAttribute<Album, Fotos> fotosCollection;
    public static volatile SingularAttribute<Album, Galeria> galeriaid;

}