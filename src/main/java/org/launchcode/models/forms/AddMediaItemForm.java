package org.launchcode.models.forms;

import org.launchcode.models.Media;
import org.launchcode.models.Collection;

import javax.validation.constraints.NotNull;

public class AddMediaItemForm {

    private Collection collection;

    private Iterable<Media> medias;

    @NotNull
    private int collectionId;

    @NotNull
    private int mediaId;

    public AddMediaItemForm(Collection collection, Iterable<Media> medias) {
        this.collection = collection;
        this.medias = medias;
    }

    public AddMediaItemForm() {
    }

    public Colllection getCollection() {
        return collection;
    }

    public Iterable<Media> getMedias() {
        return medias;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public int getMediaId() {
        return mediaId;
    }
}