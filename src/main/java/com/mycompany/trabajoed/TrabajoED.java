
package com.mycompany.trabajoed;

import java.util.ArrayList;


public class TrabajoED {

    public static void main(String[] args) {
        
        ArrayList<Herramienta> listaHerramientas = null;
        ListaHerramienta lista1 = new ListaHerramienta(listaHerramientas);
        
        Herramienta h1 = new Herramienta("Serrucho",8000,"manual","Metal","Starley","no tiene","Mayores de 25 años","50x12cm");
        Herramienta h2 = new Herramienta("Alicate",5400,"Manual","Metal","INGCO","No tiene","Mayores de 18 años","30x10cm");
        Herramienta h3 = new Herramienta("Destornillador",7500,"electrico","Metal","Hychika","No tiene","Mayores de 18 años","50x20cm");
        Herramienta h4 = new Herramienta("Martillo",4700,"Manual","Metal","Starley","No tiene","Mayores de 15 años","70x20cm");
        
        lista1.agregarProducto(h1);
        lista1.agregarProducto(h2);
        lista1.agregarProducto(h3);
        lista1.agregarProducto(h4);
        
        System.out.println("Lista antes de eliminar");
        System.out.println(lista1.toString());
        
        
        lista1.eliminarProducto("Serrucho");
        
        System.out.println("\n");
        System.out.println("Lista despues de eliminar ");
        System.out.println(lista1.toString());
        
    }
}
