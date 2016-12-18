package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import domain.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer>{

	@Query("select a from Banner a where a=?1")
	Banner findByBanner(Banner banner);
	
}
