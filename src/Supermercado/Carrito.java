package Supermercado;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import Supermercado.Producto;
import java.util.Scanner;
import java.util.Vector;

public class Carrito {
    Monitor m;
    Principal p;
    private int codigo;
    Vector<Producto> ContenidoDeCarrito = new Vector(20);
    int productos=0;
    double precioTotal=0.0;

    public Carrito(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Vector<Producto> getContenidoDeCarrito() {
        return ContenidoDeCarrito;
    }

    public void setContenidoDeCarrito(Vector<Producto> ContenidoDeCarrito) {
        this.ContenidoDeCarrito = ContenidoDeCarrito;
    }

    public int getProductos() {
        return productos;
    }

    public void setProductos(int productos) {
        this.productos = productos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public synchronized void añadirCarro (){
        Producto p = new Producto();
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Escribe la id: ");
        int id;
        id = teclado.nextInt();
        p.setCodigo(id);
        
        System.out.println("Escribe el nombre: ");
        String nombre;
        nombre = teclado.nextLine();
        nombre = teclado.nextLine();
        p.setNombre(nombre);
        
        System.out.println("Escribe el precio: ");
        double precio;
        precio = teclado.nextDouble();
        p.setPrecio(precio);
        
        System.out.println("Escribe la cantidad: ");
        int cantidad;
        cantidad = teclado.nextInt();
        p.setCantidad(cantidad);

        ContenidoDeCarrito.add(p);
        productos++;
        precioTotal+=(precio*cantidad);

    }
}
