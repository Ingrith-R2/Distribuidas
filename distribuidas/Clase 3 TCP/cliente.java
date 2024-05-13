
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



public class cliente {
    public static void main(String[] args) {


        try {
            
            //Esperar y aceptar conexiones de clientes 
            Socket socket_cliente = new Socket("localhost",6000);
            System.out.println("Cliente conectado");

            while (true) { 
                
            //crear un buffer pARA RECIBIR Y ENVIAR DATOS AL CLIENTE 
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(),true);

            //escribir los datos a enviart 
            //String mensaje_enviar = "Hola soy el Cliente";
            //salida.println(mensaje_enviar);
            
            //enviar mensaje al servidor
            //salida.println(mensaje_enviar);
            //leer los datos de entrada recibidos por el clioente almacenados en entrada 
            String datos_recibidos = entrada.readLine();
            System.out.println("Pregunta "+datos_recibidos);

            //Leer mensaje desde el teclado 
            Scanner scanner = new Scanner(System.in);
            System.out.print("Respuesta: ");
            String mensaje_enviar =scanner.nextLine();

            //enviar mensaje al servidor
            salida.println(mensaje_enviar);

            // Leer la respuesta del servidor
            String respuesta_servidor = entrada.readLine();
            System.out.println("...." + respuesta_servidor);
        
            
            }

        
        }catch(Exception e){

            e.printStackTrace();

        }
    }
    
}
