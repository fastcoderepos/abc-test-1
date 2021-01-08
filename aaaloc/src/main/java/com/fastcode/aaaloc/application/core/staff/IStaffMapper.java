package com.fastcode.aaaloc.application.core.staff;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.fastcode.aaaloc.domain.core.address.AddressEntity;
import com.fastcode.aaaloc.domain.core.store.StoreEntity;
import com.fastcode.aaaloc.application.core.staff.dto.*;
import com.fastcode.aaaloc.domain.core.staff.StaffEntity;
import java.time.*;

@Mapper(componentModel = "spring")
public interface IStaffMapper {

   StaffEntity createStaffInputToStaffEntity(CreateStaffInput staffDto);
   
   
   @Mappings({ 
   @Mapping(source = "entity.address.addressId", target = "addressId"),                   
   @Mapping(source = "entity.address.addressId", target = "addressDescriptiveField"),                    
   }) 
   CreateStaffOutput staffEntityToCreateStaffOutput(StaffEntity entity);
   
    StaffEntity updateStaffInputToStaffEntity(UpdateStaffInput staffDto);
    
    @Mappings({ 
    @Mapping(source = "entity.address.addressId", target = "addressId"),                   
    @Mapping(source = "entity.address.addressId", target = "addressDescriptiveField"),                    
   	}) 
   	UpdateStaffOutput staffEntityToUpdateStaffOutput(StaffEntity entity);

   	@Mappings({ 
   	@Mapping(source = "entity.address.addressId", target = "addressId"),                   
   	@Mapping(source = "entity.address.addressId", target = "addressDescriptiveField"),                    
   	}) 
   	FindStaffByIdOutput staffEntityToFindStaffByIdOutput(StaffEntity entity);


   @Mappings({
   @Mapping(source = "address.address", target = "address"),                  
   @Mapping(source = "address.lastUpdate", target = "lastUpdate"),                  
   @Mapping(source = "foundStaff.staffId", target = "staffStaffId"),
   })
   GetAddressOutput addressEntityToGetAddressOutput(AddressEntity address, StaffEntity foundStaff);
   
   @Mappings({
   @Mapping(source = "store.lastUpdate", target = "lastUpdate"),                  
   @Mapping(source = "store.storeId", target = "storeId"),                  
   @Mapping(source = "foundStaff.staffId", target = "staffStaffId"),
   })
   GetStoreOutput storeEntityToGetStoreOutput(StoreEntity store, StaffEntity foundStaff);
   
}

