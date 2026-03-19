package exercicio03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static Bilhete_Unico[] bilhete = new Bilhete_Unico[3];
    static Scanner sc = new Scanner(System.in);
    static int index = 0;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("[1] Cadastrar bilhete");
            System.out.println("[2] Carregar bilhete");
            System.out.println("[3] Consultar saldo");
            System.out.println("[4] Passar na catraca");
            System.out.println("[5] Finalizar");
            opcao = sc.nextInt();

            switch(opcao) {
                case 1 -> cadastrar();
                case 2 -> carregar();
                case 3 -> consultarSaldo();
                case 4 -> passarCatraca();
                case 5 -> System.out.println("Até breve!");
                default -> System.out.println("Opção inválida!");
            }

        } while(opcao != 5);

    }

    private static void passarCatraca() {
        Bilhete_Unico bilheteUnico = pesquisar();
        if (bilheteUnico != null){
            if (bilheteUnico.passarNaCatraca() == false){
                System.out.println("Saldo insuficiente!");
            }
            System.out.println("Saldo atual R$ " + bilheteUnico.saldo);
        }
    }

    private static void consultarSaldo() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        Bilhete_Unico bilheteUnico = pesquisar();
        if (bilheteUnico != null) {
            System.out.println("Saldo atual: R$ " + df.format(bilheteUnico.saldo));
        }
    }

    private static void carregar() {
        double valor;
        Bilhete_Unico bilheteUnico = pesquisar();
        if (bilheteUnico != null){
            System.out.println("Qual o valor da recarga?");
            valor = sc.nextDouble();

            bilheteUnico.carregar(valor);
        }
    }

    private static void cadastrar() {
        String nome;
        long cpf;
        String tipoTarifa;

        if(index < bilhete.length) {
            System.out.print("Nome do usuário: ");
            nome = sc.next();
            System.out.print("CPF: ");
            cpf = sc.nextLong();
            System.out.print("Tipo de tarifa (estudante | professor | comum): ");
            tipoTarifa = sc.next();
            bilhete[index] = new Bilhete_Unico(new Usuario(nome, cpf, tipoTarifa));
            index++;
        }
        else {
            System.out.println("Erro ao gerar o bilhete! Procure um posto de atendimento");
        }
    }

    public static Bilhete_Unico pesquisar() {
        long cpf;
        System.out.print("Qual o CPF para pesquisa? ");
        cpf = sc.nextLong();
        for(int i = 0; i < index; i++) {
            if(bilhete[i].usuario.cpf == cpf) {
                return bilhete[i];
            }
        }
        System.out.println("CPF não encontrado");
        return null;
    }
}