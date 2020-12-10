/*
 * SPDX-License-Identifier: MIT
 */

package edu.tecmm.zapopan.promedio.hilos;

public class Promedio {

    private byte nProcesadores;
    private LeerArchivo la;

    public void setNProcesadores(byte n) {
        nProcesadores = n;
    }

    public byte getNProcesadores() {
        return nProcesadores;
    }

    public boolean leerArchivo(String filename) {
        la = new LeerArchivo(filename);
        return la.getDatos().size() != 0;
    }


    public float calcularHilos(){
	Hilo h1 = new Hilo(la);
	h1.start();
	try{
	h1.join();
	}
	catch(Exception e){
	e.printStackTrace();
}
	return h1.getSuma();
    }

    public float calcularPromedio(){
        float aux=0;
        for(int i=0; i<la.getDatos().size();i++){
            aux= aux + la.getDatos().get(i);
        }
        aux = aux/la.getDatos().size();
        return aux;
    }


    public static void main(String []args) {

        if (args.length == 0) {
            System.err.println("Debes de especificar un archivo de entrada");
            System.exit(1);
        }

        Promedio promedio = new Promedio();

        promedio.setNProcesadores( (byte) Runtime.getRuntime().availableProcessors() );

        System.out.println("Tienes "+ promedio.getNProcesadores() + " procesadores lógicos en la JVM");

        if ( ! promedio.leerArchivo(args[0]) ) {
            System.err.println("Error en el archivo o no hay datos");
            System.exit(2);
        }
	System.out.println("El promedio es: "+promedio.calcularPromedio());
	System.out.println("El promedio del hilo es: "+promedio.calcularHilos());


        System.out.println("El promedio es: "+promedio.calcularPromedio());

    }
}

/*
 * Editor modelines  -  https://www.wireshark.org/tools/modelines.html
 *
 * Local variables:
 * c-basic-offset: 4
 * tab-width: 4
 * indent-tabs-mode: nil
 * End:
 *
 * vi: set shiftwidth=4 tabstop=4 expandtab:
 * :indentSize=4:tabSize=4:noTabs=true:
 */

