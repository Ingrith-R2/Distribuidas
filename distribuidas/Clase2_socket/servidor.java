import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class servidor {
    public static void main(String[] args) {
        //crear objeto socket
        int puerto =50000;
        try{
            DatagramSocket socket = new DatagramSocket(puerto);
            System.err.println("Servidor esperando conexiones ......");
            while(true){

            //crear arreglo de bytes para recibir los datos del cliente 
            byte[] bufferEntrada = new byte[1024];

            //Crear objeto datagra para recibir los datos
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            //recibir paquete 
            socket.receive(paqueteEntrada);
            // Iniciar un hilo para cada cliente 
            Thread hiloCliente =new Hilocliente(socket, paqueteEntrada);
            hiloCliente.start();}

            
        }catch (Exception e){
            //Todo auto-generated catch block
            e.printStackTrace();
        }
    }
}