
package forosemana5_2;

import java.util.List;
import java.util.Scanner;

public class ForoSemana5_2 {


    public static void main(String[] args) {
        
         ListaEmpleados lista = new ListaEmpleados();
        Scanner scanner = new Scanner(System.in);
        
        //Lista EmpleadosEntregada 
        lista.agregarEmpleado(new Empleado(1, "Carlos Alberto", "Martínez Rodríguez", 'M', 2952670));
        lista.agregarEmpleado(new Empleado(2, "Teresa", "Nicolás Otaño", 'F', 2338617));
        lista.agregarEmpleado(new Empleado(3, "Rosa Alquidia", "Lázala Polanco", 'F', 2355228));
        lista.agregarEmpleado(new Empleado(4, "Ivellisse", "Estévez Ventura", 'M', 1801728));
        lista.agregarEmpleado(new Empleado(5, "Margarita", "Núñez de la Cruz", 'F', 3124269));
        lista.agregarEmpleado(new Empleado(6, "Belkis Josefina", "Hernández", 'F', 2975450));
        lista.agregarEmpleado(new Empleado(7, "Ruth", "Ortega", 'F', 2306902));
        lista.agregarEmpleado(new Empleado(8, "Lourdes", "Florentino de la Cruz", 'F', 2583729));
        lista.agregarEmpleado(new Empleado(9, "Luisa", "Mejía", 'F', 2160378));
        lista.agregarEmpleado(new Empleado(10, "Cándido Mercedes", "Vargas", 'F', 1961114));
        
        ///navegacion de menu 
            
            int opcion;
            
             do {
            System.out.println("\nMenú:");
            System.out.println("1. Listar todos los empleados");
            System.out.println("2. Ingresar un nuevo empleado");
            System.out.println("3. Consultar por salario");
            System.out.println("4. Actualizar empleado");
            System.out.println("5. Eliminar empleado");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                     List<String> empleadosListados = lista.listarEmpleados();
                    if (!empleadosListados.isEmpty()) {
                        for (String empleado : empleadosListados) {
                            System.out.println(empleado);
                        }
                    } else {
                        System.out.println("No hay empleados en la lista.");
                    }
                    break;
                case 2:
                    System.out.println("Ingresando datos para un nuevo empleado: ");
                    lista.agregarEmpleado(Empleado.leerEmpleadoDesdeConsola());
                    break;
                case 3:
                    System.out.print("Ingrese el salario a buscar: ");
                int salarioBuscado = scanner.nextInt();
                 Empleado encontradoLineal = lista.buscarLineal(salarioBuscado);
                 Empleado encontradoBinario = lista.buscarBinaria(salarioBuscado);
                 
                 if (encontradoLineal != null) {
                       System.out.println("Empleado encontrado (búsqueda lineal): " + encontradoLineal);
                   } else {
                       System.out.println("Empleado no encontrado (búsqueda lineal)");
                   }

                   if (encontradoBinario != null) {
                       System.out.println("Empleado encontrado (búsqueda binaria): " + encontradoBinario);
                   } else {
                       System.out.println("Empleado no encontrado (búsqueda binaria)");
                   }

                    break;
                 case 4:              
                    System.out.print("Ingrese el ID del empleado a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    Empleado nuevoEmpleado = Empleado.leerEmpleadoDesdeConsola();
                    lista.actualizarEmpleadoPorID(idActualizar, nuevoEmpleado);
                    
                  break;
                 case 5:
                     System.out.print("Ingrese el ID del empleado a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    lista.eliminarEmpleadoPorID(idEliminar);
                     break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
           
       
    }
    
    
    
}
