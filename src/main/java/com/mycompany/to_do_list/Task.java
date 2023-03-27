/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.to_do_list;

/**
 *
 * @author jonnier andres teran
 */
public class Task {
    //Propiedades de la tarea
    private String title, description;
    private Boolean status;
    
    public Task(){ //Constructor De la tarea, se inicializan los campos vacidos y el status en false
        this.title ="";
        this.description="";
        this.status = false;
    }      

    //Metodos modificadores y de acceso set y get
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String estado;
        
        if(!status){
            estado = "Pendiente";
        }else {
            estado = "Completa";
        }
        return """
               Tarea:  
                Nombre:  """ + title + 
                " \n Detalles:  " + description + 
                "\n Estado:  " + estado;
    }
    
}
