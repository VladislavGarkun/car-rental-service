package com.ibagroup.carrental.service;

import com.ibagroup.carrental.dao.model.photo.Photo;
import com.ibagroup.carrental.dao.repository.photo.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    private final PhotoRepository repo;

    @Autowired
    public PhotoService(PhotoRepository repo){
        this.repo = repo;
    }


    public void upload(byte[] file, String name) {
        Photo entity = new Photo();

        entity.setPhoto(file);
        entity.setName(name);

        repo.save(entity);
    }

    public byte[] download(String name) {
        return repo.findPhotoByName(name).getPhoto();
    }
}
