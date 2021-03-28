package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.enums.StatusPedido;
import br.com.alura.mvc.mudi.services.PedidoService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public String home(Model model) {
		List<Pedido> pedidos = pedidoService.findAll();
		model.addAttribute("pedidos", pedidos);

		return "home";
	}

	@GetMapping("/{status}")
	public String aguardando(@PathVariable("status") String status, Model model) {
		List<Pedido> pedidos = pedidoService.
				findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
