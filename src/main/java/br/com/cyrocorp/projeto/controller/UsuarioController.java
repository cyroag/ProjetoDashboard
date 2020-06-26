package br.com.cyrocorp.projeto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cyrocorp.projeto.dao.UsuarioDAO;
import br.com.cyrocorp.projeto.model.Usuario;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ArrayList<Usuario> listarTudo(){
		ArrayList<Usuario> lista = (ArrayList<Usuario>)dao.findAll();
		return lista;
	}
	
	@PostMapping("/login")
	public Usuario login(@RequestBody Usuario userEmailSenha) {
		Usuario user = dao.findByEmailAndSenha(userEmailSenha.getEmail(), userEmailSenha.getSenha());
		return user;
	}

}
