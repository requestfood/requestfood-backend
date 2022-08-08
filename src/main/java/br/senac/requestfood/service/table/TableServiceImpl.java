package br.senac.requestfood.service.table;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.mesa.MesaDTO;
import br.senac.requestfood.exception.mesa.TableNotFoundException;
import br.senac.requestfood.mapper.mesa.MesaMapper;
import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.projection.mesa.TableProjection;
import br.senac.requestfood.projection.mesa.TableWithCommandProjection;
import br.senac.requestfood.repository.mesa.MesaRepository;

@Service
public class TableServiceImpl implements TableService{

	private final MesaRepository repository;
	private final MesaMapper mapper;

	public TableServiceImpl(MesaRepository repository, MesaMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public MesaDTO save(MesaDTO mesaDTO) {
		
		Mesa mesa = mapper.toEntity(mesaDTO);
		Mesa mesaSaved = repository.save(mesa);
		
		return mapper.toDTO(mesaSaved);
	}

	public void update(MesaDTO mesaDTO, Long id) {
		
		Mesa mesa = repository.findById(id).orElseThrow(() -> new TableNotFoundException("Table " + id + "was not found"));
	
		mesa.setLimitUserNumber(mesaDTO.limitUserNumber());
		mesa.setPassword(mesaDTO.password());
	}

	public void delete(Long id) {
		
		if (!repository.existsById(id))
			throw new TableNotFoundException("Table " + id + "was not found");
	
		repository.deleteById(id);
	}

	public boolean TableLimitUserNumber(Long id) {

		TableProjection table = repository.findTableById(id).orElseThrow(() -> new TableNotFoundException("Table " + id + " was not found" ));
		List<Comanda> comandas = table.getComandas();
		int contagem = 0;
		
		for (Comanda comanda : comandas) {
			contagem++;
		}
		
		if(contagem == table.getLimitUserNumber()) {
			throw new TableNotFoundException("limit number of commands reached");
		}

		return true;
	}
	
	public TableProjection findById(Long id) {
		TableProjection table = repository.findTableById(id).orElseThrow(() -> new TableNotFoundException("Table " + id + " was not found" ));
		return table;
	}

	public TableWithCommandProjection findCommandById(Long id) {
		TableWithCommandProjection table = repository.findTableWithCommandById(id).orElseThrow(() -> new TableNotFoundException("Table " + id + " was not found"));
		return table;
	}

	public List<TableProjection> findAll() {
		return repository.findTables();
	}
}
