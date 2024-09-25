package pe.edu.pucp.creditomovil.rrhh.model;

import java.util.Date;
import java.util.ArrayList;

import pe.edu.pucp.creditomovil.getscliente.model.Evaluacion;

public class Supervisor extends Usuario{

    private String codigoEv;
    private String agenciaAsignacion;
	private int codigoCargo;
	private ArrayList<Evaluacion> evaluaciones;
    
    public Supervisor(int idUsuario, Date fecha, String nombre, String apPaterno, 
            String apMaterno, String contrasenha, Date fechaVencimiento,
            boolean activo, String codigoEv, int codigoCargo,
            String agenciaAsignacion){
                super(idUsuario,fecha,nombre,apPaterno,apMaterno,contrasenha,
                      fechaVencimiento,activo);
                this.codigoEv = codigoEv;
				this.codigoCargo = codigoCargo;
                this.agenciaAsignacion = agenciaAsignacion;
				this.evaluaciones = new ArrayList<Evaluacion>();
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

    public String getCodigoEv() {
        return codigoEv;
    }

    public void setCodigoEv(String codigoEv) {
        this.codigoEv = codigoEv;
    }
	
	public int getCodigoCargo() {
		return codigoCargo;
	}
	
	public void setCodigoCargo() {
		this.codigoCargo = codigoCargo;
	}

    public String getAgenciaAsignacion() {
        return agenciaAsignacion;
    }

    public void setAgenciaAsignacion(String agenciaAsignacion) {
        this.agenciaAsignacion = agenciaAsignacion;
    }
	
	public void agregarEvaluacion(Evaluacion eval){
		evaluaciones.add(eval);
	}
}

