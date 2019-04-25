/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * adaptação Bruno Daher
 *
 *
 * @author Cristina
 */
public class Cliente extends Thread {

    private Protocolo meuProtocolo;
    private Registry registroServicoNomes;
    private Interface_Servidor referenciaServidorPacotesViagem;

    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.start();
    }

    public void notifica() {

    }

    public void run() {

        meuProtocolo = new Protocolo();
        setDados();

        try {
            //servico de nomes pra Mapeamento

            Interface_Cliente interCli = new ClienteImpl();

            // obtém referência do serviço de nomes
            registroServicoNomes = LocateRegistry.getRegistry();
            referenciaServidorPacotesViagem = (Interface_Servidor) registroServicoNomes.lookup("ServidorViagens");
            registroServicoNomes.rebind(meuProtocolo.referencia, interCli);

            //invoca metodo remoto
            request();
        } catch (RemoteException e) {
            System.out.println("ErroServidor " + e.getMessage());
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //invoca metodo remoto
    public void request() {
        try {
            String x = referenciaServidorPacotesViagem.consulta(meuProtocolo);
            System.out.println(x);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //inserção de dados
    public void setDados() {

        System.out.println("SeuNome");
        meuProtocolo.nome = new Scanner(System.in).nextLine();
        meuProtocolo.referencia = meuProtocolo.nome + "#ref";

        System.out.println("Somente Ida?");
        String ida = new Scanner(System.in).nextLine();

        System.out.println("Origem");
        meuProtocolo.origem = new Scanner(System.in).nextLine();
        //consulta

        System.out.println("Ida");
        meuProtocolo.ida = new Scanner(System.in).nextLine();

        System.out.println("Destino");
        meuProtocolo.destino = new Scanner(System.in).nextLine();

        System.out.println("Quartos");
        meuProtocolo.quartos = new Scanner(System.in).nextInt();

        //se for so ida
        if (ida.equalsIgnoreCase("sim")) {
            //volta é nula
            meuProtocolo.volta = null;
        } else {
            System.out.println("Volta");
            meuProtocolo.volta = new Scanner(System.in).nextLine();
        }

        System.out.println("Notificações?");
        String notifica = new Scanner(System.in).nextLine();

        if (notifica.equalsIgnoreCase("SIM")) {
            meuProtocolo.notifica = true;
        } else {
            meuProtocolo.notifica = false;
        }

    }
}
