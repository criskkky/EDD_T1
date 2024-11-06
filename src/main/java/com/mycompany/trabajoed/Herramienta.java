
package com.mycompany.trabajoed;

public class Herramienta {
    private String nombre;
    private double precio;
    private String tipoHerramienta;
    private String material;
    private String marca;
    private String especificacionesTecnicas;
    private String usoRecomendado;
    private String dimensiones;
    

    public Herramienta() {
    }

    public Herramienta(String nombre, double precio, String tipoHerramienta, String material, String marca, String especificacionesTecnicas, String usoRecomendado, String dimensiones){
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setTipoHerramienta(tipoHerramienta);
        this.setMaterial(material);
        this.setMarca(marca);
        this.setEspecificacionesTecnicas(especificacionesTecnicas);
        this.setUsoRecomendado(usoRecomendado);
        this.setDimensiones(dimensiones);
    }
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoHerramienta() {
        return tipoHerramienta;
    }

    public void setTipoHerramienta(String tipoHerramienta) {
        this.tipoHerramienta = tipoHerramienta;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEspecificacionesTecnicas() {
        return especificacionesTecnicas;
    }

    public void setEspecificacionesTecnicas(String especificacionesTecnicas) {
        this.especificacionesTecnicas = especificacionesTecnicas;
    }

    public String getUsoRecomendado() {
        return usoRecomendado;
    }

    public void setUsoRecomendado(String usoRecomendado) {
        this.usoRecomendado = usoRecomendado;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    @Override
    public String toString() {
        return "Herramienta{" + "nombre: " + nombre + ", precio: " + precio + ", tipoHerramienta: " + tipoHerramienta + ", material: " + material + ", marca: " + marca + ", especificacionesTecnicas: " + especificacionesTecnicas + ", usoRecomendado: " + usoRecomendado + ", dimensiones: " + dimensiones + '}';
    }


    
    
}


