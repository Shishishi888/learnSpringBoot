package com.tjulab.adminsystem.service.impl;

import com.tjulab.adminsystem.bean.NbData;
import com.tjulab.adminsystem.mapper.NbDataMapper;
import com.tjulab.adminsystem.service.NbDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NbDataServiceImpl implements NbDataService {

    @Autowired
    NbDataMapper nbDataMapper;

    public NbData getNbDataById(String dataId){
        return nbDataMapper.getNbDataById(dataId);
    }
}
