/*
 * SPDX-License-Identifier: MIT
 */

package edu.tecmm.zapopan.promedio.hilos;

public class Hilo extends Thread {

    private float suma;
    private LeerArchivo la;

    public Hilo(LeerArchivo la){
    	this.la = la;
    }

    public void setSuma(float n) {
        suma = n;
    }

    public float getSuma() {
        return suma;
    }

    @Override
    public void run() {
        float aux=0;

        for(int i=0; i<la.getDatos().size();i++){
            aux= aux + la.getDatos().get(i);
        }

        suma=aux/la.getDatos().size();
        System.out.println("Hilo1");
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
