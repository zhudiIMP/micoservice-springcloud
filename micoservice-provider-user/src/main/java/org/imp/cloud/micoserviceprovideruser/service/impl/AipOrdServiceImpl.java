package org.imp.cloud.micoserviceprovideruser.service.impl;

import org.imp.cloud.micoserviceproviderapi.dto.AipOrdDto;
import org.imp.cloud.micoserviceprovideruser.entity.AipOrd;
import org.imp.cloud.micoserviceprovideruser.mapper.AipOrdMapper;
import org.imp.cloud.micoserviceprovideruser.service.AipOrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AipOrdServiceImpl implements AipOrdService {
    @Autowired
    private AipOrdMapper aipOrdMapper;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void addAipOrd(AipOrdDto aipOrdDto){
        AipOrd aipOrd = new AipOrd();
        aipOrd.setNetOrdId(aipOrdDto.getNetOrdId());
        aipOrd.setOrdTotal(aipOrdDto.getOrdTotal());
        aipOrdMapper.insert(aipOrd);
    }
}
