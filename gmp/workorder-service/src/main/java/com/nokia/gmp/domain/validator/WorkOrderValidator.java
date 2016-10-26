package com.nokia.gmp.domain.validator;

import com.nokia.gmp.domain.WorkOrder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by fatih.dirlikli on 07/09/16.
 */
public class WorkOrderValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return WorkOrder.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors,"type","type.empty");
    }
}
