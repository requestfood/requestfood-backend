package br.senac.requestfood.mapper.mesa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.mesa.MesaDTO;
import br.senac.requestfood.model.mesa.Mesa;

@Service
public class MesaMapper {
    public MesaDTO toDTO(Mesa mesa) {
        return new MesaDTO(mesa.getId(), mesa.getEstabelecimento(), mesa.getPassword(), mesa.getLimitUserNumber(), mesa.getComandas());
    }

    public MesaDTO toEntity(MesaDTO mesaDTO) {
        // Not completed, waiting response for Front-End
    	return null;
    }

    public List<MesaDTO> toDTO(List<Mesa> mesas) {

        final List<MesaDTO> mesaDTOs = new ArrayList<>();

        for (Mesa mesa : mesas) {
            mesaDTOs.add(toDTO(mesa));
        }

        return mesaDTOs;
    }

    public List<Mesa> toEntity(List<MesaDTO> mesaDTOs) {

        final List<Mesa> mesas = new ArrayList<>();

        for (MesaDTO mesaDTO : mesaDTOs) {
            // contatos.add(toEntity(contatoDTO));
        }

        return mesas;
    }
}
