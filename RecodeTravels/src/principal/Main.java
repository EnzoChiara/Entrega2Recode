package principal;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import principal.DAO.ReservasDAO;
import principal.DAO.UsuarioDAO;
import principal.DAO.VoosDAO;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ReservasDAO reservasDAO = new ReservasDAO();
        VoosDAO voosDAO = new VoosDAO();
        
        while (true) {
            System.out.println("\nSistema de Gestão de Usuários");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Editar Usuário");
            System.out.println("4. Excluir Usuário");
            System.out.println("5. Cadastrar Voo");
            System.out.println("6. Listar Voos");
            System.out.println("7. Editar Voo");
            System.out.println("8. Excluir Voo");
            System.out.println("9. Cadastrar Reserva");
            System.out.println("10. Listar Reservas");
            System.out.println("11. Editar Reserva");
            System.out.println("12. Excluir Reserva");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    // Cadastrar Usuário
                    Usuario usuario = new Usuario();
                    System.out.print("Nome: ");
                    usuario.setNome(scanner.nextLine());
                    System.out.print("Sobrenome: ");
                    usuario.setSobrenome(scanner.nextLine());
                    System.out.print("Email: ");
                    usuario.setEmail(scanner.nextLine());
                    System.out.print("Senha: ");
                    usuario.setSenha(scanner.nextLine());
                    System.out.print("Informações de Contato: ");
                    usuario.setInformacoesContato(scanner.nextLine());
                    usuarioDAO.criarUsuario(usuario);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 2:
                    // Listar Usuários
                    List<Usuario> usuarios = usuarioDAO.listarUsuarios();
                    for (Usuario u : usuarios) {
                        System.out.println("ID: " + u.getIDUsuario() +
                                ", Nome: " + u.getNome() +
                                ", Sobrenome: " + u.getSobrenome() +
                                ", Email: " + u.getEmail() +
                                ", Informações de Contato: " + u.getInformacoesContato());
                    }
                    break;

                case 3:
                    // Editar Usuário
                    System.out.print("Digite o ID do Usuário que deseja editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();  // Limpar o buffer
                    Usuario usuarioEditar = usuarioDAO.buscarUsuario(idEditar);
                    if (usuarioEditar != null) {
                        System.out.print("Novo Nome: ");
                        usuarioEditar.setNome(scanner.nextLine());
                        System.out.print("Novo Sobrenome: ");
                        usuarioEditar.setSobrenome(scanner.nextLine());
                        System.out.print("Novo Email: ");
                        usuarioEditar.setEmail(scanner.nextLine());
                        System.out.print("Nova Senha: ");
                        usuarioEditar.setSenha(scanner.nextLine());
                        System.out.print("Novas Informações de Contato: ");
                        usuarioEditar.setInformacoesContato(scanner.nextLine());

                        usuarioDAO.atualizarUsuario(usuarioEditar);
                        System.out.println("Usuário atualizado com sucesso!");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 4:
                    // Excluir Usuário
                    System.out.print("Digite o ID do Usuário que deseja excluir: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine();  // Limpar o buffer
                    usuarioDAO.excluirUsuario(idExcluir);
                    System.out.println("Usuário excluído com sucesso!");
                    break;
                    
                case 5:
                	Voos voo = new Voos();
                    System.out.print("Número do Voo: ");
                    voo.setNumeroVoo(scanner.next());
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Origem: ");
                    voo.setAeroportoOrigem(scanner.nextLine());
                    System.out.print("Destino: ");
                    voo.setAeroportoDestino(scanner.nextLine());
                    System.out.print("Data e Hora de Partida (dd/MM/yyyy HH:mm): ");
                    String dataPartidaString = scanner.nextLine();

                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        java.util.Date dataPartida = sdf.parse(dataPartidaString);
                        voo.setDataHoraPartida(dataPartida);
                    } catch (ParseException e) {
                        System.out.println("Formato de data e hora inválido. Use dd/MM/yyyy HH:mm.");
                        break;
                    }

                    System.out.print("Data e Hora de Chegada (dd/MM/yyyy HH:mm): ");
                    String dataChegadaString = scanner.nextLine();

                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        java.util.Date dataChegada = sdf.parse(dataChegadaString);
                        voo.setDataHoraChegada(dataChegada);
                    } catch (ParseException e) {
                        System.out.println("Formato de data e hora inválido. Use dd/MM/yyyy HH:mm.");
                        break;
                    }

                    System.out.print("Companhia Aérea: ");
                    voo.setCompanhiaAerea(scanner.nextLine());
                    System.out.print("Preço: ");
                    voo.setPreco(scanner.nextDouble());

                    voosDAO.criarVoo(voo);
                    System.out.println("Voo cadastrado com sucesso!");
                    break;

                case 6:
                	 // Listar Voos
                    List<Voos> voosList = voosDAO.listarVoos();
                    for (Voos v : voosList) {
                        System.out.println("ID: " + v.getIDVoo() +
                                ", Número do Voo: " + v.getNumeroVoo() +
                                ", Origem: " + v.getAeroportoOrigem() +
                                ", Destino: " + v.getAeroportoDestino() +
                                ", Data de Partida: " + v.getDataHoraPartida() +
                                ", Data de Chegada: " + v.getDataHoraChegada() +
                                ", Companhia Aérea: " + v.getCompanhiaAerea() +
                                ", Preço: " + v.getPreco());
                    }
                    break;

                case 7:
                	// Editar Voo
                    System.out.print("Digite o ID do Voo que deseja editar: ");
                    int idEditarVoo = scanner.nextInt();
                    scanner.nextLine();  // Limpar o buffer
                    Voos vooEditar = voosDAO.buscarVoo(idEditarVoo);
                    if (vooEditar != null) {
                        System.out.print("Novo Número do Voo: ");
                        vooEditar.setNumeroVoo(scanner.nextLine());
                        System.out.print("Nova Origem: ");
                        vooEditar.setAeroportoOrigem(scanner.nextLine());
                        System.out.print("Novo Destino: ");
                        vooEditar.setAeroportoDestino(scanner.nextLine());
                        System.out.print("Nova Data de Partida (dd/MM/yyyy): ");
                        String novaDataPartidaString = scanner.nextLine();
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            java.util.Date novaDataPartida = sdf.parse(novaDataPartidaString);
                            vooEditar.setDataHoraPartida(novaDataPartida);
                        } catch (ParseException e) {
                            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
                            break;
                        }
                        System.out.print("Nova Data de Chegada (dd/MM/yyyy): ");
                        String novaDataChegadaString = scanner.nextLine();
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            java.util.Date novaDataChegada = sdf.parse(novaDataChegadaString);
                            vooEditar.setDataHoraChegada(novaDataChegada);
                        } catch (ParseException e) {
                            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
                            break;
                        }

                        System.out.print("Nova Companhia Aérea: ");
                        vooEditar.setCompanhiaAerea(scanner.nextLine());

                        System.out.print("Novo Preço: ");
                        double novoPreco = scanner.nextDouble();
                        vooEditar.setPreco(novoPreco);
                        scanner.nextLine();  // Limpar o buffer

                        // Adicionar lógica para atualizar o voo no banco de dados
                        voosDAO.atualizarVoo(vooEditar);
                        System.out.println("Voo atualizado com sucesso!");
                    } else {
                        System.out.println("Voo não encontrado.");
                    }
                    break;
                case 8:
                    // Excluir Voo
                    System.out.print("Digite o ID do Voo que deseja excluir: ");
                    int idExcluirVoo = scanner.nextInt();
                    scanner.nextLine();  // Limpar o buffer
                    voosDAO.excluirVoo(idExcluirVoo);
                    System.out.println("Voo excluído com sucesso!");
                    break;
                    
                case 9:
                	// Criar Reserva
                    Reservas reserva = new Reservas();
                    System.out.print("ID do Voo: ");
                    int idVoo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    reserva.setIDVoo(idVoo);
                    System.out.print("ID do Usuário: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    reserva.setIDUsuario(idUsuario);
                    System.out.print("Data da Reserva (dd/MM/yyyy): ");
                    String dataString1 = scanner.nextLine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                      
                        java.util.Date dataReserva = sdf.parse(dataString1);
                        java.sql.Date dataReservaSQL = new java.sql.Date(dataReserva.getTime());

                        reserva.setDataHoraReserva(dataReservaSQL);
                        reservasDAO.criarReserva(reserva);
                        System.out.println("Reserva criada com sucesso!");
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
                    }
                    break;

                case 10:
                    // Listar Reservas
                    List<Reservas> reservas = reservasDAO.listarReservas();
                    SimpleDateFormat sdfVoo = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("Lista de Reservas:");
                    for (Reservas r : reservas) {
                        System.out.println("ID: " + r.getIDReserva() +
                                ", ID do Voo: " + r.getIDVoo() +
                                ", ID do Usuário: " + r.getIDUsuario() +
                                ", Data da Reserva: " + sdfVoo.format(r.getDataHoraReserva()));
                    }
                    break;

                case 11:
                    // Atualizar Reserva
                    System.out.print("Digite o ID da Reserva que deseja atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    SimpleDateFormat sdfReserva = new SimpleDateFormat("dd/MM/yyyy");
                    scanner.nextLine();  // Limpar o buffer
                    Reservas reservaAtualizar = reservasDAO.buscarReserva(idAtualizar);
                    if (reservaAtualizar != null) {
                        System.out.print("Novo ID do Voo: ");
                        int novoIdVoo = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        reservaAtualizar.setIDVoo(novoIdVoo);
                        System.out.print("Novo ID do Usuário: ");
                        int novoIdUsuario = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        reservaAtualizar.setIDUsuario(novoIdUsuario);
                        System.out.print("Nova Data da Reserva (dd/MM/yyyy): ");
                        String novaDataString = scanner.nextLine();
                        try {
                            java.util.Date novaDataReserva = sdfReserva.parse(novaDataString);
                            reservaAtualizar.setDataHoraReserva(novaDataReserva);
                            reservasDAO.atualizarReserva(reservaAtualizar);
                            System.out.println("Reserva atualizada com sucesso!");
                        } catch (ParseException e) {
                            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
                        }
                    } else {
                        System.out.println("Reserva não encontrada.");
                    }
                    break;

                case 12:
                    // Cancelar Reserva
                    System.out.print("Digite o ID da Reserva que deseja cancelar: ");
                    int idCancelar = scanner.nextInt();
                    scanner.nextLine();  // Limpar o buffer
                    reservasDAO.excluirReserva(idCancelar);
                    System.out.println("Reserva cancelada com sucesso!");
                    break;


                case 0:
                    usuarioDAO.fecharConexao();
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

	}
        
        

}
	}
