package com.mindtree.modules.skills.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.modules.skills.entity.Skill;


@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{

	public List<Skill> findAll();

}
