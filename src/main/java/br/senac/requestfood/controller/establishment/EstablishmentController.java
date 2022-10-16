package br.senac.requestfood.controller.establishment;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.senac.requestfood.dto.establishment.EstablishmentAllDTO;
import br.senac.requestfood.dto.establishment.EstablishmentImageDTO;
import br.senac.requestfood.dto.establishment.EstablishmentUpdateDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithOrdersDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithOrdersReadyDTO;
import br.senac.requestfood.dto.order.establishment.OrderControlDTO;
import br.senac.requestfood.enumeration.dish.CategoryDish;
import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.projection.establishment.EstablishmentCardProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentStartOrderProjection;
import br.senac.requestfood.projection.establishment.EstablishmentUpdateProjection;
import br.senac.requestfood.repository.establisment.EstablishmentRepository;
import br.senac.requestfood.service.consumable.ConsumableService;
import br.senac.requestfood.service.dish.DishService;
import br.senac.requestfood.service.drink.DrinkService;
import br.senac.requestfood.service.establishment.EstablishmentService;
import br.senac.requestfood.service.order.OrderService;
import br.senac.requestfood.util.ImageUtil;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/establishment")
public class EstablishmentController {
    
    private final EstablishmentService service;
    private final EstablishmentRepository repository;
    private final OrderService orderService;
    private final ConsumableService consumableService;
    private final DishService dishService;
    private final DrinkService drinkService;

