package Supermercado;

import java.util.Scanner;
import java.util.Vector;


/*Los clientes empiezan y van cogiendo cosas de estanteria y meten en carrito, luego llevan el carrito a cajero*/

public class Principal {

    static Vector <Cajero> cajeros= new Vector();
    static Vector <Cliente> clientes = new Vector();
    static Vector <Carrito> carritos = new Vector();
    static Vector <Producto> productos = new Vector();
    
    public static void main(String[] args) throws InterruptedException {
        Monitor m=new Monitor();
        Carrito ca=new Carrito(0);
        Cliente c = new Cliente(m,0, ca);
        Cajero cj= new Cajero(m,ca,0);
        clientes.add(c);
        carritos.add(ca);
        cajeros.add(cj);
        
        
        int opcion;
        
        do {
            do {
                System.out.println("=====AGENDA DE CONTACTOS=====");
                System.out.println("Elija una opcion: ");
                System.out.println("1) Añadir producto a carrito");
                System.out.println("2) Pagar");
                System.out.println("3) Salir");
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();
                System.out.println("");
                System.out.println("");
            } while (opcion < 1 || opcion > 12);

            switch (opcion) {
                case 1: //HECHO
                    System.out.println("Añadir producto a carrito");
                    System.out.println("");
                    ca.añadirCarro();
                    
                    break;
                case 2:
                    //clientes.get(0).join();
                    cajeros.get(0).start();
                    break;
                case 3:
                    System.out.println("Cerrando programa");
            }
        } while(opcion==1);
        
        if(opcion==2){
            cajeros.get(0).join();

            for (int i = 0; i < ca.ContenidoDeCarrito.size(); i++) {
                System.out.println(ca.ContenidoDeCarrito.elementAt(i).getNombre() + " x " + ca.ContenidoDeCarrito.elementAt(i).getCantidad());
            }
            System.out.println("");
            System.out.println(cajeros.get(0).getPrecio() + " euros");
        }else{
            System.out.println("Fin");
        }
    }
}
