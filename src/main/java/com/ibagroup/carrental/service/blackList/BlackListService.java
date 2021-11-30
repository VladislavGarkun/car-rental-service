package com.ibagroup.carrental.service.blackList;

import com.ibagroup.carrental.dto.blackList.BlackListDto;
import com.ibagroup.carrental.model.blackList.BlackList;
import com.ibagroup.carrental.repo.blackList.BlackListRepo;
import com.ibagroup.carrental.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlackListService {

    private final BlackListRepo repo;

    private final UserRepo userRepo;

    @Autowired
    public BlackListService(BlackListRepo repo, UserRepo userRepo){
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

    public BlackList getBlackListById(Long blackListId) {
        return repo.findById(blackListId).get();
    }

    public List<BlackList> getAllBlackList() {
        return repo.findAll();
    }

    public BlackList updateBlackList(BlackList blackList) {
        return repo.save(blackList);
    }

    public void deleteBlackListById(Long blackListId) {
        repo.deleteById(blackListId);
    }
}
