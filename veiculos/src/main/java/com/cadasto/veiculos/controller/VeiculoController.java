package com.cadasto.veiculos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cadasto.veiculos.model.Veiculo;
import com.cadasto.veiculos.repository.VeiculoRepository;
import com.cadasto.veiculos.service.VeiculoService;

@Controller
@RequestMapping("api/v1/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private VeiculoService veiculoService;

	@PostMapping("/cadastro")
	public ResponseEntity<Veiculo> cadastro(@RequestBody Veiculo veiculo) {
		veiculoService.cadastra(veiculo);
		return ResponseEntity.ok().body(null);
	}

	@GetMapping("/buscar")
	public ResponseEntity<List<Veiculo>> buscar() {
		List<Veiculo> buscar = veiculoService.buscar();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(buscar);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		veiculoService.delete(id);
	}

	@PutMapping("/alterar/{id}")
	public ResponseEntity<Veiculo> alterar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
		Optional<Veiculo> veiculoOpt = veiculoRepository.findById(id);
		if (veiculoOpt.isPresent()) {
			veiculo.setId(id); 
			return ResponseEntity.status(HttpStatus.OK).body(VeiculoService.alterar(veiculo));
		} else {
			return (ResponseEntity<Veiculo>) ResponseEntity.status(HttpStatus.NOT_FOUND);
			
		}

	}
	
	@PatchMapping("/alterarMarca/{id}")
	public ResponseEntity <Veiculo> alterarMarca (@PathVariable Long id, @RequestBody Veiculo veiculo){
		Optional <Veiculo> veiculoOpt = veiculoRepository.findById(id);
		if(veiculoOpt.isPresent()) {
			Veiculo veiculoDoBanco = veiculoOpt.get();  
			veiculoDoBanco.setMarca(veiculo.getMarca());
			return ResponseEntity.status(HttpStatus.OK).body(VeiculoService.alterarMarca(veiculoDoBanco));
		}else {
			return (ResponseEntity<Veiculo>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
	}

}
