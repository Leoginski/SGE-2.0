package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Inscricao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-11T08:10:00")
@StaticMetamodel(Aluno.class)
public class Aluno_ { 

    public static volatile SingularAttribute<Aluno, String> senha;
    public static volatile CollectionAttribute<Aluno, Inscricao> inscricaoCollection;
    public static volatile SingularAttribute<Aluno, Integer> idAluno;
    public static volatile SingularAttribute<Aluno, String> nome;
    public static volatile SingularAttribute<Aluno, String> dataNascimento;
    public static volatile SingularAttribute<Aluno, String> email;

}