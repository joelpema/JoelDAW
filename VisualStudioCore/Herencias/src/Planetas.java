public class Planetas extends Astro{

    private double distanciaSol;
    private double  orbitaSol;
    private boolean tieneSatelites;

    public Planetas(double  masaDelCuerpo, double  diametroMedio, double  períodoRotaciónHoras, double  períodoTraslaciónHoras, double  distanciaMedia,
     double distanciaSol, double  orbitaSol, boolean tieneSatelites){

        super(masaDelCuerpo,diametroMedio,períodoRotaciónHoras,períodoTraslaciónHoras,distanciaMedia);

        this.distanciaSol = distanciaSol;
        this.orbitaSol = orbitaSol;
        this.tieneSatelites = tieneSatelites;
    }

    
    public double getDistanciaSol() {
        return distanciaSol;
    }

    public double getOrbitaSol() {
        return orbitaSol;
    }

    public boolean isTieneSatelites() {
        return tieneSatelites;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append(super.toString());
        sb.append("Planeta{");
        sb.append("Masa del Cuerpo=").append(super.getMasaDelCuerpo());
        sb.append(", Diametro Medio=").append(super.getDiametroMedio());
        sb.append(", Periodo de Rotacion =").append(super.getDistanciaMedia());
        sb.append(", Periodo de Traslacion=").append(super.getPeríodoRotaciónHoras());
        sb.append(", Distancia Media =").append(super.getPeríodoTraslaciónHoras());
        sb.append(", Distancia al Sol=").append(this.distanciaSol);
        sb.append(", Orbita al Sol=").append(this.orbitaSol);
        sb.append(", ¿Tiene satelites?=").append(this.tieneSatelites);
        sb.append('}');
        return sb.toString();
    }
    

}