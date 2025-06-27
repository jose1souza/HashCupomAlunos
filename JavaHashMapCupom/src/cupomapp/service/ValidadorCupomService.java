package hash.service;

import hash.model.Cupom;
import hash.model.Venda;
import java.util.HashMap;
import java.util.HashSet;

public class ValidadorCupomService {

    private HashMap<String, Cupom> cuponsAtivos;
    private HashSet<String> cuponsProcessados = new HashSet<>();

    public HashMap<String, Cupom> getCuponsAtivos() {
        return cuponsAtivos;
    }

    public void addCupom(Cupom cupom) {
        if (this.cuponsAtivos == null) {
            this.cuponsAtivos = new HashMap<>();
        }
        this.cuponsAtivos.put(cupom.getCodigo(), cupom);
    }

    public HashSet<String> getCuponsProcessados() {
        return cuponsProcessados;
    }
    public void setCuponsAtivos(HashMap<String, Cupom> cuponsAtivos) {
        this.cuponsAtivos = cuponsAtivos;
    }


    public boolean validarCumpom(Venda venda) {
        System.out.println("----------------------------------------");
        System.out.printf("Validando Venda para Cliente ID: %d, Cupom: '%s'...\n", venda.getIdCliente(), venda.getCodigoCupom());

        // Se a venda não usa cupom.
        if (venda.getCodigoCupom() == null || venda.getCodigoCupom().isEmpty()) {
            System.out.println("Resultado: Venda sem cupom. Aprovada.");
            return false;
        }

        // 1. O cupom existe e está ativo no sistema? // return false se não existir
        Cupom meuCupom = cuponsAtivos.get(venda.getCodigoCupom());
        if(meuCupom == null){
            System.out.println("Cupom inválido");
            return false;
        }
        // 2. O cupom não está expirado? return false se expirado
        // a data ataul <= data cupom
      //  LocalDate dataAtual = LocalDate.now();
       // if(dataAtual.isAfter(meuCupom.getDataValidade())){
       //     return false;
     //   }

        // antes de aplicar o desconto, veja se não processou este cupom para o cliente
        cuponsProcessados.contains(venda.getIdCliente()+venda.getCodigoCupom());
        // aplica o desconto
        

        // processei o cupom para o cliente, agora armazena no set
        cuponsProcessados.add(venda.getIdCliente()+venda.getCodigoCupom());
        // 3. O cliente já usou este cupom ? return false se já usado


        // Se todas as validações passaram, o cupom é válido.
        // atualize o valor de valorFinalComDesconto da venda
        // Registre o uso do cupom neste momento.
        //cuponsProcessados.add id do cliente + cupom
        return true;
    }
    



}