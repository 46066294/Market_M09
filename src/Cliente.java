import java.util.Random;

/**
 * Representa un cliente de nuestro supermarket
 * Tiene un nombre, una caja aleatoria adjudicada,
 * y un tiempo de compra
 */
public class Cliente implements Runnable{

    private String nombre;
    private int intCajaDeCliente;
    private Caja cajaDeCliente;
    boolean flag = false;
    private long espera;

    //constructor
    public Cliente(String nombre, int intCajaDeCliente, Caja cajaDeCliente){
        this.nombre = nombre;
        this.intCajaDeCliente = intCajaDeCliente;
        this.cajaDeCliente = cajaDeCliente;
    }

    //getters
    public long getEspera() {
        return espera;
    }

    public int getIntCajaDeCliente() {
        return intCajaDeCliente;
    }

    public String getNombre() {
        return nombre;
    }


    /**
     * Arranca la ejecucion del hilo
     * El cliente compra durante un tiempo aleatorio
     * y se espera en la cola asta que esta se reactiva
     */
    @Override
    public void run() {
        try {
            Random rnd = new Random();
            espera = rnd.nextInt(1000);
            Thread.sleep(espera);//tiempo de compra aleatorio
            System.out.println(nombre + " compra");

            if(cajaDeCliente.getArrayCaixes()[intCajaDeCliente]){//si la caja esta ocupada (ocupada = true)
                flag = true;
                System.out.println("..." + nombre + " EN ESPERA");
                //wait();//////////////////////////////////////////
            }

            cajaDeCliente.cobra(this);

            if(flag){
                System.out.println("...Caja " + intCajaDeCliente + " REACTIVADA");
                //notify();//////////////////////////////////////////
                flag = false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
