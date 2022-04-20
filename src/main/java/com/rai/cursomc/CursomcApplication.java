package com.rai.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rai.cursomc.domain.Categoria;
import com.rai.cursomc.domain.Cidade;
import com.rai.cursomc.domain.Cliente;
import com.rai.cursomc.domain.Endereco;
import com.rai.cursomc.domain.Estado;
import com.rai.cursomc.domain.Produto;
import com.rai.cursomc.domain.enums.TipoCliente;
import com.rai.cursomc.repositories.CategoriaRepository;
import com.rai.cursomc.repositories.CidadeRepository;
import com.rai.cursomc.repositories.ClienteRepository;
import com.rai.cursomc.repositories.EnderecoRepository;
import com.rai.cursomc.repositories.EstadoRepository;
import com.rai.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

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
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Infoamática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		cat2.getProdutos().addAll(Arrays.asList(produto2));	
		
		produto1.getCategorias().addAll(Arrays.asList(cat1));
		produto2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		produto3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		
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
	}

}
