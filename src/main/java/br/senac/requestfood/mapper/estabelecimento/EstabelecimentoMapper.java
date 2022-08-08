package br.senac.requestfood.mapper.estabelecimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.estabelecimento.EstabelecimentoDTO;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

@Service
public class EstabelecimentoMapper {
	
	public EstabelecimentoDTO toDTO(Estabelecimento estabelecimento) {
		return new EstabelecimentoDTO(estabelecimento.getId(), estabelecimento.getNome(), estabelecimento.getContato(),estabelecimento.getConsumiveis(), estabelecimento.getMesas());
	}
	
	public Estabelecimento toEntity(EstabelecimentoDTO estabelecimentoDTO) {
	//Not Completed, waiting response for Front-End
		return null;
	}

	public List<EstabelecimentoDTO> toDTO(List<Estabelecimento> estabelecimentos){
		
		final List<EstabelecimentoDTO> estabelecimentoDTOs = new ArrayList<>();
		
		for (Estabelecimento estabelecimento : estabelecimentos) {
			estabelecimentoDTOs.add(toDTO(estabelecimento));
		}
		
		return estabelecimentoDTOs;
	}
	
	public List<Estabelecimento> toEntity(List<EstabelecimentoDTO> estabelecimentoDTOs) {
		
		final List<Estabelecimento> estabelecimentos= new ArrayList<>();
		
		for (EstabelecimentoDTO estabelecimentoDTO : estabelecimentoDTOs) {
			estabelecimentos.add(toEntity(estabelecimentoDTO));
		}
		
		return estabelecimentos;
	}
}
