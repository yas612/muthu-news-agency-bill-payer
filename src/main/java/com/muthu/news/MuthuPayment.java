package com.muthu.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class MuthuPayment {
	
		@Id
		@Column(name="orderid")
		private String orderid;
		
		@Column(name="payid")
		private String payid;
		
		@Column(name="mob")
		private String mob;
		
		@Column(name="billmonth")
		private String billmonth;
		
		@Column(name="paymentdatetime")
		private String paymentDateTime;
		
		@Column(name="status")
		private String status;
		
		public MuthuPayment() {
			
		}

		public String getOrderid() {
			return orderid;
		}

		public void setOrderid(String orderid) {
			this.orderid = orderid;
		}

		public String getPayid() {
			return payid;
		}

		public void setPayid(String payid) {
			this.payid = payid;
		}

		public String getMob() {
			return mob;
		}

		public void setMob(String mob) {
			this.mob = mob;
		}

		public String getBillmonth() {
			return billmonth;
		}

		public void setBillmonth(String billmonth) {
			this.billmonth = billmonth;
		}

		public String getPaymentDateTime() {
			return paymentDateTime;
		}

		public void setPaymentDateTime(String paymentDateTime) {
			this.paymentDateTime = paymentDateTime;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public MuthuPayment(String orderid, String payid, String mob, String billmonth, String paymentDateTime,
				String status) {
			super();
			this.orderid = orderid;
			this.payid = payid;
			this.mob = mob;
			this.billmonth = billmonth;
			this.paymentDateTime = paymentDateTime;
			this.status = status;
		}

		@Override
		public String toString() {
			return "MuthuPayment [orderid=" + orderid + ", payid=" + payid + ", mob=" + mob + ", billmonth=" + billmonth
					+ ", paymentDateTime=" + paymentDateTime + ", status=" + status + "]";
		}	
		

}
