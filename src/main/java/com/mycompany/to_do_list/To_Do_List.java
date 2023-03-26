/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.to_do_list;

/**
 *
 * @author jonnier andres teran
 *
 * Description:
 * crear un programa que permita manejar una lista de tareas (to-do list). 
 * Cada tarea debe tener un título y una descripción, y debe poder ser marcada como completada
 * o no completada.
 */

import javax.swing.JOptionPane;

public class To_Do_List {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"BIENDEVIDO AL TO-DO LIST");
        
        Boolean Value = Boolean.TRUE;
        int Option;
        List_Task ListTask;
        ListTask = new List_Task();
        
        while(Value){
           Option = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                MEN\u00da DE OPCIONES 
                                                 
                                                1 - Registrar una nueva Tarea 
                                                 
                                                2 - Ver Tareas Registradas 
                                                 
                                                3 - Actualizar una Tarea 
                                                                 
                                                4 - Eliminar una Tarea 
                                                 
                                                5 - Salir 
                                                                       
                                                """, "1"));
           
            switch (Option) {
                case 1 -> {
                    Task Task;
                    Task = new Task();
                    String Title  = JOptionPane.showInputDialog(null,"Inserte El titulo de la tarea");
                    String Description  = JOptionPane.showInputDialog(null,"Inserte la Descripcion de la tarea");
                    
                    Object[] options = {"Pendiente", "Completada"};
                    int selection = JOptionPane.showOptionDialog(null, "Seleccione el estado de la tarea:", "Estado de tarea", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    Boolean Status;
                    if (selection == 0) {
                         Status = Boolean.FALSE;
                    } else {
                       Status = Boolean.TRUE;
                    }
                    Task.setTitle(Title);
                    Task.setDescription(Description);
                    Task.setStatus(Status);
                    ListTask.AddTask(Task);
                }
                case 2 -> ListTask.VerList();
                case 3 -> ListTask.ActualizarTarea();
                case 4 -> ListTask.DeleteTask();
                case 5 -> {
                    JOptionPane.showMessageDialog(null,"F I N " +" D E "+" E J E C U C I O N ");
                    System.exit(0);}
                default -> {
                    JOptionPane.showMessageDialog(null,"OPCION INVALIDA, ELIJA UN NUMERO DEL MENU");
                }
            }
            
          
           
        }
        
      
    }
}
