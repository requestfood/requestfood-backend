package br.senac.requestfood.service.drink;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.bebida.BebidaDTO;
import br.senac.requestfood.exception.consumivel.ConsumivelNameRegisteredException;
import br.senac.requestfood.exception.consumivel.ConsumivelNotFoundException;
import br.senac.requestfood.mapper.bebida.BebidaMapper;
import br.senac.requestfood.model.consumivel.bebida.Bebida;
import br.senac.requestfood.projection.bebida.BebidaProjection;
import br.senac.requestfood.repository.bebida.BebidaRepository;

@Service
public class DrinkServiceImpl implements DrinkService{

	private final BebidaRepository repository;
	private final BebidaMapper mapper;

	public DrinkServiceImpl(BebidaRepository repository, BebidaMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public BebidaDTO save(BebidaDTO bebidaDTO) {

		if (repository.existsByName(bebidaDTO.nome()))
			throw new ConsumivelNameRegisteredException("Bebida " + bebidaDTO.nome() + " is already registered");

		Bebida drink = mapper.toEntity(bebidaDTO);
		Bebida drinkSaved = repository.save(drink);

		return mapper.toDTO(drinkSaved);
	}

	public void update(BebidaDTO bebidaDTO, Long id) {

		Bebida drink = repository.findById(id).orElseThrow(() -> new ConsumivelNotFoundException("Drink " + id + " was not found"));

		if (!repository.existsByName(bebidaDTO.nome()))
			throw new ConsumivelNameRegisteredException("Bebida " + bebidaDTO.nome() + " is already registered");

		drink.setEstabelecimento(bebidaDTO.estabelecimento());
		drink.setNome(bebidaDTO.nome());
		drink.setValor(bebidaDTO.valor());

		repository.save(drink);
	}

	public void delete(Long id) {

		if (!repository.existsById(id))
			throw new ConsumivelNotFoundException("Drink " + id + " was not found");

			repository.deleteById(id);
	}

	public BebidaProjection findById(Long id) {
		BebidaProjection bebida = repository.findDrinkById(id).orElseThrow(() -> new ConsumivelNotFoundException("Drink " + id + " was not found"));
		return bebida;
	}

	public List<BebidaProjection> findAll() {
		return repository.findDrinks();
	}
}
