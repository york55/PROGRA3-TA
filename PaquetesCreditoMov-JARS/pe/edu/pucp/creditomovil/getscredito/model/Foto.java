package pe.edu.pucp.creditomovil.getscredito.model;

import java.util.ArrayList;

public class Foto {


    private int tipoFoto;
    private ArrayList<Character> foto;
    
    public Foto(int tipoFoto){
        this.tipoFoto = tipoFoto;
        foto = new ArrayList<Character>();
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

}
