package com.wangx.sys.untils.verification;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * @author: wangxu
 * @date: 2020/3/27 16:43
 */
public class ObjNotBlankValidator extends ValidatorHandler<Object> implements Validator<Object> {
    @Override
    public boolean validate(ValidatorContext context, Object s) {
        if(s == null){
            context.addError(ValidationError.create("对象为空"));
            return false;
        }
        return true;
    }
}
