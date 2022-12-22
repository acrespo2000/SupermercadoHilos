package Supermercado;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread{
    Monitor m;
    private int codigo;
    Carrito c;

    public Cliente(Monitor m, int codigo, Carrito c) {
        this.m = m;
        this.codigo = codigo;
        this.c = c;
    }

    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Carrito getC() {
        return c;
    }

    public void setC(Carrito c) {
        this.c = c;
    }

    public boolean Seguir(int i){
        boolean seguir=false;
        if(i==1){
            seguir=true;
        }else{
            seguir=false;
        }
        return seguir;
    }
    
    @Override
    public void run() {
        while(true){
            
            synchronized(m){
                try {
                    m.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    
    

    
    
    
    
}
