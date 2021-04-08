package br.com.alura.mvc.mudi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repositories.PedidoRepository;

@EnableCaching
@SpringBootApplication
public class MudiApplication implements CommandLineRunner {

	@Autowired
	private PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MudiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pedido pedido = new Pedido();
		pedido.setNome("Xiaomi Redmi Note 8");
		pedido.setUrlImagem("https://http2.mlstatic.com/D_NQ_NP_2X_920977-MLA43915525858_102020-F.webp");
		pedido.setUrlProduto(
				"https://produto.mercadolivre.com.br/MLB-1726708542-xiaomi-redmi-note-8-dual-sim-64-gb-neptune-blue-4-gb-ram-_JM?matt_tool=84274024&matt_word=&matt_source=google&matt_campaign_id=12406821329&matt_ad_group_id=113343067330&matt_match_type=&matt_network=g&matt_device=c&matt_creative=500403102840&matt_keyword=&matt_ad_position=&matt_ad_type=pla&matt_merchant_id=283323489&matt_product_id=MLB1726708542&matt_product_partition_id=358100206005&matt_target_id=pla-358100206005&gclid=Cj0KCQjwrsGCBhD1ARIsALILBYqZpvXPXziukVnvlpd7uuqjUi2iK98hu3m1SoSNqnmRUy9phzObeDMaAntQEALw_wcB#&gid=1&pid=1");
		pedido.setDescricao("Uma descrição qualquer para este pedido");

		List<Pedido> pedidos = pedidoRepository.findAll();

		if (pedidos.isEmpty()) {
			pedidoRepository.save(pedido);
		} 
	}
}
