package com.ensat.controllers;

import com.ensat.entities.Error;
import com.ensat.services.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @Autowired
    private ErrorService errorService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("errors", errorService.listAllErrors());
        return "errors";
    }

    @GetMapping("/{id}")
    public String showError(@PathVariable Integer id, Model model) {
        model.addAttribute("error", errorService.getErrorById(id));
        return "Errorshow";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("error", errorService.getErrorById(id));
        return "errorEdit";
    }

    @RequestMapping("/new")
    public String newError(Model model) {
        model.addAttribute("error", new Error());
        return "errorform";
    }

    @PostMapping("/editdb")
    public String editdb(Error error) {
        errorService.editdb(error);
        return "redirect:/error/list";
    }

    @PostMapping("/save")
    public String saveError(Error error) {
        System.out.println("cerror");
        errorService.saveError(error);
        return "redirect:/error/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        errorService.deleteError(id);
        return "redirect:/error/list";
    }
}
