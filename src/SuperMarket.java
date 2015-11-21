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

        //se generan clientes
        for(int i = 0; i < m; i++){
            String cliente = "cliente".concat(String.valueOf(i));//adjudica un nombre al cliente
            Cliente c = new Cliente(cliente, rnd.nextInt(n), caja);
            Thread hilo = new Thread(c);
            hilo.start();//run() c
            //c.run();
            //caja.cobra(c);
        }

        input.close();
    }
}
