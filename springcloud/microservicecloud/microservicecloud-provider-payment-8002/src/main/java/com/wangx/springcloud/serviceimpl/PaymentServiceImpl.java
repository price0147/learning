package com.wangx.springcloud.serviceimpl;

import com.wangx.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import com.wangx.springcloud.dao.PaymentDao;
import com.wangx.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author: wangxu
 * @date: 2020/3/17 20:09
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
