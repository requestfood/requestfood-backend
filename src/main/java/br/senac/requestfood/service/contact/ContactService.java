package br.senac.requestfood.service.contact;

import java.util.List;

import br.senac.requestfood.dto.contato.ContatoDTO;
import br.senac.requestfood.projection.contato.ContatoProjection;

public interface ContactService {
	
	ContatoDTO save(ContatoDTO contactDTO);
	
	void update(ContatoDTO contactDTO, Long id);
	
	void delete(Long id);
	
	ContatoProjection findById(Long id);
	
	List<ContatoProjection> findAll();
}
