package com.mayssa.demo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mayssa.demo.entities.chanson;
import com.mayssa.demo.services.chansonService;

@Controller
public class chansonController {
   @Autowired
	chansonService chansonService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("chanson", new chanson());
		modelMap.addAttribute("mode", "new");

		return "formChanson";
	}
	@RequestMapping("/saveChanson")
	public String saveChanson(@Valid chanson chanson, BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) return "formChanson";
	 chansonService.saveChanson(chanson);
	return "formChanson";
	}
@RequestMapping("/ListeChansons")
public String listeChansons(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "3") int size)
{
	Page<chanson> fact = chansonService.getAllChansonsParPage(page, size);
	modelMap.addAttribute("chansons", fact);
	 modelMap.addAttribute("pages", new int[fact.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeChansons";

}
@RequestMapping("/supprimerChanson")
public String supprimerChanson(@RequestParam("id") Long id,
 ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
 @RequestParam (name="size", defaultValue = "2") int size)
{ 
chansonService.deleteChansonById(id);
Page<chanson> fact = chansonService.getAllChansonsParPage(page, size);
		modelMap.addAttribute("chansons", fact);
		modelMap.addAttribute("pages", new int[fact.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

return "listechansons";
}
@RequestMapping("/modifierChanson")
public String editerChanson(@RequestParam("id") Long id,ModelMap modelMap)
{
chanson c= chansonService.getChanson(id);
modelMap.addAttribute("chanson", c);
modelMap.addAttribute("mode", "edit");
return "formChanson";
}
@RequestMapping("/updateChanson")
public String updateChanson(@ModelAttribute("chanson") chanson chanson,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
{
	 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 chanson.setDateCreation(dateCreation);
	 
	chansonService.updateChanson(chanson);
	 List<chanson> fact = chansonService.getAllChansons();
	 modelMap.addAttribute("chansons", fact);
	return "listeChansons";
	}
}
