package service;


import java.util.Scanner;

public class MenuService {
    private final Scanner scanner;
    private final FormularioService formularioService;

    public MenuService(Scanner scanner, FormularioService formularioService) {
        this.formularioService = formularioService;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcaoEscolhida;
        System.out.println("Seja bem vindo ao sistema de cadastro de PETs CLI!");
        System.out.println("Digite o número com a opção desejada");
        do {
            lerMenu();
            opcaoEscolhida = lerOpcao();
            processaOpcao(opcaoEscolhida);
        } while (opcaoEscolhida != 6);
        System.out.println("Sistema encerrado com sucesso! Até mais!");
    }

    private void lerMenu() {
        System.out.println("1 - Cadastrar um novo pet");
        System.out.println("2 - Alterar os dados do pet cadastrado");
        System.out.println("3 - Deletar um pet cadastrado");
        System.out.println("4 - Listar todos os pets cadastrados");
        System.out.println("5 - Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6 - Sair");
    }

    private int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return -1;
        }

    }

    private void processaOpcao(int opcao) {
        switch (opcao) {
            case 1:
                formularioService.lerFormulario();
                break;
            case 2:
                System.out.println("case 1");
                break;
            case 3:
                System.out.println("case 1");
                break;
            case 4:
                System.out.println("case 1");
                break;
            case 5:
                System.out.println("case 1");
                break;
            default:
                System.out.println("Opção Inválida, tente novamente");
        }
    }

}
