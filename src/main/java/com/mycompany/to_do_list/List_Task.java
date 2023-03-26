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
    
    public ArrayList<Task> TaskList;
    

    public List_Task() {
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
     
    public void AddTask(Task Task) {
        this.TaskList.add(Task);
        JOptionPane.showMessageDialog(null, "Tarea Registrada con exito \n  Descripcion del registro \n \n"
                + Task.toString());
    }
     
    public void VerList() {
      
        StringBuilder builder = new StringBuilder();

        // Recorrer la lista de tareas y agregar cada tarea con su número de índice
        for (int i = 0; i < this.TaskList.size(); i++) {
            builder.append(i+1).append(". ").append(this.TaskList.get(i)).append("\n \n");
        }

        // Mostrar las tareas enumeradas en un JOptionPane
        JOptionPane.showMessageDialog(null, "Tareas Registradas \n \n" + builder.toString(), "Lista de Tareas", JOptionPane.INFORMATION_MESSAGE);

    }
    
    /*--------------------------------------------------------------------------------------------------------------------*/
    public void ActualizarTarea(){
        
         StringBuilder builder = new StringBuilder();

        // Recorrer la lista de tareas y agregar cada tarea con su número de índice
        for (int i = 0; i < this.TaskList.size(); i++) {
            builder.append(i+1).append(". ").append(this.TaskList.get(i)).append("\n \n");
        }
        
        int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Tareas Registradas \n \n" + builder.toString() +
                "Ingrese el indice de la tarea a editar "));
        
        // Convertir el dato a String y verificar si está vacío
        if (!Integer.toString(index).isEmpty() && this.TaskList.size() >= index) {
            
              String tittle= JOptionPane.showInputDialog(null, "Tarea a Actualizar \n \n" + this.TaskList.get(index-1)+
                          "\n \n Ingrese el NUEVO NOMBRE DE LA TAREA: ", this.TaskList.get(index-1).getTitle());
              
              String description= JOptionPane.showInputDialog(null, "Tarea a Actualizar \n \n" + this.TaskList.get(index-1) +
                                 "\n \n Ingrese la  NUEVA DESCRIPCION DE LA TAREA: ", this.TaskList.get(index-1).getDescription());
            
              Object[] options = {"Pendiente", "Completada"};
                 int selection = JOptionPane.showOptionDialog(null, "Seleccione el estado de la tarea:", "Estado de tarea", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

               
                  Boolean Status;
                    if (selection == 0) {
                         Status = Boolean.FALSE;
                    } else {
                       Status = Boolean.TRUE;
                    }
            
            Task Task2;
            Task2 = new Task();
            
            
            Task2.setTitle(tittle);
            Task2.setDescription(description);
            Task2.setStatus(Status);
            
            this.TaskList.set(index-1, Task2);
            
            JOptionPane.showMessageDialog(null, "Tarea Actualizada con exito \n  Descripcion de la actualizacion  \n \n"
                            + this.TaskList.get(index-1));
             
        } else {
            
            JOptionPane.showMessageDialog(null, "El indice ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
   }
    
    
    public void DeleteTask(){
        
         StringBuilder builder = new StringBuilder();

        // Recorrer la lista de tareas y agregar cada tarea con su número de índice
        for (int i = 0; i < this.TaskList.size(); i++) {
            builder.append(i+1).append(". ").append(this.TaskList.get(i)).append("\n \n");
        }
        
        int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Tareas Registradas \n \n" + builder.toString() +
                "Ingrese el indice de la tarea a eliminar "));
        
        if (!Integer.toString(index).isEmpty() && 
                this.TaskList.size() >= index) {
             this.TaskList.remove(index-1);
             JOptionPane.showMessageDialog(null, "La Tarea se ha Eliminado con éxito.", "Mensaje de éxito", JOptionPane.INFORMATION_MESSAGE);
        }else {
         JOptionPane.showMessageDialog(null, "El indice ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
