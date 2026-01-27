package service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuService {
    private final Scanner scanner;

    public MenuService(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public void iniciar(){
        int opcaoEscolhida = -1;
        System.out.println("Seja bem vindo ao sistema de cadastro de PETs CLI!");
        System.out.println("Digite o número com a opção desejada");
        do {
            lerMenu();
            opcaoEscolhida = opcaoEscolhida();
            System.out.println(opcaoEscolhida);
        } while (opcaoEscolhida != 6);
        System.out.println("Sistema encerrado com sucesso! Até mais!");
    }

    private void lerMenu(){
        System.out.println("1 - Cadastrar um novo pet");
        System.out.println("2 - Alterar os dados do pet cadastrado");
        System.out.println("3 - Deletar um pet cadastrado");
        System.out.println("4 - Listar todos os pets cadastrados");
        System.out.println("5 - Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6 - Sair");
    }

    private int opcaoEscolhida(){
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e){
            return -1;
        }

    }

}
