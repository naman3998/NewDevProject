package com.mindtree.modules.skills.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.modules.skills.entity.Skill;
import com.mindtree.modules.skills.repository.SkillRepository;


@Service
public class SkillServiceImple implements SkillService {

	@Autowired
	public SkillRepository repo;

	@Override
	public List<Skill> getAllSkills() {
		return repo.findAll();
	}

	@Override
	public void setSkill(Skill s) {
		repo.save(s);
	}

	@Override
	public Optional<Skill> searchById(Long id) {
		return repo.findById(id);
	}

	public void delete_skill(Long id) {
		repo.deleteById(id);
	}

}
