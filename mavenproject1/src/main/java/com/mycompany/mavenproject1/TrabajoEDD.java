package com.mycompany.mavenproject1;

import java.util.Scanner;

class Herramienta {
    private static int contadorId = 1; // Contador estático para generar IDs únicos
    private int id; // ID único de la herramienta
    private String nombre;
    private double precio;
    private String tipo;
    private String material;
    private String marca;
    private String especificacionesTecnicas;
    private String usoRecomendado;
    private String dimensiones;

    public Herramienta(String nombre, double precio, String tipo, String material, String marca,
            String especificacionesTecnicas, String usoRecomendado, String dimensiones) {
        this.id = contadorId++; // Generar ID único y aumentar el contador
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.material = material;
        this.marca = marca;
        this.especificacionesTecnicas = especificacionesTecnicas;
        this.usoRecomendado = usoRecomendado;
        this.dimensiones = dimensiones;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getTipo() { return tipo; }
    public String getMaterial() { return material; }
    public String getMarca() { return marca; }
    public String getEspecificacionesTecnicas() { return especificacionesTecnicas; }
    public String getUsoRecomendado() { return usoRecomendado; }
    public String getDimensiones() { return dimensiones; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setMaterial(String material) { this.material = material; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setEspecificacionesTecnicas(String especificacionesTecnicas) { this.especificacionesTecnicas = especificacionesTecnicas; }
    public void setUsoRecomendado(String usoRecomendado) { this.usoRecomendado = usoRecomendado; }
    public void setDimensiones(String dimensiones) { this.dimensiones = dimensiones; }

    // - Override indica que se está sobreescribiendo un método de la clase padre
    // - En este caso nos permite imprimir los datos de la herramienta de forma más legible
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: $" + precio + ", Tipo: " + tipo + ", Material: " + material +
                ", Marca: " + marca + ", Especificaciones: " + especificacionesTecnicas +
                ", Uso recomendado: " + usoRecomendado + ", Dimensiones: " + dimensiones;
    }
}

class Nodo {
    private Herramienta herramienta;
    private Nodo siguiente;

    public Nodo(Herramienta herramienta) {
        this.herramienta = herramienta;
        this.siguiente = null;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
}

public class TrabajoEDD {
    private static Nodo cabeza = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        precargarProductos(); // Comentarlo para no precargar productos

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    eliminarProducto();
                    break;
                case 3:
                    modificarProducto();
                    break;
                case 4:
                    consultarUsoRecomendado();
                    break;
                case 5:
                    verificarMaterial();
                    break;
                case 6:
                    registrarTipo();
                    break;
                case 7:
                    listarPorMarca();
                    break;
                case 8:
                    generarHistorial();
                    break;
                case 9:
                    salir = true;
                    System.out.println("Gracias por usar el Sistema de Gestión de Herramientas. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Sistema de Gestión de Herramientas ---");
        System.out.println("1. Agregar producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Modificar producto");
        System.out.println("4. Consultar uso recomendado");
        System.out.println("5. Verificar material");
        System.out.println("6. Registrar tipo de herramienta");
        System.out.println("7. Listar por marca");
        System.out.println("8. Generar historial de herramientas");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void precargarProductos() {
        Herramienta h1 = new Herramienta("Taladro", 120000, "eléctrica", "metal", "Bosch", "600W, velocidad variable",
                "Construcción", "30x20x10 cm");
        Herramienta h2 = new Herramienta("Martillo", 25000, "manual", "acero", "Stanley", "Cabeza de acero forjado",
                "Carpintería", "15x5x3 cm");
        Herramienta h3 = new Herramienta("Sierra", 75000, "eléctrica", "plástico", "Makita", "700W, hoja de 20 cm",
                "Jardinería", "50x30x20 cm");

        Nodo nodo1 = new Nodo(h1);
        Nodo nodo2 = new Nodo(h2);
        Nodo nodo3 = new Nodo(h3);

        cabeza = nodo1;
        nodo1.setSiguiente(nodo2);
        nodo2.setSiguiente(nodo3);

        System.out.println("Datos pre-cargados en la lista.");
    }

    private static void agregarProducto() {
        System.out.println("\n--- Agregar Producto ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Tipo (eléctrica/manual): ");
        String tipo = scanner.nextLine();
        System.out.print("Material: ");
        String material = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Especificaciones técnicas: ");
        String especificaciones = scanner.nextLine();
        System.out.print("Uso recomendado: ");
        String usoRecomendado = scanner.nextLine();
        System.out.print("Dimensiones: ");
        String dimensiones = scanner.nextLine();

        Herramienta herramienta = new Herramienta(nombre, precio, tipo, material, marca, especificaciones,
                usoRecomendado, dimensiones);
        Nodo nuevoNodo = new Nodo(herramienta);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
        }

        System.out.println("Producto agregado con éxito. ID generado: " + herramienta.getId());
    }

    private static void eliminarProducto() {
        System.out.println("\n--- Eliminar Producto ---");
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (cabeza == null) {
            System.out.println("No hay productos en la lista.");
            return;
        }

        if (cabeza.getHerramienta().getId() == id) {
            cabeza = cabeza.getSiguiente();
            System.out.println("Producto eliminado con éxito.");
            return;
        }

        Nodo actual = cabeza;
        while (actual.getSiguiente() != null && actual.getSiguiente().getHerramienta().getId() != id) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            System.out.println("Producto eliminado con éxito.");
        } else {
            System.out.println("Producto no encontrado, compruebe el ID ingresado.");
        }
    }

    private static void modificarProducto() {
        System.out.println("\n--- Modificar Producto ---");
        System.out.print("Ingrese el ID del producto a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Nodo temp = cabeza;

        while (temp != null) {
            if (temp.getHerramienta().getId() == id) {
                Herramienta h = temp.getHerramienta();
                System.out.println("Ingrese los nuevos datos del producto (deje en blanco para no modificar):");

                System.out.print("Nuevo nombre (" + h.getNombre() + "): ");
                String nombre = scanner.nextLine();
                if (!nombre.isEmpty()) {
                    h.setNombre(nombre);
                }

                System.out.print("Nuevo precio (" + h.getPrecio() + "): ");
                String precio = scanner.nextLine();
                if (!precio.isEmpty()) {
                    h.setPrecio(Double.parseDouble(precio));
                }

                System.out.print("Nuevo tipo (" + h.getTipo() + "): ");
                String tipo = scanner.nextLine();
                if (!tipo.isEmpty()) {
                    h.setTipo(tipo);
                }

                System.out.print("Nuevo material (" + h.getMaterial() + "): ");
                String material = scanner.nextLine();
                if (!material.isEmpty()) {
                    h.setMaterial(material);
                }

                System.out.print("Nueva marca (" + h.getMarca() + "): ");
                String marca = scanner.nextLine();
                if (!marca.isEmpty()) {
                    h.setMarca(marca);
                }

                System.out.print("Nuevas especificaciones técnicas (" + h.getEspecificacionesTecnicas() + "): ");
                String especificaciones = scanner.nextLine();
                if (!especificaciones.isEmpty()) {
                    h.setEspecificacionesTecnicas(especificaciones);
                }

                System.out.print("Nuevo uso recomendado (" + h.getUsoRecomendado() + "): ");
                String usoRecomendado = scanner.nextLine();
                if (!usoRecomendado.isEmpty()) {
                    h.setUsoRecomendado(usoRecomendado);
                }

                System.out.print("Nuevas dimensiones (" + h.getDimensiones() + "): ");
                String dimensiones = scanner.nextLine();
                if (!dimensiones.isEmpty()) {
                    h.setDimensiones(dimensiones);
                }

                System.out.println("Producto modificado con éxito.");
                return;
            }
            temp = temp.getSiguiente();
        }

        System.out.println("Producto no encontrado.");
    }

    private static void consultarUsoRecomendado() {
        System.out.println("\n--- Consultar Uso Recomendado ---");
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        Nodo temp = cabeza;

        while (temp != null) {
            if (temp.getHerramienta().getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Uso recomendado: " + temp.getHerramienta().getUsoRecomendado());
                return;
            }
            temp = temp.getSiguiente();
        }

        System.out.println("Producto no encontrado.");
    }

    private static void verificarMaterial() {
        System.out.println("\n--- Verificar Material ---");
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        Nodo temp = cabeza;

        while (temp != null) {
            if (temp.getHerramienta().getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Material: " + temp.getHerramienta().getMaterial());
                return;
            }
            temp = temp.getSiguiente();
        }

        System.out.println("Producto no encontrado.");
    }

    private static void registrarTipo() {
        System.out.println("\n--- Registrar Tipo de Herramienta ---");
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        Nodo temp = cabeza;

        while (temp != null) {
            if (temp.getHerramienta().getNombre().equalsIgnoreCase(nombre)) {
                System.out.print("Nuevo tipo (eléctrica/manual): ");
                String tipo = scanner.nextLine();
                if (tipo.equalsIgnoreCase("eléctrica") || tipo.equalsIgnoreCase("manual")) {
                    temp.getHerramienta().setTipo(tipo);
                    System.out.println("Tipo registrado con éxito.");
                } else {
                    System.out.println("Tipo no válido. Debe ser 'eléctrica' o 'manual'.");
                }
                return;
            }
            temp = temp.getSiguiente();
        }

        System.out.println("Producto no encontrado.");
    }

    private static void listarPorMarca() {
        System.out.println("\n--- Listar por Marca ---");
        System.out.print("Ingrese la marca: ");
        String marca = scanner.nextLine();
        Nodo temp = cabeza;
        boolean encontrado = false;

        while (temp != null) {
            if (temp.getHerramienta().getMarca().equalsIgnoreCase(marca)) {
                System.out.println(temp.getHerramienta());
                encontrado = true;
            }
            temp = temp.getSiguiente();
        }

        if (!encontrado) {
            System.out.println("No se encontraron productos de la marca " + marca);
        }
    }

    private static void generarHistorial() {
        // Validar que haya productos en la lista
        if (cabeza == null) {
            System.out.println("No hay productos en la lista.");
            return;
        }

        System.out.println("\n--- Generar Historial de Herramientas ---");
        Nodo temp = cabeza;

        while (temp != null) {
            System.out.println(temp.getHerramienta());
            temp = temp.getSiguiente();
        }
    }

    // Método para calcular el tamaño de un nodo
    private static int calcularTamanoNodo() {

        if (cabeza == null) {
            System.out.println("La lista está vacía, no se puede calcular el tamaño del nodo.");
            return 0;
        }

        int tamanoOverHead = 12; // (APROX) Espacio adicional para almacenar un objeto en memoria.
        int tamanoDato = calcularTamanoDato();
        int tamanoReferencia = 8; // Tamaño de una referencia en bytes (OS de 64 bits)

        return tamanoOverHead + tamanoDato + tamanoReferencia;
    }

    // Método para calcular el tamaño de los datos de una herramienta
    private static int calcularTamanoDato() {
        // Validar que haya herramientas en la lista
        if (cabeza == null || cabeza.getHerramienta() == null) {
            System.out.println("No hay herramientas disponibles para calcular el tamaño de los datos.");
            return 0;
        }

        int tamanoInt = 4; // Tamaño de un int
        int tamanoPrecio = 8; // Tamaño de un double
        int tamanoCadenas = 0; // Acumulador para las cadenas
        int tamanoReferencia = 8; // Tamaño de una referencia en bytes (OS de 64 bits)
        int tamanoOverhead = 12; // Tamaño del overhead de un objeto en bytes

        Herramienta herramienta = cabeza.getHerramienta();

        // Colocar los atributos de tipo String en un array
        String[] atributos = {
                herramienta.getNombre(),
                herramienta.getTipo(),
                herramienta.getMaterial(),
                herramienta.getMarca(),
                herramienta.getEspecificacionesTecnicas(),
                herramienta.getUsoRecomendado(),
                herramienta.getDimensiones()
        };

        // Calcular tamaño de cada String
        for (String atributo : atributos) {
            if (atributo != null) {
                int longitud = atributo.length(); // Longitud del String con el largo de caracteres que contiene el String
                // Tamaño total de este String (Overhead + Referencia + Arreglo de caracteres)
                tamanoCadenas += tamanoOverhead + tamanoReferencia + (longitud * Character.BYTES);
            }
        }

        return tamanoCadenas + tamanoPrecio + tamanoInt;
    }

    private static int calcularTamanoLista() {
        // Validar que la lista no esté vacía
        if (cabeza == null) {
            System.out.println("La lista está vacía, no se puede calcular el tamaño de la lista.");
            return 0;
        }

        int tamanoOverhead = 12; // Tamaño del overhead de un objeto en bytes
        int tamanoReferencia = 8; // Tamaño de una referencia en bytes (OS de 64 bits)
        int tamanoNodo = calcularTamanoNodo();
        int cantidadNodos = 0;

        Nodo temp = cabeza;
        while (temp != null) {
            cantidadNodos++;
            temp = temp.getSiguiente();
        }

        return tamanoOverhead + tamanoReferencia + (tamanoNodo * cantidadNodos);
    }
}