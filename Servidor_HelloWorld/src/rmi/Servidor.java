/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Cristina
 */
public class Servidor {

    public static void main(String[] args) {
        try {
            // Cria instância da classe que implementa a interface
            //esta classe é responsável por adm os request
            //uma espécie de controller
            ServidorImpl servidorTurismo = new ServidorImpl();

            // Cria serviço de nomes
            Registry clientes = LocateRegistry.createRegistry(1099);

            //CLIENTES
            // Registra a referência do serviço ServidorViagens no serviço de nomes
            clientes.bind("ServidorViagens", servidorTurismo);
            // controle Interno
            System.out.println("ServidorViagensClientes - Rodando");

            //AGENTES
            // Registra a referência do serviço ServidorAgentes no serviço de nomes
            clientes.bind("ServidorAgentes", servidorTurismo);

            //servidorTurismo.setRegistro(clientes);
            // controle Interno
            System.out.println("ServidorViagensAgentes - Rodando");
        } catch (Exception e) {
            //System.out.println("Servidor " + e.getMessage());
        }
    }

}
