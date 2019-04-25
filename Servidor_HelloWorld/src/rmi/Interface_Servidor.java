/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Cristina
 */
public interface Interface_Servidor extends Remote {

    //CLIENTE
    String consulta(Protocolo protocolo) throws RemoteException;

    //AGENTE
    void attHotel(String nme, int qts, String dataIda, String dataVolta, int op) throws RemoteException;

    void attVoo(boolean pac, String dataIda, String dataVolta, String origem, String destino, int nPass) throws RemoteException;

    void attPacotes(String nomePacote, String origem, String destino, String dataIda, String dataVolta) throws RemoteException;

    void descadastra(Protocolo protocolo) throws RemoteException;

}
