
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;


public class HiloC extends Thread{

    Socket socket_cliente;
    HashMap<String, String> preguntas;

    public HiloC(Socket socket_cliente) {
        this.socket_cliente = socket_cliente;
        this.preguntas = new HashMap<>();
        preguntas.put("Cual es la capital de Ecuador?", "Quito");
        preguntas.put("Cual es el animal terrestre mas rapido?", "Guepardo");
        preguntas.put("La ballena es un mamífero?", "Si");
    }
    public void run () {
        try {
            //crear un buffer pARA RECIBIR Y ENVIAR DATOS AL CLIENTE 
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream());

            while(true){

                //obtener pregunta aleatoria
                String pregunta = preguntAleatorea();
                // Escribir los datos a enviar
            salida.println(pregunta);
            salida.flush(); // Asegurar que el mensaje se envíe


            //leer los datos de entrada recibidos por el cliente almacenados en entrada 
            String datos_recibidos = entrada.readLine();
            System.out.println("Respuesta: "+datos_recibidos);
            
            //Verificar si es correcta la respuesta}+
            if (verificarRespuesta(pregunta,datos_recibidos)){
                salida.println("Respuesta Correcta!");
            }else{
                salida.println("Respuesta incorrecta!");
            }
            salida.flush();

            }
            

            //escribir los datos a enviart 
            //String mensaje_enviar = "Hola soy el servidor";
            //salida.println(mensaje_enviar);
            
             // Leer mensaje desde el teclado
            //Scanner scanner = new Scanner(System.in);
            //System.out.print("Escribe tu mensaje para enviar al cliente: ");
            //String mensaje_enviar = scanner.nextLine()
            
        
        } catch (IOException e) {
        }
        
    }
    // Método para obtener una pregunta aleatoria
    private String preguntAleatorea() {
        // Obtener todas las preguntas como un arreglo
        String[] preguntass = preguntas.keySet().toArray(new String[0]);
        // Obtener un índice aleatorio
        int indice = (int) (Math.random() * preguntas.length);
        // Devolver la pregunta en ese índice
        return preguntass[indice];
    }

    // Método para verificar si la respuesta es correcta
    private boolean verificarRespuesta(String pregunta, String respuesta) {
        // Obtener la respuesta correcta para la pregunta
        String respuestaCorrecta = preguntas.get(pregunta);
        // Verificar si la respuesta coincide con la respuesta correcta (ignorando mayúsculas y minúsculas)
        return respuesta.equalsIgnoreCase(respuestaCorrecta);
    }

    
    
}
