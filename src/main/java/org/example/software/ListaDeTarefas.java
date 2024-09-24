package org.example.software;

import java.util.ArrayList;
import java.util.Scanner;

// Classe Tarefa, agora corretamente fora da classe todolist
class Tarefa {
    String descricao;
    boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    public String toString() {
        return (concluida ? "[Concluída]" : "[Pendente]") + " " + descricao;
    }
}

// Classe principal ListaDeTarefas
public class ListaDeTarefas {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    marcarTarefaComoConcluida();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n===== Lista de Tarefas =====");
        System.out.println("1. Adicionar nova tarefa");
        System.out.println("2. Listar todas as tarefas");
        System.out.println("3. Marcar tarefa como concluída");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            System.out.println("\n===== Tarefas =====");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    private static void marcarTarefaComoConcluida() {
        listarTarefas();
        if (!tarefas.isEmpty()) {
            System.out.print("Digite o número da tarefa que deseja marcar como concluída: ");
            int indice = scanner.nextInt() - 1;

            if (indice >= 0 && indice < tarefas.size()) {
                tarefas.get(indice).marcarComoConcluida();
                System.out.println("Tarefa marcada como concluída!");
            } else {
                System.out.println("Número inválido.");
            }
        }
    }
}
