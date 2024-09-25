package pe.edu.pucp.creditomovil.rrhh.model;

import java.util.Date;

public class Administrador extends Usuario{
	private String codigoAdm;
	private int codigoCargo;
	
	public Administrador(int idUsuario, Date fecha, String nombre, String apPaterno, 
            String apMaterno, String contrasenha, Date fechaVencimiento,
            boolean activo,String codigoAdm, int codigoCargo){
		super(idUsuario,fecha,nombre,apPaterno,apMaterno,contrasenha,fechaVencimiento,activo);
		this.codigoAdm = codigoAdm;
		this.codigoCargo = codigoCargo;
	}
	
	public void setCodigoAdm(String codigoAdm) {
		this.codigoAdm = codigoAdm;
	}
	
	public String getCodigoAdm() {
		return codigoAdm;
	}
	
	public void setCodigoCargo(int codigoCargo) {
		this.codigoCargo = codigoCargo;
	}
	
	public int getCodigoCargo() {
		return codigoCargo;
	}
}