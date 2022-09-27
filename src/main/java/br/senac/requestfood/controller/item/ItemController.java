package br.senac.requestfood.controller.item;

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

import br.senac.requestfood.dto.item.ItemOrderDTO;
import br.senac.requestfood.projection.item.ItemProjection;
import br.senac.requestfood.service.item.ItemService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemOrderDTO> addItem(@RequestBody ItemOrderDTO itemDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(itemDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatedItem(@RequestBody ItemOrderDTO itemDTO, @PathVariable(value = "id") Long id) {
        itemService.update(itemDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Item updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedItem(@PathVariable(value = "id") Long id) {
        itemService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Item deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemProjection> getItem(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ItemProjection>> getAllItem() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findAll());
    }
}
