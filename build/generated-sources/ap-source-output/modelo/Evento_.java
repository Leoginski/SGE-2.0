package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Administrador;
import modelo.Galeria;
import modelo.Noticia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-11T08:10:00")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile SingularAttribute<Evento, String> nomeEvento;
    public static volatile SingularAttribute<Evento, String> tema;
    public static volatile SingularAttribute<Evento, String> dataFimInscricao;
    public static volatile SingularAttribute<Evento, String> dataInicioEvento;
    public static volatile CollectionAttribute<Evento, Galeria> galeriaCollection;
    public static volatile SingularAttribute<Evento, Integer> idEvento;
    public static volatile SingularAttribute<Evento, String> dataInicioInscricao;
    public static volatile SingularAttribute<Evento, String> duracao;
    public static volatile CollectionAttribute<Evento, Noticia> noticiaCollection;
    public static volatile SingularAttribute<Evento, Administrador> administradorcodAdministrador;
    public static volatile SingularAttribute<Evento, String> dataFimEvento;

}