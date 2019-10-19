package com.selwill.track.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MediaRowMapper implements RowMapper<Media> {

    @Override
    public Media mapRow(ResultSet rs, int rowNum) throws SQLException {
        Media media = new Media();
        media.setMediaId(rs.getInt("mediaId"));
        media.setTitle(rs.getString("title"));
        media.setCategory(rs.getString("category"));
        media.setFormat(rs.getString("format"));
        media.setDescription(rs.getString("description"));
        return media;
    }

}
