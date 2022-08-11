package br.senac.requestfood.controller.drink;

import br.senac.requestfood.dto.bebida.BebidaDTO;
import br.senac.requestfood.projection.bebida.BebidaProjection;
import br.senac.requestfood.projection.item.ItemProjection;
import br.senac.requestfood.service.drink.DrinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/drink")
public class DrinkController {

    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @PostMapping
    public ResponseEntity<BebidaDTO> drink(@RequestBody BebidaDTO drinkDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(drinkService.save(drinkDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatedDrink(@RequestBody BebidaDTO drinkDTO, @PathVariable(value = "id") Long id) {
        drinkService.update(drinkDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Drink updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedDrink(@PathVariable(value = "id") Long id) {
        drinkService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Drink deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<BebidaProjection> getDrink(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(drinkService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<BebidaProjection>> getAllDrink() {
        return ResponseEntity.status(HttpStatus.OK).body(drinkService.findAll());
    }
}
