package br.senac.requestfood.repository.item;

import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.itemadicional.ItemAdicional;
import br.senac.requestfood.repository.itemadicional.ItemAdicionalRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	//usem oque o professor mandou de exemplo


  boolean existsItemAdicional (ItemAdicional itemAdicional);

  boolean existsConsumivel (Consumivel consumivel);


}
