package br.senac.requestfood.controller.dish;


import br.senac.requestfood.dto.prato.PratoDTO;
import br.senac.requestfood.projection.prato.PratoProjection;
import br.senac.requestfood.service.dish.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/dish")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping
    public ResponseEntity<PratoDTO> dish(@RequestBody PratoDTO additionalItemDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dishService.save(additionalItemDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatedDish(@RequestBody PratoDTO pratoDTO, @PathVariable(value = "id") Long id) {
        dishService.update(pratoDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Dish updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedDish(@PathVariable(value = "id") Long id) {
        dishService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Dish deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PratoProjection> getDish(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(dishService.findById(id));
    }
}
