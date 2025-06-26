package hash.model;
import java.time.LocalDate;

public class Venda {
    private final int idCliente;
    private final String codigoCupom;
    private final LocalDate dataVenda;
    private final double valorOriginal;
    private double valorFinalComDesconto;



    public Venda(int idCliente, double valorOriginal, String codigoCupom, LocalDate dataVenda) {
        this.idCliente = idCliente;
        this.valorOriginal = valorOriginal;
        this.valorFinalComDesconto = this.valorOriginal;
        this.codigoCupom = codigoCupom;
        this.dataVenda = dataVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getCodigoCupom() {
        return codigoCupom;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    
    public double getValorFinalComDesconto() {
        return valorFinalComDesconto;
    }

    public void setValorFinalComDesconto(double valorFinalComDesconto) {
        this.valorFinalComDesconto = valorFinalComDesconto;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "idCliente=" + idCliente +
                ", codigoCupom='" + codigoCupom + '\'' +
                ", dataVenda=" + dataVenda +
                ", valorOriginal=" + valorOriginal +
                '}';
    }

}