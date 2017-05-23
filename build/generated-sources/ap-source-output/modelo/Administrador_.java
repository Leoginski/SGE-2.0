package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Evento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-11T08:10:00")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, String> senha;
    public static volatile SingularAttribute<Administrador, Integer> codAdministrador;
    public static volatile SingularAttribute<Administrador, String> nome;
    public static volatile SingularAttribute<Administrador, String> dataNascimento;
    public static volatile SingularAttribute<Administrador, String> email;
    public static volatile CollectionAttribute<Administrador, Evento> eventoCollection;

}