/*
 * SPDX-License-Identifier: MIT
 */

package edu.tecmm.zapopan.promedio.hilos;

public class Promedio {

    private byte nProcesadores;

    public void setNProcesadores(byte n) {
        nProcesadores = n;
    }

    public void getNProcesadores() {
        return n;
    }

    public static void main(String []args) {

        promedio = new Promedio();

        promedio.setNProcesadores( (byte) Runtime.getRuntime().availableProcessors() );

        System.out.println("Tienes "+ promedio.getNProcesadores() + " procesadores lógicos en la JVM");
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

