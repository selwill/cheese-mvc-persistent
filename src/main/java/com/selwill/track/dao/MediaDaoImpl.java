package com.selwill.track.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.selwill.track.model.Media;
import com.selwill.track.model.MediaRowMapper;


@Transactional
@Repository
public class MediaDaoImpl implements MediaDao {

@Autowired
private JdbcTemplate jdbcTemplate;

@Override
public List<Media>getAllMedias(){
    String query = "SELECT * FROM medias";
    RowMapper<Media> rowMapper = new MediaRowMapper();
    List<Media> list = jdbcTemplate.query(query, rowMapper);

    return list;
}

@Override
public Media findMediaById(int id) {
    String query = "SELECT * FROM medias WHERE mediaId = ?";
    RowMapper<Media> rowMapper = new BeanPropertyRowMapper<Media>(Media.class);
    Media media = jdbcTemplate.queryForObject(query, rowMapper, id);

    return media;
}

    @Override
    public void addMedia(Media media) {
        String query = "INSERT INTO medias(mediaId, title, category, format, description) VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, media.getMediaId(), media.getTitle(), media.getCategory(), media.getFormat(), media.getDescription());

    }

    @Override
    public void updateMedia(Media media) {
        String query = "UPDATE medias SET title=?, category=?, format=?, description=? WHERE mediaId=?";
        jdbcTemplate.update(query, media.getTitle(), media.getCategory(), media.getFormat(), media.getDescription(), media.getMediaId());

    }

    @Override
    public void deleteMedia(int id) {
        String query = "DELETE FROM medias WHERE mediaId=?";
        jdbcTemplate.update(query, id);
    }
}
