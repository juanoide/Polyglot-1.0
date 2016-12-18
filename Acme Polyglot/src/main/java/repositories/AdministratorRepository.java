package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import security.UserAccount;

import domain.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer>{
	@Query("select a from Administrator a where a.userAccount=?1")
	Administrator findByUserAccount(UserAccount userAccount);
	


	@Query("select a from Administrator a where a.userAccount.id = ?1")
	Administrator findByUserAccountID(int UserAccountID);
	
	@Query("select avg(a.size) from LanguageExchange lan join lan.sponsorships a where lan.polyglotOrganise.id= ?1")
	Double averageLanguageExchangeSponsorshipPolyglot(int polyglotid);
}