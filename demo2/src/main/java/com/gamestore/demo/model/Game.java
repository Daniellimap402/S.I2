package com.gamestore.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Entity @Data
public class Game {
//Id, título, imagem, preço, número de vendas
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 50)
	@NotEmpty(message = "Insira um titulo")
	private String titulo; 
	
    @NotEmpty(message = "Insira uma imagem")
	private String imagem;
	
	@NotNull(message = "O preço não pode ser nulo")
	@Min(value = 10, message = "O preço tem que ser no minimo 10 reais")
	private int preco;
	
	@NotNull(message = "O numero de vendas não pode ser nulo")
	@Min(value = 1, message = "O numero de vendas tem que ser no minimo 1")
	private int numeroDeVendas;
}
