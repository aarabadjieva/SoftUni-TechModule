package projectrider.controller;

import projectrider.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import projectrider.bindingModel.ProjectBindingModel;
import projectrider.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Project> projectsFromDb = this.projectRepository.findAll();
        model.addAttribute("projects", projectsFromDb);
        model.addAttribute("view", "project/index");

        return "base-layout";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("view", "project/create");
        return "base-layout";
    }

    @PostMapping("/create")
    public String createProcess(Model model, ProjectBindingModel projectBindingModel) {
        Project project = new Project();
        project.setTitle(projectBindingModel.getTitle());
        project.setDescription(projectBindingModel.getDescription());
        project.setBudget(projectBindingModel.getBudget());
        this.projectRepository.saveAndFlush(project);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Project projectFromDb = this.projectRepository.getOne(id);
        model.addAttribute("project", projectFromDb);
        model.addAttribute("view", "project/edit");
        return "base-layout";
    }

    @PostMapping("/edit/{id}")
    public String editProcess(@PathVariable int id, Model model, ProjectBindingModel projectBindingModel) {
        Project projectFromDb = this.projectRepository.getOne(id);
        projectFromDb.setTitle(projectBindingModel.getTitle());
        projectFromDb.setDescription(projectBindingModel.getDescription());
        projectFromDb.setBudget(projectBindingModel.getBudget());
        this.projectRepository.saveAndFlush(projectFromDb);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        Project projectToDelete = this.projectRepository.getOne(id);
        model.addAttribute("project", projectToDelete);
        model.addAttribute("view", "project/delete");
        return "base-layout";
    }

    @PostMapping("/delete/{id}")
    public String deleteProcess(@PathVariable int id, ProjectBindingModel projectBindingModel) {
        this.projectRepository.deleteById(id);
        return "redirect:/";
    }
}
