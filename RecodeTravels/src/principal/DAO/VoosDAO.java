package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import principal.Conexao;
import principal.Voos;

public class VoosDAO {
    private static Connection conexao;

    public VoosDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarVoo(Voos voo) {
        String sql = "INSERT INTO voos (IDVoo, NumeroVoo, AeroportoOrigem, AeroportoDestino, DataHoraPartida, DataHoraChegada, CompanhiaAerea, Preco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, voo.getIDVoo());
            stmt.setString(2, voo.getNumeroVoo());
            stmt.setString(3, voo.getAeroportoOrigem());
            stmt.setString(4, voo.getAeroportoDestino());
            stmt.setDate(5, new java.sql.Date(voo.getDataHoraPartida().getTime()));
            stmt.setDate(6, new java.sql.Date(voo.getDataHoraChegada().getTime()));
            stmt.setString(7, voo.getCompanhiaAerea());
            stmt.setDouble(8, voo.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Voos buscarVoo(int id) {
        Voos voo = null;
        String sql = "SELECT * FROM voos WHERE IDVoo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                voo = new Voos();
                voo.setIDVoo(resultado.getInt("IDVoo"));
                voo.setNumeroVoo(resultado.getString("NumeroVoo"));
                voo.setAeroportoOrigem(resultado.getString("AeroportoOrigem"));
                voo.setAeroportoDestino(resultado.getString("AeroportoDestino"));
                voo.setDataHoraPartida(resultado.getDate("DataHoraPartida"));
                voo.setDataHoraChegada(resultado.getDate("DataHoraChegada"));
                voo.setCompanhiaAerea(resultado.getString("CompanhiaAerea"));
                voo.setPreco(resultado.getDouble("Preco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voo;
    }

    public List<Voos> listarVoos() {
        List<Voos> voos = new ArrayList<>();
        String sql = "SELECT * FROM voos";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Voos voo = new Voos();
                voo.setIDVoo(resultado.getInt("IDVoo"));
                voo.setNumeroVoo(resultado.getString("NumeroVoo"));
                voo.setAeroportoOrigem(resultado.getString("AeroportoOrigem"));
                voo.setAeroportoDestino(resultado.getString("AeroportoDestino"));
                voo.setDataHoraPartida(resultado.getDate("DataHoraPartida"));
                voo.setDataHoraChegada(resultado.getDate("DataHoraChegada"));
                voo.setCompanhiaAerea(resultado.getString("CompanhiaAerea"));
                voo.setPreco(resultado.getDouble("Preco"));
                voos.add(voo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voos;
    }

    public void atualizarVoo(Voos voo) {
        String sql = "UPDATE voos SET NumeroVoo = ?, AeroportoOrigem = ?, AeroportoDestino = ?, DataHoraPartida = ?, DataHoraChegada = ?, CompanhiaAerea = ?, Preco = ? WHERE IDVoo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, voo.getNumeroVoo());
            stmt.setString(2, voo.getAeroportoOrigem());
            stmt.setString(3, voo.getAeroportoDestino());
            stmt.setDate(4, new java.sql.Date(voo.getDataHoraPartida().getTime()));
            stmt.setDate(5, new java.sql.Date(voo.getDataHoraChegada().getTime()));
            stmt.setString(6, voo.getCompanhiaAerea());
            stmt.setDouble(7, voo.getPreco());
            stmt.setInt(8, voo.getIDVoo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirVoo(int id) {
        String sql = "DELETE FROM voos WHERE IDVoo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}