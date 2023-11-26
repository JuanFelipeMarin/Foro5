/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forosemana5_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jmarin
 */
public class Empleado {
    
     int id;
    String nombre;
    String apellido;
    char genero;
    int salario;

    public Empleado(int id, String nombre, String apellido, char genero, int salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.salario = salario;
    }

    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Género: " + genero + ", Salario: " + salario;
    }
    
    public static Empleado leerEmpleadoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del empleado: ");
        int id = scanner.nextInt();

        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.next();

        System.out.print("Ingrese el apellido del empleado: ");
        String apellido = scanner.next();

        System.out.print("Ingrese el género del empleado (M/F): ");
        char genero = scanner.next().charAt(0);

        System.out.print("Ingrese el salario del empleado: ");
        int salario = scanner.nextInt();

        return new Empleado(id, nombre, apellido, genero, salario);
    }
    
}
class ListaEmpleados {
    private ArrayList<Empleado> empleados;
    
    public void agregarEmpleadoDesdeConsola() {
        Empleado nuevoEmpleado = Empleado.leerEmpleadoDesdeConsola();
        empleados.add(nuevoEmpleado);
        ordenarPorSalario();
    }

    public ListaEmpleados() {
        empleados = new ArrayList<>();
    }

  public boolean agregarEmpleado(Empleado nuevoEmpleado) {
        if (existeID(nuevoEmpleado.id)) {
            System.out.println("Error: El ID ya existe en la lista. No se puede agregar el empleado.");
            return false;
        }

        empleados.add(nuevoEmpleado);
        ordenarPorSalario();
        System.out.println("Empleado agregado correctamente.");
        return true;
    }
   
  private boolean existeID(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.id == id) {
                return true;
            }
        }
        return false;
    }
  
  public boolean eliminarEmpleadoPorID(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.id == id) {
                empleados.remove(empleado);
                System.out.println("Empleado con ID " + id + " eliminado correctamente.");
                return true;
            }
        }
        System.out.println("No se encontró un empleado con ID " + id + ".");
        return false;
  }
  
  public boolean actualizarEmpleadoPorID(int id, Empleado nuevoEmpleado) {
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleadoActual = empleados.get(i);
            if (empleadoActual.id == id) {
                empleados.set(i, nuevoEmpleado);
                System.out.println("Empleado con ID " + id + " actualizado correctamente.");
                return true;
            }
        }
        System.out.println("No se encontró un empleado con ID " + id + ".");
        return false;
    }

    public void ordenarPorSalario() {
        Collections.sort(empleados, Comparator.comparingInt(e -> e.salario));
    }
    
    public List<String> listarEmpleados() {
        List<String> resultado = new ArrayList<>();

        for (Empleado empleado : empleados) {
            resultado.add(empleado.toString());
        }

        return resultado;
    }

    public Empleado buscarLineal(int salarioBuscado) {
        for (Empleado empleado : empleados) {
            if (empleado.salario == salarioBuscado) {
                return empleado;
            }
        }
        return null;
    }

    public Empleado buscarBinaria(int salarioBuscado) {
        int inicio = 0;
        int fin = empleados.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            Empleado empleadoMedio = empleados.get(medio);

            if (empleadoMedio.salario == salarioBuscado) {
                return empleadoMedio;
            } else if (empleadoMedio.salario < salarioBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return null;
    }
}
