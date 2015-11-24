import java.util.Random;

/**
 * Representa la serie de cajas del supermercado
 */
public class Caja {

    private boolean[] arrayCaixes;
    private int numCaixes;

    //constr
    public Caja(int numCaixes){
        this.arrayCaixes = new boolean[numCaixes];//se crean las cajas
        for(int i = 0; i < numCaixes; i++){
            arrayCaixes[i] = true;
        }
        this.numCaixes = numCaixes;
    }

    //getter
    public boolean[] getArrayCaixes() {
        return arrayCaixes;
    }

    /**
     * Representa el cobro de un cliente
     * en su caja preestablecida
     * @param c: el cliente en curso
     * @throws InterruptedException
     */
    public synchronized void cobra(Cliente c) throws InterruptedException {

        for(int i = 0; i < arrayCaixes.length; i++){
            if(arrayCaixes[i]){
                //arrayCaixes[c.getIntCajaDeCliente()] = false;
                arrayCaixes[i] = false;
                //long esperaEnCaja = c.getEspera() / (long)500;
                //Thread.sleep(esperaEnCaja);//meitat de temps proporcional de compra a la caixa
                System.out.println("Caja " + i + ": Cobrado a " + c.getNombre() +
                   /* " Tiempo de espera en caja: " + esperaEnCaja + " seg/2" +*/
                        "\n\tTiempo medio de espera del cliente: "/* + ((c.getEspera() + esperaEnCaja) / 2) + " seg/2"*/);

                arrayCaixes[i] = true;
                notifyAll();
            }
            else{
                System.out.println("WAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIT");
                wait();
            }
        }

    }

}
