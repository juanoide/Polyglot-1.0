package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.LanguageExchange;

@Repository
public interface LanguageExchangeRepository extends JpaRepository<LanguageExchange, Integer>{

	@Query("select c from LanguageExchange c where (c.date)>adddate(current_date,-90) and (c.date)<adddate(current_date,0)")
	Collection<LanguageExchange> listExchangePastOrganised3Months();
	
	@Query("select c from LanguageExchange c where (c.date)<adddate(current_date,90) and (c.date)>adddate(current_date,0)")
	Collection<LanguageExchange> listExchangeFutureOrganised3Months();
	
	@Query("select c from LanguageExchange c join c.joinExchanges s join s.polyglot i where i.id = ?1")
	Collection<LanguageExchange> languageExchangeOfPolyglotID(int id);
	
	@Query("select c from LanguageExchange c join c.polyglotOrganise i where i.id = ?1")
	Collection<LanguageExchange> findAllPolyglotLogin(int id);
	
	@Query("select c from LanguageExchange c where c.cancel is false")
	Collection<LanguageExchange> languageExchangeNoCancel();
}
