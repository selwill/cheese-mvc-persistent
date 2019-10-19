package com.selwill.track.dao;

import java.util.List;

import com.selwill.track.model.*;


public interface MediaDao {

    public List<Media> getAllMedias();

    public Media findMediaById(int mediaId);

    public void addMedia(Media media);

    public void updateMedia(Media media);

    public void deleteMedia(int mediaId);
}
