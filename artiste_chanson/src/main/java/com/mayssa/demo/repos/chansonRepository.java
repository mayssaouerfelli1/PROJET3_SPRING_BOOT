package com.mayssa.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mayssa.demo.entities.Artiste;
import com.mayssa.demo.entities.chanson;
@RepositoryRestResource(path = "rest")
public interface chansonRepository extends JpaRepository<chanson,Long>{
	@Query("select c from chanson c where c.artiste = ?1")
	List<chanson> findByArtiste (Artiste artiste);
	List<chanson> findByArtisteIdArtiste(Long id);

	

	


}
