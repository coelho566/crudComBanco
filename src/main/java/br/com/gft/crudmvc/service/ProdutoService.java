package br.com.gft.crudmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.crudmvc.model.Produto;
import br.com.gft.crudmvc.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repositor;
	
	public List<Produto> listAll(){
		return repositor.findAll();
	}
	
	public void save(Produto produto) {
		repositor.save(produto);
	}
	
	public Produto get(Long id) {
		return repositor.findById(id).get();
	}
	
	public void delete(Long id) {
		repositor.deleteById(id);
	}
}
