/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Math
 */
@Entity
@Table(name = "proposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proposta.findAll", query = "SELECT p FROM Proposta p"),
    @NamedQuery(name = "Proposta.findByIdProposta", query = "SELECT p FROM Proposta p WHERE p.idProposta = :idProposta"),
    @NamedQuery(name = "Proposta.findByProponente", query = "SELECT p FROM Proposta p WHERE p.proponente = :proponente"),
    @NamedQuery(name = "Proposta.findByEmailProponente", query = "SELECT p FROM Proposta p WHERE p.emailProponente = :emailProponente"),
    @NamedQuery(name = "Proposta.findByTipoAtividade", query = "SELECT p FROM Proposta p WHERE p.tipoAtividade = :tipoAtividade"),
    @NamedQuery(name = "Proposta.findByTituloAtividade", query = "SELECT p FROM Proposta p WHERE p.tituloAtividade = :tituloAtividade"),
    @NamedQuery(name = "Proposta.findByFinalidadeAtividade", query = "SELECT p FROM Proposta p WHERE p.finalidadeAtividade = :finalidadeAtividade"),
    @NamedQuery(name = "Proposta.findByCargaHoraria", query = "SELECT p FROM Proposta p WHERE p.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "Proposta.findByVagasAtividade", query = "SELECT p FROM Proposta p WHERE p.vagasAtividade = :vagasAtividade"),
    @NamedQuery(name = "Proposta.findByNomeConvidado", query = "SELECT p FROM Proposta p WHERE p.nomeConvidado = :nomeConvidado"),
    @NamedQuery(name = "Proposta.findByEmailConvidado", query = "SELECT p FROM Proposta p WHERE p.emailConvidado = :emailConvidado"),
    @NamedQuery(name = "Proposta.findByFormacaoConvidado", query = "SELECT p FROM Proposta p WHERE p.formacaoConvidado = :formacaoConvidado"),
    @NamedQuery(name = "Proposta.findByOrigem", query = "SELECT p FROM Proposta p WHERE p.origem = :origem"),
    @NamedQuery(name = "Proposta.findByInformacoesComplementares", query = "SELECT p FROM Proposta p WHERE p.informacoesComplementares = :informacoesComplementares"),
    @NamedQuery(name = "Proposta.findByDiaria", query = "SELECT p FROM Proposta p WHERE p.diaria = :diaria"),
    @NamedQuery(name = "Proposta.findByEstado", query = "SELECT p FROM Proposta p WHERE p.estado = :estado"),
    @NamedQuery(name = "Proposta.findByPublicoAlvo", query = "SELECT p FROM Proposta p WHERE p.publicoAlvo = :publicoAlvo"),
    @NamedQuery(name = "Proposta.findByPublicoTodos", query = "SELECT p FROM Proposta p WHERE p.publicoTodos = :publicoTodos"),
    @NamedQuery(name = "Proposta.findByPublicoInformatica", query = "SELECT p FROM Proposta p WHERE p.publicoInformatica = :publicoInformatica"),
    @NamedQuery(name = "Proposta.findByPublicoEdificacoes", query = "SELECT p FROM Proposta p WHERE p.publicoEdificacoes = :publicoEdificacoes"),
    @NamedQuery(name = "Proposta.findByPublicoEletromecanica", query = "SELECT p FROM Proposta p WHERE p.publicoEletromecanica = :publicoEletromecanica"),
    @NamedQuery(name = "Proposta.findByPublicoEletrotecnica", query = "SELECT p FROM Proposta p WHERE p.publicoEletrotecnica = :publicoEletrotecnica"),
    @NamedQuery(name = "Proposta.findByPublicoMecanica", query = "SELECT p FROM Proposta p WHERE p.publicoMecanica = :publicoMecanica"),
    @NamedQuery(name = "Proposta.findByPublicoMetalurgia", query = "SELECT p FROM Proposta p WHERE p.publicoMetalurgia = :publicoMetalurgia"),
    @NamedQuery(name = "Proposta.findByPublicoEventos", query = "SELECT p FROM Proposta p WHERE p.publicoEventos = :publicoEventos"),
    @NamedQuery(name = "Proposta.findByPublicoSecretariado", query = "SELECT p FROM Proposta p WHERE p.publicoSecretariado = :publicoSecretariado"),
    @NamedQuery(name = "Proposta.findByPublicodesignMoveis", query = "SELECT p FROM Proposta p WHERE p.publicodesignMoveis = :publicodesignMoveis"),
    @NamedQuery(name = "Proposta.findByPublicoEletronica", query = "SELECT p FROM Proposta p WHERE p.publicoEletronica = :publicoEletronica"),
    @NamedQuery(name = "Proposta.findByPublicotransacoesImobiliarias", query = "SELECT p FROM Proposta p WHERE p.publicotransacoesImobiliarias = :publicotransacoesImobiliarias"),
    @NamedQuery(name = "Proposta.findByPublicotransporteFerroviario", query = "SELECT p FROM Proposta p WHERE p.publicotransporteFerroviario = :publicotransporteFerroviario"),
    @NamedQuery(name = "Proposta.findByPublicosistemasInformacao", query = "SELECT p FROM Proposta p WHERE p.publicosistemasInformacao = :publicosistemasInformacao"),
    @NamedQuery(name = "Proposta.findByPublicoengMecatronica", query = "SELECT p FROM Proposta p WHERE p.publicoengMecatronica = :publicoengMecatronica"),
    @NamedQuery(name = "Proposta.findByPublicoengMetalurgica", query = "SELECT p FROM Proposta p WHERE p.publicoengMetalurgica = :publicoengMetalurgica"),
    @NamedQuery(name = "Proposta.findByPublicoFisica", query = "SELECT p FROM Proposta p WHERE p.publicoFisica = :publicoFisica"),
    @NamedQuery(name = "Proposta.findBySegunda", query = "SELECT p FROM Proposta p WHERE p.segunda = :segunda"),
    @NamedQuery(name = "Proposta.findByTerca", query = "SELECT p FROM Proposta p WHERE p.terca = :terca"),
    @NamedQuery(name = "Proposta.findByQuarta", query = "SELECT p FROM Proposta p WHERE p.quarta = :quarta"),
    @NamedQuery(name = "Proposta.findByQuinta", query = "SELECT p FROM Proposta p WHERE p.quinta = :quinta"),
    @NamedQuery(name = "Proposta.findBySexta", query = "SELECT p FROM Proposta p WHERE p.sexta = :sexta"),
    @NamedQuery(name = "Proposta.findBySabado", query = "SELECT p FROM Proposta p WHERE p.sabado = :sabado"),
    @NamedQuery(name = "Proposta.findByGerentecodGerente", query = "SELECT p FROM Proposta p WHERE p.gerentecodGerente = :gerentecodGerente"),
    @NamedQuery(name = "Proposta.findByLocalId", query = "SELECT p FROM Proposta p WHERE p.localId = :localId"),
    @NamedQuery(name = "Proposta.findByEventoId", query = "SELECT p FROM Proposta p WHERE p.eventoId = :eventoId"),
    @NamedQuery(name = "Proposta.findByDataInicio", query = "SELECT p FROM Proposta p WHERE p.dataInicio = :dataInicio"),
    @NamedQuery(name = "Proposta.findByDataFim", query = "SELECT p FROM Proposta p WHERE p.dataFim = :dataFim")})
