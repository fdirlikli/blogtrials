package com.nokia.gmp.domain.command.handler;

import com.nokia.gmp.domain.WorkOrder;
import org.axonframework.repository.Repository;
import org.axonframework.unitofwork.DefaultUnitOfWork;
import org.axonframework.unitofwork.UnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;

@Component
public class Db {

    @Autowired
    @Qualifier("transactionManager")
    protected PlatformTransactionManager txManager;

    @Autowired
    private Repository repository;

    @PostConstruct
    private void init(){
        TransactionTemplate transactionTmp = new TransactionTemplate(txManager);
        transactionTmp.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                UnitOfWork uow = DefaultUnitOfWork.startAndGet();
                WorkOrder wo1 = new WorkOrder(1L);
                wo1.setOntSerialNumber("1111");
                wo1.setType(WorkOrder.WorkOrderType.ADD_SERVICE);

                WorkOrder wo2 = new WorkOrder(2L);
                wo2.setOntSerialNumber("2222");
                wo2.setType(WorkOrder.WorkOrderType.ADD_SUBSCRIPTION);
                repository.add(wo1);
                repository.add(wo2);
                uow.commit();
            }
        });
    }
}
