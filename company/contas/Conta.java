package com.company.contas;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Conta {
    protected String nome;
    protected String razaoSocial;

    protected String cpf;
    protected String cnpj;

    protected BigDecimal saldoCc;
    protected BigDecimal saldoCp;
    protected BigDecimal saldoCi;
    protected int qtdSaques;

    protected BigDecimal rendCi;
    protected BigDecimal rendCp;
    protected BigDecimal rendPj;
    protected BigDecimal taxa;

    protected Scanner input = new Scanner(System.in);

    //coloquei "CANADA", pois não tem Brasil no padrão, concertei o "R$" no sout.
    protected NumberFormat nf  = NumberFormat.getCurrencyInstance(Locale.CANADA);

    public Conta() {

    }

    protected Conta(String nome, String razaoSocial, String cpf, String cnpj, BigDecimal saldoCc, BigDecimal saldoCp, BigDecimal saldoCi, int qtdSaques) {
        this.nome = nome;
        this.cpf = cpf;

        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;

        this.saldoCc = saldoCc;
        this.saldoCp = saldoCp;
        this.saldoCi = saldoCi;
        this.qtdSaques = qtdSaques;

        this.rendCp = new BigDecimal("1.02");
        this.rendCi = new BigDecimal("1.09");
        this.rendPj = new BigDecimal("1.11");

        this.taxa = new BigDecimal("0.995");

    }

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getCpf() {
        return cpf;
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected BigDecimal getSaldoCc() {
        return saldoCc;
    }

    protected void setSaldoCc(BigDecimal saldo) {
        this.saldoCc = saldo;
    }

    public BigDecimal getSaldoCp() {
        return saldoCp;
    }

    public void setSaldoCp(BigDecimal saldoCp) {
        this.saldoCp = saldoCp;
    }

    public BigDecimal getSaldoCi() {
        return saldoCi;
    }

    public void setSaldoCi(BigDecimal saldoCi) {
        this.saldoCi = saldoCi;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
