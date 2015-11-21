
public class Cliente implements Runnable{

    private String nombre;
    private int intCajaDeCliente;
    private Caja cajaDeCliente;
    boolean flag = false;

    //constructor
    public Cliente(String nombre, int intCajaDeCliente, Caja cajaDeCliente){
        this.nombre = nombre;
        this.intCajaDeCliente = intCajaDeCliente;
        this.cajaDeCliente = cajaDeCliente;
    }


    public int getIntCajaDeCliente() {
        return intCajaDeCliente;
    }

    public String getNombre() {
        return nombre;
    }


    @Override
    public void run() {
        try {

            Thread.sleep((long) Math.random() * 100);//tiempo de compra aleatorio
            System.out.println(nombre + " compra");

            if(cajaDeCliente.getArrayCaixes()[intCajaDeCliente]){//si la caja esta ocupada (ocupada = true)
                flag = true;
                System.out.println("..." + nombre + " EN ESPERA");
                //wait();
            }

            cajaDeCliente.cobra(this);

            if(flag){
                System.out.println("...Caja " + intCajaDeCliente + " REACTIVADA");
                //notify();
                flag = false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
