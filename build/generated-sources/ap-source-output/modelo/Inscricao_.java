package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Aluno;
import modelo.Certificado;
import modelo.Externo;
import modelo.Proposta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-11T08:10:00")
@StaticMetamodel(Inscricao.class)
public class Inscricao_ { 

    public static volatile SingularAttribute<Inscricao, String> tipo;
    public static volatile SingularAttribute<Inscricao, Proposta> propostaid;
    public static volatile SingularAttribute<Inscricao, Aluno> alunomatricula;
    public static volatile SingularAttribute<Inscricao, Integer> codInscricao;
    public static volatile SingularAttribute<Inscricao, Boolean> frequencia;
    public static volatile SingularAttribute<Inscricao, Externo> externoid;
    public static volatile CollectionAttribute<Inscricao, Certificado> certificadoCollection;

}