package com.selwill.track.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.selwill.track.model.Media;
import com.selwill.track.repository.MediaRepository;

@Service
@Transactional
public class MediaServiceImpl implements MediaService {

    @Autowired
    MediaRepository mediaRepository;

    @Override
    public List<Media> getAllMedias() {
        return (List<Media>) mediaRepository.findAll();
    }

    @Override
    public Media getMediaById(long id) {
        return mediaRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Media media) {
        mediaRepository.save(media);
    }

    @Override
    public void deleteMedia(long id) {
        mediaRepository.deleteById(id);
    }

}