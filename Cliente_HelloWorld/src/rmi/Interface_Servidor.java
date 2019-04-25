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

    String consulta(Protocolo protocolo) throws RemoteException;

}
