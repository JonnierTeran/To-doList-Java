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
 * El problema que se quiere resolver con este ejercicio es el de crear una aplicación de lista de tareas (Todo-List) utilizando Programación Orientada a Objetos (POO). La aplicación debe permitir al usuario crear una lista de tareas, agregar y eliminar tareas de la lista, y marcar tareas como completadas o no.
 */

import javax.swing.JOptionPane;

public class To_Do_List {

    public static void main(String[] args) {
        //Mensaje
        JOptionPane.showMessageDialog(null,"BIENDEVIDO AL TO-DO LIST");
        //Variable para el ciclo while
        Boolean Value = Boolean.TRUE;
        
        //Opcion elegida en el menù
        int Option;
        
        //Instancia de la clase el TODO (List_Task)
        List_Task ListTask;
        ListTask = new List_Task();
        
        //Ciclo que muestra el menu hasta que el usuario quiera finalizar la ejecucion
        while(Value){
           Option = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                MEN\u00da DE OPCIONES 
                                                 
                                                1 - Registrar una nueva Tarea 
                                                 
                                                2 - Ver Tareas Registradas 
                                                 
                                                3 - Actualizar una Tarea 
                                                                 
                                                4 - Eliminar una Tarea 
                                                 
                                                5 - Salir 
                                                                       
                                                """, "1"));
           
           //Switch Case con  arrow switch statement
            switch (Option) {
                case 1 -> {
                    //Creamos un nuevo objeto task y su instancia
                    Task Task;
                    Task = new Task();
                    //Solicita Los datos del objeto por teclado
                    String Title  = JOptionPane.showInputDialog(null,"Inserte El titulo de la tarea");
                    String Description  = JOptionPane.showInputDialog(null,"Inserte la Descripcion de la tarea");
                    
                    //Valida el estado de la tarea
                    Object[] options = {"Pendiente", "Completada"};
                    int selection = JOptionPane.showOptionDialog(null, "Seleccione el estado de la tarea:", "Estado de tarea", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    Boolean Status;
                    if (selection == 0) {
                         Status = Boolean.FALSE;
                    } else {
                       Status = Boolean.TRUE;
                    }
                    
                    //Agrega valores al Objeto
                    Task.setTitle(Title);
                    Task.setDescription(Description);
                    Task.setStatus(Status); 
                    //Registra la tarea en el arreglo
                    ListTask.AddTask(Task);
                }
                case 2 -> ListTask.VerList(); // Ejecuta el metodo VerList
                case 3 -> ListTask.ActualizarTarea(); //Ejecuta el metodo ActualizarTarea
                case 4 -> ListTask.DeleteTask(); //Ejecuta el Metodo DeleteTask
                case 5 -> { //Finaliza LA Ejecucion
                    JOptionPane.showMessageDialog(null,"F I N " +" D E "+" E J E C U C I O N ");
                    System.exit(0);}
                default -> { //En caso de ingresar algo invalido, informa por pantalla
                    JOptionPane.showMessageDialog(null,"OPCION INVALIDA, ELIJA UN NUMERO DEL MENU");
                }
            }
            
          
           
        }
        
      
    }
}
