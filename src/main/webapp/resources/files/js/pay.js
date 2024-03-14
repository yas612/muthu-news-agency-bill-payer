
var x = new XMLHttpRequest();
var res;
var jobj;
var amount;
var orderId;
var rzid;
var callBackUrl;
var imgurl;

function createOrderId(reqamount, mob, url) {
	x.open("GET", url + reqamount, false);
	x.send();
	jobj = x.responseText;
	res = JSON.parse(jobj);
	orderId = res.orderId;
	amount = res.amount;
	rzid = res.rzid;
	imgurl = res.imgUrl;
	callBackUrl = res.callBackUrl;
	openCheckout(mob);
}

function openCheckout(mob) {
	var options = {
		"key": rzid,
		"amount": amount,
		"currency": "INR",
		"name": "Muthu News Agency",
		"description": "News Paper Bill.",
		"image": imgurl,
		"order_id": orderId,
		"callback_url": callBackUrl + mob,
		"prefill": {
			"name": "",
			"email": "",
			"contact": mob
		},
		config: {
			display: {
				blocks: {
					banks: {
						name: 'Payment Options',
						instruments: [
							{
								method: 'upi'
							},
							{
								method: 'card'
							},
							{
								method: 'wallet'
							},
							{
								method: 'netbanking'
							}
						],
					},
				},
				sequence: ['block.banks'],
				preferences: {
					show_default_blocks: false,
				},
			},
		},
	};
	var rzp1 = new Razorpay(options);
	document.getElementById('rzp-button1').onclick = function(e) {
		rzp1.open();
		e.preventDefault();
	}
}