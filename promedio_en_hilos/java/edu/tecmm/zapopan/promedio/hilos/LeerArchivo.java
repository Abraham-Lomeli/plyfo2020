/*
 * Copyright (C) <year> <name of author>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package edu.tecmm.zapopan.promedio.hilos;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.util.ArrayList;

public class LeerArchivo {

    private File           archivo = null;
    private FileReader     fr      = null;
    private BufferedReader br      = null;
    private ArrayList<int> datos   = null;

    public  LeerArchivo() {
        archivo = null;
        fr      = null;
        br      = null;
        datos   = null;
    }

    public  LeerArchivo(String nombre) {

        String linea;

        try {
            archivo = new File(nombre);
            fr = new FileReader(archivo);
            br = new BufferredReader(fr);

            datos = new ArrayList<int>;

            while( (linea = br.readLine()) != null)  {
                datos.add( Integer.parseInt(linea) );
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if ( null != fr) {
                    fr.close();
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
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