public class Proposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProposta")
    private Integer idProposta;
    @Size(max = 45)
    @Column(name = "proponente")
    private String proponente;
    @Size(max = 45)
    @Column(name = "emailProponente")
    private String emailProponente;
    @Size(max = 45)
    @Column(name = "tipoAtividade")
    private String tipoAtividade;
    @Size(max = 45)
    @Column(name = "tituloAtividade")
    private String tituloAtividade;
    @Size(max = 100)
    @Column(name = "finalidadeAtividade")
    private String finalidadeAtividade;
    @Size(max = 45)
    @Column(name = "cargaHoraria")
    private String cargaHoraria;
    @Column(name = "vagasAtividade")
    private Integer vagasAtividade;
    @Size(max = 45)
    @Column(name = "nomeConvidado")
    private String nomeConvidado;
    @Size(max = 45)
    @Column(name = "emailConvidado")
    private String emailConvidado;
    @Size(max = 45)
    @Column(name = "formacaoConvidado")
    private String formacaoConvidado;
    @Size(max = 45)
    @Column(name = "origem")
    private String origem;
    @Size(max = 100)
    @Column(name = "informacoesComplementares")
    private String informacoesComplementares;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diaria")
    private int diaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "publico_alvo")
    private String publicoAlvo;
    @Column(name = "publico_todos")
    private Integer publicoTodos;
    @Column(name = "publico_informatica")
    private Integer publicoInformatica;
    @Column(name = "publico_edificacoes")
    private Integer publicoEdificacoes;
    @Column(name = "publico_eletromecanica")
    private Integer publicoEletromecanica;
    @Column(name = "publico_eletrotecnica")
    private Integer publicoEletrotecnica;
    @Column(name = "publico_mecanica")
    private Integer publicoMecanica;
    @Column(name = "publico_metalurgia")
    private Integer publicoMetalurgia;
    @Column(name = "publico_eventos")
    private Integer publicoEventos;
    @Column(name = "publico_secretariado")
    private Integer publicoSecretariado;
    @Column(name = "publico_designMoveis")
    private Integer publicodesignMoveis;
    @Column(name = "publico_eletronica")
    private Integer publicoEletronica;
    @Column(name = "publico_transacoesImobiliarias")
    private Integer publicotransacoesImobiliarias;
    @Column(name = "publico_transporteFerroviario")
    private Integer publicotransporteFerroviario;
    @Column(name = "publico_sistemasInformacao")
    private Integer publicosistemasInformacao;
    @Column(name = "publico_engMecatronica")
    private Integer publicoengMecatronica;
    @Column(name = "publico_engMetalurgica")
    private Integer publicoengMetalurgica;
    @Column(name = "publico_fisica")
    private Integer publicoFisica;
    @Column(name = "segunda")
    private Integer segunda;
    @Column(name = "terca")
    private Integer terca;
    @Column(name = "quarta")
    private Integer quarta;
    @Column(name = "quinta")
    private Integer quinta;
    @Column(name = "sexta")
    private Integer sexta;
    @Column(name = "sabado")
    private Integer sabado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gerente_codGerente")
    private int gerentecodGerente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "local_id")
    private int localId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evento_id")
    private int eventoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "dataInicio")
    private String dataInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "dataFim")
    private String dataFim;
    

    public Proposta() {
    }

    public Proposta(Integer idProposta) {
        this.idProposta = idProposta;
    }

    public Proposta(Integer idProposta, int diaria, String estado, String publicoAlvo, int gerentecodGerente, int localId, int eventoId, String dataInicio, String dataFim) {
        this.idProposta = idProposta;
        this.diaria = diaria;
        this.estado = estado;
        this.publicoAlvo = publicoAlvo;
        this.gerentecodGerente = gerentecodGerente;
        this.localId = localId;
        this.eventoId = eventoId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Proposta(Integer idProposta, String proponente, String emailProponente, String tipoAtividade, String tituloAtividade, String finalidadeAtividade, String cargaHoraria, Integer vagasAtividade, String nomeConvidado, String emailConvidado, String formacaoConvidado, String origem, String informacoesComplementares, int diaria, String estado, String publicoAlvo, Integer publicoTodos, Integer publicoInformatica, Integer publicoEdificacoes, Integer publicoEletromecanica, Integer publicoEletrotecnica, Integer publicoMecanica, Integer publicoMetalurgia, Integer publicoEventos, Integer publicoSecretariado, Integer publicodesignMoveis, Integer publicoEletronica, Integer publicotransacoesImobiliarias, Integer publicotransporteFerroviario, Integer publicosistemasInformacao, Integer publicoengMecatronica, Integer publicoengMetalurgica, Integer publicoFisica, Integer segunda, Integer terca, Integer quarta, Integer quinta, Integer sexta, Integer sabado, int gerentecodGerente, int localId, int eventoId, String dataInicio, String dataFim) {
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
        this.publicoAlvo = publicoAlvo;
        this.publicoTodos = publicoTodos;
        this.publicoInformatica = publicoInformatica;
        this.publicoEdificacoes = publicoEdificacoes;
        this.publicoEletromecanica = publicoEletromecanica;
        this.publicoEletrotecnica = publicoEletrotecnica;
        this.publicoMecanica = publicoMecanica;
        this.publicoMetalurgia = publicoMetalurgia;
        this.publicoEventos = publicoEventos;
        this.publicoSecretariado = publicoSecretariado;
        this.publicodesignMoveis = publicodesignMoveis;
        this.publicoEletronica = publicoEletronica;
        this.publicotransacoesImobiliarias = publicotransacoesImobiliarias;
        this.publicotransporteFerroviario = publicotransporteFerroviario;
        this.publicosistemasInformacao = publicosistemasInformacao;
        this.publicoengMecatronica = publicoengMecatronica;
        this.publicoengMetalurgica = publicoengMetalurgica;
        this.publicoFisica = publicoFisica;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
        this.gerentecodGerente = gerentecodGerente;
        this.localId = localId;
        this.eventoId = eventoId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    
    
    public Integer getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(Integer idProposta) {
        this.idProposta = idProposta;
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

    public Integer getVagasAtividade() {
        return vagasAtividade;
    }

    public void setVagasAtividade(Integer vagasAtividade) {
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

    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }

    public Integer getPublicoTodos() {
        return publicoTodos;
    }

    public void setPublicoTodos(Integer publicoTodos) {
        this.publicoTodos = publicoTodos;
    }

    public Integer getPublicoInformatica() {
        return publicoInformatica;
    }

    public void setPublicoInformatica(Integer publicoInformatica) {
        this.publicoInformatica = publicoInformatica;
    }

    public Integer getPublicoEdificacoes() {
        return publicoEdificacoes;
    }

    public void setPublicoEdificacoes(Integer publicoEdificacoes) {
        this.publicoEdificacoes = publicoEdificacoes;
    }

    public Integer getPublicoEletromecanica() {
        return publicoEletromecanica;
    }

    public void setPublicoEletromecanica(Integer publicoEletromecanica) {
        this.publicoEletromecanica = publicoEletromecanica;
    }

    public Integer getPublicoEletrotecnica() {
        return publicoEletrotecnica;
    }

    public void setPublicoEletrotecnica(Integer publicoEletrotecnica) {
        this.publicoEletrotecnica = publicoEletrotecnica;
    }

    public Integer getPublicoMecanica() {
        return publicoMecanica;
    }

    public void setPublicoMecanica(Integer publicoMecanica) {
        this.publicoMecanica = publicoMecanica;
    }

    public Integer getPublicoMetalurgia() {
        return publicoMetalurgia;
    }

    public void setPublicoMetalurgia(Integer publicoMetalurgia) {
        this.publicoMetalurgia = publicoMetalurgia;
    }

    public Integer getPublicoEventos() {
        return publicoEventos;
    }

    public void setPublicoEventos(Integer publicoEventos) {
        this.publicoEventos = publicoEventos;
    }

    public Integer getPublicoSecretariado() {
        return publicoSecretariado;
    }

    public void setPublicoSecretariado(Integer publicoSecretariado) {
        this.publicoSecretariado = publicoSecretariado;
    }

    public Integer getPublicodesignMoveis() {
        return publicodesignMoveis;
    }

    public void setPublicodesignMoveis(Integer publicodesignMoveis) {
        this.publicodesignMoveis = publicodesignMoveis;
    }

    public Integer getPublicoEletronica() {
        return publicoEletronica;
    }

    public void setPublicoEletronica(Integer publicoEletronica) {
        this.publicoEletronica = publicoEletronica;
    }

    public Integer getPublicotransacoesImobiliarias() {
        return publicotransacoesImobiliarias;
    }

    public void setPublicotransacoesImobiliarias(Integer publicotransacoesImobiliarias) {
        this.publicotransacoesImobiliarias = publicotransacoesImobiliarias;
    }

    public Integer getPublicotransporteFerroviario() {
        return publicotransporteFerroviario;
    }

    public void setPublicotransporteFerroviario(Integer publicotransporteFerroviario) {
        this.publicotransporteFerroviario = publicotransporteFerroviario;
    }

    public Integer getPublicosistemasInformacao() {
        return publicosistemasInformacao;
    }

    public void setPublicosistemasInformacao(Integer publicosistemasInformacao) {
        this.publicosistemasInformacao = publicosistemasInformacao;
    }

    public Integer getPublicoengMecatronica() {
        return publicoengMecatronica;
    }

    public void setPublicoengMecatronica(Integer publicoengMecatronica) {
        this.publicoengMecatronica = publicoengMecatronica;
    }

    public Integer getPublicoengMetalurgica() {
        return publicoengMetalurgica;
    }

    public void setPublicoengMetalurgica(Integer publicoengMetalurgica) {
        this.publicoengMetalurgica = publicoengMetalurgica;
    }

    public Integer getPublicoFisica() {
        return publicoFisica;
    }

    public void setPublicoFisica(Integer publicoFisica) {
        this.publicoFisica = publicoFisica;
    }

    public Integer getSegunda() {
        return segunda;
    }

    public void setSegunda(Integer segunda) {
        this.segunda = segunda;
    }

    public Integer getTerca() {
        return terca;
    }

    public void setTerca(Integer terca) {
        this.terca = terca;
    }

    public Integer getQuarta() {
        return quarta;
    }

    public void setQuarta(Integer quarta) {
        this.quarta = quarta;
    }

    public Integer getQuinta() {
        return quinta;
    }

    public void setQuinta(Integer quinta) {
        this.quinta = quinta;
    }

    public Integer getSexta() {
        return sexta;
    }

    public void setSexta(Integer sexta) {
        this.sexta = sexta;
    }

    public Integer getSabado() {
        return sabado;
    }

    public void setSabado(Integer sabado) {
        this.sabado = sabado;
    }

    public int getGerentecodGerente() {
        return gerentecodGerente;
    }

    public void setGerentecodGerente(int gerentecodGerente) {
        this.gerentecodGerente = gerentecodGerente;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProposta != null ? idProposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proposta)) {
            return false;
        }
        Proposta other = (Proposta) object;
        if ((this.idProposta == null && other.idProposta != null) || (this.idProposta != null && !this.idProposta.equals(other.idProposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Proposta[ idProposta=" + idProposta + " ]";
    }
    
}
