package com.company.contas;

import java.math.BigDecimal;
import java.text.ParseException;

public class ContaPf extends Conta implements Iconta {

    public ContaPf() {
    }

    @Override
    public void abrirConta() {
        System.out.print("Digite seu  primeiro nome: ");
        this.nome = input.nextLine();
        setNome(this.nome);
        System.out.println(getNome() + ", nós do banco Let´s Code, estamos honrados em termos você conosco!");
        System.out.println("Vamos começar abrindo suas contas, Corrente, investimento e Poupança");
        System.out.print(getNome() + ", por favor, digite seu cpf: ");
        this.cpf = input.nextLine();
        setCpf(this.cpf);
        System.out.println(getNome() + ", com quantos reais deseja iniciar a conta corrente? ");
        System.out.print("R$ ");
        this.saldoCc = input.nextBigDecimal();
        setSaldoCc(this.saldoCc);
        setSaldoCi(this.saldoCi = new BigDecimal("0"));
        setSaldoCp(this.saldoCp = new BigDecimal("0"));
    }

    @Override
    public void contaCorrente() {

    }

    @Override
    public void depositar(BigDecimal depositar) {
        System.out.println("Quanto deseja depositar na conta corrente? ");
        System.out.print("R$ ");
        depositar = input.nextBigDecimal();
        System.out.print(getNome() + ", você depositou: R" + this.nf.format(depositar));
        this.saldoCc = this.saldoCc.add(depositar);
        System.out.println("Seu saldo atual é de: R" + this.nf.format(getSaldoCc()));
    }

    @Override
    public void sacar(BigDecimal sacar) {
        //Só é possivel sacar da conta conrrente, assim como na vida real.
        System.out.println("Quanto deseja sacar da conta corrente? ");
        System.out.print("R$ ");
        sacar = input.nextBigDecimal();
        if (sacar.compareTo(this.saldoCc) < 1) {
            System.out.print("Você Sacou R" + this.nf.format(sacar) + ". ");
            this.saldoCc = this.saldoCc.subtract(sacar);
            System.out.println(getNome() + " seu saldo atual é de: R" + this.nf.format(getSaldoCc()));
            this.qtdSaques++;
        } else {
            System.err.print("O seu saldo é insuficiente!");
        }
    }

