/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.Date;

/**
 *
 * @author Bleak
 */
public abstract class Usuario {

    private Date fecha;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String contrasenha;
    private Date fechaVencimiento;
    private boolean activo; // define si el usuario esta activo en el sistema o no
    private Date ultimoLogueo;
    
    public Usuario(Date fecha, String nombre, String apPaterno, 
            String apMaterno, String contrasenha, Date fechaVencimiento,
            boolean activo){
                this.fecha = fecha;
                this.nombre = nombre;
                this.apPaterno = apPaterno;
                this.apMaterno = apMaterno;
                this.contrasenha = contrasenha;
                this.fechaVencimiento = fechaVencimiento;
                //el activo podría ser inicializado por su setter
                this.activo = activo;
    }

    

    public void registrar(){
        
    }
    
    public void desactivar(){
        
    }
    
    public void actualizar(){
        
    }
    
    public void listarClientes(){


    }
    
    public Cliente buscarCliente(){


    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getUltimoLogueo() {
        return ultimoLogueo;
    }

    public void setUltimoLogueo(Date ultimoLogueo) {
        this.ultimoLogueo = ultimoLogueo;
    }

}