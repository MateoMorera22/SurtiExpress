/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Marca;
import Entidades.Submarca;
import Facades.MarcaFacade;
import Facades.SubmarcaFacade;
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
@Named(value = "subMarcaControlador")
@SessionScoped
public class subMarcaControlador implements Serializable {

    /**
     * Creates a new instance of subMarcaControlador
     */
    public subMarcaControlador() {
    }
    //Importación de EJB y entidades
    @EJB
    SubmarcaFacade submarcaFacade;
    Submarca submarca = new Submarca();
    @EJB
    MarcaFacade marcaFacade;
    Marca marca = new Marca();

    //Getters y Setters
    public Submarca getSubmarca() {
        return submarca;
    }

    public void setSubmarca(Submarca submarca) {
        this.submarca = submarca;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @PostConstruct
    public void init() {
        submarca = new Submarca();
        marca = new Marca();
    }

    public void crearSubMarca() {
        submarca.setIdMarca(marcaFacade.find(marca.getIdMarca()));
        submarcaFacade.create(submarca);
        submarca = new Submarca();
        marca = new Marca();
    }

    public void editarSubMarca() {
        submarca.setIdMarca(marcaFacade.find(marca.getIdMarca()));
        submarcaFacade.edit(submarca);

    }

    public List<Submarca> listarSubMarca() {
        return submarcaFacade.findAll();
    }

    public void eliminarSubMarca(Submarca submarca) {
        String mensaje = "";
        try {
            submarcaFacade.remove(submarca);
            mensaje = "Submarca eliminada correctamente.";
            System.out.println(mensaje);
        } catch (Exception e) {
            mensaje = "¡No se a podido eliminar! Por favor elimina primero los productos asociados a esta submarca ";
            System.out.println(mensaje);
        }

    }

    public String preEditarSubMarca(Submarca submarca) {
        this.submarca = submarca;
        return "";
    }

}
