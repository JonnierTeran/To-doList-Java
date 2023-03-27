/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.to_do_list;


/**
 *
 * @author jonnier andres teran
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;



public class List_Task {
    
    private ArrayList<Task> TaskList; //Arreglo Objetos de la clase task
    

    public List_Task() { //inicializamos el arreglo
        this.TaskList = new ArrayList<>();
    }
/*____________________________Set and get________________________*/
    
    public  ArrayList<Task> getTaskList() {
        return TaskList;
    }

    public void setTaskList(ArrayList<Task> TaskList) {
        this.TaskList = TaskList;
    }
    
    /*-------------------Methods -----------------------------------------------------*/
    
    //Agregar un Objeto al Arreglo
    public void AddTask(Task Task) {
        this.TaskList.add(Task);
        JOptionPane.showMessageDialog(null, "Tarea Registrada con exito \n  Descripcion del registro \n \n"
                + Task.toString());
    }
     
    
    //Ver Lista De Registros
    public void VerList() {
      
        StringBuilder builder = new StringBuilder(); //forma eficiente y mutable de construir y manipular cadenas de texto 

        // Recorrer la lista de tareas y agregar cada tarea con su número de índice
        for (int i = 0; i < this.TaskList.size(); i++) {
            builder.append(i+1).append(". ").append(this.TaskList.get(i)).append("\n \n");
        } 

        // Mostrar las tareas enumeradas en un JOptionPane
        JOptionPane.showMessageDialog(null, "Tareas Registradas \n \n" + builder.toString(), "Lista de Tareas", JOptionPane.INFORMATION_MESSAGE);

    }
    
    /*--------------------------------------------------------------------------------------------------------------------*/
    //Actualizar Tarea
    public void ActualizarTarea(){
        
         StringBuilder builder = new StringBuilder();

        // Recorrer la lista de tareas y agregar cada tarea con su número de índice
        for (int i = 0; i < this.TaskList.size(); i++) {
            builder.append(i+1).append(". ").append(this.TaskList.get(i)).append("\n \n");
        }
        
        //Solicitamos el indice del objeto a actualizar
        int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Tareas Registradas \n \n" + builder.toString() +
                "Ingrese el indice de la tarea a editar "));
        
        // Convertir el dato a String y verificar si está vacío
        if (!Integer.toString(index).isEmpty() && this.TaskList.size() >= index) {
            
            //Coloca por defecto los datos registrados y se solicitan los nuevos datos 
              String tittle= JOptionPane.showInputDialog(null, "Tarea a Actualizar \n \n" + this.TaskList.get(index-1)+
                          "\n \n Ingrese el NUEVO NOMBRE DE LA TAREA: ", this.TaskList.get(index-1).getTitle());
              
              String description= JOptionPane.showInputDialog(null, "Tarea a Actualizar \n \n" + this.TaskList.get(index-1) +
                                 "\n \n Ingrese la  NUEVA DESCRIPCION DE LA TAREA: ", this.TaskList.get(index-1).getDescription());
            
              Object[] options = {"Pendiente", "Completada"};
                 int selection = JOptionPane.showOptionDialog(null, "Seleccione el estado de la tarea:", "Estado de tarea",
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

               //Se valida la seleccion del estado
                  Boolean Status;
                    if (selection == 0) {
                         Status = Boolean.FALSE;
                    } else {
                       Status = Boolean.TRUE;
                    }
            
            //Se crea un nuevo objeto task y se genera una instancia 
            Task Task2;
            Task2 = new Task();
            
            
            Task2.setTitle(tittle);
            Task2.setDescription(description);
            Task2.setStatus(Status);
            
            //Actualizacion del Objeto en el arreglo
            this.TaskList.set(index-1, Task2);
            
             //Mensaje de actualizacion y ver nuevo objeto
            JOptionPane.showMessageDialog(null, "Tarea Actualizada con exito \n  Descripcion de la actualizacion  \n \n"
                            + this.TaskList.get(index-1));
             
        } else {
            //Mensaje de Error en caso que no se ingrese un valor valido
            JOptionPane.showMessageDialog(null, "El indice ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
   }
    
    //Metodo para eliminar un objeto del arreglo
    public void DeleteTask(){
        
         StringBuilder builder = new StringBuilder();

        // Recorrer la lista de tareas y agregar cada tarea con su número de índice
        for (int i = 0; i < this.TaskList.size(); i++) {
            builder.append(i+1).append(". ").append(this.TaskList.get(i)).append("\n \n");
        }
        
        //Solicitamos el indice del objeto a eliminar
        int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Tareas Registradas \n \n" + builder.toString() +
                "Ingrese el indice de la tarea a eliminar "));
        
        //Valida que se ingrese un valor valido
        if (!Integer.toString(index).isEmpty() && this.TaskList.size() >= index) {
             this.TaskList.remove(index-1); //Elimina un objeto y confirma al usuario
             JOptionPane.showMessageDialog(null, "La Tarea se ha Eliminado con éxito.", "Mensaje de éxito", JOptionPane.INFORMATION_MESSAGE);
        }else {
         //Alerta en caso de ingresar un valor invalido
         JOptionPane.showMessageDialog(null, "El indice ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
