package ec.edu.espe.builder;

public class CarroBuilder {
    private String id;
    private String modelo;
    private String marca;
    private String placa;
    private double cilindraje;
    private String tipo;
    private String procedencia;
    private String combustible;
    private String color;

    private CarroBuilder(Builder builder) {
        this.id = builder.id;
        this.modelo = builder.modelo;
        this.marca = builder.marca;
        this.placa = builder.placa;
        this.cilindraje = builder.cilindraje;
        this.tipo = builder.tipo;
        this.procedencia = builder.procedencia;
        this.combustible = builder.combustible;
        this.color = builder.color;
    }

    @Override
    public String toString() {
        return "CarroBuilder{" +
                "id='" + id +
                ", modelo='" + modelo +
                ", marca='" + marca +
                ", placa='" + placa +
                ", cilindraje=" + cilindraje +
                ", tipo='" + tipo +
                ", procedencia='" + procedencia +
                ", combustible='" + combustible +
                ", color='" + color +
                '}';
    }

    public static class Builder {
        private String id;
        private String modelo;
        private String marca;
        private String placa;
        private double cilindraje;
        private String tipo;
        private String procedencia;
        private String combustible;
        private String color;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setModelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public Builder setMarca(String marca) {
            this.marca = marca;
            return this;
        }

        public Builder setPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public Builder setCilindraje(double cilindraje) {
            this.cilindraje = cilindraje;
            return this;
        }

        public Builder setTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder setProcedencia(String procedencia) {
            this.procedencia = procedencia;
            return this;
        }

        public Builder setCombustible(String combustible) {
            this.combustible = combustible;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarroBuilder build() {
            return new CarroBuilder(this);
        }
    }
}
