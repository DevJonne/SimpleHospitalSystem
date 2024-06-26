package Main;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaMedica {
    private static List<Paciente> pacientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Sistema de Consulta Médica");
            System.out.println("1. Incluir Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Realizar Atendimento");
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Mostrar Paciente");
            System.out.println("6. Apagar Paciente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcao) {
                case 1:
                    incluirPaciente(scanner);
                    break;
                case 2:
                    alterarPaciente(scanner);
                    break;
                case 3:
                    realizarAtendimento(scanner);
                    break;
                case 4:
                    listarPacientes();
                    break;
                case 5:
                    mostrarPaciente(scanner);
                    break;
                case 6:
                    apagarPaciente(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void incluirPaciente(Scanner scanner) {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome do paciente: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatoBr);
        Paciente paciente = new Paciente(nome, sobrenome, dataNascimento);
        pacientes.add(paciente);
        System.out.println("Paciente incluído com sucesso.");
    }

    private static void alterarPaciente(Scanner scanner) {
        System.out.print("Nome do paciente a ser alterado: ");
        String nome = scanner.nextLine();
        Paciente paciente = buscarPacientePorNome(nome);

        if (paciente != null) {
            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo sobrenome: ");
            String novoSobrenome = scanner.nextLine();
            System.out.print("Nova data de nascimento (dd/MM/yyyy): ");
            String novaDataNascimentoStr = scanner.nextLine();
            DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate novaDataNascimento = LocalDate.parse(novaDataNascimentoStr, formatoBr);

            paciente.setNome(novoNome);
            paciente.setSobrenome(novoSobrenome);
            paciente.setDataNascimento(novaDataNascimento);
            System.out.println("Paciente alterado com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void realizarAtendimento(Scanner scanner) {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();
        Paciente paciente = buscarPacientePorNome(nome);

        if (paciente != null) {
            System.out.print("Data do atendimento (dd/MM/yyyy): ");
            String dataAtendimentoStr = scanner.nextLine();
            System.out.print("Descrição do atendimento: ");
            String descricao = scanner.nextLine();
            DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataAtendimento = LocalDate.parse(dataAtendimentoStr, formatoBr);

            Atendimento atendimento = new Atendimento(dataAtendimento, descricao);
            paciente.adicionarConsulta(atendimento);
            System.out.println("Atendimento realizado com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void listarPacientes() {
        System.out.println("Lista de Pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getNome() + " " + paciente.getSobrenome());
        }
    }

    private static void mostrarPaciente(Scanner scanner) {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();
        Paciente paciente = buscarPacientePorNome(nome);

        if (paciente != null) {
            System.out.println(paciente);
            int count = 0;
            for (Atendimento atendimento : paciente.getAtendimentos()) {
                System.out.println(atendimento);
                count++;
                if (count % 5 == 0) {
                    System.out.print("Pressione Enter para continuar...");
                    scanner.nextLine();
                }
            }
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void apagarPaciente(Scanner scanner) {
        System.out.print("Nome do paciente a ser apagado: ");
        String nome = scanner.nextLine();
        Paciente paciente = buscarPacientePorNome(nome);

        if (paciente != null) {
            pacientes.remove(paciente);
            System.out.println("Paciente removido com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static Paciente buscarPacientePorNome(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                return paciente;
            }
        }
        return null;
    }
}

