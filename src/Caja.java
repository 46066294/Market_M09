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
            arrayCaixes[i] = false;
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

        if(!arrayCaixes[c.getIntCajaDeCliente()]){//si esa caja esta desocupada (false == desocupada)
            long esperaEnCaja = c.getEspera() / (long)500;
            arrayCaixes[c.getIntCajaDeCliente()] = true;
            Thread.sleep(esperaEnCaja);//meitat de temps proporcional de compra a la caixa
            System.out.println("Caja " + c.getIntCajaDeCliente() + ": Cobrado a " + c.getNombre() +
                   /* " Tiempo de espera en caja: " + esperaEnCaja + " seg/2" +*/
                    "\n\tTiempo medio de espera del cliente: " + ((c.getEspera() + esperaEnCaja)/2) + " seg/2");

            arrayCaixes[c.getIntCajaDeCliente()] = false;
        }

    }

}
