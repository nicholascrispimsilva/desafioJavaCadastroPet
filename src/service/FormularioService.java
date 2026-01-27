package service;

import exceptions.NomePetInvalidoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormularioService {
    private final Path pathFormulario = Paths.get("formulario.txt");
    private final Scanner scanner;
    private final String naoInformado = "NÃO INFORMADO";

    public FormularioService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void lerFormulario(){
        ArrayList<String> respostas = new ArrayList<>();
        int contadorLinha = 1;
        try {
            List<String> linhas = Files.readAllLines(pathFormulario);

            for (String linha : linhas) {
                System.out.println(linha);
                respostas.add(scanner.nextLine());
                switch (contadorLinha){
                    case 1:
                        tratamentoNome(respostas.get(0));
                        break;
                    case 2:
                        tratamentoTipo(respostas.get(1));
                        break;
                }

            }
            contadorLinha++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NomePetInvalidoException e){

        }
    }

    private void tratamentoNome(String linha) throws NomePetInvalidoException {
        if (linha.isEmpty() == true){
            linha = naoInformado;
        } else if (linha.matches("a-zA-Z")) {
            throw new NomePetInvalidoException("O nome do pet deve ser composto somente por letras");
        } else if (linha.split(" ").length < 2){
            throw new NomePetInvalidoException("O nome do pet deve ser composto por nome e sobrenome");

        }
    }

    private void tratamentoTipo(String linha) throws NomePetInvalidoException {
        if (linha.isEmpty() == true){
            linha = naoInformado;
        } else if (linha.matches("a-zA-Z")) {
            throw new NomePetInvalidoException("O nome do pet deve ser composto somente por letras");
        } else if (linha.split(" ").length > 1){
            throw new NomePetInvalidoException("O nome do pet deve ser composto por nome e sobrenome");

        }
    }
}
