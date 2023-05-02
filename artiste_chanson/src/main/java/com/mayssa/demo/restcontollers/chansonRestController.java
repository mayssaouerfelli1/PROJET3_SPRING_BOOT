package com.mayssa.demo.restcontollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mayssa.demo.entities.chanson;
import com.mayssa.demo.services.chansonService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class chansonRestController {
	@Autowired
	chansonService chansonService;
	@RequestMapping(method = RequestMethod.GET)
	public List<chanson> getAllChansons() {
	return chansonService.getAllChansons();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public chanson getChansonsById(@PathVariable("id") Long id) {
	return chansonService.getChanson(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public chanson createChanson(@RequestBody chanson chanson) {
	return chansonService.saveChanson(chanson);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public chanson updateChanson(@RequestBody chanson chanson) {
	return chansonService.updateChanson(chanson);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteChanson(@PathVariable("id") Long id)
	{
		chansonService.deleteChansonById(id);
	}
	@RequestMapping(value="/chArtiste/{idArtiste}",method = RequestMethod.GET)
	public List<chanson> getChansonsByCatId(@PathVariable("idArtiste") Long idArtiste) {
	return chansonService.findByArtisteIdArtiste(idArtiste);
	}





}
