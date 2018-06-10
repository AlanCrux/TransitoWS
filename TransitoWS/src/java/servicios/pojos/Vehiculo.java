
package servicios.pojos;

import java.util.Date;

public class Vehiculo {
    private String placas;
    private Date anio;
    private String color;
    private String numPoliza;
    private int idAseguradora;
    private String numLicencia;
    private int idModelo;

    public Vehiculo() {
    }

    public Vehiculo(String placas, Date anio, String color, String numPoliza) {
        this.placas = placas;
        this.anio = anio;
        this.color = color;
        this.numPoliza = numPoliza;
    }

    public int getIdAseguradora() {
        return idAseguradora;
    }

    public void setIdAseguradora(int idAseguradora) {
        this.idAseguradora = idAseguradora;
    }

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }
    
    

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }
    
    
}
