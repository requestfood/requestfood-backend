package br.senac.requestfood.repository.addicionalitem;

import br.senac.requestfood.model.addicionalItem.AdditionalItem;
import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.projection.addicionalItem.AddicionalItemProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalItemRepository extends JpaRepository <AdditionalItem, Long> {

	Optional<AddicionalItemProjection> findAdditionalItemById(Long id);

	@Query(value = "SELECT a.id_additional_item as id, a.id_item as Item, a.additional_name as AdditionItemName, a.additional_quantity as AdditionalItemQuantity FROM AdditionalItem a")
	List<AddicionalItemProjection>findAdditionalItens();


}
