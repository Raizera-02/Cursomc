package com.rai.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rai.cursomc.domain.Categoria;
import com.rai.cursomc.domain.Cidade;
import com.rai.cursomc.domain.Cliente;
import com.rai.cursomc.domain.Endereco;
import com.rai.cursomc.domain.Estado;
import com.rai.cursomc.domain.ItemPedido;
import com.rai.cursomc.domain.Pagamento;
import com.rai.cursomc.domain.PagamentoComBoleto;
import com.rai.cursomc.domain.PagamentoComCartao;
import com.rai.cursomc.domain.Pedido;
import com.rai.cursomc.domain.Produto;
import com.rai.cursomc.domain.enums.EstadoPagamento;
import com.rai.cursomc.domain.enums.TipoCliente;
import com.rai.cursomc.repositories.CategoriaRepository;
import com.rai.cursomc.repositories.CidadeRepository;
import com.rai.cursomc.repositories.ClienteRepository;
import com.rai.cursomc.repositories.EnderecoRepository;
import com.rai.cursomc.repositories.EstadoRepository;
import com.rai.cursomc.repositories.ItemPedidoRepository;
import com.rai.cursomc.repositories.PagamentoRepository;
import com.rai.cursomc.repositories.PedidoRepository;
import com.rai.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateDatabase() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Infoamática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);
		Produto produto4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto produto5 = new Produto(null, "Toalha", 50.00);
		Produto produto6 = new Produto(null, "Colcha", 200.00);
		Produto produto7 = new Produto(null, "TV true color", 1200.00);
		Produto produto8 = new Produto(null, "Roçadeira", 800.00);
		Produto produto9 = new Produto(null, "Abajour", 100.00);
		Produto produto10 = new Produto(null, "Pendente", 180.00);
		Produto produto11 = new Produto(null, "Shampoo", 90.00);
		
		cat1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		cat2.getProdutos().addAll(Arrays.asList(produto2, produto4));
		cat3.getProdutos().addAll(Arrays.asList(produto5, produto6));
		cat4.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3, produto7));
		cat5.getProdutos().addAll(Arrays.asList(produto8));
		cat6.getProdutos().addAll(Arrays.asList(produto9, produto10));
		cat7.getProdutos().addAll(Arrays.asList(produto11));
		
		produto1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		produto2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		produto3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		produto4.getCategorias().addAll(Arrays.asList(cat2));
		produto5.getCategorias().addAll(Arrays.asList(cat3));
		produto6.getCategorias().addAll(Arrays.asList(cat3));
		produto7.getCategorias().addAll(Arrays.asList(cat4));
		produto8.getCategorias().addAll(Arrays.asList(cat5));
		produto9.getCategorias().addAll(Arrays.asList(cat6));
		produto10.getCategorias().addAll(Arrays.asList(cat6));
		produto11.getCategorias().addAll(Arrays.asList(cat7));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6, produto7, produto8, produto9, produto10, produto11));
		
		Estado estado1 = new Estado(null, "Bahia");
		Estado estado2 = new Estado(null, "Minas Gerais");
		
		Cidade cidade1 = new Cidade(null, "Porto Seguro", estado1);
		Cidade cidade2 = new Cidade(null, "Salvador", estado1);
		Cidade cidade3 = new Cidade(null, "Uberlandia", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1, cidade2));
		estado2.getCidades().addAll(Arrays.asList(cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		Cliente cliente1 = new Cliente(null, "Maria da Silva", "maria@hotmail.com", "56148998502", TipoCliente.PESSOAFISICA);
		
		cliente1.getTelefones().addAll(Arrays.asList("3233-3185", "3275-9246"));
		
		Endereco endereco1 = new Endereco(null, "Rua 1", "200", "casa 01", "Mirante", "40810000", cliente1, cidade1);
		Endereco endereco2 = new Endereco(null, "Rua serra", "879", "apt 305", "São Jorge", "38400302", cliente1, cidade3);
		
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1,endereco2));
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cliente1, endereco1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cliente1, endereco2);
		
		cliente1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido itp1 = new ItemPedido(ped1, produto1, 0.00, 1, 2000.00);
		ItemPedido itp2 = new ItemPedido(ped1, produto3, 0.00, 2, 80.00);
		ItemPedido itp3 = new ItemPedido(ped2, produto2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(itp1, itp2));
		ped2.getItens().addAll(Arrays.asList(itp3));
		
		produto1.getItens().addAll(Arrays.asList(itp1));
		produto2.getItens().addAll(Arrays.asList(itp3));
		produto3.getItens().addAll(Arrays.asList(itp2));
		
		itemPedidoRepository.saveAll(Arrays.asList(itp1, itp2, itp3));
	}
}
