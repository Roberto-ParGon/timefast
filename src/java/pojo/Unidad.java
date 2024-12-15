package pojo;

public class Unidad {
    private String vin;
    private String marca;
    private String modelo;
    private String anio;
    private Integer idTipoUnidad;
    private Integer numLicencia;

    public Unidad() {
    }

    public Unidad(String vin, String marca, String modelo, String anio, Integer idTipoUnidad, Integer numLicencia) {
        this.vin = vin;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.idTipoUnidad = idTipoUnidad;
        this.numLicencia = numLicencia;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Integer getIdTipoUnidad() {
        return idTipoUnidad;
    }

    public void setIdTipoUnidad(Integer idTipoUnidad) {
        this.idTipoUnidad = idTipoUnidad;
    }

    public Integer getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(Integer numLicencia) {
        this.numLicencia = numLicencia;
    }
    
    
}
