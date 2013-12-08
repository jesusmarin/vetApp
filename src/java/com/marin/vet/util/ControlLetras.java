package com.marin.vet.util;

import java.io.Serializable;

/**
 *
 * @author JesusMarin
 */
public class ControlLetras implements Serializable {

    public ControlLetras() {
    }

    public String pasaMayuscula(String s) {
        s = s.toUpperCase();
        s = s.replaceAll(" ", "");
        return s;
    }

    public String quitaEspaciosPuntosComas(String s) {
        s = s.replaceAll(" ", "");
        s = s.replace(".", "");
        s = s.replaceAll(",", "");
        s = s.replaceAll(";", "");
        s = s.replaceAll(":", "");
        s = s.replaceAll("-", "");
        s = s.replaceAll("_", "");
        s = s.replace("{", "");
        s = s.replaceAll("}", "");
        return s;
    }

    public String pasaPalabrasMayuscula(String s) {
        s = s.toUpperCase();
        return s;
    }
}
