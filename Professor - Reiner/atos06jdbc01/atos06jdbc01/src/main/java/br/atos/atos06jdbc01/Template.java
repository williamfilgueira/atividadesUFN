package br.atos.atos06jdbc01;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Template {

    MySQLR mysqlr;
    
    public Template() {
        mysqlr = new MySQLR();
    }
    
    
    public static void main(String[] args) {
        try {
            Template template = new Template();
            template.conectar();
                       
//            template.inserir();
//            
//            
//            template.inserir("Gabriel", "gabi@atos.br", "SM");
//            
//            
            
            Pessoa pessoa = new Pessoa();
            
//            pessoa.setNome("Meani");
//            pessoa.setEmail("meani@atos.br");
//            pessoa.setCidade("Santa Maria");
//            template.inserir(pessoa);
//            
            
//            template.consultar();
            
             
//            pessoa.setNome("Pedro");
//            pessoa.setEmail("pedro@atos.br");
//            pessoa.setCidade("Rio de Janeiro");
//            
//            template.alterar(pessoa,2);
//            template.consultar();
//            
         
            template.excluir(1);
            template.consultar();
            
            
            
            //template.mysqlr.stmt.close();
            //template.mysqlr.conn.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
    
    public void conectar(){
        boolean connected = mysqlr.connect("localhost", "3306", "atos02", "root", "123456");
        if (connected) {
            System.out.println("Base de dados conectada.");
        } else {
            System.out.println("Base de dados não conectada.");
        }
    }
    
    public void inserir(){
        String query = "INSERT INTO Pessoa (nome, email, cidade) "
                + "values ('Adrian', 'adrian@atos.com', 'Santa Maria')";
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
        } else {
            System.out.println("Erro ao inserir dados!");
        }
    }
    
    public void inserir(String nome, String email, String cidade){
        String query = "INSERT INTO Pessoa (nome, email, cidade) "
                + "values ('"+nome+"', '"+email+"', '"+cidade+"')";
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
        } else {
            System.out.println("Erro ao inserir dados!");
        }
    }
    
    public void inserir(Pessoa pessoa){
        String query = "INSERT INTO Pessoa (nome, email, cidade) "
                + "values ('"+pessoa.getNome()+"', '"+pessoa.getEmail()+"', '"+pessoa.getCidade()+"')";
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
        } else {
            System.out.println("Erro ao inserir dados!");
        }
    }
    
    public void consultar(){
        ResultSet rs = mysqlr.executeQuery("SELECT * FROM Pessoa");
        if (rs != null) {
            try {
                while (rs.next()) {
                    // É possível referenciar a coluna pelo índice 
                    System.out.println("Id: " + rs.getString(1));
                    // Ou pelo nome
                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("E-mail: " + rs.getString("email"));
                    System.out.println("Cidade: " + rs.getString("cidade"));
                    System.out.println();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    public void alterar(Pessoa pessoa, int ID){
        int status;
        String query = "UPDATE Pessoa SET nome='" + pessoa.getNome() + "', "
                    + "email='" + pessoa.getEmail() + "', cidade='" + pessoa.getCidade() + "'  "
                    + "WHERE id=" + ID;
        status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados alterados com sucesso!");
        } else {
            System.out.println("Erro ao alterar dados!");
        }
    }
    
    public void excluir(int ID){ 
        String query = "DELETE FROM Pessoa WHERE id=" + ID;
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados excluídos com sucesso!");
        } else {
            System.out.println("Erro ao excluir dados!");
        }  
    } 
    
}    