package com.example.mma_fightera.Controller;

import com.example.mma_fightera.Model.Flyweight_male;
import com.example.mma_fightera.Service.Flyweight_male_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FWMController {
    @Autowired
    Flyweight_male_Service FWMService;

    // This method will take us to the new html which is containing the tabel.
    @GetMapping("FWMTabel")
    public String tabel(Model model) {
        model.addAttribute("FMWFS", FWMService.fetchAll());
        return "Home/FWMTabel";
    }

    // The get mapping for enter the html which will allows the user to creat a new fighter in FWM
    @GetMapping("creatFWMF")
    public String creat() {
        return "Home/creatFWMF";
    }
    // This is also the post mapping for insert the new fighter in FWM.

    @PostMapping("/addFWMF")
    public String addFWMF(@ModelAttribute Flyweight_male flyweight_male) {
        FWMService.addFWM(flyweight_male);
        return "redirect:/FWMTabel";
    }

    // The method for view the fighter.
    @GetMapping("/viewFigher/{id}")
    public String viewFWM(@PathVariable("id") int id, Model model) {
        model.addAttribute("FWMF", FWMService.fWM_View(id));
        return "Home/viewFWMF";
    }

    // This get will delet the fighter.
    @GetMapping("/deleteFigher/{id}")
    public String deleteFWM(@PathVariable("id") int id) {
        boolean delete = FWMService.delete(id);
        if (delete) {
            return "redirect:/FWMTabel";
        } else {
            return "redirect:/FWMTabel";
        }

    }
    // The get mapping

    @GetMapping("/updateFigher/{id}")
    public String updatFWMF(@PathVariable("id") int id, Model model) {
        model.addAttribute("FWMF", FWMService.fWM_View(id));
        return "Home/updateFWM";


    }
    @PostMapping("/updateFWMF")
    public String update(@ModelAttribute Flyweight_male FWMOb) {
      FWMService.update(FWMOb.getId(),FWMOb);
      return "redirect:/FWMTabel";
    }


}
