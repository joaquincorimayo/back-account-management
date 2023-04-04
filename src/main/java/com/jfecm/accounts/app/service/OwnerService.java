package com.jfecm.accounts.app.service;

import com.jfecm.accounts.app.dto.OwnerDto;
import com.jfecm.accounts.app.entity.Owner;
import com.jfecm.accounts.app.mapper.OwnerMapper;
import com.jfecm.accounts.app.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService extends BaseService<Owner, Long, OwnerDto> implements IOwnerService {
    @Autowired
    private OwnerMapper ownerMapper;

    @Autowired
    public OwnerService(BaseRepository<Owner, Long> repository) {
        super(repository);
    }

    @Override
    public Owner dtoToEntity(OwnerDto element) {
        return ownerMapper.unMap(element);
    }

    @Override
    public Owner dtoToEntityUpdate(Owner owner, OwnerDto ownerDto) {
        return ownerMapper.unMap(owner, ownerDto);
    }

    @Override
    public OwnerDto entityToDTO(Owner element) {
        return ownerMapper.map(element);
    }
}
