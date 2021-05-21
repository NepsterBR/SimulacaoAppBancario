package com.company.contas;

import java.math.BigDecimal;

public interface Iconta {
    void abrirConta();
    void contaCorrente();
    void contaInvestimento();

    void depositar(BigDecimal depositar);
    void sacar (BigDecimal sacar);
    void extrato ();

    void menu();
    void escolheIndice(int indice);
    void indice();

    void tranferirInvestir();


}
