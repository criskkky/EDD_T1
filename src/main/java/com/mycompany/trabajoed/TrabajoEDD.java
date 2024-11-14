
package com.mycompany.trabajoed;

import java.util.Scanner;

class Herramienta {
    // Atributos - Características de una herramienta
    private String nombre;
    private double precio;
    private String tipo; // "eléctrica" o "manual"
    private String material;
    private String marca;
    private String especificacionesTecnicas;
    private String usoRecomendado;
    private String dimensiones;

    // Constructor - Inicializar los atributos
    public Herramienta(String nombre, double precio, String tipo, String material, String marca,
                       String especificacionesTecnicas, String usoRecomendado, String dimensiones) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.material = material;
        this.marca = marca;
        this.especificacionesTecnicas = especificacionesTecnicas;
        this.usoRecomendado = usoRecomendado;
        this.dimensiones = dimensiones;
    }

    // Getters - Obtener valores de los atributos
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getTipo() { return tipo; }
    public String getMaterial() { return material; }
    public String getMarca() { return marca; }
    public String getEspecificacionesTecnicas() { return especificacionesTecnicas; }
    public String getUsoRecomendado() { return usoRecomendado; }
    public String getDimensiones() { return dimensiones; }

    // Setters - Establecer valores de los atributos
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setMaterial(String material) { this.material = material; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setEspecificacionesTecnicas(String especificacionesTecnicas) { this.especificacionesTecnicas = especificacionesTecnicas; }
    public void setUsoRecomendado(String usoRecomendado) { this.usoRecomendado = usoRecomendado; }
    public void setDimensiones(String dimensiones) { this.dimensiones = dimensiones; }

    @Override // Método para mostrar los datos de una herramienta, Override indica que se está sobreescribiendo un método de la clase Object
    public String toString() {
        return "Nombre: " + nombre + ", Precio: $" + precio + ", Tipo: " + tipo + ", Material: " + material +
               ", Marca: " + marca + ", Especificaciones: " + especificacionesTecnicas +
               ", Uso recomendado: " + usoRecomendado + ", Dimensiones: " + dimensiones;
    }
}

// Clase Nodo para almacenar las herramientas en una lista enlazada
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

// Clase principal
public class TrabajoEDD {
    private static Nodo cabeza = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Método para precargar productos, comentar si no se desea precargar.
        precargarProductos();

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

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
                    System.out.println("Tamaño promedio de un nodo: " + calcularTamanoNodo() + " bytes");
                    System.out.println("Tamaño promedio de los datos de una herramienta: " + calcularTamanoDato() + " bytes");
                    break;
                case 10:
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
        System.out.println("8. Generar historial");
        System.out.println("9. Calcular tamaños");
        System.out.println("10. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void precargarProductos() {
        // Crear algunas herramientas
        Herramienta h1 = new Herramienta("Taladro", 120.50, "eléctrica", "metal", "Bosch", "600W, velocidad variable", "Construcción", "30x20x10 cm");
        Herramienta h2 = new Herramienta("Martillo", 25.00, "manual", "acero", "Stanley", "Cabeza de acero forjado", "Carpintería", "15x5x3 cm");
        Herramienta h3 = new Herramienta("Sierra", 75.99, "eléctrica", "plástico", "Makita", "700W, hoja de 20 cm", "Jardinería", "50x30x20 cm");
    
        // Crear nodos y agregar a la lista
        Nodo nodo1 = new Nodo(h1);
        Nodo nodo2 = new Nodo(h2);
        Nodo nodo3 = new Nodo(h3);
    
        // Establecer la cabeza de la lista
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
        scanner.nextLine(); // Consumir el salto de línea
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

        Herramienta herramienta = new Herramienta(nombre, precio, tipo, material, marca, especificaciones, usoRecomendado, dimensiones);
        Nodo nuevoNodo = new Nodo(herramienta);

        if (cabeza == null) { // Si la lista está vacía
            cabeza = nuevoNodo; // El nuevo nodo se convierte en la cabeza
        } else {
            Nodo temp = cabeza; // Recorrer la lista hasta el último nodo
            while (temp.getSiguiente() != null) { // Mientras no sea el último nodo
                temp = temp.getSiguiente(); // Avanzar al siguiente nodo
            }
            temp.setSiguiente(nuevoNodo); // Agregar el nuevo nodo al final de la lista
        }

        System.out.println("Producto agregado con éxito.");
    }

