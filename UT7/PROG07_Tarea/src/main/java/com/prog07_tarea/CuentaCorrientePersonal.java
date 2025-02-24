package com.prog07_tarea;

import java.util.ArrayList;

public class CuentaCorrientePersonal extends CuentaCorriente {
    protected double comisionMantenimiento;

    protected CuentaCorrientePersonal(Persona titular, double saldo, String iban, ArrayList<String> listaEntidades, double comisionMantenimiento){
        super(titular, saldo, iban, listaEntidades);
        this.comisionMantenimiento = comisionMantenimiento;
    };

    public String devolverInfoString(){
        return "Titular: " + titular.nombre + " " + titular.apellidos + "\n" +
                "Saldo: " + saldo + "\n" +
                "IBAN: " + iban + "\n" +
                "Comisión de mantenimiento: " + comisionMantenimiento + "\n" + 
                "Lista de entidades: " + listaEntidades + "\n"
;
    };
}
