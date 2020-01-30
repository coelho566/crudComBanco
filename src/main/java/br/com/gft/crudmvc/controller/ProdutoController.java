package br.com.gft.crudmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.gft.crudmvc.model.Produto;
import br.com.gft.crudmvc.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Produto> listaProduto = service.listAll();
		model.addAttribute("listaProduto", listaProduto);
		
		return "index";
	}
	
	@RequestMapping("/novo")
	public String cadastrar(Model model) {
		Produto produto = new Produto();
		model.addAttribute("produto", produto);
		
		return "cadastro";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("produto") Produto produto) {
		service.save(produto);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro");
		Produto produto = service.get(id);
		mv.addObject("produto", produto);
		
		return mv;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
