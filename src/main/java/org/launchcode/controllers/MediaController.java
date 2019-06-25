package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.Cheese;
import org.launchcode.models.data.CategoryDao;
import org.launchcode.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("media")
public class TrackController {

    @Autowired
    private MediaDao mediaDao;

    @Autowired
    private CategoryDao categoryDao;

    // Request path: /media
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("media", mediaDao.findAll());
        model.addAttribute("title", "My Media");

        return "media/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddMediaForm(Model model) {

        model.addAttribute("title", "Add Media");
        model.addAttribute(new Media());
        model.addAttribute("categories", categoryDao.findAll());
        return "media/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddMediaForm(@ModelAttribute  @Valid Media newMedia,
                                       Errors errors, @RequestParam int
                                               categoryId, Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Media");
            model.addAttribute("categories", categoryDao.findAll());
            return "media/add";
        }

        Category cat = categoryDao.findOne(categoryId);
        newMedia.setCategory(cat);
        mediaDao.save(newMedia);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveMediaForm(Model model) {
        model.addAttribute("media", cheeseDao.findAll());
        model.addAttribute("title", "Remove Media");
        return "media/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveMediaForm(@RequestParam int[] mediaIds) {

        for (int mediaId : mediaIds){
            mediaDao.delete(mediaId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "category", method = RequestMethod.GET)
    public String category(Model model, @RequestParam int id){

        Category cat = categoryDao.findOne(id);
        List<Media> medias = cat.getMedias();
        model.addAttribute("medias", medias);
        model.addAttribute("title", "Medias in Category: " + cat.getName());
        return "media/index";
    }

}