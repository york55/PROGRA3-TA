package pe.edu.pucp.creditomovil.getscredito.model;

import java.util.ArrayList;

public class Foto {


    private int tipoFoto;
    private ArrayList<Character> foto;
	private Transaccion transaccion;
    
    public Foto(int tipoFoto, Transaccion transaccion){
        this.tipoFoto = tipoFoto;
        foto = new ArrayList<Character>();
		this.transaccion = transaccion;
    }

    public void registraFoto(){
        
    }
    
    public void recuperafoto(){
        
    }

    public void agregarFoto(char nuevo){
        foto.add(nuevo);
    }

    public int getTipoFoto() {
        return tipoFoto;
    }

    public void setTipoFoto(int tipoFoto) {
        this.tipoFoto = tipoFoto;
    }
	
	public Transaccion getTransaccion() {
		return transaccion;
	}
	
	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

}
