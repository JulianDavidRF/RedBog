package com.example.redbog.clases;

public class Reporte {
    private String nombre;
    private String reporte;
    private String fecha;
    private String hora;
    private String localidad;
    private String tipologia;
    private int id;
    private int dateId;



    public Reporte(String nombre, String reporte, String fecha, String hora, String localidad, String tipologia,int id, int dateId) {
        this.nombre = nombre;
        this.reporte = reporte;
        this.fecha = fecha;
        this.hora = hora;
        this.localidad = localidad;
        this.tipologia = tipologia;
        this.id =id;
        this.dateId = dateId;
    }

    public int getDateId() {
        return dateId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReporte() {
        return reporte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getFecha() {
        return fecha + " - " +hora;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
}
