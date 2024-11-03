/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.model;

import java.util.Date;

public abstract class Usuario {

    private int idUsuario;
    private Date fecha;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String contrasenha;
    private Date fechaVencimiento;
    private boolean activo; // define si el usuario esta activo en el sistema o no
    private Date ultimoLogueo;
    private TipoDocumento tipoDocumento;
    private String documento;
    
    public Usuario(int idUsuario, Date fecha, String nombre, String apPaterno,
            String apMaterno, String contrasenha, Date fechaVencimiento,
            boolean activo, TipoDocumento tipoDocumento, String documento) {
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.contrasenha = contrasenha;
        this.fechaVencimiento = fechaVencimiento;
        //el activo podría ser inicializado por su setter
        this.activo = activo;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
    }

    public void registrar() {

    }

    public void desactivar() {

    }

    public void actualizar() {

    }

    public void listarClientes() {

    }

//    public Cliente buscarCliente(){
//
//        return ;
//    }
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
