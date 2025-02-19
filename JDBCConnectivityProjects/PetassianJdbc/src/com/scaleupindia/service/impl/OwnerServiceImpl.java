package com.scaleupindia.service.impl;

import java.util.List;
import java.util.Optional;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.exception.DuplicateOwnerException;
import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.repository.impl.OwnerRepositoryImpl;
import com.scaleupindia.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerServiceImpl implements OwnerService {

    //Interface reference variable
    private OwnerRepository ownerRepository;
    //String values
    private static final String OWNER_ALREADY_EXISTS = "Owner already exists with ownerId ";
    private static final String OWNER_NOT_FOUND = "Can't find owner with ownerId ";

    //when constructor is called OwnerRepo getting the reference
    // from OwnerRepoImple
    //That is Interface reference variable getting a reference
    public OwnerServiceImpl() {
        this.ownerRepository = new OwnerRepositoryImpl();
    }

    @Override
    public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException {
        Optional<OwnerDTO> existingOwnerDTO = ownerRepository.findOwner(ownerDTO.getId());
        if (existingOwnerDTO.isPresent()) {
            throw new DuplicateOwnerException(OWNER_ALREADY_EXISTS + ownerDTO.getId());
        } else {
            ownerRepository.saveOwner(ownerDTO);
        }
    }

    @Override
    public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
        Optional<OwnerDTO> ownerDTO = ownerRepository.findOwner(ownerId);
        if (!ownerDTO.isPresent()) {
            throw new OwnerNotFoundException(OWNER_NOT_FOUND + ownerId);
        } else {
            return ownerDTO.get();
        }
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
        Optional<OwnerDTO> ownerDTO = ownerRepository.findOwner(ownerId);
        if (!ownerDTO.isPresent()) {
            throw new OwnerNotFoundException(OWNER_NOT_FOUND + ownerId);
        } else {
            ownerRepository.updatePetDetails(ownerId, petName);
        }
    }

    @Override
    public void deleteOwner(int ownerId) throws OwnerNotFoundException {
        Optional<OwnerDTO> ownerDTO = ownerRepository.findOwner(ownerId);
        if (!ownerDTO.isPresent()) {
            throw new OwnerNotFoundException(OWNER_NOT_FOUND + ownerId);
        } else {
            ownerRepository.deleteOwner(ownerId);
        }
    }

    @Override
    public List<OwnerDTO> findAllOwners() {
        return ownerRepository.findAllOwners();
    }
}