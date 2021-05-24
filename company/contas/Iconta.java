package com.company.contas;

import java.math.BigDecimal;
import java.text.ParseException;

public interface Iconta {
    void abrirConta();
    void contaCorrente();
    void contaInvestimento();

    void depositar(BigDecimal depositar);
    void sacar (BigDecimal sacar);
    void extrato () throws ParseException;

    void menu();
    void escolheIndice(int indice) throws ParseException;
    void indice() throws ParseException;

    void tranferirInvestir();


}
