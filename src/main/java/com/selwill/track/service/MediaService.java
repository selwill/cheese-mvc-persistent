package com.selwill.track.service;

import java.util.List;

import com.selwill.track.model.Media;

public interface MediaService {
    public List<Media> getAllMedias();

    public Media findMediaById(int id);

    public void addMedia(Media media);

    public void updateMedia(Media media);

    public void deleteMedia(int id);
}
