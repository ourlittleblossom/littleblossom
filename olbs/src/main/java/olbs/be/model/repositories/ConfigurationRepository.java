package olbs.be.model.repositories;

import org.springframework.stereotype.Repository;

import olbs.be.model.entities.Configuration;

import org.springframework.data.repository.CrudRepository;
@Repository
public interface ConfigurationRepository extends CrudRepository<Configuration,String>{


}
