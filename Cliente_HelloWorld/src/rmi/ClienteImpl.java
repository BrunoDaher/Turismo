/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * adaptacao Bruno Daher
 *
 * @author Cristina
 */
class ClienteImpl extends UnicastRemoteObject implements Interface_Cliente {

    public ClienteImpl() throws RemoteException {
    }

    public void notificacoes(String x) throws RemoteException {
        System.out.println("notificação" + x);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
