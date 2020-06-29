package br.com.cyrocorp.projeto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cyrocorp.projeto.dao.UsuarioDAO;
import br.com.cyrocorp.projeto.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ArrayList<Usuario> listarTudo(){
		ArrayList<Usuario> lista = (ArrayList<Usuario>)dao.findAll();
		return lista;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario incompleto) {
		
		Usuario resultado = dao.findByRacfOrEmail(incompleto.getRacf(), incompleto.getEmail());
		if(resultado != null) {
			if(incompleto.getSenha().contentEquals(resultado.getSenha())) {
				resultado.setSenha("*******");
				return ResponseEntity.ok(resultado);
			}
			else {
				return ResponseEntity.status(403).build();
			}
		}
		else {
			return ResponseEntity.status(404).build();
		}
	}
}
