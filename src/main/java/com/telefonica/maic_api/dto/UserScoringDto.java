package com.telefonica.maic_api.dto;

public class UserScoringDto {
    private String numTelefono;
    private String nombre;
    private int adelantaPago;
    private int tramo0;
    private int tramo30;
    private int tramo60;
    
    public UserScoringDto(String numTelefono, String nombre, int adelantaPago, int tramo0, int tramo30, int tramo60) {
        this.numTelefono = numTelefono;
        this.nombre = nombre;
        this.adelantaPago = adelantaPago;
        this.tramo0 = tramo0;
        this.tramo30 = tramo30;
        this.tramo60 = tramo60;
    }
    
    public UserScoringDto() {
    }
    public String getNumTelefono() {
        return numTelefono;
    }
    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getAdelantaPago() {
        return adelantaPago;
    }
    public void setAdelantaPago(int adelantaPago) {
        this.adelantaPago = adelantaPago;
    }
    public int getTramo0() {
        return tramo0;
    }
    public void setTramo0(int tramo0) {
        this.tramo0 = tramo0;
    }
    public int getTramo30() {
        return tramo30;
    }
    public void setTramo30(int tramo30) {
        this.tramo30 = tramo30;
    }
    public int getTramo60() {
        return tramo60;
    }
    public void setTramo60(int tramo60) {
        this.tramo60 = tramo60;
    }
}
