package com.bsuir.carrental.endpoint.blackList;

import com.bsuir.carrental.domain.dto.blackList.BlackListRegistrationDto;
import com.bsuir.carrental.service.blackList.BlackListService;
import com.bsuir.carrental.domain.dto.blackList.BlackListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blacklist")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class BlackListController {

    private final BlackListService blackListService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addToBlackList(@RequestBody BlackListRegistrationDto blackListRegistrationDto){
        return blackListService.addToBlackList(blackListRegistrationDto);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBlackListByUserId(@PathVariable("userId") Long userId){
        BlackListDto blackListDto = blackListService.findBlackListByUserId(userId);

        return ResponseEntity.ok(blackListDto);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllBlackList(){
        List<BlackListDto> blackListDtoList = blackListService.findAllBlackList();

        return ResponseEntity.ok(blackListDtoList);
    }

    @DeleteMapping(value = "/{blackListId}")
    public void deleteBlackListById(@PathVariable("blackListId") Long blackListId){
        blackListService.deleteBlackListById(blackListId);
    }
}