    public void tranferirInvestir() {
        String tipoConta;
        BigDecimal transferir;
        String selecao;
        System.out.println(getNome() + " *Por enquanto* você só pode tranfesfir entre suas próprias contas ");
        System.out.println("Estamos trabalhando duro para melhorar isso, contamos com sua compreensão :-)");
        System.out.println();
        System.out.println();
        System.out.println("             Deseja tranferir de qual conta? ");
        System.out.println("[A] Conta corrente, [B]Conta Investimento (Investir!) ou [C]Conta poupança? ");
        tipoConta = input.next();
        if (tipoConta.equalsIgnoreCase("A")) {
            System.out.println();
            System.out.println(getNome() + ", seu saldo atual na Conta Corrente é de: R" + this.nf.format(getSaldoCc()));
            System.out.println();
            System.out.print("Quanto deseja tranferir? ");
            transferir = this.input.nextBigDecimal();
            System.out.println("Para qual conta conta?");
            System.out.println("[A]Conta Investimento (Investir!) ou [B]Conta poupança? ");
            selecao = this.input.next();
            if (selecao.equalsIgnoreCase("A")) {
                System.out.print(getNome() + ", você transferiu R" + this.nf.format(transferir));
                System.out.println(", para conta Investimento.");
                this.saldoCi = this.saldoCi.add(transferir);
                this.saldoCc = this.saldoCc.subtract(transferir);
            }
            if (selecao.equalsIgnoreCase("B")) {
                System.out.print(getNome() + ", você transferiu R" + this.nf.format(transferir));
                System.out.println(", para Conta Poupança.");
                this.saldoCp = this.saldoCp.add(transferir);
                this.saldoCc = this.saldoCc.subtract(transferir);
            }
        }
        if (tipoConta.equalsIgnoreCase("B")) {
            System.out.println();
            System.out.println(getNome() + ", seu saldo atual na Conta investimento é de: R" + this.nf.format(getSaldoCi()));
            System.out.println();
            System.out.print("Quanto deseja tranferir? ");
            transferir = this.input.nextBigDecimal();
            System.out.println("Para qual conta conta?");
            System.out.println("[A]Conta Corrente ou [B]Conta poupança? ");
            selecao = this.input.next();
            if (selecao.equalsIgnoreCase("A")) {
                System.out.print(getNome() + ", você transferiu R" + this.nf.format(transferir));
                System.out.println(", para Conta Corrente.");
                this.saldoCc = this.saldoCc.add(transferir);
                this.saldoCi = this.saldoCi.subtract(transferir);
            }
            if (selecao.equalsIgnoreCase("B")) {
                System.out.print(getNome() + ", você transferiu R" + this.nf.format(transferir));
                System.out.println(", para Conta Poupança");
                this.saldoCp = this.saldoCp.add(transferir);
                this.saldoCi = this.saldoCi.subtract(transferir);
            }
        }
        if (tipoConta.equalsIgnoreCase("C")) {
            System.out.println();
            System.out.println(getNome() + ", seu saldo atual na Conta Poupança é de: R" + this.nf.format(getSaldoCp()));
            System.out.println();
            System.out.print("Quanto deseja tranferir? ");
            transferir = this.input.nextBigDecimal();
            System.out.println("Para qual conta conta?");
            System.out.println("[A]Conta Corrente ou [B]Conta Ivestimento(Investir!)? ");
            selecao = this.input.next();
            if (selecao.equalsIgnoreCase("A")) {
                System.out.print(getNome() + ", você transferiu R" + this.nf.format(transferir));
                System.out.println(", para Conta Corrente.");
                this.saldoCc = this.saldoCc.add(transferir);
                this.saldoCp = this.saldoCp.subtract(transferir);
            }
            if (selecao.equalsIgnoreCase("B")) {
                System.out.print(getNome() + ", você transferiu R" + this.nf.format(transferir));
                System.out.println(", para Conta Investimento.");
                this.saldoCi = this.saldoCi.add(transferir);
                this.saldoCp = this.saldoCp.subtract(transferir);
            }
        }

    }

    @Override
    public void extrato() throws ParseException {
        System.out.println("__________________--- EXTRATO ---_________________");
        System.out.println("Nome: " + getNome());
        System.out.println();
        System.out.println("Cpf: " + fS(getCpf(), "###.###.###-##"));
        System.out.println("Saldo atual da conta corrente é de: R" + this.nf.format(getSaldoCc()));
        System.out.println();
        System.out.println("A Conta Investimento rende 9% do valor aplicado!");
        contaInvestimento();
        System.out.println("Saldo atual da conta investimento é de: R" + this.nf.format(getSaldoCi()));
        System.out.println();
        System.out.println("A Conta Poupança rende 2% do valor aplicado!");
        contaPoupanca();
        System.out.println("Saldo atual da conta poupança é de: R" + this.nf.format(getSaldoCp()));
        System.out.println("Total de saques realizados: " + this.qtdSaques);
        System.out.println("___________________________________________________");
    }

    @Override
    public void contaInvestimento() {
        this.rendCi = new BigDecimal("1.09");
        this.saldoCi = this.saldoCi.multiply(this.rendCi);
    }

    public void contaPoupanca() {
        this.rendCp = new BigDecimal("1.02");
        this.saldoCp = this.saldoCp.multiply(this.rendCp);
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

    public void indice() throws ParseException {
        int indice;

        do {
            menu();
            indice = this.input.nextInt();
            escolheIndice(indice);
        } while (indice != 5);
    }


}
