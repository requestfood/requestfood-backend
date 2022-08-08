package br.senac.requestfood.mapper.contato;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.contato.ContatoDTO;
import br.senac.requestfood.model.contato.Contato;

@Service
public class ContatoMapper {
	
	public ContatoDTO toDTO(Contato contato) {
		return new ContatoDTO(contato.getId(), contato.getTelefone(), contato.getEmail());
	}
	
	public Contato toEntity(ContatoDTO contatoDTO) {
		// Not completed, waiting response for Front-End
		return null;
	}
	
	public List<ContatoDTO> toDTO(List<Contato> contatos){
		
		final List<ContatoDTO> contatoDTOs = new ArrayList<>();
		
		for (Contato contato : contatos) {
			contatoDTOs.add(toDTO(contato));
		}
		
		return contatoDTOs;
	}
	
	public List<Contato> toEntity(List<ContatoDTO> contatoDTOs) {
		
		final List<Contato> contatos = new ArrayList<>();
		
		for (ContatoDTO contatoDTO : contatoDTOs) {
			contatos.add(toEntity(contatoDTO));
		}
		
		return contatos;
	}
}
