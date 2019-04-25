/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;

/**
 * @author Bruno Daher
 */
public class Protocolo implements Serializable {

    //referencia
    String referencia;

    //preco
    int preco;

    //dados
    String nome;
    String origem;
    String destino;
    String hotel;

    //DATAS
    String ida;
    String volta;

    //numero quartos e pessoas
    int quartos;
    int pessoas;
    //registro interesse
    boolean notifica;
}
