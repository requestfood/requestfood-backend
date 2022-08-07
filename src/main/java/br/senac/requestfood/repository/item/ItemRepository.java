package br.senac.requestfood.repository.item;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.itemadicional.ItemAdicional;
import br.senac.requestfood.projection.itemAdicional.ItemAdicionalProjection;
import br.senac.requestfood.repository.itemadicional.ItemAdicionalRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	//usem oque o professor mandou de exemplo



  boolean existsBill (Comanda bill);
  boolean existsQuantity (Integer Quantity);
  boolean existsItemAdicional (ItemAdicional itemAdicional);

  boolean existsProduct (Consumivel product);

  boolean existsDescription (String Description);

  @Query(value = "SELECT u.id AS id, u.name AS name FROM Estabelecimento u")
  List<ItemAdicionalProjection> findItem();


}
