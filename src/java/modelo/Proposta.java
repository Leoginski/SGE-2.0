/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import DAO.PropostaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Proposta {
    private int idProposta;
    private String proponente;
    private String emailProponente;
    private String tipoAtividade;
    private String tituloAtividade;
    private String finalidadeAtividade;
    private String cargaHoraria;
    private int vagasAtividade;
    private String nomeConvidado;
    private String emailConvidado;
    private String formacaoConvidado;
    private String origem;
    private String informacoesComplementares;
    private int diaria;
    private String estado;
    private String publico_alvo;
    private int publico_todos;
    private int publico_informatica;
    private int publico_edificacoes;
    private int publico_eletromecanica;
    private int publico_eletrotecnica;
    private int publico_mecanica;
    private int publico_metalurgia;
    private int publico_eventos;
    private int publico_secretariado;
    private int publico_designMoveis;
    private int publico_eletronica;
    private int publico_transacoesImobiliarias;
    private int publico_transporteFerroviario;
    private int publico_sistemasInformacao;
    private int publico_engMecatronica;
    private int publico_engMetalurgica;
    private int publico_fisica;
    private int segunda;
    private int terca;
    private int quarta;
    private int quinta;
    private int sexta;
    private int sabado;
    private int idEvento;
    private int idLocal;
    private int idGerente;
    private String dataInicio;
    private String dataFim; 
    
    private Evento evento;
    private Local local;
    private Gerente gerente;

    public Proposta(int idProposta, String proponente, String emailProponente, String tipoAtividade, String tituloAtividade, String finalidadeAtividade, String cargaHoraria, int vagasAtividade, String nomeConvidado, String emailConvidado, String formacaoConvidado, String origem, String informacoesComplementares, int diaria, String estado, String publico_alvo, int publico_todos, int publico_informatica, int publico_edificacoes, int publico_eletromecanica, int publico_eletrotecnica, int publico_mecanica, int publico_metalurgia, int publico_eventos, int publico_secretariado, int publico_designMoveis, int publico_eletronica, int publico_transacoesImobiliarias, int publico_transporteFerroviario, int publico_sistemasInformacao, int publico_engMecatronica, int publico_engMetalurgica, int publico_fisica, int segunda, int terca, int quarta, int quinta, int sexta, int sabado, int idEvento, int idLocal, int idGerente, String dataInicio, String dataFim) {
        this.idProposta = idProposta;
        this.proponente = proponente;
        this.emailProponente = emailProponente;
        this.tipoAtividade = tipoAtividade;
        this.tituloAtividade = tituloAtividade;
        this.finalidadeAtividade = finalidadeAtividade;
        this.cargaHoraria = cargaHoraria;
        this.vagasAtividade = vagasAtividade;
        this.nomeConvidado = nomeConvidado;
        this.emailConvidado = emailConvidado;
        this.formacaoConvidado = formacaoConvidado;
        this.origem = origem;
        this.informacoesComplementares = informacoesComplementares;
        this.diaria = diaria;
        this.estado = estado;
        this.publico_alvo = publico_alvo;
        this.publico_todos = publico_todos;
        this.publico_informatica = publico_informatica;
        this.publico_edificacoes = publico_edificacoes;
        this.publico_eletromecanica = publico_eletromecanica;
        this.publico_eletrotecnica = publico_eletrotecnica;
        this.publico_mecanica = publico_mecanica;
        this.publico_metalurgia = publico_metalurgia;
        this.publico_eventos = publico_eventos;
        this.publico_secretariado = publico_secretariado;
        this.publico_designMoveis = publico_designMoveis;
        this.publico_eletronica = publico_eletronica;
        this.publico_transacoesImobiliarias = publico_transacoesImobiliarias;
        this.publico_transporteFerroviario = publico_transporteFerroviario;
        this.publico_sistemasInformacao = publico_sistemasInformacao;
        this.publico_engMecatronica = publico_engMecatronica;
        this.publico_engMetalurgica = publico_engMetalurgica;
        this.publico_fisica = publico_fisica;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
        this.idEvento = idEvento;
        this.idLocal = idLocal;
        this.idGerente = idGerente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    
    
    public String getPublico_alvo() {
        return publico_alvo;
    }

    public void setPublico_alvo(String publico_alvo) {
        this.publico_alvo = publico_alvo;
    }
    
    public String getProponente() {
        return proponente;
    }

    public void setProponente(String proponente) {
        this.proponente = proponente;
    }

    public String getEmailProponente() {
        return emailProponente;
    }

    public void setEmailProponente(String emailProponente) {
        this.emailProponente = emailProponente;
    }

    public String getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(String tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public String getTituloAtividade() {
        return tituloAtividade;
    }

    public void setTituloAtividade(String tituloAtividade) {
        this.tituloAtividade = tituloAtividade;
    }

    public String getFinalidadeAtividade() {
        return finalidadeAtividade;
    }

    public void setFinalidadeAtividade(String finalidadeAtividade) {
        this.finalidadeAtividade = finalidadeAtividade;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getVagasAtividade() {
        return vagasAtividade;
    }

    public void setVagasAtividade(int vagasAtividade) {
        this.vagasAtividade = vagasAtividade;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }

    public String getEmailConvidado() {
        return emailConvidado;
    }

    public void setEmailConvidado(String emailConvidado) {
        this.emailConvidado = emailConvidado;
    }

    public String getFormacaoConvidado() {
        return formacaoConvidado;
    }

    public void setFormacaoConvidado(String formacaoConvidado) {
        this.formacaoConvidado = formacaoConvidado;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getInformacoesComplementares() {
        return informacoesComplementares;
    }

    public void setInformacoesComplementares(String informacoesComplementares) {
        this.informacoesComplementares = informacoesComplementares;
    }

    public int getDiaria() {
        return diaria;
    }

    public void setDiaria(int diaria) {
        this.diaria = diaria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getPublico_todos() {
        return publico_todos;
    }

    public void setPublico_todos(int publico_todos) {
        this.publico_todos = publico_todos;
    }

    public int getPublico_informatica() {
        return publico_informatica;
    }

    public void setPublico_informatica(int publico_informatica) {
        this.publico_informatica = publico_informatica;
    }

    public int getPublico_edificacoes() {
        return publico_edificacoes;
    }

    public void setPublico_edificacoes(int publico_edificacoes) {
        this.publico_edificacoes = publico_edificacoes;
    }

    public int getPublico_eletromecanica() {
        return publico_eletromecanica;
    }

    public void setPublico_eletromecanica(int publico_eletromecanica) {
        this.publico_eletromecanica = publico_eletromecanica;
    }

    public int getPublico_eletrotecnica() {
        return publico_eletrotecnica;
    }

    public void setPublico_eletrotecnica(int publico_eletrotecnica) {
        this.publico_eletrotecnica = publico_eletrotecnica;
    }

    public int getPublico_mecanica() {
        return publico_mecanica;
    }

    public void setPublico_mecanica(int publico_mecanica) {
        this.publico_mecanica = publico_mecanica;
    }

    public int getPublico_metalurgia() {
        return publico_metalurgia;
    }

    public void setPublico_metalurgia(int publico_metalurgia) {
        this.publico_metalurgia = publico_metalurgia;
    }

    public int getPublico_eventos() {
        return publico_eventos;
    }

    public void setPublico_eventos(int publico_eventos) {
        this.publico_eventos = publico_eventos;
    }

    public int getPublico_secretariado() {
        return publico_secretariado;
    }

    public void setPublico_secretariado(int publico_secretariado) {
        this.publico_secretariado = publico_secretariado;
    }

    public int getPublico_designMoveis() {
        return publico_designMoveis;
    }

    public void setPublico_designMoveis(int publico_designMoveis) {
        this.publico_designMoveis = publico_designMoveis;
    }

    public int getPublico_eletronica() {
        return publico_eletronica;
    }

    public void setPublico_eletronica(int publico_eletronica) {
        this.publico_eletronica = publico_eletronica;
    }

    public int getPublico_transacoesImobiliarias() {
        return publico_transacoesImobiliarias;
    }

    public void setPublico_transacoesImobiliarias(int publico_transacoesImobiliarias) {
        this.publico_transacoesImobiliarias = publico_transacoesImobiliarias;
    }

    public int getPublico_transporteFerroviario() {
        return publico_transporteFerroviario;
    }

    public void setPublico_transporteFerroviario(int publico_transporteFerroviario) {
        this.publico_transporteFerroviario = publico_transporteFerroviario;
    }

    public int getPublico_sistemasInformacao() {
        return publico_sistemasInformacao;
    }

    public void setPublico_sistemasInformacao(int publico_sistemasInformacao) {
        this.publico_sistemasInformacao = publico_sistemasInformacao;
    }

    public int getPublico_engMecatronica() {
        return publico_engMecatronica;
    }

    public void setPublico_engMecatronica(int publico_engMecatronica) {
        this.publico_engMecatronica = publico_engMecatronica;
    }

    public int getPublico_engMetalurgica() {
        return publico_engMetalurgica;
    }

    public void setPublico_engMetalurgica(int publico_engMetalurgica) {
        this.publico_engMetalurgica = publico_engMetalurgica;
    }

    public int getPublico_fisica() {
        return publico_fisica;
    }

    public void setPublico_fisica(int publico_fisica) {
        this.publico_fisica = publico_fisica;
    }

    public int getSegunda() {
        return segunda;
    }

    public void setSegunda(int segunda) {
        this.segunda = segunda;
    }

    public int getTerca() {
        return terca;
    }

    public void setTerca(int terca) {
        this.terca = terca;
    }

    public int getQuarta() {
        return quarta;
    }

    public void setQuarta(int quarta) {
        this.quarta = quarta;
    }

    public int getQuinta() {
        return quinta;
    }

    public void setQuinta(int quinta) {
        this.quinta = quinta;
    }

    public int getSexta() {
        return sexta;
    }

    public void setSexta(int sexta) {
        this.sexta = sexta;
    }

    public int getSabado() {
        return sabado;
    }

    public void setSabado(int sabado) {
        this.sabado = sabado;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Evento getEvento() throws ClassNotFoundException {
        if ((evento == null) && (idEvento != 0)) {
            evento = Evento.obterEvento(idEvento);
        }
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Local getLocal() throws ClassNotFoundException {
        if ((local == null) && (idLocal != 0)) {
            local = Local.obterLocal(idLocal);
        }
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Gerente getGerente() throws ClassNotFoundException {
        if ((gerente == null) && (idGerente != 0)) {
            gerente = Gerente.obterGerente(idGerente);
        }
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    
    
    
 public static List<Proposta> obterPropostas() throws ClassNotFoundException{
        return PropostaDAO.obterPropostas();
    } 

    /**
     * @return the idProposta
     */
    public int getIdProposta() {
        return idProposta;
    }

    /**
     * @param idProposta the idProposta to set
     */
    public void setIdProposta(int idProposta) {
        this.idProposta = idProposta;
    }

    public static Proposta obterProposta(int idProposta) throws ClassNotFoundException{
        return PropostaDAO.obterProposta(idProposta);
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        PropostaDAO.gravar(this);
    }
    public void alterar() throws SQLException, ClassNotFoundException {
        PropostaDAO.alterar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException {
        PropostaDAO.excluir(this);
    }
    
}