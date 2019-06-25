package org.launchcode.controllers;

import org.launchcode.models.Media;
import org.launchcode.models.Collection;
import org.launchcode.models.data.MediaDao;
import org.launchcode.models.data.CollectionDao;
import org.launchcode.models.forms.AddMediaItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "collection")
public class CollectionController {
    @Autowired
    private CollectionDao collectionDao;

    @Autowired
    private MediaDao mediaDao;

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("title", "My Collection");
        model.addAttribute("collections", collectionDao.findAll());

        return "collection/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Collection());
        model.addAttribute("title", "Add Collection");
        return "collection/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Collection collection, Errors errors) {
        if (errors.hasErrors()) {
            return "collection/add";
        }
        collectionDao.save(collection);
        return "redirect:/collection/view/" + collection.getId();
    }

    @RequestMapping(value = "view/{collectionId}", method = RequestMethod.GET)
    public String viewCollection(Model model, @PathVariable int collectionId) {
        Collection collection = collectionDao.findOne(collectionId);
        model.addAttribute("collection", collection);
        model.addAttribute("title", collection.getName());
        return "collection/view";
    }

    @RequestMapping(value="add-item/{collectionId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int collectionId) {
        Collection collection = collectionDao.findOne(collectionId);

        AddMediaItemForm addMediaItemForm = new AddMediaItemForm(collection, mediaDao.findAll());

        model.addAttribute("title", "Add item to collection: " + collection.getName());
        model.addAttribute("form", addMediaItemForm);

        return "collection/add-item";
    }

    @RequestMapping(value="add-item", method = RequestMethod.POST)
    public String addItem(Model model, @ModelAttribute @Valid AddMediaItemForm addMediaItemForm, Errors errors,@RequestParam int collectionId, @RequestParam int mediaId) {
        if (errors.hasErrors()) {
            return "collection/add-item";
        }

        Collection collection = collectionDao.findOne(collectionId);
        Media media = mediaDao.findOne(mediaId);
        collection.addItem(media);
        collectionDao.save(collection);

        return "redirect:/collection/view/" + collection.getId();
    }
}