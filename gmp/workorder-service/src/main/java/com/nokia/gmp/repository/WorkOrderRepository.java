
package com.nokia.gmp.repository;

import com.nokia.gmp.domain.WorkOrder;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by fdirlikl on 5/6/2015.
 */
//@PreAuthorize("hasRole('ROLE_USER')")
//@RepositoryRestResource(collectionResourceRel = "workorder",path = "workorder")
public interface WorkOrderRepository  {

  //  @Override
   // @RestResource(exported = false)
    public WorkOrder save(WorkOrder s);



}

