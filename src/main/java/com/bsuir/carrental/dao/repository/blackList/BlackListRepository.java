package com.bsuir.carrental.dao.repository.blackList;

import com.bsuir.carrental.dao.model.blackList.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<BlackList, Long> {

    BlackList findDistinctFirstByUserId(Long userId);

}