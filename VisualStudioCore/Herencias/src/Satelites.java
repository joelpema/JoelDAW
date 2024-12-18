public class Satelites extends Astro{
    private double distanciaPlaneta;
    private double orbitaPlaneta;
    private String planetaPerteneciente;

    public Satelites(double  masaDelCuerpo, double  diametroMedio, double  períodoRotaciónHoras, double  períodoTraslaciónHoras, double  distanciaMedia,
    double distanciaPlaneta, double  orbitaPlaneta, String planetaPerteneciente){

        super(masaDelCuerpo,diametroMedio,períodoRotaciónHoras,períodoTraslaciónHoras,distanciaMedia);

        this.distanciaPlaneta = distanciaPlaneta;
        this.orbitaPlaneta = orbitaPlaneta;
        this.planetaPerteneciente = planetaPerteneciente;
    }

    public double  getDistanciaPlaneta() {
        return distanciaPlaneta;
    }

    public double  getOrbitaPlaneta() {
        return orbitaPlaneta;
    }

    public String getPlanetaPerteneciente() {
        return planetaPerteneciente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Satelite{");
        sb.append("Masa del Cuerpo=").append(super.getMasaDelCuerpo());
        sb.append(", Diametro Medio=").append(super.getDiametroMedio());
        sb.append(", Periodo de Rotacion =").append(super.getDistanciaMedia());
        sb.append(", Periodo de Trastacion=").append(super.getPeríodoRotaciónHoras());
        sb.append(", Distancia Media =").append(super.getPeríodoTraslaciónHoras());
        sb.append(", Distancia al Planeta=").append(this.distanciaPlaneta);
        sb.append(", Orbita al Planeta=").append(this.orbitaPlaneta);
        sb.append(", ¿Planeta al que pertenece?=").append(this.planetaPerteneciente);
        sb.append('}');
        return sb.toString();
    }

    
}
