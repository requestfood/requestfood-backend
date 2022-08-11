package br.senac.requestfood.controller.item;

import br.senac.requestfood.dto.item.ItemDTO;
import br.senac.requestfood.projection.item.ItemProjection;
import br.senac.requestfood.service.item.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemDTO> item(@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(itemDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatedItem(@RequestBody ItemDTO itemDTO, @PathVariable(value = "id") Long id) {
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
}
