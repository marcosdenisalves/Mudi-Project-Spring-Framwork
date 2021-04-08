package br.com.alura.mvc.mudi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.enums.StatusPedido;
import br.com.alura.mvc.mudi.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	public List<Pedido> findByStatus(StatusPedido status, PageRequest page) {
		return pedidoRepository.findByStatus(status, page);
	}

	public List<Pedido> findAllByUsuario(String username) {
		return pedidoRepository.findAllByUsuario(username);
	}

	public void save(Pedido pedido) {
		pedido.setNome(SecurityContextHolder.
				getContext().getAuthentication().getName());
		
		pedidoRepository.save(pedido);
	}

	public List<Pedido> findByStatusAndUser(StatusPedido status, String name) {
		return pedidoRepository.findByStatusAndUser(status, name);
	}
}
