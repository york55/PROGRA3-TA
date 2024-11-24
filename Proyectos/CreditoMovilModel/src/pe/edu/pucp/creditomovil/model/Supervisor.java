/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.model;

import java.util.Date;
import java.util.ArrayList;

public class Supervisor extends Usuario {

    private int codigoEv;
    private String agenciaAsignacion;
    private int codigoCargo;

    public Supervisor(){}
    public Supervisor(int idUsuario, Date fecha, String nombre, String apPaterno,
            String apMaterno, String contrasenha, Date fechaVencimiento,
            boolean activo, TipoDocumento tipoDocumento, String documento, String salt,
            int codigoEv, int codigoCargo,
            String agenciaAsignacion) {
        super(idUsuario, fecha, nombre, apPaterno, apMaterno, contrasenha,
                fechaVencimiento, activo, tipoDocumento, documento, salt);
        this.codigoEv = codigoEv;
        this.codigoCargo = codigoCargo;
        this.agenciaAsignacion = agenciaAsignacion;
    }

    @Override
    public void registrar() {

    }

    @Override
    public void desactivar() {

    }

    @Override
    public void actualizar() {

    }

    public int getCodigoEv() {
        return codigoEv;
    }

    public void setCodigoEv(int codigoEv) {
        this.codigoEv = codigoEv;
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
