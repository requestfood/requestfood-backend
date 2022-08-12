package br.senac.requestfood.service.desk;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.table.DeskDTO;
import br.senac.requestfood.exception.table.DeskNotFoundException;
import br.senac.requestfood.mapper.desk.TableMapper;
import br.senac.requestfood.model.command.Command;
import br.senac.requestfood.model.table.Desk;
import br.senac.requestfood.projection.desk.DeskProjection;
import br.senac.requestfood.projection.desk.DeskWithCommandProjection;
import br.senac.requestfood.repository.desk.DeskRepository;

@Service
public class DeskServiceImpl implements DeskService{

	private final DeskRepository repository;
	private final TableMapper mapper;

	public DeskServiceImpl(DeskRepository repository, TableMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public DeskDTO save(DeskDTO mesaDTO) {
		
		Desk mesa = mapper.toEntity(mesaDTO);
		Desk mesaSaved = repository.save(mesa);
		
		return mapper.toDTO(mesaSaved);
	}

	public void update(DeskDTO mesaDTO, Long id) {
		
		Desk mesa = repository.findById(id).orElseThrow(() -> new DeskNotFoundException("Table " + id + "was not found"));
	
		mesa.setLimitUserNumber(mesaDTO.limitUserNumber());
		mesa.setPassword(mesaDTO.password());
	}

	public void delete(Long id) {
		
		if (!repository.existsById(id))
			throw new DeskNotFoundException("Table " + id + "was not found");
	
		repository.deleteById(id);
	}

	public boolean TableLimitUserNumber(Long id) {

		DeskProjection desk = repository.findDeskById(id).orElseThrow(() -> new DeskNotFoundException("Desk " + id + " was not found" ));
		List<Command> commands = desk.getComandas();
		int cont = 0;
		
		for (Command commads : commands) {
			cont++;
		}
		
		if(cont == desk.getLimitUserNumber()) {
			throw new DeskNotFoundException("limit number of commands reached");
		}

		return true;
	}
	
	public DeskProjection findById(Long id) {
		DeskProjection table = repository.findDeskById(id).orElseThrow(() -> new DeskNotFoundException("Desk " + id + " was not found" ));
		return table;
	}

	public DeskWithCommandProjection findCommandById(Long id) {
		DeskWithCommandProjection desk = repository.findDeskWithCommandById(id).orElseThrow(() -> new DeskNotFoundException("Desk " + id + " was not found"));
		return desk;
	}

	public List<DeskProjection> findAll() {
		return repository.findTables();
	}
}
