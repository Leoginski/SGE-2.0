package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Inscricao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-11T08:10:00")
@StaticMetamodel(Externo.class)
public class Externo_ { 

    public static volatile SingularAttribute<Externo, String> senha;
    public static volatile CollectionAttribute<Externo, Inscricao> inscricaoCollection;
    public static volatile SingularAttribute<Externo, Integer> idExterno;
    public static volatile SingularAttribute<Externo, String> conhecimento;
    public static volatile SingularAttribute<Externo, String> nome;
    public static volatile SingularAttribute<Externo, String> dataNascimento;
    public static volatile SingularAttribute<Externo, String> email;

}