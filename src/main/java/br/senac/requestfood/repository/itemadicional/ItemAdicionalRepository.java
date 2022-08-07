package br.senac.requestfood.repository.itemadicional;

import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.itemadicional.ItemAdicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemAdicionalRepository extends JpaRepository <ItemAdicional, Long> {
	//usem oque o professor mandou de exemplo

    boolean existsName (String name);
    boolean existsQuantity (Integer quantity);
    boolean existsId (Long id);
    boolean existsItem (Item item);
}
