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
   private String title, description;
    private Boolean status;
    
    public Task(){
        this.title ="";
        this.description="";
        this.status = false;
    }      

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
