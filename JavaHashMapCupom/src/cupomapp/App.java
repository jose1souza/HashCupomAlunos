package cupomapp;

import cupomapp.model.Cupom;
import cupomapp.model.Venda;
import cupomapp.service.ValidadorCupomService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    static Scanner leia = new Scanner(System.in);
     public static HashMap<String, Cupom> carregarDeArquivo(String caminho) {
        HashMap<String, Cupom> cupons = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            boolean primeira = true;
            while ((linha = br.readLine()) != null) {
                if (primeira) {
                    primeira = false; // pula cabeçalho
                    continue;
                }
                String[] partes = linha.split(",");
                String id = partes[0];
                double desconto = Double.parseDouble(partes[1]);
                LocalDate validade = LocalDate.parse(partes[2]);
                cupons.put(id, new Cupom(id, desconto, validade));
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler cupons: " + e.getMessage());
        }
        System.err.println("Cupons carregados: " + cupons.size());
        return cupons;
    }

    static Venda lerVenda() {
        System.out.print("Digite o ID do Cliente: ");
        int idCliente = leia.nextInt();
        leia.nextLine(); // Limpa o buffer do scanner
        System.out.print("Digite o código do cupom (ou deixe em branco se não houver): ");
        String codigoCupom = leia.nextLine();
        System.out.println("Digite o valor original da venda: ");
        double valorOriginal = leia.nextDouble();
        leia.nextLine(); // Limpa o buffer do scanner
        System.out.println("Venda foi realizada hoje?");
        String resp = leia.nextLine();
        boolean vendaHoje = resp.equalsIgnoreCase("sim");
        LocalDate dataVenda;
        if (!vendaHoje) {
            System.out.print("Digite a data da venda (formato YYYY-MM-DD): ");
             dataVenda = LocalDate.parse(leia.nextLine());
        }else {
             dataVenda = LocalDate.now();
        }
    
        return new Venda(idCliente, valorOriginal, codigoCupom, dataVenda);
    }

    static int menu(){
        System.out.println("========================================");
        System.out.println("Menu de Validação de Cupons:");
        System.out.println("1. Validar Venda");
        System.out.println("2. Listar Cupons Ativos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = leia.nextInt();
        leia.nextLine(); // Limpa o buffer do scanner
        return opcao;
    }
    
    public static void main(String[] args) {
        ValidadorCupomService validador = new ValidadorCupomService();
        validador.setCuponsAtivos(carregarDeArquivo( "cupons.csv"));
        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    // realizar a venda e apresentar o valor após o desconto caso houver
                    break;
                case 2:
                    //
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Digite ENTER para continuar...");
            leia.nextLine();

        } while (opcao != 0);

        // --- RESULTADO FINAL ---
        // mostre todos os cupons processados e vendas realizadas
        System.out.println("========================================");
    }
}
