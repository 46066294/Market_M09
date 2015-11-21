import java.util.Random;

public class Caja {

    public boolean[] getArrayCaixes() {
        return arrayCaixes;
    }

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

    public synchronized void cobra(Cliente c) throws InterruptedException {

        if(!arrayCaixes[c.getIntCajaDeCliente()]){//si esa caja esta desocupada (false == desocupada)

            arrayCaixes[c.getIntCajaDeCliente()] = true;
            System.out.println("Caja " + c.getIntCajaDeCliente() + ": Cobrado a " + c.getNombre());
            arrayCaixes[c.getIntCajaDeCliente()] = false;
        }

    }


}
