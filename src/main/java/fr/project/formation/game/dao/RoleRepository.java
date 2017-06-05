package fr.project.formation.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.project.formation.game.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
