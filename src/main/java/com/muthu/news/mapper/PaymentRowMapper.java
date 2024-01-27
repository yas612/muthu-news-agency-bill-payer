package com.muthu.news.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.muthu.news.MuthuPayment;



public class PaymentRowMapper implements RowMapper<MuthuPayment> {

	@Override
	public MuthuPayment mapRow(ResultSet rs, int rowNum) throws SQLException {
		MuthuPayment payment = new MuthuPayment();
		payment.setOrderid(rs.getString("orderid"));
		payment.setPayid(rs.getString("payid"));
		payment.setMob(rs.getString("mob"));
		payment.setBillmonth(rs.getString("billmonth"));
		payment.setPaymentDateTime(rs.getString("paymentdatetime"));
		payment.setStatus(rs.getString("status"));
		return payment;
		
	}

}

