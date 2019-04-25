/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import Dados.Hotel;
import Dados.Voo;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * adaptacao Bruno Daher
 *
 * @author Cristina
 */
class ServidorImpl extends UnicastRemoteObject implements Interface_Servidor {

    private HashMap<String, Hotel> hoteis = new HashMap();
    private HashMap<String, Voo> voos = new HashMap();
    private HashMap<String, Protocolo> clientes = new HashMap();
    private List<String> localidades;
    private Registry regCliente;
    private Interface_Cliente interCli;

    public ServidorImpl() throws RemoteException {
    }

    public void setRegistro(Registry reg) {
        this.regCliente = reg;
    }

    //(CLIENTE e AGENTE) - Consulta de pacotes
    public String consulta(Protocolo protocolo) throws RemoteException {

        //GUARDA CLIENTE NA "WISHLIST", CASO REQUISITADO
        if (protocolo.notifica) {
            clientes.put(protocolo.referencia, protocolo);
        }

        //RETORNA INFORMACAO
        String x = "Hoteis disponiveis" + hoteis.entrySet() + "\n Voos" + voos.entrySet() + "\n";
        return x;
    }

    //AGENTE -  METODO INTERNO (Registra interesse do cliente)
    protected void observer(Protocolo pac) {

    }

    public void attVoo(boolean pac, String dataIda, String dataVolta, String origem, String destino, int nPass) throws RemoteException {

        Voo voo = new Voo();
        voo.assentos = nPass;
        voo.origem = origem;
        voo.destino = destino;
        voo.pacote = pac;

        //caso exista, replace...eh possivel tb
        voos.put(voo.origem + "-" + destino, voo);
        //voos.remove(voo.origem + "-" + destino, voo);
        ///break;

        System.out.println(voos.toString());
    }

//att Hoteis
    public void attHotel(String nme, int qts, String checkIn, String checkOut, int op) throws RemoteException {

        Hotel hotel = new Hotel();
        hotel.nome = nme;
        hotel.localidade = 1;
        hotel.quartos = qts;
        hotel.checkIn = checkIn;
        hotel.checkOut = checkOut;

        //caso exista, replace...eh possivel tb
        hoteis.put(nme, hotel);
        //hoteis.replace(nme, hotel);

        System.out.println(hoteis.toString());
    }

    public void attPacotes(String nomePacote, String origem, String destino, String dataIda, String dataVolta) throws RemoteException {

        //A cada finalização de cadastro de pacotes
        //notifica os clientes cadastrados
        if (!clientes.isEmpty()) {
            System.out.println(clientes);

            for (Map.Entry<String, Protocolo> entry : clientes.entrySet()) {
                String keyRef = entry.getKey();

                //COMPARA
                //SE PREMISSAS OK
                //NOTIFICA
                notifica(keyRef);
            }

        } else {
            System.out.println("sem Clientes");
        }
    }

    public void descadastra(Protocolo protocolo) {
        clientes.remove(protocolo.referencia);
    }

    // notifica
    private void notifica(String keyRef) {

        try {
            // obtém referência do serviço de nomes
            Registry refServName = LocateRegistry.getRegistry();
            Interface_Cliente cliRef = (Interface_Cliente) refServName.lookup(keyRef);
            //System.out.println("criouLookup com sucesso" + keyRef);
            cliRef.notificacoes("are you a Newsletter Client");
        } catch (NotBoundException e) {
            System.out.println("Cliente desconectado " + e.getMessage());
        } catch (RemoteException e) {
            System.out.println("Cliente desconectado " + e.getMessage());
        }

    }

}
