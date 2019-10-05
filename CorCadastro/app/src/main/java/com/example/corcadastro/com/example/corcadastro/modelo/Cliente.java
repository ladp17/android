package com.example.corcadastro.com.example.corcadastro.modelo;

import com.example.corcadastro.controle.Controle;

import java.util.Objects;

public class Cliente {

    private String nome;
    private String cpf;
    private String dataNacimento;
    private String email;

    //em hexa
    private String color;

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String dataNacimento, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNacimento = dataNacimento;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(String dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setColor(Integer color) {
        this.color = Controle.toHexa(color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) &&
                Objects.equals(cpf, cliente.cpf) &&
                Objects.equals(dataNacimento, cliente.dataNacimento) &&
                Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, dataNacimento, email);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNacimento='" + dataNacimento + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
