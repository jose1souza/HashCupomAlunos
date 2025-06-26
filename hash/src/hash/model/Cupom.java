package hash.model;

import java.time.LocalDate;
public class Cupom {
    private final String codigo;
    private final double percentualDesconto;
    private final LocalDate dataValidade;

    public Cupom(String codigo, double percentualDesconto, LocalDate dataValidade) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
        this.dataValidade = dataValidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    @Override
    public boolean equals(Object outroCupom) {
        if (this == outroCupom) return true;
        if (!(outroCupom instanceof Cupom)) return false;

        Cupom cupom = (Cupom) outroCupom;
        if (!codigo.equals(cupom.codigo)) return false;
        return dataValidade.equals(cupom.dataValidade);
    }

    @Override
    public int hashCode() {
        int result = codigo.hashCode()+ dataValidade.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "codigo='" + codigo + '\'' +
                ", desconto=" + percentualDesconto +
                ", validade=" + dataValidade +
                '}';
    }
}