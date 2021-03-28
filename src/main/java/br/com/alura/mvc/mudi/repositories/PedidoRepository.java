package br.com.alura.mvc.mudi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.enums.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	List<Pedido> findByStatus(StatusPedido aguardando);
}
