package com.ibagroup.carrental.dao.repository.photo;

import com.ibagroup.carrental.dao.model.photo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    Photo findPhotoByName(String name);

}
