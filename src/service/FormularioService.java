package service;

import exceptions.*;

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
    private ArrayList<String> respostas = new ArrayList<>();
    private ArrayList<String> respostasEndereco = new ArrayList<>();

    public FormularioService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void lerFormulario() {
        int contadorLinha = 1;
        try {
            List<String> linhas = Files.readAllLines(pathFormulario);

            for (String linha : linhas) {
                System.out.println(linha);
                if (contadorLinha == 4) {
                    System.out.println("Endereço - Digite o nome da rua");
                    respostasEndereco.add(scanner.nextLine());
                    System.out.println("Endereço - Digite o número");
                    respostasEndereco.add(scanner.nextLine());
                    System.out.println("Endereço - Digite o nome do bairro");
                    respostasEndereco.add(scanner.nextLine());
                    System.out.println("Endereço - Digite o nome da cidade");
                    respostasEndereco.add(scanner.nextLine());
                } else {
                    respostas.add(scanner.nextLine());
                }
                switch (contadorLinha) {
                    case 1:
                        tratamentoNome(respostas.get(0));
                        break;
                    case 2:
                        tratamentoTipo(respostas.get(1));
                        break;
                    case 3:
                        tratamentoSexo(respostas.get(2));
                        break;
                    case 4:
                        tratamentoEndereco(respostasEndereco);
                        break;
                    case 5:
                        tratamentoIdade(respostas.get(3));
                        break;
                    case 6:
                        tratamentoPeso(respostas.get(4));
                        break;
                    case 7:
                        tratamentoRaca(respostas.get(5));
                        break;
                }
                contadorLinha++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private void tratamentoNome(String linha) throws NomePetInvalidoException {
        linha = linha.trim();
        if (linha.isEmpty()) {
            respostas.set(0, naoInformado);
        } else if (!linha.matches("[a-zA-Z ]+")) {
            throw new NomePetInvalidoException("O nome do pet deve ser composto somente por letras");
        } else if (!linha.matches("^\\p{L}+(\\s+\\p{L}+)+$")) {
            throw new NomePetInvalidoException("O nome do pet deve ser composto por nome e sobrenome");
        }
    }

    private void tratamentoTipo(String linha) throws TipoPetInvalidoException {
        linha = linha.trim();
        if (!linha.equals("Cachorro") && !linha.equals("Gato")) {
            throw new TipoPetInvalidoException("O tipo do pet deve ser 'Cachorro' ou 'Gato'");
        }
    }

    private void tratamentoSexo(String linha) throws SexoPetInvalidoException {
        linha = linha.trim();
        if (!linha.equals("Masculino") && !linha.equals("Feminino")) {
            throw new SexoPetInvalidoException("O sexo do pet deve ser 'Masculino' ou 'Feminino'");
        }
    }

    private void tratamentoEndereco(ArrayList<String> respostasEndereco) throws EnderecoPetInvalidoException {
        if (respostasEndereco.get(0).isEmpty() || respostasEndereco.get(2).isEmpty() || respostasEndereco.get(3).isEmpty()) {
            throw new EnderecoPetInvalidoException("O endereço do pet deve ser preenchido (rua, bairro e cidade)");
        }
        if (respostasEndereco.get(1).isEmpty()) {
            respostasEndereco.set(1, naoInformado);
        }
    }

    private void tratamentoIdade(String linha) throws IdadePetInvalidoException {
        float idade = Float.parseFloat(linha);
        linha = linha.replace(",", ".");
        if (linha.isEmpty()) {
            respostas.set(3, naoInformado);
        } else if (!linha.matches("^[\\d.]+$")) {
            throw new IdadePetInvalidoException("A idade do pet deve possuir apenas valores númericos");
        } else if (idade > 20) {
            throw new IdadePetInvalidoException("A idade do pet não pode ser maior que 20");
        } else if (idade < 1) {
            respostas.set(3, String.valueOf(idade / 12));
        }
    }

    private void tratamentoPeso(String linha) throws PesoPetInvalidoException {
        linha = linha.replace(",", ".");
        if (linha.isEmpty()) {
            respostas.set(4, naoInformado);
        } else if (!linha.matches("^[\\d.]+$")) {
            throw new PesoPetInvalidoException("O peso do pet deve possuir apenas valores númericos");
        } else if (Float.parseFloat(linha) < 0.5) {
            throw new PesoPetInvalidoException("O peso do pet deve ser maior que 0.5");
        } else if (Float.parseFloat(linha) > 60) {
            throw new PesoPetInvalidoException("O peso do pet deve ser menor que 60");
        }
    }

    private void tratamentoRaca(String linha) throws RacaPetInvalidoException {
        if (linha.isEmpty()) {
            respostas.set(5, naoInformado);
        } else if (!linha.matches("[a-zA-Z ]+")) {
            throw new RacaPetInvalidoException("A raça do pet não poderá usar números nem caracteres especiais");
        }

    }
}
