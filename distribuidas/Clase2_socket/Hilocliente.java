import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Hilocliente extends Thread{

    private DatagramSocket socket;
    private DatagramPacket paqueteEntrada;
    
    public Hilocliente(DatagramSocket socket, DatagramPacket paqueteEntrada) {
        this.socket = socket;
        this.paqueteEntrada = paqueteEntrada;
    }

    public void run() {
        // Extraer información del paquete
        String mensajeRecibido = new String(paqueteEntrada.getData());
        System.out.println("Mensaje recibido: " + mensajeRecibido);
        
        // Obtener dirección del cliente y puerto
        InetAddress direccionIp_cliente = paqueteEntrada.getAddress();
        int puerto_cliente = paqueteEntrada.getPort();

        // Solicitar mensaje al usuario
        System.out.print("Escribe tu mensaje de respuesta: ");
        Scanner scanner = new Scanner(System.in);
        String mensajeSalida = scanner.nextLine();

        // Crear arreglo de bytes para enviar los datos del cliente y enviar un mensaje
        byte[] bufferSalida = mensajeSalida.getBytes();

        // Crear objeto DatagramPacket para enviar los datos
        DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIp_cliente, puerto_cliente);
        
        try {
            // Enviar el paquete de salida
            socket.send(paqueteSalida);
            System.out.println("Mensaje enviado al cliente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}