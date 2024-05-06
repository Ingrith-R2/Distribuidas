public class HilosRun implements Runnable {

    private int tipo;

    public HilosRun(int tipo) {
        this.tipo = tipo; // Constructor que recibe el tipo de hilo
    }

    @Override
    public void run() {
        
        switch(tipo) {
            case 1 -> {
                for(int i = 1; i < 30; i++) {
                    System.out.println(i); // Imprimir números del 1 al 29
                }
            }
            case 2 -> {
                // Imprimir letras minúsculas de 'a' a 'y'
                for(char i = 'a'; i < 'z'; i++) {
                    System.out.print(i + ", "); // Imprimir números del 1 al 29
                }
                
            }
        
        }
    }
}

