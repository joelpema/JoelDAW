package com.decroly.pruebaexamenfinal.model;

public class Consulta {

    private String Fecha;
    private int duracion;
    private String observaciones;
    private String mascotaPasaporte;
    private String MascotaPropietarioDNI;

    public Consulta(String fecha, int duracion, String observaciones, String mascotaPasaporte, String mascotaPropietarioDNI) {

        Fecha = fecha;
        this.duracion = duracion;
        this.observaciones = observaciones;
        this.mascotaPasaporte = mascotaPasaporte;
        MascotaPropietarioDNI = mascotaPropietarioDNI;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getMascotaPasaporte() {
        return mascotaPasaporte;
    }

    public void setMascotaPasaporte(String mascotaPasaporte) {
        this.mascotaPasaporte = mascotaPasaporte;
    }

    public String getMascotaPropietarioDNI() {
        return MascotaPropietarioDNI;
    }

    public void setMascotaPropietarioDNI(String mascotaPropietarioDNI) {
        MascotaPropietarioDNI = mascotaPropietarioDNI;
    }

    @Override
    public String toString() {
        return
                "idConsulta=" + idConsulta +
                ", Fecha='" + Fecha + '\'' +
                ", duracion=" + duracion +
                ", observaciones='" + observaciones + '\'' +
                ", mascotaPasaporte='" + mascotaPasaporte + '\'' +
                ", MascotaPropietarioDNI='" + MascotaPropietarioDNI + '\'';
    }
}
