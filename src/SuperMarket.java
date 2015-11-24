import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class SuperMarket {

    public static void main(String[] args) throws InterruptedException {
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);


        System.out.println("Entra numero de clientes:");
        int m = input.nextInt();

        System.out.println("Entra numero de cajas:");
        int n = input.nextInt();

        Caja caja = new Caja(n);

        Date tiempoInicialEjecucionPrograma = new Date();
        long ini = tiempoInicialEjecucionPrograma.getTime();

        //se generan clientes
        for(int i = 0; i < m; i++){
            String cliente = "cliente".concat(String.valueOf(i));//adjudica un nombre al cliente
            Cliente c = new Cliente(cliente, rnd.nextInt(n), caja);
            Thread hilo = new Thread(c);
            hilo.start();//run() c
            //c.run();
            //caja.cobra(c);

        }

        Thread.sleep(1000);

        Date tiempoFinalEjecucionPrograma = new Date();
        long end = tiempoFinalEjecucionPrograma.getTime();

        //Returns the number of milliseconds since January 1,
        // 1970, 00:00:00 GMT represented by this Date object.

        System.out.println("\nTIEMPO DE EJECUCION: " + (end - ini));

        input.close();
    }//main

}
