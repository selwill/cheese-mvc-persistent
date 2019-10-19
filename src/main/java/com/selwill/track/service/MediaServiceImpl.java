package com.selwill.track.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selwill.track.dao.MediaDaoImpl;
import com.selwill.track.model.Media;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private MediaDaoImpl mediaDao;

    @Override
    public List<Media> getAllMedias() {
        return mediaDao.getAllMedias();
    }

    @Override
    public Media findMediaById(int id) {
        return mediaDao.findMediaById(id);
    }

    @Override
    public void addMedia(Media media) {
        mediaDao.addMedia(media);
    }

    @Override
    public void updateMedia(Media media) {
        mediaDao.updateMedia(media);
    }

    @Override
    public void deleteMedia(int id) {
        mediaDao.deleteMedia(id);
    }

}
