package com.company.contas;

import java.math.BigDecimal;
import java.text.ParseException;


public class ContaPJ extends Conta implements Iconta {


    @Override
    public void abrirConta() {
        System.out.print("Digite sua Razão Social: ");
        this.razaoSocial = input.next();
        setRazaoSocial(this.razaoSocial);
        System.out.println(getRazaoSocial() + ", nós do banco Let´s Code, estamos honrados em termos sua empresa conosco!");
        System.out.println("Vamos começar abrindo suas contas, Corrente e investimento.");
        System.out.print(getRazaoSocial() + ", por favor, digite seu CNPJ: ");
        this.cnpj = input.next();
        setCnpj(this.cnpj);
        System.out.println(getRazaoSocial() + ", com quantos reais deseja iniciar a conta corrente? ");
        System.out.print("R$ ");
        this.saldoCc = input.nextBigDecimal();
        setSaldoCc(this.saldoCc);
        setSaldoCi(this.saldoCi = new BigDecimal("0"));
    }

    @Override
    public void contaCorrente() {

    }

    @Override
    public void contaInvestimento() {
        this.rendPj = new BigDecimal("1.11");
        this.saldoCi = this.saldoCi.multiply(this.rendPj);
        ;
    }

    @Override
    public void tranferirInvestir() {
        String tipoConta;
        BigDecimal transferir;
        String selecao;
        System.out.println(getRazaoSocial() + " *Por enquanto* você só pode tranfesfir entre suas próprias contas ");
        System.out.println("Estamos trabalhando duro para melhorar isso, contamos com sua compreensão :-)");
        System.out.println();
        System.out.println();
        System.out.println("-------------------- IMPORTANTE! -----------------");
        System.out.println("Contas juridicas são taxadas em 0,5% por transferência");
        System.out.println("             Deseja tranferir de qual conta? ");
        System.out.println("[A] Conta corrente ou [B]Conta Investimento (Investir!)");
        tipoConta = input.next();
        if (tipoConta.equalsIgnoreCase("A")) {
            System.out.println();
            System.out.println(getRazaoSocial() + ", o saldo atual da empresa na Conta Corrente é de: R" + this.nf.format(getSaldoCc()));
            System.out.println();
            System.out.print("Quanto deseja tranferir? ");
            transferir = this.input.nextBigDecimal();
            System.out.print(getRazaoSocial() + ", você transferiu R" + this.nf.format(transferir));
            System.out.println(", para conta Investimento.");
            this.saldoCi = this.saldoCi.add(transferir);
            this.saldoCc = this.saldoCc.subtract(transferir);
            this.taxa = new BigDecimal("0.995");
            this.saldoCc = this.saldoCc.multiply(this.taxa);
            System.out.println("O saldo atual da conta corrente da empresa é de: R" + this.nf.format(getSaldoCc()));
        }
        if (tipoConta.equalsIgnoreCase("B")) {
            System.out.println();
            System.out.println(getRazaoSocial() + ", o saldo atual da empresa na Conta Investimento é de: R" + this.nf.format(getSaldoCi()));
            System.out.println();
            System.out.print("Quanto deseja tranferir? ");
            transferir = this.input.nextBigDecimal();
            System.out.print(getRazaoSocial() + ", você transferiu R" + this.nf.format(transferir));
            System.out.println(", para Conta corrente.");
            this.saldoCc = this.saldoCc.add(transferir);
            this.saldoCi = this.saldoCi.subtract(transferir);
            this.taxa = new BigDecimal("0.995");
            this.saldoCi = this.saldoCi.multiply(this.taxa);
            System.out.println("O saldo atual da conta investimento da empresa é de: R" + this.nf.format(getSaldoCi()));
        }
    }

    @Override
    public void depositar(BigDecimal depositar) {
        System.out.println("Quanto deseja depositar na conta corrente empresarial? ");
        System.out.print("R$ ");
        depositar = input.nextBigDecimal();
        System.out.print(getRazaoSocial() + ", você depositou: R" + this.nf.format(depositar));
        this.saldoCc = this.saldoCc.add(depositar);
        System.out.println("o saldo atual da conta corrente empresarial é de: R" + this.nf.format(getSaldoCc()));
    }

    @Override
    public void sacar(BigDecimal sacar) {
        //Só é possivel sacar da conta conrrente, assim como na vida real.
        System.out.println("-------------------- IMPORTANTE! -----------------");
        System.out.println("Os saques de Conta Juridica, são taxados em 0,5%");
        System.out.println("Quanto deseja sacar da conta corrente empresarial? ");
        System.out.print("R$ ");
        sacar = input.nextBigDecimal();
        if (sacar.compareTo(this.saldoCc) < 1) {
            System.out.print("Você Sacou R" + this.nf.format(sacar));
            this.saldoCc = this.saldoCc.subtract(sacar);
            this.taxa = new BigDecimal("0.995");
            this.saldoCc = this.saldoCc.multiply(this.taxa);
            System.out.println();
            System.out.println(getRazaoSocial() + " o saldo atual da conta correte empresarial é de: R" + this.nf.format(getSaldoCc()));
            this.qtdSaques++;
        } else {
            System.err.print("O seu saldo é insuficiente!");
        }
    }

    @Override
    public void extrato() throws ParseException {
        System.out.println("__________________--- EXTRATO ---_________________");
        System.out.println("Razão Social " + getRazaoSocial());
        System.out.println("Cnpj " + fS(getCnpj(), "##.###.###/####-##"));
        System.out.println();
        System.out.println("Saldo atual da conta corrente da empresa é de: R" + this.nf.format(getSaldoCc()));
        System.out.println();
        System.out.println("A Conta Investimento *Empresarial* rende 11% do valor aplicado!");
        contaInvestimento();
        System.out.println("Saldo atual da conta investimento empresarial é de: R" + this.nf.format(getSaldoCi()));
        System.out.println();
        System.out.println("Total de saques realizados: " + this.qtdSaques);
        System.out.println("___________________________________________________");
    }

    @Override
    public void menu() {
        System.out.println();
        System.out.println("___--- O que deseja fazer?---____");
        System.out.println(" 1 - Consultar Extrato");
        System.out.println(" 2 - Transferir");
        System.out.println(" 3 - Sacar");
        System.out.println(" 4 - Depositar");
        System.out.println(" 5 - Deslogar do sistema");
        System.out.println("__________________________________");
        System.out.print("indice: ");
    }

    @Override
    public void escolheIndice(int indice) throws ParseException {
        switch (indice) {
            case 1:
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                extrato();
                break;
            case 2:
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                tranferirInvestir();
                break;
            case 3:
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                sacar(new BigDecimal("0"));
                break;
            case 4:
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                depositar(new BigDecimal("0"));
                break;
            case 5:
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                System.out.println("Até Breve :)");
        }
    }

    @Override
    public void indice() throws ParseException {
        int indice;

        do {
            menu();
            indice = this.input.nextInt();
            escolheIndice(indice);
        } while (indice != 5);
    }
}


