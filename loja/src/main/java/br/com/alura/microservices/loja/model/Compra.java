package br.com.alura.microservices.loja.model;

public class Compra {

    private Long pedidoId;
    private Integer tempoDePreparo;
    private String enderecoDestino;

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(Integer tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

    public String getEnderecoDeDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDeDestino(String enderecoDeDestino) {
        this.enderecoDestino = enderecoDeDestino;
    }
}
