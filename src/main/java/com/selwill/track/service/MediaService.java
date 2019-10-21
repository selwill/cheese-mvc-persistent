package com.selwill.track.service;

import java.util.List;

import com.selwill.track.model.*;

public interface MediaService {

    public List<Media> getAllMedias();

    public Media getMediaById(long id);

    public void saveOrUpdate(Media media);

    public void deleteMedia(long id);
}
