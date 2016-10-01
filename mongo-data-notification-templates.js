use template
show collections
db.createCollection("notification")
db.notification.insert([
{
		
        "type" : "email",
        "body" : "<html><body><p>Hello #USER#,</p><p>We have successfully received your application with a reference no #APPN_ID#.<br/>We will keep you updated on your application progress.<br/>If you have any query please contact us on #CONTACT# or reply to this email without changing the subject.<br/><br/>Best Regards,<br/>Team DemoBank</p><img src='cid:identifier1234' style='width:85px;height:75px;'></body></html>",
        "subject" : "Successfully Received Application-#APP_ID#",
	      "communicationType" : "application-received"
},
{
		
        "type" : "email",
        "body" : "<html><body><p>Hello #USER#,</p><p>Your application with a reference no #APPN_ID# has been ACCEPTED.<br/>You will receive your credit card and PIN by post in next few days.<br/>If you have any query please contact us on #CONTACT# or reply to this email without changing the subject.<br/><br/>Best Regards,<br/>Team DemoBank</p><img src='cid:identifier1234'style='width:85px;height:75px;'></body></html>",
	      "subject" : "Congratulation! Your Application-#APP_ID# is Successfully",
	      "communicationType" : "application-accepted"
}
]
)
