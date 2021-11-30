package com.ibagroup.carrental.controller.blackList;

import com.ibagroup.carrental.dto.blackList.BlackListDto;
import com.ibagroup.carrental.model.blackList.BlackList;
import com.ibagroup.carrental.service.blackList.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/blacklist")
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

    @GetMapping(value = "/{blackListId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBlackListById(@PathVariable("blackListId") Long blackListId){
        BlackList blackList = service.getBlackListById(blackListId);

        return ResponseEntity.ok(blackList);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BlackList> getAllBlackList(){
        List<BlackList> blackLists = service.getAllBlackList();

        return blackLists;
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateBlackList(@RequestBody BlackList blackList){
        BlackList entity = service.updateBlackList(blackList);

        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{blackListId}")
    public void deleteBlackListById(@PathVariable Long blackListId){
        service.deleteBlackListById(blackListId);
    }
}
