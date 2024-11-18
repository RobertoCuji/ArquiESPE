package ec.edu.espe.builder;

import java.util.Date;

public class Empleado {
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String genero;
    private String puesto;
    private double salario;
    private boolean tieneSeguro;

    @Override
    public String toString(){
        return "Empleado [nombre=" + nombre + ", apellido=" + apellido+"]";
    }


    public Empleado() {};

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Empleado(String nombre, String apellido, Date fechaNacimiento, String genero, String puesto, double salario, boolean tieneSeguro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.puesto = puesto;
        this.salario = salario;
        this.tieneSeguro = tieneSeguro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isTieneSeguro() {
        return tieneSeguro;
    }

    public void setTieneSeguro(boolean tieneSeguro) {
        this.tieneSeguro = tieneSeguro;
    }
}
