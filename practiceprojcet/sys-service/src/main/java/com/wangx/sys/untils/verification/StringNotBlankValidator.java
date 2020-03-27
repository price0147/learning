package com.wangx.sys.untils.verification;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import org.springframework.util.StringUtils;

/**
 * @author: wangxu
 * @date: 2020/3/27 13:56
 */
public class StringNotBlankValidator extends ValidatorHandler<String> implements Validator<String> {

    private String valueName;

    public StringNotBlankValidator(String valueName) {
        this.valueName = valueName;
    }

    @Override
    public boolean validate(ValidatorContext context, String s) {
        if(StringUtils.isEmpty(s)){
            context.addError(ValidationError.create(String.format("%s不能为空",valueName))
                    .setErrorCode(-1)
                    .setField(valueName)
                    .setInvalidValue(s));
            return false;
        }
        return true;
    }
}
