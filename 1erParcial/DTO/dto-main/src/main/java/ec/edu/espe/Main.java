package ec.edu.espe;

import ec.edu.espe.builder.Empleado;
import ec.edu.espe.builder.EmpleadoBuilder;
import ec.edu.espe.builder.CarroBuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        /* 
        Empleado empleado1=new Empleado();
        empleado1.setNombre("Brayan");
        empleado1.setApellido("Lopez");

        Empleado empleado2=new Empleado("Juanito","perez");

        System.out.println("empleado1:"+empleado1.toString());
        System.out.println("empleado2:"+empleado2.toString());

        EmpleadoBuilder empleado3 = new EmpleadoBuilder.Builder()
                .setNombre("Anita")
                .setApellido("Lopez")
                .build();
        System.out.println("empleado3:"+empleado3.toString());

        EmpleadoBuilder empleado4 = new EmpleadoBuilder.Builder()
                .setNombre("Liliana")
                .build();
        System.out.println("empleado4:"+empleado4.toString());

        EmpleadoBuilder empleado5 = new EmpleadoBuilder.Builder()
                .setNombre("Liliana")
                .setApellido("Chora")
                .setGenero("F")
                .setPuesto("Analista de Ti")
                .setSalario(2000)
                .build();
        System.out.println("empleado5:"+empleado5.toString());


        sE TIENE QUE EVR EL dto
        Patron de diseño, dto, patrones arquitectonicos

        Patrones de diseño y patron arqui
        Para api rest
*/

        CarroBuilder carro1 = new CarroBuilder.Builder()
        .setId("001")
        .setModelo("Corolla")
        .setMarca("Toyota")
        .setPlaca("ABC-1234")
        .setCilindraje(1.8)
        .setTipo("Sedán")
        .build();

        System.out.println("CarroBuilder 1: " + carro1);

        CarroBuilder carro2 = new CarroBuilder.Builder()
        .setId("002")
        .setModelo("Civic")
        .setMarca("Honda")
        .setPlaca("PJI-5678")
        .setCilindraje(2.0)
        .setTipo("Sedán")
        .setProcedencia("Japón")
        .setCombustible("Gasolina")
        .setColor("Rojo")
        .build();

        System.out.println("CarroBuilder 2: " + carro2);

        CarroBuilder carro3 = new CarroBuilder.Builder()
        .setId("003")
        .setModelo("Duster")
        .setMarca("Renault")
        .build();

        System.out.println("CarroBuilder 3: " + carro3);


        CarroBuilder carro4 = new CarroBuilder.Builder()
        .setId("004")
        .setModelo("Duster")
        .setMarca("Renault")
        .build();

        System.out.println("CarroBuilder 4: " + carro4.toString());


    }
}