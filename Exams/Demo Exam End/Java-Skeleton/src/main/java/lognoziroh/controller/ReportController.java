package lognoziroh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import lognoziroh.bindingModel.ReportBindingModel;
import lognoziroh.repository.ReportRepository;
import lognoziroh.entity.Report;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReportController {
    private final ReportRepository reportRepository;

    @Autowired
    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        List<Report> reports = this.reportRepository.findAll();
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "report/index");
        modelAndView.addObject("reports", reports);
        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(ModelAndView modelAndView, @PathVariable int id) {
        Report report = this.reportRepository.getOne(id);
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "report/details");
        modelAndView.addObject("report", report);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "report/create");
        return modelAndView;
    }

    @PostMapping("/create")
    public String createProcess(ModelAndView modelAndView, ReportBindingModel reportBindingModel) {
        Report report = new Report();
        report.setStatus(reportBindingModel.getStatus());
        report.setMessage(reportBindingModel.getMessage());
        report.setOrigin(reportBindingModel.getOrigin());
        this.reportRepository.saveAndFlush(report);
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "report/create");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(ModelAndView modelAndView, @PathVariable int id) {
        Report reportToDelete = this.reportRepository.getOne(id);
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "report/delete");
        modelAndView.addObject("report", reportToDelete);
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String deleteProcess(@PathVariable int id, ReportBindingModel reportBindingModel) {
        this.reportRepository.delete(id);
        return "redirect:/";
    }
}
