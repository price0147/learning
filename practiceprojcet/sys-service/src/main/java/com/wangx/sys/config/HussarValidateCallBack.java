package com.wangx.sys.config;

import com.baidu.unbiz.fluentvalidator.DefaultValidateCallback;
import com.baidu.unbiz.fluentvalidator.ValidateCallback;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.validator.element.ValidatorElementList;

import java.util.List;

/**
 * 自定义异常回调类
 * @author: wangxu
 * @date: 2020/3/26 13:58
 *
 *fluent-validate 与 spring 结合使用 annotation 方式进行参数校验，需要借助于 spring 的 AOP，
 *fluent-validate 提供了处理类 FluentValidateInterceptor，
 *但是 fluent-validate 提供的默认验证回调类 DefaultValidateCallback
 *对校验失败的情况并没有处理，所以需要自行实现一个
 */
public class HussarValidateCallBack extends DefaultValidateCallback implements ValidateCallback {
    @Override
    public void onSuccess(ValidatorElementList validatorElementList) {
        super.onSuccess(validatorElementList);
    }

    @Override
    public void onFail(ValidatorElementList validatorElementList, List<ValidationError> errors) {
        throw new RuntimeException(errors.get(0).getErrorMsg());
    }

    @Override
    public void onUncaughtException(Validator validator, Exception e, Object target) {
        throw new RuntimeException(e);
    }
}
