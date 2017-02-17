package lppo.exercicio01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcluiTabela {
    
    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/lppo-2017-2";
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            System.out.println("Conexão aberta com sucesso!");
            
            String sql = "DROP TABLE contatos";
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate(sql);
            System.out.println("Tabela excluida!");
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver indisponivel");
            Logger.getLogger(ExcluiTabela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.err.println("Problema para acessar o banco!");
            Logger.getLogger(ExcluiTabela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
