package com.gamestore.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamestore.demo.model.Game;
import com.gamestore.demo.model.Response;
import com.gamestore.demo.repository.GameRepository;

@RestController
public class GameController {

	@Autowired
	private GameRepository gameRepository;
	
	@GetMapping(value = "/game")
	public ResponseEntity<Response<List<Game>>> listarGames() 
	{
		Response<List<Game>> response = new Response<List<Game>>();
		List<Game> listaGames = gameRepository.findAll();
		response.setData(listaGames);
		response.setStatus(HttpStatus.OK.value());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/game/{id}")
	public ResponseEntity<Response<Optional<Game>>> obterGame(@PathVariable Integer id) 
	{
		Response<Optional<Game>> response = new Response<Optional<Game>>();
		Optional<Game> game = gameRepository.findById(id);
		if (!game.isPresent()) {
			response.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			response.setData(game);
			response.setStatus(HttpStatus.OK.value());	
		}
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping(value = "/game/{id}")
	public ResponseEntity<Response<Game>> modificarGame( @PathVariable(value = "id") int id, @Valid @RequestBody Game newGame, BindingResult result) 
	{
		Response<Game> response = new Response<Game>();
		if(result.hasErrors())
		{
			for (ObjectError error : result.getAllErrors()) 
			{
				String key = String.valueOf(response.getErrors().size()+1);
				response.getErrors().put(key, error.getDefaultMessage());
			}
			return ResponseEntity.ok(response);
		}
		Optional<Game> oldGame= gameRepository.findById(id);
		if (oldGame.isPresent()) {
			Game game = oldGame.get();
			game.setTitulo(newGame.getTitulo());
			game.setImagem(newGame.getImagem());
			game.setNumeroDeVendas(newGame.getNumeroDeVendas());
			game.setPreco(newGame.getPreco());
			gameRepository.save(game);
			response.setData(game);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(response);
		} else
			response.setStatus(HttpStatus.NOT_FOUND.value());
			return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/game")
	public ResponseEntity<Response<Game>> addGame(@Valid @RequestBody Game game, BindingResult result) 
	{
		Response<Game> response = new Response<Game>();
		if(result.hasErrors())
		{
			for (ObjectError error : result.getAllErrors()) 
			{
				String key = String.valueOf(response.getErrors().size()+1);
				response.getErrors().put(key, error.getDefaultMessage());
			}
			return ResponseEntity.ok(response);
		}
		gameRepository.save(game);
		response.setData(game);
		response.setStatus(HttpStatus.OK.value());
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping(value = "/game/{id}")
	public ResponseEntity<Response<Game>> deletarGame(@PathVariable Integer id) 
	{
		Response<Game> response = new Response<Game>();
		if (!gameRepository.existsById(id))
			response.setStatus(HttpStatus.NOT_FOUND.value());
		else {
			gameRepository.deleteById(id);
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value = "/game/venda/{id}")
	public ResponseEntity<Response<Game>> venderGame(@PathVariable(value = "id") int id)
	{
		Response<Game> response = new Response<Game>();
		Optional<Game> oldGame= gameRepository.findById(id);
		if(oldGame.isPresent())
		{
			Game game = oldGame.get();
			int numeroDeVendas = game.getNumeroDeVendas();
			game.setNumeroDeVendas(numeroDeVendas+1);
			gameRepository.save(game);
			response.setData(game);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(response);
		}
		else 
		{
			response.setStatus(HttpStatus.NOT_FOUND.value());
			return ResponseEntity.ok(response);
		}
		
	}
}
