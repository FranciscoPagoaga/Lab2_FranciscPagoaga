/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_franciscopagoaga;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Francisco Pagoaga
 */
public class Lab2_FranciscoPagoaga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleados p = new Empleados();
        Scanner input = new Scanner(System.in);
        ArrayList<Empleados> empleados = new ArrayList();
        int fin = 1, opcion;
        Random r = new Random();
        boolean permiso = false;
        while (fin == 1) {
            System.out.println("1. Registro de Empleados\n2. Despedir Empleados\n3. Log In\n4. Ascender Cajero\n5. Listar Empleados\n6. Modificar Empleado\n7. Random\n8. Salir");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    if (permiso == false) {
                        System.out.println("Tiene que hacer login primero\n");
                    } else {
                        System.out.println("Ingrese su nombre:");
                        String nom = input.next();
                        System.out.println("Ingrese su apellido: ");
                        String ape = input.next();
                        System.out.println("Ingrese su color favorito: ");
                        String color = input.next();
                        System.out.println("Ingrese su edad: ");
                        int ed = input.nextInt();
                        System.out.println("Ingrese 'm' para mujer y 'h' para hombre");
                        char g = input.next().charAt(0);
                        while (g != 'm' && g != 'h') {
                            System.out.println("Ingrese una opcion valida: ");
                            g = input.next().charAt(0);
                        }
                        String gen = "";
                        if (g == 'm') {
                            gen = "Mujer";
                        } else if (g == 'h') {
                            gen = "Hombre";
                        }
                        System.out.println("Ingrese su altura: ");
                        double alt = input.nextDouble();
                        System.out.println("Ingrese su peso: ");
                        double pes = input.nextDouble();
                        System.out.println("Cargo:\n1. Gerente\n2. Aseadores\n3. Cajeros\n4. Seguridad");
                        int h = input.nextInt();
                        int contger = 0;
                        if (empleados.size() > 0) {
                            for (int i = 0; i < empleados.size(); i++) {
                                if ("Gerente".equals(((Empleados) empleados.get(i)).getCargo())) {
                                    contger++;
                                }
                            }
                        }
                        while (h > 4 || h < 1 || (contger == 3 && h == 1)) {
                            System.out.println("Ingrese una opcion valida:");
                            h = input.nextInt();
                        }
                        String carg = "";
                        switch (h) {
                            case 1:
                                carg = "Gerente";
                                break;
                            case 2:
                                carg = "Aseador";
                                break;
                            case 3:
                                carg = "Cajero";
                                break;
                            case 4:
                                carg = "Seguridad";
                                break;
                        }
                        System.out.println("Ingrese su titulo:");
                        String tit = input.nextLine();

                        empleados.add(new Empleados(nom, ape, color, ed, gen, alt, pes, carg, tit));
                    }
                    break;
                case 2:
                    if (permiso == false) {
                        System.out.println("Tiene que hacer login primero\n");
                    } else {
                        for (int i = 0; i < empleados.size(); i++) {
                            System.out.println(i + ") " + ((Empleados) empleados.get(i)).getNombre() + " " + ((Empleados) empleados.get(i)).getApellido() + " ;" + ((Empleados) empleados.get(i)).getCargo());
                        }
                        int elim = input.nextInt();
                        while (elim < 0 || elim > empleados.size()) {
                            System.out.println("Ingrese un numero de la lista valido:");
                            elim = input.nextInt();
                        }
                        empleados.remove(elim);
                        if ("Gerente".equals(((Empleados) empleados.get(elim)).getCargo())) {
                            System.out.println("Eliga un cajero para ascender: ");
                            for (int i = 0; i < empleados.size(); i++) {
                                System.out.println(i + ") " + ((Empleados) empleados.get(i)).getNombre() + " " + ((Empleados) empleados.get(i)).getApellido() + " ;" + ((Empleados) empleados.get(i)).getCargo());
                            }
                            int agreg = input.nextInt();
                            if ("Cajero".equals(((Empleados) empleados.get(agreg)).getCargo())) {
                                ((Empleados) empleados.get(agreg)).setCargo("Gerente");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el usuario a ingresar: ");
                    String correo = input.next();
                    System.out.println("Ingrese contraseña: ");
                    String psswd = input.next();
                    if ("leobanegas".equals(correo) && "99".equals(psswd)) {
                        System.out.println("Ha entrado existosamente!");
                        permiso = true;
                    } else {
                        System.out.println("Usuario o Contraseña Incorrectos");
                    }
                    break;
                case 4:
                    int cont = 0;
                    int contger = 0;
                    if (empleados.size() > 0) {
                        for (int i = 0; i < empleados.size(); i++) {
                            if ("Gerente".equals(((Empleados) empleados.get(i)).getCargo())) {
                                contger++;
                            }
                        }
                    }
                    if (permiso == false) {
                        System.out.println("Tiene que hacer login primero\n");
                    } else if (contger == 3) {
                        System.out.println("Ya tiene la cantidad maxima de gerentes, no puede ascender");
                    } else {
                        System.out.println("Eliga un cajero para ascender");
                        for (int i = 0; i < empleados.size(); i++) {
                            System.out.println(i + ") " + ((Empleados) empleados.get(i)).getNombre() + " " + ((Empleados) empleados.get(i)).getApellido() + " ;" + ((Empleados) empleados.get(i)).getCargo());
                        }
                        int x = input.nextInt();
                        if ("Cajero".equals(((Empleados) empleados.get(x)).getCargo())) {
                            ((Empleados) empleados.get(x)).setCargo("Gerente");
                        } else {
                            System.out.println("El empleado no es cajero, no se puede ascender");
                        }
                    }
                    break;
                case 5:
                    if (permiso == false) {
                        System.out.println("Tiene que hacer login primero\n");
                    } else {
                        cont = 1;
                        for (int i = 0; i < empleados.size(); i++) {
                            if ("Gerente".equals(((Empleados) empleados.get(i)).getCargo())) {
                                System.out.println(cont + ") " + ((Empleados) empleados.get(i)).getNombre() + " " + ((Empleados) empleados.get(i)).getApellido() + " ;" + ((Empleados) empleados.get(i)).getCargo());
                                cont++;
                            }
                        }
                        for (int i = 0; i < empleados.size(); i++) {
                            if ("Cajero".equals(((Empleados) empleados.get(i)).getCargo())) {
                                System.out.println(cont + ") " + ((Empleados) empleados.get(i)).getNombre() + " " + ((Empleados) empleados.get(i)).getApellido() + " ;" + ((Empleados) empleados.get(i)).getCargo());
                                cont++;
                            }
                        }
                        for (int i = 0; i < empleados.size(); i++) {
                            if ("Aseador".equals(((Empleados) empleados.get(i)).getCargo())) {
                                System.out.println(cont + ") " + ((Empleados) empleados.get(i)).getNombre() + " " + ((Empleados) empleados.get(i)).getApellido() + " ;" + ((Empleados) empleados.get(i)).getCargo());
                                cont++;
                            }
                        }
                        for (int i = 0; i < empleados.size(); i++) {
                            if ("Seguridad".equals(((Empleados) empleados.get(i)).getCargo())) {
                                System.out.println(cont + ") " + ((Empleados) empleados.get(i)).getNombre() + " " + ((Empleados) empleados.get(i)).getApellido() + " ;" + ((Empleados) empleados.get(i)).getCargo());
                                cont++;
                            }
                        }
                    }
                    break;
                case 6:
                    if (permiso == false) {
                        System.out.println("Tiene que hacer login primero\n");
                    } else {
                        System.out.println("Eliga un empleado de la siguiente Lista");
                        for (int i = 0; i < empleados.size(); i++) {
                            System.out.println(i + ") " + ((Empleados) empleados.get(i)).getNombre() + " " + ((Empleados) empleados.get(i)).getApellido() + " ;" + ((Empleados) empleados.get(i)).getCargo());
                        }
                        int x = input.nextInt();
                        while (x < 0 || x > empleados.size()) {
                            System.out.println("Ingrese un numero valido: ");
                            x = input.nextInt();
                        }
                        System.out.println("Que desea modifica?\n1. Nombre\n2. Apellido\n3. Color Favorito\n4. Edad\n5. Genero\n6. Altura\n7. Peso\n8. Cargo\n9. Titulo");
                        int k = input.nextInt();
                        while (k < 1 || k > 9) {
                            System.out.println("Ingrese un numero valido: ");
                            k = input.nextInt();
                        }
                        String y = null;
                        int o;
                        double c;
                        char z;
                        switch (k) {
                            case 1:
                                System.out.println("Ingrese nuevo nombre:");
                                y = input.next();
                                ((Empleados) empleados.get(x)).setNombre(y);
                                break;
                            case 2:
                                System.out.println("Ingrese nuevo apellido:");
                                y = input.next();
                                ((Empleados) empleados.get(x)).setApellido(y);
                                break;
                            case 3:
                                System.out.println("Ingrese un nuevo color:");
                                y = input.next();
                                ((Empleados) empleados.get(x)).setColor(y);
                                break;
                            case 4:
                                System.out.println("Ingrese una nueva edad:");
                                o = input.nextInt();
                                ((Empleados) empleados.get(x)).setEdad(o);
                                break;
                            case 5:
                                char g = input.next().charAt(0);
                                while (g != 'm' && g != 'h') {
                                    System.out.println("Ingrese una opcion valida: ");
                                    g = input.next().charAt(0);
                                }
                                if (g == 'm') {
                                    y = "Mujer";
                                } else if (g == 'h') {
                                    y = "Hombre";
                                }
                                ((Empleados) empleados.get(x)).setGenero(y);
                                break;
                            case 6:
                                System.out.println("Ingrese altura: ");
                                c = input.nextDouble();
                                ((Empleados) empleados.get(x)).setAltura(c);
                                break;
                            case 7:
                                System.out.println("Ingrese Peso:");
                                c = input.nextDouble();
                                ((Empleados) empleados.get(x)).setPeso(c);
                                break;
                            case 8:
                                System.out.println("Cargo:\n1. Gerente\n2. Aseadores\n3. Cajeros\n4. Seguridad");
                                int h = input.nextInt();
                                contger = 0;
                                if (empleados.size() > 0) {
                                    for (int i = 0; i < empleados.size(); i++) {
                                        if ("Gerente".equals(((Empleados) empleados.get(i)).getCargo())) {
                                            contger++;
                                        }
                                    }
                                }
                                while (h > 4 || h < 1 || (contger == 3 && h == 1)) {
                                    System.out.println("Ingrese una opcion valida:");
                                    h = input.nextInt();
                                }
                                String carg = "";
                                switch (h) {
                                    case 1:
                                        y = "Gerente";
                                        break;
                                    case 2:
                                        y = "Aseador";
                                        break;
                                    case 3:
                                        y = "Cajero";
                                        break;
                                    case 4:
                                        y = "Seguridad";
                                        break;
                                }
                                ((Empleados) empleados.get(x)).setCargo(y);
                                break;
                            case 9:
                                System.out.println("Ingrese titulo: ");
                                y = input.nextLine();
                                ((Empleados) empleados.get(x)).setTitulo(y);
                                break;
                        }
                    }
                case 7:
                    if (permiso == false) {
                        System.out.println("Tiene que hacer login primero\n");
                    } else {
                        contger = 0;
                        if (empleados.size() > 0) {
                            for (int i = 0; i < empleados.size(); i++) {
                                if ("Gerente".equals(((Empleados) empleados.get(i)).getCargo())) {
                                    contger++;
                                }
                            }
                        }
                        int h, e;
                        String y = null;
                        System.out.println("Ingrese un numero para random");
                        int num = input.nextInt();
                        while (num < 1 || num > empleados.size()) {
                            System.out.println("Ingrese un numero valido: ");
                            num = input.nextInt();
                        }
                        for (int i = 0; i < num; i++) {
                            e = 1 + r.nextInt(empleados.size());
                            h = 1 + r.nextInt(4);
                            switch (h) {
                                case 1:
                                    y = "Gerente";
                                    break;
                                case 2:
                                    y = "Aseador";
                                    break;
                                case 3:
                                    y = "Cajero";
                                    break;
                                case 4:
                                    y = "Seguridad";
                                    break;
                            }
                            while (y.equals(((Empleados) empleados.get(e)).getCargo()) || ("Gerente".equals(y) && contger == 3)) {
                                h = 1 + r.nextInt(4);
                                switch (h) {
                                    case 1:
                                        y = "Gerente";
                                        break;
                                    case 2:
                                        y = "Aseador";
                                        break;
                                    case 3:
                                        y = "Cajero";
                                        break;
                                    case 4:
                                        y = "Seguridad";
                                        break;
                                }
                            }
                            ((Empleados) empleados.get(e)).setCargo(y);
                        }
                    }
                    break;
                case 8:
                    fin = 0;
                    break;
            }
        }
    }

    public Empleados metodos() {
        return new Empleados();
    }

}
