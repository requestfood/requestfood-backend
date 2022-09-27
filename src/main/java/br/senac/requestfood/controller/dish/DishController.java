package br.senac.requestfood.controller.dish;

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

import br.senac.requestfood.dto.dish.DishDTO;
import br.senac.requestfood.enumeration.dish.CategoryDish;
import br.senac.requestfood.projection.dish.DishProjection;
import br.senac.requestfood.service.dish.DishService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/dish")
public class DishController {

    private final DishService service;

    public DishController(DishService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DishDTO> dish(@RequestBody DishDTO dishDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dishDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatedDish(@RequestBody DishDTO dishDTO, @PathVariable(value = "id") Long id) {
        service.update(dishDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Dish updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedDish(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Dish deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishProjection> getDish(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    
    @GetMapping("/search-name/{name}")
	public ResponseEntity<Page<DishProjection>> getDishByName(@PathVariable(value = "name") String name, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByName(name, pageable));
	}
	
	@GetMapping("/price/minor-to-major/{page}")
	public ResponseEntity<Page<DishProjection>> getAllDishByOrderByPriceByAsc(Pageable pageable, @PathVariable(value= "page") Integer page){
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPriceByOrdemByAsc(pageable, page));
	}
	
	@GetMapping("/price/major-to-minor/{page}")
	public ResponseEntity<Page<DishProjection>> getAllDishByOrderByPriceByDesc(Pageable pageable, @PathVariable(value= "page") Integer page){
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPriceByOrdemByDesc(pageable, page));
	}
	
	@GetMapping("/category/{typeDish}")
	public ResponseEntity<Page<DishProjection>> getAllDishByTypeDish(@PathVariable(value = "typeDish") CategoryDish typeDish, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByTypeDish(typeDish, pageable));
	}
    
    @GetMapping("/page/{page}")
	public ResponseEntity<Page<DishProjection>> getAllDish(Pageable pageable,@PathVariable(value = "page") Integer page) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable, page));
	}

    @GetMapping()
	public ResponseEntity<List<DishProjection>> getAllDish() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
}
