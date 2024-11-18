package ec.edu.espe.builder;

import java.util.Date;

public class EmpleadoBuilder
{
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String genero;
    private String puesto;
    private double salario;
    private boolean tieneSeguro;

    private EmpleadoBuilder(Builder builder){
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.fechaNacimiento = builder.fechaNacimiento;
        this.genero = builder.genero;
        this.puesto = builder.puesto;
        this.salario = builder.salario;
        this.tieneSeguro = builder.tieneSeguro;
    }

    @Override
    public String toString(){
        return "[nombre=" + nombre +
                ", apellido=" + apellido+
                ", fechaNacimiento=" + fechaNacimiento +
                ", genero="+genero+
                ", puesto="+puesto+"]";
    }

    public static class Builder{
        private String nombre;
        private String apellido;
        private Date fechaNacimiento;
        private String genero;
        private String puesto;
        private double salario;
        private boolean tieneSeguro;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setApellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Builder setFechaNacimiento(Date fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Builder setGenero(String genero) {
            this.genero = genero;
            return this;
        }

        public Builder setPuesto(String puesto) {
            this.puesto = puesto;
            return this;
        }

        public Builder setSalario(double salario) {
            this.salario = salario;
            return this;
        }

        public Builder setTieneSeguro(boolean tieneSeguro) {
            this.tieneSeguro = tieneSeguro;
            return this;
        }

        public EmpleadoBuilder build(){
            return new EmpleadoBuilder(this);
        }
    }

}
