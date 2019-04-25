/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author BrunoSeven
 */
public interface Interface_Cliente extends Remote {

    void notificacoes(String x) throws RemoteException;

}
