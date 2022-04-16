package com.ibagroup.carrental.endpoint.photo;

import com.ibagroup.carrental.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/photo")
@CrossOrigin(origins = "http://localhost:3000")
public class PhotoController {

    private final PhotoService service;

    @Autowired
    public PhotoController(PhotoService service){
        this.service = service;
    }

    @PostMapping(path = "{name}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity upload(
            @PathVariable(value = "name") String name,
            @RequestPart("file")MultipartFile file
            ) throws IOException {
        service.upload(file.getBytes(), name);

        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "{name}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity download(@PathVariable String name){
        byte[] photo = service.download(name);

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + name + "\";charset=utf-8");

        return ResponseEntity.ok().headers(header)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .contentLength(photo.length)
                .body(photo);

    }

}
