package org.imp.cloud.micoserviceprovideruser.controller;

import org.imp.cloud.micoserviceproviderapi.dto.AipOrdDto;
import org.imp.cloud.micoserviceproviderapi.dto.Request;
import org.imp.cloud.micoserviceproviderapi.dto.Response;
import org.imp.cloud.micoserviceprovideruser.service.AipOrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AipOrdController {
    @Autowired
    private AipOrdService aipOrdService;

    @RequestMapping(value = "/addAipOrd", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Response<AipOrdDto> addAipOrd(@RequestBody Request<AipOrdDto> req){
        aipOrdService.addAipOrd(req.getBody());
        return Response.success();
    }
}
