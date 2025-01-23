package com.telefonica.maic_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "otc_")
public class UserScoring {

    @Id
    @Column(name = "num_telefono")
    private String numTelefono;

    @Column(name = "acoount_number")
    private String accountNumber;

    private String cedula;

    private String gauge;

    private String veritas;

    @Column(name = "fecha_proceso")
    private String fechaProceso;

    private String nombre;

    private int adelantaPago;

    private int tramo0;

    private int tramo30;

    private int tramo60;

    public String getNumTelefono() {
        return numTelefono;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCedula() {
        return cedula;
    }

    public String getGauge() {
        return gauge;
    }

    public String getVeritas() {
        return veritas;
    }

    public String getFechaProceso() {
        return fechaProceso;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setGauge(String gauge) {
        this.gauge = gauge;
    }

    public void setVeritas(String veritas) {
        this.veritas = veritas;
    }

    public void setFechaProceso(String fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAdelantaPago(int adelantaPago) {
        this.adelantaPago = adelantaPago;
    }

    public void setTramo0(int tramo0) {
        this.tramo0 = tramo0;
    }

    public void setTramo30(int tramo30) {
        this.tramo30 = tramo30;
    }

    public void setTramo60(int tramo60) {
        this.tramo60 = tramo60;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTramo0() {
        return tramo0;
    }

    public int getTramo30() {
        return tramo30;
    }

    public int getTramo60() {
        return tramo60;
    }

    public int getAdelantaPago() {
        return adelantaPago;
    }    
}
