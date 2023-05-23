package br.com.fintech.model;

import java.util.Objects;

public class Usuario{

    private String senha;
    private String nome;
    private String email;
    private String telefone;
    private String pais;
    private String userName;

    public Usuario() {

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(senha, usuario.senha) && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(telefone, usuario.telefone) && Objects.equals(pais, usuario.pais) && Objects.equals(userName, usuario.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senha, nome, email, telefone, pais, userName);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", pais='" + pais + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
