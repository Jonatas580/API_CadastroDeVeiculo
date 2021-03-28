package com.cadasto.veiculos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cadasto.veiculos.model.Veiculo;
import com.cadasto.veiculos.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	
	private static VeiculoRepository veiculoRepository;
	
	public VeiculoService(VeiculoRepository veiculoRepository) {
			this.veiculoRepository = veiculoRepository;
	}
	
	public void cadastra (Veiculo veiculo) {
		veiculoRepository.save(veiculo);
	}

	
	public List<Veiculo> buscar(){
		return veiculoRepository.findAll();
	}
	
	public void delete(Long id) {
		if(veiculoRepository.findById(id).isPresent());
			veiculoRepository.deleteById(id);
	}
	
	public static  Veiculo alterar (Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	public static Veiculo alterarMarca (Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	
	
}
