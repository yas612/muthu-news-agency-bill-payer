<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Muthu News Agency</title>
<link href="${pageContext.request.contextPath}/resources/css/footer.css" rel="stylesheet">
<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"
    rel="stylesheet" type="text/css" />
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/logo.png">
<style type="text/css">
.ui-widget-header {
	background: #00478e;
	font-weight: bold;
}
</style>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        $("#tandcCtnt").dialog({
            modal: true,
            autoOpen: false,
            title: "Muthu News Agency "
            +"<br/>Terms & Conditions",
            width: 'auto', // overcomes width:'auto' and maxWidth bug
            height: 600,
            maxWidth: 600,
            modal: true,
            fluid: true, //new option
            resizable: false
        });
        $("#tandcBtn, #uftandcBtn").click(function () {
            $('#tandcCtnt').dialog('open');
        });
    });
    
    $(function () {
        $("#candrCtnt").dialog({
            modal: true,
            autoOpen: false,
            title: "Muthu News Agency "
            +"<br/>Cancellation and refund",
            width: 'auto', // overcomes width:'auto' and maxWidth bug
            height: 600,
            maxWidth: 600,
            modal: true,
            fluid: true, //new option
            resizable: false
        });
        $("#candrBtn").click(function () {
            $('#candrCtnt').dialog('open');
        });
    });
    
    $(function () {
        $("#sandCtnt").dialog({
            modal: true,
            autoOpen: false,
            title: "Muthu News Agency "
            +"<br/>shipping and delivery",
            width: 'auto', // overcomes width:'auto' and maxWidth bug
            height: 600,
            maxWidth: 600,
            modal: true,
            fluid: true, //new option
            resizable: false
        });
        $("#sanddbtn").click(function () {
            $('#sandCtnt').dialog('open');
        });
    });
    
    $(function () {
        $("#pandpCtnt").dialog({
            modal: true,
            autoOpen: false,
            title: "Muthu News Agency "
            +"<br/>Privacy Policy",
            width: 'auto', // overcomes width:'auto' and maxWidth bug
            height: 600,
            maxWidth: 600,
            modal: true,
            fluid: true, //new option
            resizable: false
        });
        $("#pandpbtn, #ufpandpbtn").click(function () {
            $('#pandpCtnt').dialog('open');
        });
    });
    
