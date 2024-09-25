package pe.edu.pucp.creditomovil.getsclientes.model;
import java.util.Date;
import java.util.ArrayList;
import pe.edu.pucp.creditomovil.rrhh.model.Usuario;
import pe.edu.pucp.creditomovil.getscliente.model.Credito;

public class Cliente extends Usuario{

    private String codigoCliente;
    private String direccion;
    private String telefono;
    private String email;
    private String tipoCliente;
    private ArrayList<Credito> creditos;
    private double score;

    public Cliente(int idUsuario, Date fecha, String nombre, String apPaterno, 
            String apMaterno, String contrasenha, Date fechaVencimiento,
            boolean activo, String codigoCliente, String direccion, 
            String telefono, String email, String tipoCliente){
                super(idUsuario,fecha,nombre,apPaterno,apMaterno,contrasenha,
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
}
