package br.senac.requestfood.service.additionalitem;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.addicionalitem.AdditionalItemDTO;
import br.senac.requestfood.exception.additionalitem.AdditionalItemNotFoundException;
import br.senac.requestfood.mapper.addicionalitem.AdditionalItemMapper;
import br.senac.requestfood.model.addicionalItem.AdditionalItem;
import br.senac.requestfood.projection.addicionalItem.AddicionalItemProjection;
import br.senac.requestfood.repository.addicionalitem.AdditionalItemRepository;

@Service
public class AdditionalItemServiceImpl implements AdditionalItemService{
	
	private final AdditionalItemRepository repository;
	private final AdditionalItemMapper mapper;
	
	public AdditionalItemServiceImpl(AdditionalItemRepository repository, AdditionalItemMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public AdditionalItemDTO save(AdditionalItemDTO additionalItemDTO) {

		AdditionalItem additionalItem = mapper.toEntity(additionalItemDTO);
		AdditionalItem additionalItemSaved = repository.save(additionalItem);
		
		return mapper.toDTO(additionalItemSaved);
	}

	public void update(AdditionalItemDTO additionalItemDTO, Long id) {

		AdditionalItem additionalItem = repository.findById(id).orElseThrow(() -> new AdditionalItemNotFoundException("Additional item"+ id +" was not found."));
		
		additionalItem.setNomeAdicional(additionalItemDTO.name());
		
		repository.save(additionalItem);
	}

	public void delete(Long id) {

		if (!repository.existsById(id))
			throw new AdditionalItemNotFoundException("Additional item"+ id +" was not found.");
			
		repository.deleteById(id);
	}

	public AddicionalItemProjection findById(Long id) {

		AddicionalItemProjection additionalItem = repository.findAdditionalItemById(id).orElseThrow(() -> new AdditionalItemNotFoundException("Additional item"+ id +" was not found."));
		
		return additionalItem;
	}

	public List<AddicionalItemProjection> findAll() {
		
		return repository.findAdditionalItens();
	}
}
