package br.senac.requestfood.controller.drink;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import br.senac.requestfood.dto.drink.DrinkDTO;
import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.projection.dish.DishProjection;
import br.senac.requestfood.projection.drink.DrinkProjection;
import br.senac.requestfood.service.drink.DrinkService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/drink")
public class DrinkController {

    private final DrinkService service;

    public DrinkController(DrinkService drinkService) {
        this.service = drinkService;
    }

    @PostMapping
    public ResponseEntity<DrinkDTO> drink(@RequestBody DrinkDTO drinkDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(drinkDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatedDrink(@RequestBody DrinkDTO drinkDTO, @PathVariable(value = "id") Long id) {
        service.update(drinkDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Drink updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedDrink(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Drink deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrinkProjection> getDrink(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    
    @GetMapping("/search-name/{name}")
	public ResponseEntity<Page<DrinkProjection>> getDrinkByName(@PathVariable(value = "name") String name, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByName(name, pageable));
	}
	
	@GetMapping("/price/minor-to-major/{page}")
	public ResponseEntity<Page<DrinkProjection>> getAllDrinkByOrderByPriceByAsc(Pageable pageable, @PathVariable(value= "page") Integer page){
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPriceByOrdemByAsc(pageable, page));
	}
	
	@GetMapping("/price/major-to-minor/{page}")
	public ResponseEntity<Page<DrinkProjection>> getAllDrinkByOrderByPriceByDesc(Pageable pageable, @PathVariable(value= "page") Integer page){
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPriceByOrdemByDesc(pageable, page));
	}
	
	@GetMapping("/category/{categoryDrink}")
	public ResponseEntity<Page<DrinkProjection>> getAllDrinkByCategoryDrink(@PathVariable(value = "categoryDrink") CategoryDrink categoryDrink, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByCategoryDrink(categoryDrink, pageable));
	}
	
	@GetMapping("/page/{page}")
	public ResponseEntity<Page<DrinkProjection>> getAllConsumable(Pageable pageable,@PathVariable(value = "page") Integer page) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable, page));
	}

    @GetMapping()
    public ResponseEntity<List<DrinkProjection>> getAllDrink() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
}
