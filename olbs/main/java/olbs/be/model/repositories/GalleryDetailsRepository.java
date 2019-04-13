package olbs.be.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import olbs.be.model.entities.EventImages;



@Repository
public interface GalleryDetailsRepository extends CrudRepository<EventImages, String>{

	Iterable<EventImages> findAll();
	
}

