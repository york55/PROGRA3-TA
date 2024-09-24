package pe.edu.pucp.creditomovil.rrhh.model;

import java.util.Date;

public class Supervisor extends Usuario{

    private String codigoSup;
    private int codigoCargo;
    private String agenciaAsignacion;
    
    public Supervisor(Date fecha, String nombre, String apPaterno, 
            String apMaterno, String contrasenha, Date fechaVencimiento,
            boolean activo, String codigoSup, int codigoCargo,
            String agenciaAsignacion){
                super(fecha,nombre,apPaterno,apMaterno,contrasenha,
                      fechaVencimiento,activo);
                this.codigoSup = codigoSup;
                this.codigoCargo = codigoCargo;
                this.agenciaAsignacion = agenciaAsignacion;
    }
    @Override
    public void registrar(){
        
    }
    @Override
    public void desactivar(){
        
    }
    @Override
    public void actualizar(){
        
    }

    public String getCodigoSup() {
        return codigoSup;
    }

    public void setCodigoSup(String codigoSup) {
        this.codigoSup = codigoSup;
    }

    public int getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(int codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public String getAgenciaAsignacion() {
        return agenciaAsignacion;
    }

    public void setAgenciaAsignacion(String agenciaAsignacion) {
        this.agenciaAsignacion = agenciaAsignacion;
    }
}

