package com.wangx.sys.untils;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.baidu.unbiz.fluentvalidator.Validator;

/**
 * @author: wangxu
 * @date: 2020/3/27 16:03
 */
public class ValidUntil {
    private FluentValidator fluentValidator = null;
    private ComplexResult result = null;

    public ComplexResult getResult() {
        return result;
    }

    public <T> ValidUntil on(T t, Validator<T> v){
        if (fluentValidator == null) {
            this.fluentValidator = FluentValidator.checkAll();
        }
        fluentValidator.on(t,v);
        this.result = null;
        return this;
    }

    public boolean isSuccess(){
        if(result == null){
            this.result = this.fluentValidator.doValidate().result(ResultCollectors.toComplex());
        }
        return this.result.isSuccess();
    }

    public boolean isError(){
        return !this.isSuccess();
    }
}
