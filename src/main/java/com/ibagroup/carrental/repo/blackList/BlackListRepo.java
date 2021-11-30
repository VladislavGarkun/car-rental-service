package com.ibagroup.carrental.repo.blackList;

import com.ibagroup.carrental.model.blackList.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepo extends JpaRepository<BlackList, Long> {


}