/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * adaptação Bruno Daher
 *
 * @author Cristina
 */
public class Agente {

    Protocolo meuPacote = new Protocolo();
    TelaAgente tela;

    public static void main(String[] args) {

        Agente c = new Agente();

        try {
            // obtém referência do serviço de nomes
            Registry referenciaServicoNomes = LocateRegistry.getRegistry();
            //System.out.println(LocateRegistry.getRegistry()) ;
            //procura referência do serviço HelloWorld no serviço de nomes
            Interface_Servidor servidorViagens = (Interface_Servidor) referenciaServicoNomes.lookup("ServidorViagens");
            // chama método da Interface do Servidor (
            //String retorno = servidorViagens.atualiza("hotel Itacolomi");

            TelaAgente tela = new TelaAgente(servidorViagens);

            // Exibe retorno
            // System.out.println("Retorno Ok \n" + retorno);
        } catch (Exception e) {
            System.out.println("ErroServidor " + e.getMessage());
        }
    }

}
