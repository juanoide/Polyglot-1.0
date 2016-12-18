package controllers;


import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import domain.Description;
import domain.Language;
import domain.LanguageExchange;


import forms.LanguageExchangeForm;



import services.DescriptionService;
import services.LanguageExchangeService;
import services.LanguageService;


@Controller
@RequestMapping("/languageExchange")
public class LanguageExchangeController extends AbstractController{
	
	// Managed service ----------------------------------------------
	

	
	@Autowired
	private LanguageExchangeService languageExchangeService;

	@Autowired
	private LanguageService languageService;
	
	@Autowired
	private DescriptionService descriptionService;

	
	// Constructors -------------------------------------------------
	//Register -------------------------------------------------------

	


	
	
	//Auxiliary methods--------------------------------------------

	
	@RequestMapping(value="/electionLanguage", method= RequestMethod.GET)
	public ModelAndView SelectLanguage(@RequestParam int languageExchangeId){
		ModelAndView result;
		
		LanguageExchange lExc = languageExchangeService.findOne(languageExchangeId);
		
		result=createEditModelAndViewNoForm(lExc);
		

		return result;
	}
	
	
	protected ModelAndView createEditModelAndView(LanguageExchangeForm lform){
		ModelAndView result;
	
		result = createEditModelAndView(lform,null);
		
		
		
		return result;
	}
	

	protected ModelAndView createEditModelAndViewNoForm(LanguageExchange lexc){
		ModelAndView result;
	
		result = createEditModelAndViewNoForm(lexc,null);
		
		
		
		return result;
	}
	
	
	protected ModelAndView createEditModelAndView(LanguageExchangeForm lform, String message){
		ModelAndView result;
	
		String requestURI="languageExchange/polyglot/register.do";
		
		result = new ModelAndView("languageExchange/polyglot/register");
		
		Collection<Language> languages = languageService.findAll();
		
		Assert.notNull(languages);
		
		result.addObject("languages",languages);
		
		result.addObject("languageExchangeForm",lform);
		
		result.addObject("message",message);

		result.addObject("requestURI",requestURI);
		
		return result;
	}
	
	protected ModelAndView createEditModelAndViewNoForm(LanguageExchange lexc, String message){
		ModelAndView result;
	
		String requestURI="languageExchange/electionLanguage.do";
		
		result = new ModelAndView("languageExchange/electionLanguage");
		
		Collection<Language> languages = languageService.findAll();
		
		Description des = descriptionService.create();
		
		Assert.notNull(languages);
		
		result.addObject("description",des);
		
		result.addObject("languages",languages);
		
		result.addObject("languageExchange",lexc);
		
		result.addObject("message",message);

		result.addObject("requestURI",requestURI);
		
		return result;
	}
	
	//listar por querys
	
	@RequestMapping("/future3months/list")
	public ModelAndView future3months() {
		ModelAndView result;
		Collection<LanguageExchange> languageExchanges;
		languageExchanges = languageExchangeService.listExchangeFutureOrganised3Months();
		
		String requestURI="languageExchange/future3months/list.do";
		
		result = new ModelAndView("languageExchange/future3months/list");		
		result.addObject("languageExchanges",languageExchanges);
		result.addObject("requestURI",requestURI);
		return result;
	}
	
	@RequestMapping("/past3months/list")
	public ModelAndView past3months() {
		ModelAndView result;
		Collection<LanguageExchange> languageExchanges;
		languageExchanges = languageExchangeService.listExchangePastOrganised3Months();
		
			
		String requestURI="languageExchange/past3months/list.do";
		
		result = new ModelAndView("languageExchange/past3months/list");
		result.addObject("languageExchanges",languageExchanges);
		result.addObject("requestURI",requestURI);
		
		
		return result;
	}
	

	
}

