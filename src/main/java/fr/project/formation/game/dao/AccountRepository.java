package fr.project.formation.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.project.formation.game.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	Account findOneByUsername(final String username);

}
