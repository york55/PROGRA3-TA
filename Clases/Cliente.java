/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.ArrayList;
/**
 *
 * @author Bleak
 */
public class Cliente extends Usuario{

    private String codigoCliente;
    private String direccion;
    private String telefono;
    private String email;
    private String tipoCliente;
    private ArrayList<Credito> creditos;
    

    public Cliente(Date fecha, String nombre, String apPaterno, 
            String apMaterno, String contrasenha, Date fechaVencimiento,
            boolean activo, String codigoCliente, String direccion, 
            String telefono, String email, String tipoCliente){
                super(fecha,nombre,apPaterno,apMaterno,contrasenha,
                      fechaVencimiento,activo);
                this.codigoCliente = codigoCliente;
                this.direccion = direccion;
                this.telefono = telefono;
                this.email = email;
                this.tipoCliente = tipoCliente;
                
                creditos = new ArrayList<Credito>();
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
    
    public void listarCreditos(){
        
    }

    public void agregarCredito(Credito nuevo){
        creditos.add(nuevo);
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

}
