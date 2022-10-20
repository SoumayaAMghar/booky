package com.sakamaya.booky.dao;

import com.sakamaya.booky.dao.interfaces.IPaymentDAO;
import com.sakamaya.booky.model.Payment;

public class PaymentDAO extends BaseDAO<Payment> implements IPaymentDAO {
    public PaymentDAO() {
        super(Payment.class);
    }

    @Override
    public Payment findByReservationId(int reservationId) {
        return find("reservation_id", reservationId);
    }
}
