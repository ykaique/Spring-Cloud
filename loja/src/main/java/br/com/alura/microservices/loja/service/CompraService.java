package br.com.alura.microservices.loja.service;

import br.com.alura.microservices.loja.client.FornecedorClient;
import br.com.alura.microservices.loja.dto.CompraDTO;
import br.com.alura.microservices.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservices.loja.dto.InfoPedidoDTO;
import br.com.alura.microservices.loja.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDTO compra) {

        LOG.info("Buscando informações de {}", compra.getEndereco().getEstado());
        InfoFornecedorDTO info =
                fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

        LOG.info("Realizando um pedido");
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setEnderecoDeDestino(compra.getEndereco().toString());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        return compraSalva;
    }

}
