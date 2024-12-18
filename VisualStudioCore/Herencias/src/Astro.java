public class Astro {

    private double  MasaDelCuerpo;
    private double  DiametroMedio;
    private double  PeríodoRotaciónHoras;
    private double  PeríodoTraslaciónHoras;
    private double DistanciaMedia;

    public Astro(double  MasaDelCuerpo, double  DiametroMedio, double  PeríodoRotaciónHoras, double  PeríodoTraslaciónHoras, double  DistanciaMedia) {
        this.MasaDelCuerpo = MasaDelCuerpo;
        this.DiametroMedio = DiametroMedio;
        this.PeríodoRotaciónHoras = PeríodoRotaciónHoras;
        this.PeríodoTraslaciónHoras = PeríodoTraslaciónHoras;
        this.DistanciaMedia = DistanciaMedia;
    }

    public Astro(double  MasaDelCuerpo, double  DiámetroMedio) {
        this.MasaDelCuerpo = MasaDelCuerpo;
        this.DiametroMedio = DiámetroMedio;
    }

    public String mostrarInfo(){
        String info;
        info = "Masa del cuerpo.: "+this.MasaDelCuerpo+" Diámetro medio: "+this.DiametroMedio+" Período de rotación sobre su propio eje: "+
        this.PeríodoRotaciónHoras+" Período de traslación alrededor del cuerpo que orbitan: "+this.PeríodoTraslaciónHoras + " Distancia media a ese cuerpo: "+this.DistanciaMedia;
        return info;
    }

    

    public double getMasaDelCuerpo() {
        return MasaDelCuerpo;
    }

    public double getDiametroMedio(){
        return DiametroMedio;
    }

    public double getDistanciaMedia(){
        return this.DistanciaMedia;
    }

    public double getPeríodoRotaciónHoras() {
        return PeríodoRotaciónHoras;
    }

    public double getPeríodoTraslaciónHoras() {
        return PeríodoTraslaciónHoras;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("Masa del Cuerpo=").append(MasaDelCuerpo);
        sb.append(", Diametro Medio=").append(DiametroMedio);
        sb.append(", Periodo de Rotacion =").append(PeríodoRotaciónHoras);
        sb.append(", Periodo de Trastacion=").append(PeríodoTraslaciónHoras);
        sb.append(", Distancia Media =").append(DistanciaMedia);
        sb.append('}');
        return sb.toString();
    }


}
