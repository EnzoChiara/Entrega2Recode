package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import principal.Conexao;
import principal.Reservas;

public class ReservasDAO {
    private static Connection conexao;

    public ReservasDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarReserva(Reservas reserva) {
        String sql = "INSERT INTO reservas (IDReserva, IDUsuario, IDVoo, DataHoraReserva, StatusReserva) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, reserva.getIDReserva());
            stmt.setInt(2, reserva.getIDUsuario());
            stmt.setInt(3, reserva.getIDVoo());
            stmt.setObject(4, reserva.getDataHoraReserva());
            stmt.setString(5, reserva.getStatusReserva());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reservas buscarReserva(int id) {
        Reservas reserva = null;
        String sql = "SELECT * FROM reservas WHERE IDReserva = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                reserva = new Reservas();
                reserva.setIDReserva(resultado.getInt("IDReserva"));
                reserva.setIDUsuario(resultado.getInt("IDUsuario"));
                reserva.setIDVoo(resultado.getInt("IDVoo"));
                reserva.setDataHoraReserva(resultado.getTimestamp("DataHoraReserva"));
                reserva.setStatusReserva(resultado.getString("StatusReserva"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reserva;
    }

    public List<Reservas> listarReservas() {
        List<Reservas> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Reservas reserva = new Reservas();
                reserva.setIDReserva(resultado.getInt("IDReserva"));
                reserva.setIDUsuario(resultado.getInt("IDUsuario"));
                reserva.setIDVoo(resultado.getInt("IDVoo"));
                reserva.setDataHoraReserva(resultado.getTimestamp("DataHoraReserva"));
                reserva.setStatusReserva(resultado.getString("StatusReserva"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
    }

    public void atualizarReserva(Reservas reserva) {
        String sql = "UPDATE reservas SET IDUsuario = ?, IDVoo = ?, DataHoraReserva = ?, StatusReserva = ? WHERE IDReserva = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, reserva.getIDUsuario());
            stmt.setInt(2, reserva.getIDVoo());
            stmt.setObject(3, reserva.getDataHoraReserva());
            stmt.setString(4, reserva.getStatusReserva());
            stmt.setInt(5, reserva.getIDReserva());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirReserva(int id) {
        String sql = "DELETE FROM reservas WHERE IDReserva = ?";
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