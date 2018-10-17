/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import br.com.dao.ClassConecta;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @since 29/01/2013
 * @author jleme
 */
public class Clientes implements Serializable {

    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private ClassConecta conexao = new ClassConecta();

    public Clientes() {
    }

    public Clientes(Integer id, String nome) {
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

    public String getTelefone() {
        if (telefone == null) {
            return "-";
        }
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        if (email == null) {
            return "-";
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void incluiCliente() {
        try {
            conexao.conecta();
            Statement stmt = conexao.con.createStatement();
            stmt.executeUpdate("insert into clientes(nome, telefone, email)values('" + getNome() + "', '" + getTelefone() + "', '" + getEmail() + "')");

            JOptionPane.showMessageDialog(null, "Cliente cadastrado");

           } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, se o problema persistir contate o administrador:\n" + e, "ATEN๏ฟฝ๏ฟฝO", JOptionPane.WARNING_MESSAGE);
        }
    }
}
