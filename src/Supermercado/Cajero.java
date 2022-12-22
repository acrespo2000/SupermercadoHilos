package Supermercado;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Cajero extends Thread{
    Monitor m;
    Cliente c;
    Carrito ca;
    Principal p;
    private int codigo;
    double precio = 0.0;

    public Cajero(Monitor m, Carrito ca, int codigo) {
        this.m = m;
        this.ca = ca;
        this.codigo = codigo;
    }


    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Principal getP() {
        return p;
    }

    public void setP(Principal p) {
        this.p = p;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public void run() {
        
        synchronized (m) {
            m.notify();
        }
        int i=0;
        do{
            precio=ca.precioTotal;
            i++;
            //precioPagar+=precio;
            try {
                sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(i<ca.productos);
    }
    
    
}
