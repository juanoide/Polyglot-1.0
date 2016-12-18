package Service.CreateLanguage;


import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import security.LoginService;
import services.LanguageService;

import utilities.PopulateDatabase;

import domain.Language;

import forms.LanguageForm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
public class LanguageServiceTest {
	@Autowired
	private LanguageService languageService;


	@Autowired
	private LoginService loginService;

	@Before
	public void setUp() {
		PopulateDatabase.main(null);
	}
	
	// A user who is authenticated as an administrator
		// must be able to manage the Language.
		// Managing implies creating, modifying, or deleting them.

		// POSITIVE TEST CASE: An administrator can create
		// a language
		

	@Transactional
	@Test
	public void testCreateLanguage() {
		
		authentificate("admin");
		LanguageForm languageForm = new LanguageForm();
		languageForm.setCode("Po");
		String links="https://projetsii.informatica.us.es/projects/623q7vprzje3n44wfxr/issues, https://projetsii.informatica.us.es/projec, https://projetsii.informatica.us.es/issues/71708";
		String tag="cosas, intercambios, sanas";
		Collection<Language> languages = languageService.findAll();	
		Language descriptionLanguage = null;
		languageForm.setLinks(links);
		languageForm.setTag(tag);
		for(Language l: languages){
			descriptionLanguage= l;
			break;
		}
		String text="Esto es asi porque si y tiene mucha informacion y tal";
		String title="esto es un titulo con informacion importante";
		languageForm.setDescriptionLanguage(descriptionLanguage);
		languageForm.setText(text);
		languageForm.setTitle(title);
		
		Language language= languageService.reconstruct(languageForm);
		
		languageService.save(language);

	}
	// Negative TEST CASE: An administrator cannot create
	// a language with description null.
	@Test(expected = IllegalArgumentException.class)
	public void testCreateLanguageWithoutLanguageDescription() {
		authentificate("admin1");
		LanguageForm languageForm = new LanguageForm();
		languageForm.setCode("ES");
		String links="https://projetsii.informatica.us.es/projects/623q7vprzje3n44wfxr/issues, https://projetsii.informatica.us.es/projec, https://projetsii.informatica.us.es/issues/71708";
		String tag="cosas, intercambios, sanas";
		Language descriptionLanguage = null;
		languageForm.setLinks(links);
		languageForm.setTag(tag);
		
		String text="Esto es asi porque si y tiene mucha informacion y tal";
		String title="esto es un titulo con informacion importante";
		languageForm.setDescriptionLanguage(descriptionLanguage);
		languageForm.setText(text);
		languageForm.setTitle(title);
		
		Language language= languageService.reconstruct(languageForm);
		
		languageService.save(language);
	}
	// Negative TEST CASE: An anonymous cannot create
	// a language 
	@Transactional
	@Test(expected = IllegalArgumentException.class)
	public void testCreateLanguageNotAutehntificated() {
		desauthentificate();
	
		LanguageForm languageForm = new LanguageForm();
		languageForm.setCode("en");
		Collection<Language> languages = languageService.findAll();		
			String links="https://projetsii.informatica.us.es/projects/623q7vprzje3n44wfxr/issues, https://projetsii.informatica.us.es/projec, https://projetsii.informatica.us.es/issues/71708";
		String tag="cosas, intercambios, sanas";
		Language descriptionLanguage = null;
		languageForm.setLinks(links);
		languageForm.setTag(tag);
		for(Language l: languages){
			descriptionLanguage= l;
			break;
		}
		String text="Esto es asi porque si y tiene mucha informacion y tal";
		String title="esto es un titulo con informacion importante";
		languageForm.setDescriptionLanguage(descriptionLanguage);
		languageForm.setText(text);
		languageForm.setTitle(title);
		
		Language language= languageService.reconstruct(languageForm);
		
		languageService.save(language);
	}
	// Negative TEST CASE: An administrator cannot create
	// a language with code null.
	@Transactional
	@Test(expected = IllegalArgumentException.class)
	public void testCreateLanguageWithCodeNo() {
		authentificate("admin2");
		LanguageForm languageForm = new LanguageForm();
		Collection<Language> languages = languageService.findAll();		
		String links="https://projetsii.informatica.us.es/projects/623q7vprzje3n44wfxr/issues, https://projetsii.informatica.us.es/projec, https://projetsii.informatica.us.es/issues/71708";
		String tag="cosas, intercambios, sanas";
		Language descriptionLanguage = null;
		languageForm.setLinks(links);
		languageForm.setTag(tag);
		for(Language l: languages){
			descriptionLanguage= l;
			break;
		}
		String text="Esto es asi porque si y tiene mucha informacion y tal";
		String title="esto es un titulo con informacion importante";
		languageForm.setDescriptionLanguage(descriptionLanguage);
		languageForm.setText(text);
		languageForm.setTitle(title);
		
		Language language= languageService.reconstruct(languageForm);
		
		languageService.save(language);
	}
	// Negative TEST CASE: An administrator cannot create
	// a language null.
	@Transactional
	@Test(expected = IllegalArgumentException.class)
	public void testCreateLanguageNull() {
		authentificate("admin2");
		languageService.save(null);
	}



	public void authentificate(String username) {
		UserDetails userDetails;
		TestingAuthenticationToken authenticationToken;
		SecurityContext context;
		userDetails = loginService.loadUserByUsername(username);
		authenticationToken = new TestingAuthenticationToken(userDetails, null);
		context = SecurityContextHolder.getContext();
		context.setAuthentication(authenticationToken);

	}

	public void desauthentificate() {
		UserDetails userDetails;
		TestingAuthenticationToken authenticationToken;
		SecurityContext context;
		userDetails = loginService.loadUserByUsername(null);
		authenticationToken = new TestingAuthenticationToken(userDetails, null);
		context = SecurityContextHolder.getContext();
		context.setAuthentication(authenticationToken);

	}

}
