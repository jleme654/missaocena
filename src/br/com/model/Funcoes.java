/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.io.Serializable;

/**
 *
 * @since 29/01/2013
 * @author jleme
 */
public class Funcoes implements Serializable {

    private Integer id;
    private String nome;

    public Funcoes() {
    }

    public Funcoes(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        if (nome == null) {
            return "-";
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
