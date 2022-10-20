package com.sakamaya.booky.dao.interfaces;

import com.sakamaya.booky.model.Payment;


public interface IPaymentDAO extends IDAO<Payment> {
    Payment findByReservationId(int reservationId);
}
