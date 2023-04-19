package com.jfecm.accounts.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.jfecm.accounts.app.dto.OwnerDto;
import com.jfecm.accounts.app.entity.Owner;
import com.jfecm.accounts.app.service.BaseService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OwnerController.class})
@ExtendWith(SpringExtension.class)
class OwnerControllerTest {
    @Autowired
    private BaseController<Owner, Long, OwnerDto> baseController;

    @MockBean
    private BaseService<Owner, Long, OwnerDto> baseService;

    /**
     * Method under test: {@link BaseController#getOne(Number)}
     */
    @Test
    void testGetOne() {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setAddress("42 Main St");
        ownerDto.setDni("2415224");
        ownerDto.setEmail("example.exa@example.org");
        ownerDto.setId(1L);
        ownerDto.setIsEnabled(true);
        ownerDto.setName("Some");
        ownerDto.setSurname("Doe");
        when(baseService.findById(Mockito.<Long>any())).thenReturn(ownerDto);
        ResponseEntity<OwnerDto> actualOne = baseController.getOne(1L);
        assertEquals(HttpStatus.OK, actualOne.getStatusCode());
        verify(baseService).findById(Mockito.<Long>any());
    }
}