</script>
</head>
<body>
	<footer>
		<div class="footer">
			<div class="footer-left">
				Email us: <a href="mailto:muthunewsagent97@gmail.com">muthunewsagent97@gmail.com</a><br>
				Contact us : <a href="tel:+90251 21449">+91 90251 21449</a><br>
				<div class="spacer"></div>
				<address>
					Address : <br>2/125,<br> Suthanthira Nagar 1st Street,<br>
					Y.Othakadai,<br> Madurai - 625107,<br> Tamil Nadu,<br>
					India.
				</address>
			</div>
			<div class="footer-right">
				<address>
					Designed & Developed by<br> Mohamed Yaseen K<br> Email :
					<a href="mailto:mohamed.yaseen.kathar.oli@gmail.com">mohamed.yaseen.kathar.oli@gmail.com</a>.<br>
					Contact : +91 87783 05977
				</address>
			</div>
			<div class="center">	
				<div class="terms">
				<div class="tc" >
					<a href="#" id="tandcBtn"> Terms & Conditions </a>
					<div id="tandcCtnt" >
    				Last updated on Feb 22 2024<br>
					<p>For the purpose of these Terms and Conditions,</p>
					<p>The term "we", "us", "our" used anywhere on this page shall mean Muthiah Kannan,</p>
					<p>whose registered/operational office is<br> 
					4/125,<br> 
					Suthanthira Nagar 1st Street,<br>  
					Othakadai,<br> 
					Madurai,<br> 
					TAMIL NADU-625107 .</p>
					<p>"you", “your”, "user", “visitor” shall mean any natural or legal person who is visiting our website and/or agreed to purchase from us.</p><br> 

					Your use of the website and/or purchase from us are governed by following Terms and Conditions:<br> 
					<ul>
					<li>The content of the pages of this website is subject to change without notice.</li>

					<li>Neither we nor any third parties provide any warranty or guarantee as to the accuracy, timeliness, performance, completeness or suitability of the information and materials found or offered on this website for any particular purpose. You acknowledge that such information and materials may contain inaccuracies or errors and we expressly exclude liability for any such inaccuracies or errors to the fullest extent permitted by law.</li>

					<li>Your use of any information or materials on our website and/or product pages is entirely at your own risk, for which we shall not be liable. It shall be your own responsibility to ensure that any products, services or information available through our website and/or product pages meet your specific requirements.</li>

					<li>Our website contains material which is owned by or licensed to us. This material includes, but are not limited to, the design, layout, look, appearance and graphics. Reproduction is prohibited other than in accordance with the copyright notice, which forms part of these terms and conditions.</li>

					<li>All trademarks reproduced in our website which are not the property of, or licensed to, the operator are acknowledged on the website.</li>

					<li>Unauthorized use of information provided by us shall give rise to a claim for damages and/or be a criminal offense.</li>

					<li>From time to time our website may also include links to other websites. These links are provided for your convenience to provide further information.</li>

					<li>You may not create a link to our website from another website or document without Muthiah Kannan’s prior written consent.</li>

					<li>Any dispute arising out of use of our website and/or purchase with us and/or any engagement with us is subject to the laws of India .</li>

					<li>We, shall be under no liability whatsoever in respect of any loss or damage arising directly or indirectly out of the decline of authorization for any Transaction, on Account of the Cardholder having exceeded the preset limit mutually agreed by us with our acquiring bank from time to time</li>
					</ul>
					</div>
				</div>
				<div class="cr">
					<a href="#" id="candrBtn"> Cancellation and refund </a>
					<div id="candrCtnt">
					Last updated on Feb 22 2024<br>

					Muthiah Kannan believes in helping its customers as far as possible, and has therefore a liberal cancellation policy. Under this policy:

					<ul>
					<li>Cancellations will be considered only if the request is made within 7 days of placing the order. However, the cancellation request may not be entertained if the orders have been communicated to the vendors/merchants and they have initiated the process of shipping them.</li>

					<li>Muthiah Kannan does not accept cancellation requests for perishable items like flowers, eatables etc. However, refund/replacement can be made if the customer establishes that the quality of product delivered is not good.</li>

					<li>In case of receipt of damaged or defective items please report the same to our Customer Service team. The request will, however, be entertained once the merchant has checked and determined the same at his own end. This should be reported within 7 days of receipt of the products.</li>

					<li>In case you feel that the product received is not as shown on the site or as per your expectations, you must bring it to the notice of our customer service within 7 days of receiving the product. The Customer Service Team after looking into your complaint will take an appropriate decision.</li>

					<li>In case of complaints regarding products that come with a warranty from manufacturers, please refer the issue to them.</li>

					<li>In case of any Refunds approved by the Muthiah Kannan, it’ll take 6-8 days for the refund to be processed to the end customer.</li>
					</ul>
					</div>
				</div>
				<div class="sd">
				<a href="#" id="sanddbtn"> Shipping and delivery </a>
					<div id="sandCtnt">

					Last updated on Feb 22 2024
					<ul>
					<li>For International buyers, orders are shipped and delivered through registered international courier companies and/or International speed post only.</li> 
					<li>For domestic buyers, orders are shipped through registered domestic courier companies and /or speed post only.</li>
					<li>Orders are shipped within 0-7 days or as per the delivery date agreed at the time of order confirmation and delivering of the shipment subject to Courier Company / post office norms.</li> 
					<li>Muthiah Kannan is not liable for any delay in delivery by the courier company / postal authorities and only guarantees to hand over the consignment to the courier company or postal authorities within 0-7 days rom the date of the order and payment or as per the delivery date agreed at the time of order confirmation.</li> 
					<li>Delivery of all orders will be to the address provided by the buyer. Delivery of our services will be confirmed on your mail ID as specified during registration.</li> 
					<li>For any issues in utilizing our services you may contact our helpdesk on 9025121449 or muthunewsagent97@gmail.com</li>
					</ul>
				</div>
			</div>
			<div class="pp">
			<a href="#" id="pandpbtn">Privacy policy</a>
			<div id="pandpCtnt">

			Last updated on Feb 22 2024
			<p>At Muthu News Agency, one of our main priorities is the privacy of our visitors. This Privacy Policy document contains types of information that is collected and recorded by Muthu News Agency and how we use it.</p>

			<p>If you have additional questions or require more information about our Privacy Policy, do not hesitate to contact us through email at muthunewsagent97@gmail.com</p>

			<p>This privacy policy applies only to our online activities and is valid for visitors to our website with regards to the information that they shared and/or collect in Muthu News Agency. 
			
			This policy is not applicable to any information collected offline or via channels other than this website. </p>
			
			<b>Consent</b><br> 
			<p>By using our website, you hereby consent to our Privacy Policy and agree to its terms.</p>

			<b>Information we collect</b><br>

			<p>The personal information that you are asked to provide, and the reasons why you are asked to provide it, will be made clear to you at the point we ask you to provide your personal information.

			If you contact us directly, we may receive additional information about you such as your name, email address, phone number, the contents of the message and/or attachments you may send us, and any other information you may choose to provide.

			When you register for an Account, we may ask for your contact information, including items such as name, company name, address, email address, and telephone number.</p>

			<b>How we use your information</b><br>

			<p>We use the information we collect in various ways, including to:</p>

			<ul>
			<li>Provide, operate, and maintain our website</li>
			<li>Improve, personalize, and expand our website</li>
			<li>Understand and analyze how you use our website</li>
			<li>Develop new products, services, features, and functionality</li>
			<li>Communicate with you, either directly or through one of our partners, including for customer service, to provide you with updates and other information relating to the website, and for marketing and promotional purposes</li>
			<li>Send you emails</li>
			<li>Find and prevent fraud</li>
			</ul><br>
			
			<b>Log Files</b><br>

			<p>Muthu News Agency follows a standard procedure of using log files. 
			These files log visitors when they visit websites. 
			All hosting companies do this and a part of hosting services' analytics. 
			The information collected by log files include internet protocol (IP) addresses, browser type, Internet Service Provider (ISP), date and time stamp, referring/exit pages, and possibly the number of clicks. 
			These are not linked to any information that is personally identifiable. 
			The purpose of the information is for analyzing trends, administering the site, tracking users' movement on the website, and gathering demographic information.</p>

			<b>Cookies and Web Beacons</b><br>
			<p>Like any other website, Muthu News Agency uses ‘cookies'. These cookies are used to store information including visitors' preferences, and the pages on the website that the visitor accessed or visited. The information is used to optimize the users' experience by customizing our web page content based on visitors' browser type and/or other information.</p>

			<b>DoubleClick DART Cookie</b><br>
			<p>Google is one of a third-party vendor on our site. It also uses cookies, known as DART cookies, to serve ads to our site visitors based upon their visit to www.website.com and other sites on the internet. However, visitors may choose to decline the use of DART cookies by visiting the Google ad and content network Privacy Policy at the following URL – https://policies.google.com/technologies/ads.</p>

			<p>Some of advertisers on our site may use cookies and web beacons. Our advertising partners are listed below. Each of our advertising partners has their own Privacy Policy for their policies on user data. For easier access, we hyperlinked to their Privacy Policies below.</p>

			<ul><li>Google</li></ul>

			<a href="https://policies.google.com/technologies/ads" id="sanddbtn"> https://policies.google.com/technologies/ads </a><br><p></p><br>

			<b>Advertising Partners Privacy Policies</b><br>

			<p>You may consult this list to find the Privacy Policy for each of the advertising partners of Muthu News Agency.</p>

			<p>Third-party ad servers or ad networks uses technologies like cookies, JavaScript, or Web Beacons that are used in their respective advertisements and links that appear on Muthu News Agency, which are sent directly to users' browser. They automatically receive your IP address when this occurs. These technologies are used to measure the effectiveness of their advertising campaigns and/or to personalize the advertising content that you see on websites that you visit.</p>

			<p>Note that Muthu News Agency has no access to or control over these cookies that are used by third-party advertisers.</p>

			<b>Third-Party Privacy Policies</b><br>

			<p>Muthu News Agency's Privacy Policy does not apply to other advertisers or websites. Thus, we are advising you to consult the respective Privacy Policies of these third-party ad servers for more detailed information. It may include their practices and instructions about how to opt-out of certain options. You may find a complete list of these Privacy Policies and their links here: Privacy Policy Links.</p>

			<p>You can choose to disable cookies through your individual browser options. To know more detailed information about cookie management with specific web browsers, it can be found at the browsers' respective websites. What Are Cookies?</p><br>

			<b>CCPA Privacy Policy (Do Not Sell My Personal Information)</b><br>

			<p>Under the CCPA, among other rights, California consumers have the right to:</p>

			<p>Request that a business that collects a consumer's personal data disclose the categories and specific pieces of personal data that a business has collected about consumers.</p>

			<p>Request that a business delete any personal data about the consumer that a business has collected.</p>

			<p>Request that a business that sells a consumer's personal data, not sell the consumer's personal data.</p>

			<p>If you make a request, we have one month to respond to you. If you would like to exercise any of these rights, please contact us.</p>

			<b>GDPR Privacy Policy (Data Protection Rights)</b><br>

			<p>We would like to make sure you are fully aware of all of your data protection rights. Every user is entitled to the following:</p>

			<p>The right to access – You have the right to request copies of your personal data. We may charge you a small fee for this service.</p>

			<p>The right to rectification – You have the right to request that we correct any information you believe is inaccurate. You also have the right to request that we complete the information you believe is incomplete.</p>

			<p>The right to erasure – You have the right to request that we erase your personal data, under certain conditions.</p>

			<p>The right to restrict processing – You have the right to request that we restrict the processing of your personal data, under certain conditions.</p>

			<p>The right to object to processing – You have the right to object to our processing of your personal data, under certain conditions.</p>

			<p>The right to data portability – You have the right to request that we transfer the data that we have collected to another organization, or directly to you, under certain conditions.</p>

			<p>If you make a request, we have one month to respond to you. If you would like to exercise any of these rights, please contact us.</p>

			<b>Children's Information</b><br>

			<p>Another part of our priority is adding protection for children while using the internet. We encourage parents and guardians to observe, participate in, and/or monitor and guide their online activity.</p>

			<p>Muthu News Agency does not knowingly collect any Personal Identifiable Information from children under the age of 13. If you think that your child provided this kind of information on our website, we strongly encourage you to contact us immediately and we will do our best efforts to promptly remove such information from our records.</p>
			</div>
			</div>
			</div>
		</div>
		</div>
	</footer>
</body>
</html>