    private static void eliminarProducto() {
        System.out.println("\n--- Eliminar Producto ---");
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();

        if (cabeza == null) {
            System.out.println("No hay productos en la lista.");
            return;
        }

        if (cabeza.getHerramienta().getNombre().equalsIgnoreCase(nombre)) {
            cabeza = cabeza.getSiguiente();
            System.out.println("Producto eliminado con éxito.");
            return;
        }

        Nodo actual = cabeza;
        while (actual.getSiguiente() != null && !actual.getSiguiente().getHerramienta().getNombre().equalsIgnoreCase(nombre)) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            System.out.println("Producto eliminado con éxito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void modificarProducto() {
        System.out.println("\n--- Modificar Producto ---");
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombre = scanner.nextLine();
        Nodo temp = cabeza;

        while (temp != null) {
            if (temp.getHerramienta().getNombre().equalsIgnoreCase(nombre)) {
                Herramienta h = temp.getHerramienta();
                System.out.println("Ingrese los nuevos datos (deje en blanco para mantener el valor actual):");

                System.out.print("Nuevo precio (" + h.getPrecio() + "): ");
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    h.setPrecio(Double.parseDouble(input));
                }

                System.out.print("Nuevo tipo (" + h.getTipo() + "): ");
                input = scanner.nextLine();
                if (!input.isEmpty()) {
                    h.setTipo(input);
                }

                System.out.print("Nuevo material (" + h.getMaterial() + "): ");
                input = scanner.nextLine();
                if (!input.isEmpty()) {
                    h.setMaterial(input);
                }

                System.out.print("Nueva marca (" + h.getMarca() + "): ");
                input = scanner.nextLine();
                if (!input.isEmpty()) {
                    h.setMarca(input);
                }

                System.out.print("Nuevas especificaciones técnicas (" + h.getEspecificacionesTecnicas() + "): ");
                input = scanner.nextLine();
                if (!input.isEmpty()) {
                    h.setEspecificacionesTecnicas(input);
                }

                System.out.print("Nuevo uso recomendado (" + h.getUsoRecomendado() + "): ");
                input = scanner.nextLine();
                if (!input.isEmpty()) {
                    h.setUsoRecomendado(input);
                }

                System.out.print("Nuevas dimensiones (" + h.getDimensiones() + "): ");
                input = scanner.nextLine();
                if (!input.isEmpty()) {
                    h.setDimensiones(input);
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
                temp.getHerramienta().setTipo(tipo);
                System.out.println("Tipo registrado con éxito.");
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
        System.out.println("\n--- Generar Historial ---");
        Nodo temp = cabeza;

        while (temp != null) {
            System.out.println(temp.getHerramienta());
            temp = temp.getSiguiente();
        }
    }

    // Métodos adicionales para calcular tamaños
    private static int calcularTamanoNodo() {
        int tamanoOverHead = 12; // (APROX) Espacio adicional para almacenar un objeto en memoria.
        int tamanoDato = calcularTamanoDato();
        int tamanoReferencia = 4; // Tamaño de una referencia a un objeto en memoria. (4 bytes en sistemas de 32 bits)

        return tamanoOverHead + tamanoDato + tamanoReferencia;
    }

    private static int calcularTamanoDato() {
        // Tamaño estimado de los atributos de tipo String (en caracteres)
        int tamanoNombre = 0;
        if (cabeza != null && cabeza.getHerramienta().getNombre() != null) {
            tamanoNombre = cabeza.getHerramienta().getNombre().length() * Character.BYTES; // Tamaño en bytes de la cadena 'nombre'
        }
    
        int tamanoTipo = 0;
        if (cabeza != null && cabeza.getHerramienta().getTipo() != null) {
            tamanoTipo = cabeza.getHerramienta().getTipo().length() * Character.BYTES;
        }
    
        int tamanoMaterial = 0;
        if (cabeza != null && cabeza.getHerramienta().getMaterial() != null) {
            tamanoMaterial = cabeza.getHerramienta().getMaterial().length() * Character.BYTES;
        }
    
        int tamanoMarca = 0;
        if (cabeza != null && cabeza.getHerramienta().getMarca() != null) {
            tamanoMarca = cabeza.getHerramienta().getMarca().length() * Character.BYTES;
        }
    
        int tamanoEspecificacionesTecnicas = 0;
        if (cabeza != null && cabeza.getHerramienta().getEspecificacionesTecnicas() != null) {
            tamanoEspecificacionesTecnicas = cabeza.getHerramienta().getEspecificacionesTecnicas().length() * Character.BYTES;
        }
    
        int tamanoUsoRecomendado = 0;
        if (cabeza != null && cabeza.getHerramienta().getUsoRecomendado() != null) {
            tamanoUsoRecomendado = cabeza.getHerramienta().getUsoRecomendado().length() * Character.BYTES;
        }
    
        int tamanoDimensiones = 0;
        if (cabeza != null && cabeza.getHerramienta().getDimensiones() != null) {
            tamanoDimensiones = cabeza.getHerramienta().getDimensiones().length() * Character.BYTES;
        }
    
        int tamanoPrecio = 8; // El tamaño de un tipo 'double' es 8 bytes
    
        // Sumar todos los tamaños
        return tamanoNombre + tamanoTipo + tamanoMaterial + tamanoMarca +
               tamanoEspecificacionesTecnicas + tamanoUsoRecomendado +
               tamanoDimensiones + tamanoPrecio;
    }
}