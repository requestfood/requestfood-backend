package br.senac.requestfood.repository.establisment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithAllProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithConsumableProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithOrderProjection;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {

	boolean existsByContact (Contact contact);
	
	Optional<EstablishmentProjection> findEstablishmentById(Long id);
	
	Optional<EstablishmentWithAllProjection> findEstablishmentWithAllById(Long id);
	
	Optional<EstablishmentWithConsumableProjection> findEstablishmentWithConsumableById(Long id);
	
	Optional<EstablishmentWithOrderProjection> findEstablishmentWithCommandById(Long id);

	@Query(value="SELECT e.id as id, e.name AS name, e.contact AS contact, e.password AS password, e.image AS image, e.cep AS cep, e.description AS description FROM Establishment e")
	List<EstablishmentProjection>findEstablishments();

}
