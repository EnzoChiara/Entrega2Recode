package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Usuario;

public class UsuarioDAO {
    private Connection connection;
    
    public UsuarioDAO() {
        try {
            connection = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	    


    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void criarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (IDUsuario, Nome, Sobrenome, Email, Senha, InformacoesContato) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getIDUsuario());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getSobrenome());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.setString(6, usuario.getInformacoesContato());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario buscarUsuario(int IDUsuario) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE IDUsuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, IDUsuario);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                usuario = new Usuario();
                usuario.setIDUsuario(resultado.getInt("IDUsuario"));
                usuario.setNome(resultado.getString("Nome"));
                usuario.setSobrenome(resultado.getString("Sobrenome"));
                usuario.setEmail(resultado.getString("Email"));
                usuario.setSenha(resultado.getString("Senha"));
                usuario.setInformacoesContato(resultado.getString("InformacoesContato"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setIDUsuario(resultado.getInt("IDUsuario"));
                usuario.setNome(resultado.getString("Nome"));
                usuario.setSobrenome(resultado.getString("Sobrenome"));
                usuario.setEmail(resultado.getString("Email"));
                usuario.setSenha(resultado.getString("Senha"));
                usuario.setInformacoesContato(resultado.getString("InformacoesContato"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET Nome = ?, Sobrenome = ?, Email = ?, Senha = ?, InformacoesContato = ? WHERE IDUsuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getInformacoesContato());
            stmt.setInt(6, usuario.getIDUsuario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE IDUsuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
