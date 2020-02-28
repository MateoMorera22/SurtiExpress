/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Marca;
import Facades.MarcaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author surtiExpress
 */
@Named(value = "marcaContolador")
@SessionScoped
public class marcaContolador implements Serializable {

    /**
     * Creates a new instance of marcaContolador
     */
    public marcaContolador() {
    }
    @EJB
    MarcaFacade marcaFacade;
    Marca marca = new Marca();

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @PostConstruct
    public void init() {
        marca = new Marca();
    }

    public void crearMarca() {
        marcaFacade.create(marca);
        marca = new Marca();

    }

    public void editarMarca() {
        marcaFacade.edit(marca);
    }

    public List<Marca> listarMarcas() {
        return marcaFacade.findAll();
    }

    public void eliminarMarca(Marca marca) {
        String mensaje = "";
        try {
            marcaFacade.remove(marca);
            mensaje = "Marca eliminada correctamente.";
            System.out.println(mensaje);
        } catch (Exception e) {
            mensaje = "¡No se a podido eliminar! Por favor elimina primero la submarca asociada a esta marca ";
            System.out.println(mensaje);
        }
    }

    public String preEditarMarca(Marca marca) {
        this.marca = marca;
        return "";
    }

}
