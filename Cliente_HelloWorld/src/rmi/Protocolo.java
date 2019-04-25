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
    public String referencia;

    //precoMax
    public int precoMax;

    //dados
    public String nome;
    public String origem;
    public String destino;
    public String hotel;

    //DATAS
    public String ida;
    public String volta; //se volta nula, somente ida

    //numero quartos e pessoas
    public int quartos;
    public int pessoas;
    //registro interesse
    public boolean notifica;
}
