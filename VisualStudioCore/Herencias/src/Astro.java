public class Astro {

    private double  masaDelCuerpo;
    private double  diametroMedio;
    private double  períodoRotaciónHoras;
    private double  períodoTraslaciónHoras;
    private double distanciaMedia;

    public Astro(double  masaDelCuerpo, double  diametroMedio, double  períodoRotaciónHoras, double  períodoTraslaciónHoras, double  distanciaMedia) {
        this.masaDelCuerpo = masaDelCuerpo;
        this.diametroMedio = diametroMedio;
        this.períodoRotaciónHoras = períodoRotaciónHoras;
        this.períodoTraslaciónHoras = períodoTraslaciónHoras;
        this.distanciaMedia = distanciaMedia;
    }

    public double getMasaDelCuerpo() {
        return masaDelCuerpo;
    }

    public double getDiametroMedio(){
        return diametroMedio;
    }

    public double getPeríodoRotaciónHoras() {
        return períodoRotaciónHoras;
    }

    public double getPeríodoTraslaciónHoras() {
        return períodoTraslaciónHoras;
    } 
    
    public double getDistanciaMedia(){
        return this.distanciaMedia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAstro\n");
        sb.append("Masa del Cuerpo= ").append(masaDelCuerpo);
        sb.append(", Diametro Medio= ").append(diametroMedio);
        sb.append(", Periodo de Rotacion= ").append(períodoRotaciónHoras);
        sb.append(", Periodo de Traslacion= ").append(períodoTraslaciónHoras);
        sb.append(", Distancia Media= ").append(distanciaMedia);
        
        return sb.toString();
    }


}
