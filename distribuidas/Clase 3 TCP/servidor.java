
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class servidor {
    public static void main(String[] args) {

        try{
             //indicar el numero del puerto
            ServerSocket socket_servidor = new ServerSocket(6000);
            System.out.println("Esperando Conexion.......");

            while (true) {
                 //Esperar y aceptar conexiones de clientes
                Socket socket_cliente = socket_servidor.accept();

                //Crear un hilo para cada cliente
                HiloC hilos = new HiloC(socket_cliente);
                hilos.start();
            }

        }catch(IOException e){
            e.printStackTrace();

        }
    }
}
