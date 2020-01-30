package br.com.gft.crudmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.crudmvc.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
