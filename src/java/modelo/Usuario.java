package modelo;

public abstract class Usuario {

    protected String nome;
    protected String email;
    protected String senha;
    protected String dataNascimento;

    public Usuario(String nome, String email, String senha, String dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getDataNasciemento() {
        return this.dataNascimento;
    }

    /**
     * @param nome
     *
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setData(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
