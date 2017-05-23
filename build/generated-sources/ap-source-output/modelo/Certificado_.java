package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Inscricao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-11T08:10:00")
@StaticMetamodel(Certificado.class)
public class Certificado_ { 

    public static volatile SingularAttribute<Certificado, String> codAutencidade;
    public static volatile SingularAttribute<Certificado, String> descricao;
    public static volatile SingularAttribute<Certificado, Inscricao> inscricaocodInscricao;

}