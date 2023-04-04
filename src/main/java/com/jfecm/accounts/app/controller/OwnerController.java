package com.jfecm.accounts.app.controller;

import com.jfecm.accounts.app.dto.OwnerDto;
import com.jfecm.accounts.app.entity.Owner;
import com.jfecm.accounts.app.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/owners")
public class OwnerController extends BaseController<Owner, Long, OwnerDto> {
    @Autowired
    public OwnerController(BaseService<Owner, Long, OwnerDto> service) {
        super(service);
    }
}
