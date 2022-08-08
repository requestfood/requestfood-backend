package br.senac.requestfood.service.additionalitem;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.itemadicional.ItemAdicionalDTO;
import br.senac.requestfood.exception.itemadicional.AdditionalItemNotFoundException;
import br.senac.requestfood.mapper.itemadicional.ItemAdicionalMapper;
import br.senac.requestfood.model.itemadicional.ItemAdicional;
import br.senac.requestfood.projection.itemAdicional.ItemAdicionalProjection;
import br.senac.requestfood.repository.itemadicional.ItemAdicionalRepository;

@Service
public class AdditionalItemServiceImpl implements AdditionalItemService{
	
	private final ItemAdicionalRepository repository;
	private final ItemAdicionalMapper mapper;
	
	public AdditionalItemServiceImpl(ItemAdicionalRepository repository, ItemAdicionalMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public ItemAdicionalDTO save(ItemAdicionalDTO additionalItemDTO) {

		ItemAdicional additionalItem = mapper.toEntity(additionalItemDTO);
		ItemAdicional additionalItemSaved = repository.save(additionalItem);
		
		return mapper.toDTO(additionalItemSaved);
	}

	public void update(ItemAdicionalDTO additionalItemDTO, Long id) {

		ItemAdicional additionalItem = repository.findById(id).orElseThrow(() -> new AdditionalItemNotFoundException("Additional item"+ id +" was not found."));
		
		additionalItem.setNomeAdicional(additionalItemDTO.nomeAdicional());
		
		repository.save(additionalItem);
	}

	public void delete(Long id) {

		if (!repository.existsById(id))
			throw new AdditionalItemNotFoundException("Additional item"+ id +" was not found.");
			
		repository.deleteById(id);
	}

	public ItemAdicionalProjection findById(Long id) {

		ItemAdicionalProjection additionalItem = repository.findAdditionalItemById(id).orElseThrow(() -> new AdditionalItemNotFoundException("Additional item"+ id +" was not found."));
		
		return additionalItem;
	}

	public List<ItemAdicionalProjection> findAll() {
		
		return repository.findAdditionalItens();
	}
	
	
}
