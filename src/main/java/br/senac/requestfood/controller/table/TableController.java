package br.senac.requestfood.controller.table;

import br.senac.requestfood.dto.mesa.MesaDTO;
import br.senac.requestfood.projection.mesa.TableProjection;
import br.senac.requestfood.service.table.TableService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/table")
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping
    public ResponseEntity<MesaDTO> table(@RequestBody MesaDTO tableDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tableService.save(tableDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatedTable(@RequestBody MesaDTO tableDTO, @PathVariable(value = "id") Long id) {
        tableService.update(tableDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Table updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedTable(@PathVariable(value = "id") Long id) {
        tableService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Table deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableProjection> getTable(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(tableService.findById(id));
    }

    @GetMapping()
	public ResponseEntity<List<TableProjection>> getAllDesk() {
		return ResponseEntity.status(HttpStatus.OK).body(tableService.findAll());
	}
}
