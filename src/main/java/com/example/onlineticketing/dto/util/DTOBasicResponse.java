package com.example.onlineticketing.dto.util;

import com.example.onlineticketing.comms.helper.HelperUtil;
import com.example.onlineticketing.entity.EntityBaseClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DTOBasicResponse {
    protected Long id;
    protected Long addedPersonId;
    protected LocalDateTime addedDate;
    protected String addedPersonName;
    protected Long updatedPersonId;
    protected String updatedPersonName;
    protected LocalDateTime updatedDate;
    protected boolean isDisabled;

    public DTOBasicResponse(EntityBaseClass entity) {
        this.id = entity.getId();
        this.addedDate = entity.getAddedDate();
        this.addedPersonId = entity.getAddedPerson()!=null? entity.getAddedPerson().getId() : null;
        this.addedPersonName = entity.getAddedPerson() != null ? HelperUtil.getFullName(entity.getAddedPerson().getFirstName(), entity.getAddedPerson().getLastName()) : null;
        this.updatedPersonId = entity.getUpdatedPerson() != null ? entity.getUpdatedPerson().getId() : null;
        this.updatedPersonName = entity.getUpdatedPerson() != null ? HelperUtil.getFullName(entity.getUpdatedPerson().getFirstName(), entity.getUpdatedPerson().getLastName()) : null;
        this.updatedDate = entity.getUpdatedDate();
        this.isDisabled = entity.isDisabled();
    }

    public DTOBasicResponse(Long id, Long addedPersonId, LocalDateTime addedDate, String addedPersonName, Long updatedPersonId, String updatedPersonName, LocalDateTime updatedDate, boolean isDisabled) {
        this.id = id;
        this.addedPersonId = addedPersonId;
        this.addedDate = addedDate;
        this.addedPersonName = addedPersonName;
        this.updatedPersonId = updatedPersonId;
        this.updatedPersonName = updatedPersonName;
        this.updatedDate = updatedDate;
        this.isDisabled = isDisabled;
    }
}
