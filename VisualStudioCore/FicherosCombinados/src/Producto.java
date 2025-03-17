public class Producto {

    private static final long serialVersionUID = 4608803335361586627L;

    private String referencia;
    private String descripcion;
    private String tipo;
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicarDto;

        
    public Producto(String referencia, String descripcion, String tipo, String categoria) {
    
    

    

    this.referencia = referencia;
        this.descripcion = descripcion;
        this.tipo = tipo;
        
    }

    public Producto(String referencia, String descripcion, String tipo, int cantidad, double precio, int descuento, int iva, boolean aplicarDto) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDto = aplicarDto;
    }

    
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public boolean isAplicarDto() {
        return aplicarDto;
    }

    public void setAplicarDto(boolean aplicarDto) {
        this.aplicarDto = aplicarDto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("Referencia=").append(referencia);
        sb.append(", Descripcion=").append(descripcion);
        sb.append(", Tipo=").append(tipo);
        sb.append(", Cantidad=").append(cantidad);
        sb.append(", Precio=").append(precio);
        sb.append(", Descuento=").append(descuento);
        sb.append(", Iva=").append(iva);
        sb.append(", Aplicar Descuento=").append(aplicarDto);
        sb.append('}');
        return sb.toString();
    }
}