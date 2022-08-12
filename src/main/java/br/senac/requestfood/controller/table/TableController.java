package br.senac.requestfood.controller.table;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.requestfood.dto.table.DeskDTO;
import br.senac.requestfood.projection.desk.DeskProjection;
import br.senac.requestfood.service.desk.DeskService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/table")
public class TableController {

    private final DeskService deskService;

    public TableController(DeskService deskService) {
        this.deskService = deskService;
    }

    @PostMapping
    public ResponseEntity<DeskDTO> desk(@RequestBody DeskDTO deskDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(deskService.save(deskDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatedDesk(@RequestBody DeskDTO deskDTO, @PathVariable(value = "id") Long id) {
        deskService.update(deskDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Table updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedDesk(@PathVariable(value = "id") Long id) {
        deskService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Table deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeskProjection> getDesk(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(deskService.findById(id));
    }

    @GetMapping()
	public ResponseEntity<List<DeskProjection>> getAllDesk() {
		return ResponseEntity.status(HttpStatus.OK).body(deskService.findAll());
	}
}
