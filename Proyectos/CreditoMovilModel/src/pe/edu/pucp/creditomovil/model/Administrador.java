/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.model;

import java.util.Date;

public class Administrador extends Usuario {

    private int codigoAdm;
    private int codigoCargo;

    public Administrador(){}
    public Administrador(int idUsuario, Date fecha, String nombre, String apPaterno,
            String apMaterno, String contrasenha, Date fechaVencimiento,
            boolean activo, TipoDocumento tipoDocumento, String documento, int codigoAdm, int codigoCargo) {
        super(idUsuario, fecha, nombre, apPaterno, apMaterno, contrasenha, fechaVencimiento, activo, tipoDocumento, documento);
        this.codigoAdm = codigoAdm;
        this.codigoCargo = codigoCargo;
    }

    public void setCodigoAdm(int codigoAdm) {
        this.codigoAdm = codigoAdm;
    }

    public int getCodigoAdm() {
        return codigoAdm;
    }

    public void setCodigoCargo(int codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public int getCodigoCargo() {
        return codigoCargo;
    }
}
