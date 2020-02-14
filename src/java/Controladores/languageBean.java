/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Mateo Morera
 */
@Named(value = "languageBean")
@SessionScoped
public class languageBean implements Serializable {
    
    private Locale idiomaSeleccionado;
    private List<Locale> idiomasSoportados;
    
    
    @PostConstruct
    public void init() {
        //Obtengo la instancia actual y asigno es como valor predeterminado
        FacesContext fc = FacesContext.getCurrentInstance();
        idiomaSeleccionado = new Locale("es");
        //Creo un arraylist de idiomas soportados segun la instancia del contexto acual
        idiomasSoportados = new ArrayList<>();
        Iterator<Locale> it = fc.getApplication().getSupportedLocales();
        //Recorro el arraylist con un iterador y los guardo en la lista de idiomas soportados
        while (it.hasNext()) {
            idiomasSoportados.add(it.next());
        }
//        idiomasSoportados.add(new Locale("es"));
//        idiomasSoportados.add(new Locale("en"));
    }

   
    public languageBean() {
       
    }
    
    public Locale getIdiomaSeleccionado() {
        return idiomaSeleccionado;
    }

    public List<Locale> getIdiomasSoportados() {
        return idiomasSoportados;
    }

    public void cambiarIdioma(Locale nuevoIdioma) {
        this.idiomaSeleccionado = nuevoIdioma;
        FacesContext.getCurrentInstance().getViewRoot().setLocale(nuevoIdioma);
    }
    
}
