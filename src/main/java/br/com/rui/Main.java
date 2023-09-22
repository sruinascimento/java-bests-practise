package br.com.rui;

import br.com.rui.cliente.ClientHttpConfiguration;
import br.com.rui.service.AbrigoService;
import br.com.rui.service.PetService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            AbrigoService abrigoService = new AbrigoService(new ClientHttpConfiguration());
            PetService petService = new PetService(new ClientHttpConfiguration());
            int opcaoEscolhida = 0;

            while (opcaoEscolhida != 5) {
                System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
                System.out.println("1 -> Listar abrigos cadastrados");
                System.out.println("2 -> Cadastrar novo abrigo");
                System.out.println("3 -> Listar pets do abrigo");
                System.out.println("4 -> Importar pets do abrigo");
                System.out.println("5 -> Sair");

                String textoDigitado = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                if (opcaoEscolhida == 1) {
                    abrigoService.listarAbrigos();
                } else if (opcaoEscolhida == 2) {
                    abrigoService.cadastrarAbrigo();
                } else if (opcaoEscolhida == 3) {
                    petService.listarPets();
                } else if (opcaoEscolhida == 4) {
                   petService.importarPets();
                } else if (opcaoEscolhida == 5) {
                    break;
                } else {
                    System.out.println("NÚMERO INVÁLIDO!");
                    opcaoEscolhida = 0;
                }
            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}