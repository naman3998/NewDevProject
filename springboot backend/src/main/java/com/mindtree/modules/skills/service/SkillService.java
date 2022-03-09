package com.mindtree.modules.skills.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mindtree.modules.skills.entity.Skill;


@Service
public interface SkillService {
	public List<Skill> getAllSkills();
	public void setSkill(Skill s);
	public Optional<Skill> searchById(Long id);
	public void delete_skill(Long id);
}
