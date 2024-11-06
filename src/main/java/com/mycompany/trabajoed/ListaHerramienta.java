
package com.mycompany.trabajoed;

import java.util.ArrayList;


public class ListaHerramienta {
    
    private ArrayList<Herramienta> listaHerramientas;

    public ListaHerramienta() {
    }

    public ListaHerramienta(ArrayList<Herramienta> listaHerramientas) {
        this.setListaHerramientas(listaHerramientas);
        this.listaHerramientas = new ArrayList<>();
    }
    
    
    public ArrayList<Herramienta> getListaHerramientas() {
        return listaHerramientas;
    }

    public void setListaHerramientas(ArrayList<Herramienta> listaHerramientas) {
        this.listaHerramientas = listaHerramientas;
    }
    
    public void agregarProducto(Herramienta herramienta){
        listaHerramientas.add(herramienta);
    }
    
    public void eliminarProducto(String nombre){
        listaHerramientas.removeIf(herramienta -> herramienta.getNombre().equals(nombre));
    }

    @Override
    public String toString() {
        return "ListaHerramienta{" + "listaHerramientas: " + listaHerramientas + '}';
    }

    
    
}
