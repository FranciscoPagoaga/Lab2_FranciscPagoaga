/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_franciscopagoaga;

/**
 *
 * @author Francisco Pagoaga
 */
public class Empleados {
    private String nombre;
    private String apellido;
    private String color;
    private int edad;
    private String genero;
    private double altura;
    private double peso;
    private String cargo;
    private String titulo;
    
    public Empleados(){
    }
    
    public Empleados(String a,String b, String c, int d, String e, double f, double g,String h, String i){
        nombre=a;
        apellido=b;
        color=c;
        edad=d;
        genero=e;
        altura=f;
        peso=g;
        cargo=h;
        titulo=i;
    }
    
    public void setNombre(String x){
        nombre=x;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setApellido(String x){
        apellido=x;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setColor(String x){
        color=x;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setEdad(int x){
        edad=x;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public void setGenero(String x){
        genero=x;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public void setAltura(Double x){
        altura=x;
    }
    
    public double getAltura(){
        return altura;
    }
    
    public void setPeso(double x){
        peso=x;
    }
    
    public double getPeso(){
        return peso;
    }
    
    public void setCargo(String x){
        cargo=x;
    }
    
    public String getCargo(){
        return cargo;
    }
    
    public void setTitulo(String x){
        titulo=x;
    }
    
    public String getTitulo(){
        return titulo;
    }
}
