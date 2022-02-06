package br.com.alura.microservices.loja.client;

import br.com.alura.microservices.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservices.loja.dto.ItemDaCompraDTO;
import br.com.alura.microservices.loja.dto.InfoPedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

    @PostMapping("/pedido")
    InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
}
