package br.senac.requestfood.service.item;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.item.ItemOrderDTO;
import br.senac.requestfood.exception.item.ItemNotFoundException;
import br.senac.requestfood.mapper.item.ItemMapper;
import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.projection.item.ItemProjection;
import br.senac.requestfood.repository.item.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

	private final ItemRepository repository;
	private final ItemMapper mapper;

	public ItemServiceImpl(ItemRepository repository, ItemMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public ItemOrderDTO save(ItemOrderDTO itemDTO) {
		
		Item item = mapper.toEntity(itemDTO); 
		Item itemSaved = repository.save(item);
		
		return mapper.toDTO(itemSaved);
	}

	public void update(ItemOrderDTO itemDTO, Long id) {
		
		Item item = repository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item "+ id +" was not found"));		
		
		item.setQuantity(itemDTO.quantityItem());
		item.setObservation(itemDTO.obsItem());
	}

	public void delete(Long id) {
		
		if(!repository.existsById(id))
			throw new ItemNotFoundException("Item "+ id +" was not found");
		
		repository.deleteById(id);
	}

	public ItemProjection findById(Long id) {

		ItemProjection item = repository.findItemById(id).orElseThrow(() -> new ItemNotFoundException("Item " + id + " was not found"));
		return item;
	}

	public List<ItemProjection> findAll() {
		return repository.findItems();
	}
}
