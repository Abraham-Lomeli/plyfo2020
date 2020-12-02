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

