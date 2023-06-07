package com.example.mma_fightera.Controller;

import com.example.mma_fightera.Model.Flyweight_female;
import com.example.mma_fightera.Repository.Flyweight_female_Repo;
import com.example.mma_fightera.Service.Flyweight_female_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
// This method will show the tabel of the flyweight_female_tabel
public class FWFController {
    @Autowired
    Flyweight_female_Service FFS;

    @GetMapping("FWFTabel")
    public String FWFTabel(Model model) {
        model.addAttribute("FWF", FFS.fetchAll());
        return "Home/FWFTabel";
    }

    // Get mapping for creat a fighter.
    @GetMapping("creatFWF")
    public String addFighter_female() {
        return "Home/creatFWF";
    }

    // The post mapping for making add the new fighter.
    @PostMapping("addFWF")
    public String addFWF(@ModelAttribute Flyweight_female FWF) {
        FFS.addFighter(FWF);
        return "redirect:/FWFTabel";

    }

    // The method that will show the fighter ID.
    @GetMapping("/viewFID/{id}")
    public String viewFighter(@PathVariable("id") int id, Model model) {
        model.addAttribute("Fly_Female", FFS.FWF_ID(id));
        return "Home/viewFWF";
    }

    @GetMapping("/DF/{id}")
    public String delete(@PathVariable("id") int id) {
        boolean delet = FFS.delete(id);
        if (delet) {
            return "redirect:/FWFTabel";
        } else {
            return "redirect:/FWFTabel";
        }

    }


    // update method. Get mapping
    @GetMapping("/UF/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("Fly_Female", FFS.FWF_ID(id));
        return "Home/updateFWFF";
    }
    // post method
    @PostMapping("/updateFWMFF")
    public String updateF(@ModelAttribute Flyweight_female FWFB) {
      FFS.updateF(FWFB.getId(),FWFB);
      return "redirect:/FWFTabel";
    }




}
