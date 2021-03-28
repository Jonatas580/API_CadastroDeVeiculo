package com.cadasto.veiculos.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "db_veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	@Column
	private String nome;
	@Column
	private String marca;
	@Column
	private Integer ano;
	@Column
	private String descricao;
	@Column
	private Boolean vendido;
	@Column
	private LocalDate created;
	@Column
	private LocalDate update;
	
}
