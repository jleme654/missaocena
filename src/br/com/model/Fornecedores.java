/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import br.com.dao.ClassConecta;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @since 29/01/2013
 * @author jleme
 */
public class Fornecedores implements Serializable {

    private Integer id;
    private String nome;
    private String rg;
    private String cpf;
    private String cnpj;
    private String telefone;
    private String funcao;
    private String email;
    
    private ClassConecta conexao = new ClassConecta();

    public Fornecedores() {
    }

    public Fornecedores(Integer id, String nome) {
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

    public String getCpf() {
        if (cpf == null) {
            return "-";
        }
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        if (rg == null) {
            return "-";
        }
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public String getFuncao() {
        if (funcao == null) {
            return "-";
        }
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCnpj() {
        if (cnpj == null) {
            return "-";
        }
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    @Override
    public String toString() {
        return "Fornecedores{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", telefone=" + telefone + ", funcao=" + funcao + ", cnpj=" + cnpj + ", email=" + email + '}';
    }

    public void incluiFornecedor() {
        try {
            conexao.conecta();
            Statement stmt = conexao.con.createStatement();
            stmt.executeUpdate("insert into fornecedores(nome, telefone, funcao)values('" + getNome() + "', '" + getTelefone() + "', '" + getFuncao() + "')");

            System.out.println("produto inserido");
            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado");

            // stmt.executeUpdate("insert into estoque(idProduto, qtde)values(" + getId() + ", "+ getQtdeProdutos() + ")");
            //  System.out.println("estoque inserido");
            //JOptionPane.showMessageDialog(null, "Produto cadastrado");

            //stmt.close();
            //conexao.con.close();
            //System.out.println("Fechada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, se o problema persistir contate o administrador:\n" + e, "ATEN๏ฟฝ๏ฟฝO", JOptionPane.WARNING_MESSAGE);
        }
    }
}
