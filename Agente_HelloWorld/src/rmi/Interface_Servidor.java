/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Adaptado Bruno Daher
 *
 * @author Cristina
 */
public interface Interface_Servidor extends Remote {

    String consulta(Protocolo helloworld) throws RemoteException;

    public void attHotel(String nme, int qts, String checkIn, String checkOut, int op);

    void attVoo(boolean pac, String dataIda, String dataVolta, String origem, String destino, int nPass) throws RemoteException;

    void attPacotes(String nomePacote, String origem, String destino, String dataIda, String dataVolta) throws RemoteException;

}
