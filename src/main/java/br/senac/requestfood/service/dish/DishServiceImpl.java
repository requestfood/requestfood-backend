package br.senac.requestfood.service.dish;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.prato.PratoDTO;
import br.senac.requestfood.exception.consumivel.ConsumivelNameRegisteredException;
import br.senac.requestfood.exception.consumivel.ConsumivelNotFoundException;
import br.senac.requestfood.mapper.prato.PratoMapper;
import br.senac.requestfood.model.consumivel.prato.Prato;
import br.senac.requestfood.projection.prato.PratoProjection;
import br.senac.requestfood.repository.prato.PratoRepository;

@Service
public class DishServiceImpl implements DishService{

	private final PratoRepository repository;
	private final PratoMapper mapper;
	
	public DishServiceImpl(PratoRepository repository, PratoMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public PratoDTO save(PratoDTO dishDTO) {
	
		if (repository.existsByName(dishDTO.nome()))
			throw new ConsumivelNameRegisteredException("Prato " + dishDTO.nome() + " is already registered");

		Prato dish = mapper.toEntity(dishDTO);
		Prato dishSaved = repository.save(dish);

		return mapper.toDTO(dishSaved);
	}

	public void update(PratoDTO dishDTO, Long id) {
		
		Prato dish = repository.findById(id).orElseThrow(() -> new ConsumivelNotFoundException("Dish " + id + " was not found"));

		if (!repository.existsByName(dishDTO.nome()))
			throw new ConsumivelNameRegisteredException("Dish " + dishDTO.nome() + " is already registered");

		dish.setNome(dishDTO.nome());
		dish.setEstabelecimento(dishDTO.estabelecimento());
		dish.setValor(dishDTO.valor());

		repository.save(dish);
	}

	public void delete(Long id) {

		if (!repository.existsById(id))
			throw new ConsumivelNotFoundException("Dish " + id + " was not found");

			repository.deleteById(id);
	}

	public PratoProjection findById(Long id) {
		PratoProjection dish = repository.findDishById(id).orElseThrow(() -> new ConsumivelNotFoundException("Dish " + id + " was not found"));
		return dish;
	}

	public List<PratoProjection> findAll() {
		return repository.findDishes();
	}
}
