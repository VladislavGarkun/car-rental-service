package com.ibagroup.carrental.service;

import com.ibagroup.carrental.service.dto.blackList.BlackListDto;
import com.ibagroup.carrental.dao.model.blackList.BlackList;
import com.ibagroup.carrental.dao.repository.blackList.BlackListRepository;
import com.ibagroup.carrental.dao.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlackListService {

    private final BlackListRepository repo;

    private final UserRepository userRepo;

    @Autowired
    public BlackListService(BlackListRepository repo, UserRepository userRepo){
        this.repo = repo;
        this.userRepo = userRepo;
    }


    public BlackList addToBlackList(BlackListDto blackList) {
        BlackList entity = new BlackList();
        entity.setUser(userRepo.findById(blackList.getId()).get());
        entity.setReason(blackList.getReason());
        entity.setDateOfAdd(blackList.getDateOfAdd());

        repo.save(entity);

        return entity;
    }

    public BlackList findBlackListById(Long blackListId) {
        return repo.findById(blackListId).get();
    }

    public List<BlackList> findAllBlackList() {
        return repo.findAll();
    }

    public BlackList updateBlackList(BlackList blackList) {
        return repo.save(blackList);
    }

    public void deleteBlackListById(Long blackListId) {
        repo.deleteById(blackListId);
    }
}