    public EstablishmentController(EstablishmentService establishmentService, DishService dishService, DrinkService drinkService, OrderService orderService, 
    		ConsumableService consumableService, EstablishmentRepository repository) {
		this.service = establishmentService;
		this.repository = repository;
		this.consumableService = consumableService;
		this.dishService = dishService;
		this.drinkService = drinkService;
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<EstablishmentAllDTO> addEstablishment(@RequestBody EstablishmentAllDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}
	
	@PostMapping("/image/{id}")
	public ResponseEntity<String> addEstablishmentImage(@RequestParam("image") MultipartFile file, @PathVariable(value = "id") Long id) throws IOException{
		service.saveImage(ImageUtil.compressBytes(file.getBytes()), id);
		return ResponseEntity.status(HttpStatus.OK).body("Establishment image registered successfully");
	}
	
	@PutMapping("/update-image/{id}")
	public ResponseEntity<String> updateEstablishmentImage(@RequestParam("image") MultipartFile file, @PathVariable(value = "id") Long id) throws IOException{
		service.saveImage(ImageUtil.compressBytes(file.getBytes()), id);
		return ResponseEntity.status(HttpStatus.OK).body("Establishment image update successfully");
	}
	
	@GetMapping("/getImage/{id}")
	public ResponseEntity<EstablishmentImageDTO> getEstablishmentImage(@PathVariable Long id) throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdImage(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updatedEstablishment(@RequestBody EstablishmentUpdateDTO dto, @PathVariable(value = "id") Long id) {
		service.update(dto, id);
		return ResponseEntity.status(HttpStatus.OK).body("Establishment update successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedEstablishment(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Establishment deleted successfully");
	}
	
	@GetMapping()
	public ResponseEntity<List<EstablishmentProjection>> getAllEstablishment() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstablishmentUpdateProjection> getEstablishment(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@GetMapping("/search-name/{name}/{page}")
	public ResponseEntity<Page<EstablishmentCardProjection>> getEstablishmentByName(Pageable pageable, @PathVariable(value = "name") String name,  @PathVariable(value = "page") Integer page) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByName(pageable, page,name));
	}
	
	@GetMapping("/card/{page}")
	public ResponseEntity<Page<EstablishmentCardProjection>> getAllEstablishmentCard(Pageable pageable,@PathVariable(value = "page") Integer page) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAllToCard(pageable, page));
	}
	
	@GetMapping("/getOpen/{id}")
	public ResponseEntity<EstablishmentUpdateProjection> getEstablishmentOpen(@PathVariable(value = "id") Long id) {
		service.setOpen(id);
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	//ORDERS
	
	//Triggered when an order is ready and the Client needs to pick it up at the counter..
	@GetMapping("/orders-ready/{id}")
	public ResponseEntity<EstablishmentWithOrdersReadyDTO> getEstablishmentWithOrderReady(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdWithOrderReady(id));
	}
	
	//Triggered before someone starting an order...
	@GetMapping("/start-order/{id}")
	public ResponseEntity<EstablishmentStartOrderProjection> getEstablishmentStartOrder(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdStartOrder(id));
	}
	
	//Show Establishment's Orders
	@GetMapping("/orders/{id}")
	public ResponseEntity<EstablishmentWithOrdersDTO> getEstablishmentWithOrder(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdWithOrder(id));
	}

	//Triggered when Establishment wants delete or update an order
	@GetMapping("/order-control/{id}")
	public ResponseEntity<OrderControlDTO> getOrderControl(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findByIdOrderControl(id));
	}
	
	//CONSUMABLES
	
	@GetMapping("/{id}/consumable/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getEstablishmentWithConsumables(@PathVariable(value = "id") Long id, @PathVariable(value = "page") Integer page, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(consumableService.findAll(id, page, pageable));
	}
	
	@GetMapping("/{id}/consumable/search-name/{name}/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getConsumableByName(@PathVariable(value = "id") Long id, @PathVariable(value = "name") String name, @PathVariable(value = "page") Integer page, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(consumableService.findByName(id, name, page,pageable));
	}
	
	@GetMapping("/{id}/consumable/price/minor/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllConsumableByOrderByPriceByAsc(@PathVariable(value = "id") Long id, Pageable pageable, @PathVariable(value= "page") Integer page){
		return ResponseEntity.status(HttpStatus.OK).body(consumableService.findByPriceByOrdemByAsc(id, page, pageable));
	}
	
	@GetMapping("/{id}/consumable/price/major/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllConsumableByOrderByPriceByDesc(@PathVariable(value = "id") Long id, Pageable pageable, @PathVariable(value= "page") Integer page){
		return ResponseEntity.status(HttpStatus.OK).body(consumableService.findByPriceByOrdemByDesc(id, page, pageable));
	}
	
	//DISHES
	
	@GetMapping("/{id}/dish/search-name/{name}/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getDishByName(@PathVariable(value = "id") Long id, @PathVariable(value = "name") String name,  @PathVariable(value = "page") Integer page, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(dishService.findByName(id, name, page, pageable));
	}
	
	@GetMapping("/{id}/dish/price/minor/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDishByPriceByAsc(@PathVariable(value= "id") Long id, @PathVariable(value = "page") Integer page, Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(dishService.findByPriceByOrdemByAsc(id, page, pageable));
	}
	
	@GetMapping("/{id}/dish/price/major/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDishByPriceByDesc(@PathVariable(value= "id")Long id, @PathVariable(value = "page") Integer page, Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(dishService.findByPriceByOrdemByDesc(id, page, pageable));
	}
	
	@GetMapping("/{id}/dish/category/{categoryDish}/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDishByTypeDish(@PathVariable(value = "id") Long id, @PathVariable(value = "categoryDish") CategoryDish categoryDish, @PathVariable(value = "page") Integer page, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(dishService.findByTypeDish(id, categoryDish, page, pageable));
	}
    
    @GetMapping("/{id}/dish/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDish(@PathVariable(value = "id") Long id, @PathVariable(value = "page") Integer page, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(dishService.findAll(id, page, pageable));
    }
    
    //DRINKS
    
    @GetMapping("/{id}/drink/search-name/{name}/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getDrinkByName(@PathVariable(value = "id") Long id, @PathVariable(value = "name") String name, @PathVariable(value = "page") Integer page, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(drinkService.findByName(id, name, page, pageable));
	}
	
	@GetMapping("/{id}/drink/price/minor/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDrinkByPriceByAsc(@PathVariable(value= "id") Long id, @PathVariable(value = "page") Integer page, Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(drinkService.findByPriceByOrdemByAsc(id, page, pageable));
	}
	
	@GetMapping("/{id}/drink/price/major/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDrinkByPriceByDesc(@PathVariable(value= "id")Long id, @PathVariable(value = "page") Integer page, Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(drinkService.findByPriceByOrdemByDesc(id, page, pageable));
	}
	
	@GetMapping("/{id}/drink/category/{categoryDrink}/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDrinkByTypeDrink(@PathVariable(value = "id") Long id, @PathVariable(value = "categoryDrink") CategoryDrink categoryDrink, @PathVariable(value = "page") Integer page, Pageable pageable ) {
		return ResponseEntity.status(HttpStatus.OK).body(drinkService.findByCategoryDrink(id, categoryDrink, page, pageable));
	}
    
    @GetMapping("/{id}/drink/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDrink(@PathVariable(value = "id") Long id, @PathVariable(value = "page") Integer page, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(drinkService.findAll(id, page, pageable));
    }
    
    @GetMapping("/{id}/drink/alcoholic/{alcoholic}/{page}")
	public ResponseEntity<EstablishmentWithConsumablesDTO> getAllDrinkByAlcoholic(@PathVariable(value = "id")Long id, @PathVariable(value = "alcoholic") Boolean alcoholic, @PathVariable(value = "page") Integer page, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(drinkService.findByAlcoholic(id, alcoholic, page, pageable));
	}
}
