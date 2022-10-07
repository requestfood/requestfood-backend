package br.senac.requestfood.repository.establisment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.user.establishment.Establishment;
import br.senac.requestfood.projection.establishment.EstablishmentCardProjection;
import br.senac.requestfood.projection.establishment.EstablishmentImageProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentStartOrderProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithConsumableProjection;
import br.senac.requestfood.projection.establishment.EstablishmentWithOrderProjection;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
	
	Optional<EstablishmentProjection> findEstablishmentById(Long id);
	
	Optional<EstablishmentImageProjection> findEstablishmentImageById(Long id);
	
	Optional<EstablishmentStartOrderProjection> findEstablishmentStartOrderById(Long id);
	
	Optional<EstablishmentWithConsumableProjection> findEstablishmentWithConsumableById(Long id);
	
	EstablishmentWithOrderProjection findEstablishmentWithOrderById(Long id);

	Page<EstablishmentCardProjection> findByNameContainingIgnoreCase(Pageable pageable, String name);
	
	@Query(value="SELECT u.id AS id, u.name AS name, u.contact AS contact, u.password AS password, e.image AS image, e.timeToOpen AS timeToOpen, e.timeToClose AS timeToClose FROM User u JOIN Establishment e ON u.id = e.id")
	Page<EstablishmentCardProjection>findEstablishments(Pageable pageable);
	
	@Query(value="SELECT u.id AS id, u.name AS name, e.image AS image FROM User u JOIN Establishment e ON u.id = e.id")
	Page<EstablishmentCardProjection>findEstablishmentsCard(Pageable pageable);
	
	@Query(value="SELECT u.id AS id, u.name AS name, u.contact AS contact, u.password AS password, e.image AS image, e.timeToOpen AS timeToOpen, e.timeToClose AS timeToClose FROM User u JOIN Establishment e ON u.id = e.id")
	List<EstablishmentProjection>findEstablishments();
	
	

}
