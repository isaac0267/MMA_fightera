package com.example.mma_fightera.Controller;

import com.example.mma_fightera.Model.StrawWight_female;
import com.example.mma_fightera.Service.StrawWight_female_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SWFController {
// Here we make the Autowrite. The AutoWrite is like constructor,to get the acces to the methods that exists in
// Other class.

    @Autowired
    StrawWight_female_Service strawWight_female_service;

    @GetMapping("/")
    public String index(Model model) {
        List<StrawWight_female> strawWight_femaleList = strawWight_female_service.fetchAll();
        model.addAttribute("fighters", strawWight_femaleList);
        return "Home/SWFTabel";
    }
    // This get mapping is for add the new fighter.The get method for that.
     @GetMapping("createSWF")
    public String creat() {
     return "Home/createSWF";
     }
     // Now let`s creat another one with the post mapping.
    // If we want to add the new fighter remember to use the @ModelAttribute
    @PostMapping ("/addFighter")
    public String addFighter(@ModelAttribute StrawWight_female strawWight_female ) {
     strawWight_female_service.addFighter(strawWight_female);
     return"redirect:/";
    }

    // Now we will creat a method that will view the fighter by the id.
    @GetMapping("/viewFighter/{id}")
    public String viewFighter(@PathVariable("id") int id, Model model) {
    model.addAttribute("fighter",strawWight_female_service.findeByID(id));
     return "Home/viewSWF";
    }

    // Method that will remove the fighter from the list.
    @GetMapping("/delete/{id}")
    public String delet(@PathVariable("id") int id) {
     boolean delete=strawWight_female_service.delete(id);
        if (delete) {
         return "redirect:/";
        }else{
          return "redirect:/";
        }
    }

// Method that will update the fighter The get method. For the update method we use the Get and post.

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id")int id, Model model) {
        model.addAttribute("fighter",strawWight_female_service.findeByID(id));
        return "Home/updateSWF";

    }
    @PostMapping("/updateFighter")
    public String updateFighter(@ModelAttribute StrawWight_female strawWight_female) {
        strawWight_female_service.update(strawWight_female.getId(),strawWight_female);
        return "redirect:/";

    }



}
