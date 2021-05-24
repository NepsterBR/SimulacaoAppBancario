package com.company;

import com.company.contas.ContaPJ;
import com.company.contas.ContaPf;
import com.company.contas.Iconta;


import java.util.Scanner;

public class Aplicacao{

    public static void main(String[] args) {
        /*Eu queria colocar mais algumas funcionalidade
        * como por exemplo, limitar a quantidade de centavos (casas decimais)
        * colocar o tipo de tranferencia Pix
        * entre outras coisas.
        * mas fiz apenas o que o exercicío pede, como o Professor pediu!*/

        /*
        * Ultilizei Condicionais para as tranferências e para o menu funcionar corretamente.
        *
        * Ultlizei Repetição no índice.
        *
        * Matrizes e Arrays, não achei necessário e também me complicaria (complicaria EU - Gabriel - não o código)
        * quando fosse fazer as operações matemáticas.
        *
        * Classes e objetos foram ultilizados no projeto inteiro.
        *
        * Encapsulamento ultlizado na Classe Conta.java .
        *
        * Ultilizei herança e interface apenas para as "contas" e não para os "clientes" pois não vi necessidade.
        *
        * Poliformismo ultilizado no projeto.
        
            PARA MELHOR VISUALIZAÇÃO, ULTILIZE O TERMINAL MAIOR POSSIVEL
        * */
        iniciar();
    }

    public static void iniciar(){

        String tipoConta;
        Scanner input = new Scanner(System.in);

        System.out.println("______---Bem vindo ao banco Let's Code!---______");
        System.out.println("Deseja abrir uma conta PJ ou conta PF? PJ/PF");
        tipoConta = input.nextLine();
        if (tipoConta.equalsIgnoreCase("pf")){
            Iconta contaPf = new ContaPf();
            contaPf.abrirConta();
            contaPf.indice();
        }
        if (tipoConta.equalsIgnoreCase("pj")){
            Iconta contaPj = new ContaPJ();
            contaPj.abrirConta();
            contaPj.indice();
        }

    }
}
