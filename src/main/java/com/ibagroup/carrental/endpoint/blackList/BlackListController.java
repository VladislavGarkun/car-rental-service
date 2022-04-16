package com.ibagroup.carrental.endpoint.blackList;

import com.ibagroup.carrental.service.dto.blackList.BlackListDto;
import com.ibagroup.carrental.dao.model.blackList.BlackList;
import com.ibagroup.carrental.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blacklist")
public class BlackListController {

    private final BlackListService service;

    @Autowired
    public BlackListController(BlackListService service){
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addToBlackList(@RequestBody BlackListDto blackList){
        BlackList entity = service.addToBlackList(blackList);

        return ResponseEntity.ok(entity);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBlackListById(@PathVariable("userId") Long id){
        BlackList blackList = service.findBlackListById(id);

        return ResponseEntity.ok(blackList);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BlackList> getAllBlackList(){
        List<BlackList> blackLists = service.findAllBlackList();

        return blackLists;
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateBlackList(@RequestBody BlackList blackList){
        BlackList entity = service.updateBlackList(blackList);

        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteBlackListById(@PathVariable Long userId){
        service.deleteBlackListById(userId);
    }
}
