import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {
        
        //crear objeto socket
        int puerto =50000;
        try{
            DatagramSocket socket = new DatagramSocket();
            //direccion ip del servior 
            InetAddress direccionip_servidor = InetAddress.getByName("172.29.54.202");
             Scanner scanner = new Scanner(System.in); // Para leer desde la entrada estándar
            while(true){
                System.out.print("Tú: ");
                String mensajeSalida = scanner.nextLine();
                if (mensajeSalida.equalsIgnoreCase("exit")) { // Si el usuario escribe "exit", salimos del bucle
                    break;
                }

           //Enviar mensaje al servidor
            byte[] bufferSalida = mensajeSalida.getBytes();
            //Crear objeto datagra para recibir los datos
            DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionip_servidor,puerto);
            socket.send(paqueteSalida);

            //Recibir respuesta del servidor
            byte[] bufferEntrada = new byte[1024];
            //Crear objeto datagra para recibir los datos
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            //recibir paquete 
            socket.receive(paqueteEntrada);

            //Extraer la informaion del paquete entra de forma datagrama 
            String mensajeRecibido = new String(paqueteEntrada.getData(),0,paqueteEntrada.getLength());
            System.out.print("Servidor: " +mensajeRecibido);
            }
            scanner.close();
            socket.close();



        }catch (Exception e){
            //Todo auto-generated catch block
            e.printStackTrace();
        }
    }
    
}