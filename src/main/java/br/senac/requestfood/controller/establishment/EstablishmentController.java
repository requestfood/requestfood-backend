package br.senac.requestfood.controller.establishment;

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

import br.senac.requestfood.dto.establishment.EstablishmentAllDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithOrdersDTO;
import br.senac.requestfood.enumeration.dish.CategoryDish;
import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.projection.establishment.EstablishmentCardProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.service.dish.DishService;
import br.senac.requestfood.service.drink.DrinkService;
import br.senac.requestfood.service.establishment.EstablishmentService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/establishment")
public class EstablishmentController {
    
    private final EstablishmentService service;
    private final DishService dishService;
    private final DrinkService drinkService;

    public EstablishmentController(EstablishmentService establishmentService, DishService dishService, DrinkService drinkService) {
		this.service = establishmentService;
		this.dishService = dishService;
		this.drinkService = drinkService;
	}

	@PostMapping
	public ResponseEntity<EstablishmentAllDTO> addEstablishment(@RequestBody EstablishmentAllDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updatedEstablishment(@RequestBody EstablishmentAllDTO dto, @PathVariable(value = "id") Long id) {
		service.update(dto, id);
		return ResponseEntity.status(HttpStatus.OK).body("Establishment update successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedEstablishment(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Establishment deleted successfully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstablishmentProjection> getEstablishment(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@GetMapping("/search-name/{name}/{page}")
	public ResponseEntity<Page<EstablishmentCardProjection>> getEstablishmentByName(Pageable pageable, @PathVariable(value = "name") String name,  @PathVariable(value = "page") Integer page) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByName(pageable, page,name));
	}
	
	@GetMapping("/name/a-z/{page}")
	public ResponseEntity<Page<EstablishmentCardProjection>> getEstablishmentByNameByOrderByAsc(Pageable pageable,@PathVariable(value = "page") Integer page){
		return ResponseEntity.status(HttpStatus.OK).body(service.findNameByOrderByAsc(pageable, page));
	}
	
	@GetMapping("/name/z-a/{page}")
	public ResponseEntity<Page<EstablishmentCardProjection>> getEstablishmentByNameByOrderByDesc(Pageable pageable,@PathVariable(value = "page") Integer page){
		return ResponseEntity.status(HttpStatus.OK).body(service.findNameByOrderByDesc(pageable, page));
	}
	
	@GetMapping("/card/{page}")
	public ResponseEntity<Page<EstablishmentCardProjection>> getAllEstablishmentCard(Pageable pageable,@PathVariable(value = "page") Integer page) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAllToCard(pageable, page));
	}
	
	@GetMapping("/with-orders/{id}")
	public ResponseEntity<EstablishmentWithOrdersDTO> getEstablishmentWithOrdes(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdWithOrder(id));
	}
	
	@GetMapping("/getOpen/{id}")
	public ResponseEntity<EstablishmentProjection> getEstablishmentOpen(@PathVariable(value = "id") Long id) {
		service.setOpen(id);
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<EstablishmentProjection>> getAllEstablishment() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	//CONSUMABLES
	
	@GetMapping("/consumable/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getEstablishmentWithConsumables(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdWithConsumable(id));
	}
	
	
	//DISHES
	
	@GetMapping("/dish/search-name/{name}/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getDishByName(@PathVariable(value = "name") String name, @PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(dishService.findByName(name, id));
	}
	
	@GetMapping("/dish/price/minor/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDishByPriceByAsc(@PathVariable(value= "id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(dishService.findByPriceByOrdemByAsc(id));
	}
	
	@GetMapping("/dish/price/major/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDishByPriceByDesc(@PathVariable(value= "id")Long id){
		return ResponseEntity.status(HttpStatus.OK).body(dishService.findByPriceByOrdemByDesc(id));
	}
	
	@GetMapping("/dish/category/{categoryDish}/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDishByTypeDish(@PathVariable(value = "categoryDish") CategoryDish categoryDish, @PathVariable(value= "id")Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(dishService.findByTypeDish(categoryDish, id));
	}
    
    @GetMapping("/dish/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDish(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(dishService.findAll(id));
    }
    
    //DRINKS
    
    @GetMapping("/drink/search-name/{name}/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getDrinkByName(@PathVariable(value = "name") String name, @PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(drinkService.findByName(name, id));
	}
	
	@GetMapping("/drink/price/minor/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDrinkByPriceByAsc(@PathVariable(value= "id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(drinkService.findByPriceByOrdemByAsc(id));
	}
	
	@GetMapping("/drink/price/major/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDrinkByPriceByDesc(@PathVariable(value= "id")Long id){
		return ResponseEntity.status(HttpStatus.OK).body(drinkService.findByPriceByOrdemByDesc(id));
	}
	
	@GetMapping("/drink/category/{categoryDrink}/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDrinkByTypeDrink(@PathVariable(value = "categoryDrink") CategoryDrink categoryDrink, @PathVariable(value= "id")Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(drinkService.findByCategoryDrink(categoryDrink, id));
	}
    
    @GetMapping("/drink/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDrink(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(drinkService.findAll(id));
    }
    
    @GetMapping("/drink/alcoholic/{alcoholic}/{id}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDrinkByAlcoholic(@PathVariable(value = "alcoholic") Boolean alcoholic, @PathVariable(value = "id")Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(drinkService.findByAlcoholic(alcoholic, id));
	}
}
