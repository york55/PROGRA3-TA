/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Bleak
 */
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
