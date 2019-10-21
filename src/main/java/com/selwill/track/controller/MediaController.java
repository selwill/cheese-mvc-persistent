package com.selwill.track.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.selwill.track.model.Media;
import com.selwill.track.service.MediaService;

@Controller
@RequestMapping(value="/home/media")
public class MediaController {

    @Autowired
    MediaService mediaService;

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("media_list");
        List<Media> mediaList = mediaService.getAllMedias();
        model.addObject("mediaList", mediaList);

        return model;
    }

    @RequestMapping(value="/addMedia/", method=RequestMethod.GET)
    public ModelAndView addMedia() {
        ModelAndView model = new ModelAndView();

        Media media = new Media();
        model.addObject("mediaForm", media);
        model.setViewName("media_form");

        return model;
    }

    @RequestMapping(value="/updateMedia/{id}", method=RequestMethod.GET)
    public ModelAndView editMedia(@PathVariable long id) {
        ModelAndView model = new ModelAndView();

        Media media = mediaService.getMediaById(id);
        model.addObject("mediaForm", media);
        model.setViewName("media_form");

        return model;
    }

    @RequestMapping(value="/saveMedia", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("mediaForm") Media media) {
        mediaService.saveOrUpdate(media);

        return new ModelAndView("redirect:/home/media/list");
    }

    @RequestMapping(value="/deleteMedia/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") long id) {
        mediaService.deleteMedia(id);

        return new ModelAndView("redirect:/home/media/list");
    }
}