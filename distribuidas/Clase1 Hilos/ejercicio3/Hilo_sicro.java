import java.util.logging.Logger;

public class Hilo_sicro {
    public static void main(String[] args) throws InterruptedException{
        Hilo hilo1 = new Hillo(1);
        Hilo hilo2 = new Hillo(2);
    
        hilo1.start();
        hilo2.start();
        try {
            hilo1.join(); // Esperar a que hilo1 termine
            hilo2.join(); // Esperar a que hilo2 termine
        } 
        catch (InterruptedException exception) {
            Logger.getLogger(null);
        }
    
        
    }
}
