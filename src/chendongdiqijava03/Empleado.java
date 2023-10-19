/*
 * Clase Empleado
 */
package chendongdiqijava03;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author Di Qi
 */
public class Empleado {
    
    private int numero;
    private String nombre;
    private GregorianCalendar fechaAlta;
    private double sueldo;
    private double sueldoMaximo;

    public Empleado(int numero, String nombre, double sueldo, double sueldoMaximo) {
        this.numero = numero;
        this.nombre = nombre;
        this.fechaAlta = new GregorianCalendar();
        this.sueldo = sueldo;
        this.sueldoMaximo = sueldoMaximo;
    }

    public Empleado(int numero, String nombre) {
        this(numero, nombre, 0, 0);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GregorianCalendar getFechaAlta() {
        return fechaAlta;
    }

    public String getFechaAltaStr() {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateTimeFormat.setCalendar(this.fechaAlta);
        return dateTimeFormat.format(this.fechaAlta.getTime());
    }

    public void setFechaAlta(GregorianCalendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getSueldoMaximo() {
        return sueldoMaximo;
    }

    public void setSueldoMaximo(double sueldoMaximo) {
        this.sueldoMaximo = sueldoMaximo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "numero=" + numero + ", nombre=" + nombre + '}';
    }
}
