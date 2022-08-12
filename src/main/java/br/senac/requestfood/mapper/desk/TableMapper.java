package br.senac.requestfood.mapper.desk;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.table.DeskDTO;
import br.senac.requestfood.model.table.Desk;

@Service
public class TableMapper {
    
	public DeskDTO toDTO(Desk desk) {
        return new DeskDTO(desk.getId(), desk.getEstablishment(), desk.getPassword(), desk.getLimitUserNumber(), desk.getComandas());
    }

    public Desk toEntity(DeskDTO tableDTO) {
        // Not completed, waiting response for Front-End
    	return null;
    }

    public List<DeskDTO> toDTO(List<Desk> tables) {

        final List<DeskDTO> tableDTOs = new ArrayList<>();

        for (Desk table : tables) {
            tableDTOs.add(toDTO(table));
        }

        return tableDTOs;
    }

    public List<Desk> toEntity(List<DeskDTO> deskDTOs) {

        final List<Desk> desks = new ArrayList<>();

        for (DeskDTO deskDTO : deskDTOs) {
            desks.add(toEntity(deskDTO));
        }

        return desks;
    }
}
