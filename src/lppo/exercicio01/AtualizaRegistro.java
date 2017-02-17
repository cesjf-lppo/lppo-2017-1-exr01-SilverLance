package lppo.exercicio01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtualizaRegistro {
    
    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/lppo-2017-2";
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            System.out.println("Conexão aberta com sucesso!");
      
            String sql = "UPDATE  produto SET qtd = qtd -1, atualizado = CURRENT_TIMESTAMP WHERE qtd >= 100";
            Statement operacao = conexao.createStatement();
            Integer n = operacao.executeUpdate(sql);
            System.out.println(n+" registros atualizados!");
            
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver indisponivel");
            Logger.getLogger(AtualizaRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.err.println("Problema para acessar o banco!");
            Logger.getLogger(AtualizaRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
