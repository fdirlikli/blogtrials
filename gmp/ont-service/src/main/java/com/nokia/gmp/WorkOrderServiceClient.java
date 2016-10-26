package com.nokia.gmp;

import com.nokia.gmp.domain.WorkOrder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fatih.dirlikli on 15/06/16.
 */

@FeignClient("workorder-service")
public interface WorkOrderServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/workorder")
    Resources<WorkOrder> getWorkOrders();
}
