package com.mindtree.modules.skills.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.modules.skills.entity.Skill;
import com.mindtree.modules.skills.service.SkillServiceImple;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@RestController
public class SkillController {

	@Autowired
	public SkillServiceImple si;
	
	
	@PostMapping("/skills")
	public void add_skill(@RequestBody Skill e)
	{
		si.setSkill(e);
	}
	
	@GetMapping("/skills")
	public List<Skill> getAllskills()
	{
		return si.getAllSkills();
	}
	@GetMapping("/skills/{id}")
	public Optional<Skill> getById(@PathVariable Long id)
	{
		return si.searchById(id);
	}
	
	@DeleteMapping("/skills/{id}")
	public void delete_skill(@PathVariable Long id)
	{
		si.delete_skill(id);
	}

	
}
