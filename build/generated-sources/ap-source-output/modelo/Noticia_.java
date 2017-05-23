package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Evento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-11T08:10:00")
@StaticMetamodel(Noticia.class)
public class Noticia_ { 

    public static volatile SingularAttribute<Noticia, Integer> idNoticia;
    public static volatile SingularAttribute<Noticia, String> data;
    public static volatile SingularAttribute<Noticia, Evento> eventoidEvento;
    public static volatile SingularAttribute<Noticia, String> descricao;

}