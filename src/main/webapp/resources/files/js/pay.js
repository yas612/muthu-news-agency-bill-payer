
var x = new XMLHttpRequest();
var res;
var jobj;
var amount;
var orderId;
var rzid;
var callBackUrl;

function createOrderId(reqamount, mob, url) {
	x.open("GET", url+reqamount, false);
	x.send();
	jobj = x.responseText;
	res = JSON.parse(jobj);
	orderId = res.orderId;
	amount = res.amount;
	rzid = res.rzid;
	callBackUrl = res.callBackUrl;
	openCheckout(mob);
}

function openCheckout(mob) {
	var options = {
		"key": rzid,
		"amount": amount,
		"currency": "INR",
		"name": "Muthu News Agency",
		"description": "Trusted company over years.",
		"image": "https://example.com/your_logo",
		"order_id": orderId,
		"callback_url": callBackUrl+mob,
		"prefill": { 
			"name": "",
			"email": "",
			"contact": mob
		},
		"notes": {
			"address": "Y.Othakadai, Madurai - 625107, Tamil Nadu, India."
		},
		"theme": {
			"color": "#3399cc"
		}
	};
	var rzp1 = new Razorpay(options);
	document.getElementById('rzp-button1').onclick = function(e) {
		rzp1.open();
		e.preventDefault();
	}
}