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
import com.selwill.track.service.MediaServiceImpl;

@Controller
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaServiceImpl mediaService;

    @RequestMapping(value= {"/", "/list"}, method=RequestMethod.GET)
    public ModelAndView getAllMedias() {
        ModelAndView model = new ModelAndView();
        List<Media> list = mediaService.getAllMedias();

        model.addObject("media_list", list);
        model.setViewName("media_list");
        return model;
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
    public ModelAndView editMedia(@PathVariable int id) {
        ModelAndView model = new ModelAndView();

        Media media = new Media();
        model.addObject("mediaForm", media);

        model.setViewName("media_form");
        return model;
    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addMedia() {
        ModelAndView model = new ModelAndView();

        Media media = new Media();
        model.addObject("mediaForm", media);

        model.setViewName("media_form");
        return model;
    }
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView saveOrUpdate(@ModelAttribute("mediaForm") Media media) {
        if (media.getMediaId() != null) {
            mediaService.updateMedia(media);
        }
        else {
            mediaService.addMedia(media);
        }
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteMedia(@PathVariable("id") int id) {
        mediaService.deleteMedia(id);

        return new ModelAndView("redirect:/media/list");
    }
}
