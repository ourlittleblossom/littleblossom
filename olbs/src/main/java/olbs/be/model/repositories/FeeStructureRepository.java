package olbs.be.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import olbs.be.model.entities.FeeStructure;
@Repository
public interface FeeStructureRepository extends CrudRepository<FeeStructure, String>{

	Iterable<FeeStructure> findAll();
	
}
