<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="se.bth.wpl.global.Global"%>


<%
  String appName = Global.getAppName();
  String appVersion = Global.getAppVersion();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=appName %> <%=appVersion %> [PA2401] - Group 5 - </title>

<script language="javascript" type="text/javascript" src="../js/index.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery.js"></script>

<link rel="stylesheet" type="text/css" media="all" href="../css/index.css" />

</head>

<body onload="loadPage('personal')">
<img alt="thankyou" src="../res/resources/images/logo-1.png">

<h1 style="text-align:center"><%=appName %> <%=appVersion %></h1><br /><br />

<div id="container">
<form  name="settingsForm" id="settingsForm" class="niceform" method="post" action="requestProduct" onsubmit="return validateForm()"  >
	<fieldset>
    	<legend>Product Type</legend>
        <h2>Which kind of website do you want to produce?</h2>
        <input type="radio" id="site_type" name="site_type" value="personal" Checked onclick="changeType('personal')" /> Personal  
        <input type="radio" id="site_type" name="site_type" value="company"  onclick="changeType('company')"/> Company
        
	</fieldset>

	<fieldset>
    	<legend>Basic Settings</legend>

			<p>
            Site name * :
            <input type="text" name="sitename" id="sitename" size="32" maxlength="128" />
            </p>
 
 			<p>
            Text font :
            <input type="radio" name="font" value="times" Checked /> Times  
			<input type="radio" name="font" value="verdana" /> Verdana
			<input type="radio" name="font" value="arial" /> Arial
			</p>

 
        
		<div id="colorDivPE" style="position:relative">
       <p>
            Bg color :
            <input type="radio" name="colorPE" value="black" Checked /> Black  
        		<input type="radio" name="colorPE" value="lightblue" /> Light blue
      		    <input type="radio" name="colorPE" value="pink" /> Pink
      </p>
        </div>
        
        <div id="colorDivCO"  style="position:relative">
       
          <p> Bg color :
          <input type="radio" name="colorCO" value="black" Checked /> Black  
          <input type="radio" name="colorCO" value="lightblue" /> Light blue
          </p>
        
        </div>
	</fieldset>

<fieldset>
    	<legend>Contact Settings</legend>

<p>Contact name * :  
  <input name="cname" type="text"  id="cname" size="50" />
</p>


<p>E-mail address * : 
  <input name="cmail" type="text" id="cmail" size="50" />
</p>

<p>Phone number : 
<input type="checkbox" name="cphoneCheck" value="yes" onclick="toggleForm(this.checked,'cphoneValue','')"/> 
<input name="cphoneValue" type="text" DISABLED id="cphoneValue" size="50" />
</p>


<div id="addressDivCO" style=" position:relative">
<p>Address : 
	<input type="checkbox" name="caddressCheck" id="caddressCheck" value="yes" onclick="toggleForm(this.checked,'caddressValue','* (Street,City,Contry) *','map')"/> 
	<input name="caddressValue" type="text" DISABLED id="caddressValue" onclick="this.value=''" value="* (Street,City,Contry) *" size="65" /> 
	<input name="mapCheckBox" id="mapCheckBox" TYPE=CHECKBOX disabled="disabled">Insert Map<BR> 
</p>
			
</div>

<div id="addressDivPE"  style="position:relative">
<p>Address : 
<input type="checkbox" name="paddressCheck" id ="paddressCheck" value="yes" onclick="toggleForm(this.checked,'paddressValue','* (Street,City,Contry) *')"/> 
<input name="paddressValue" type="text" DISABLED id="paddressValue" onclick="this.value=''" value="* (Street,City,Contry) *" size="80" />
</p>
</div>

</fieldset>
    


	<fieldset>
    	<legend>Sub Pages settings</legend>
<h3>Sub Pages Settings</h3>

<p>
<h4>Home page</h4>
<p>Home page title : <input name="home_title" id="home_title" type="text"  size="60"/><br />  </p>
<h4>Contact page</h4>
<p>Contact page title : <input name="contact_title" id="contact_title"type="text"  size="60" /><br />  </p>
<h4>About page</h4>
<p>About page title : <input name="about_title" id="about_title" type="text" size="60" /><br />  </p>

<div id="subPagesDivPE" style="position:relative">
<h4>Portfolio page <input type="checkbox" name="portfolioCheck" id="portfolioCheck" value="yes" onclick="toggleForm(this.checked,'','','portfolio')"/> </h4>
<p>Portfolio page title : <input name="portNameID" id="portNameID"  type="text" size="60" DISABLED /><br />  </p>
<p>Select layout for portfolio: 
<input type="radio" id ="portRadioID1" name="portRadio" value="vertical" Checked DISABLED  /> Vertical  
<input type="radio"  id ="portRadioID2" name="portRadio" value="horizontal" DISABLED  /> Horizontal
</p>
</div>

<div id="subPagesDivCO"  style="position:relative">

<h4>Job Offer page</h4>
<p>Job Offer page title : <input name="jobOfferTitle" id="jobOfferTitle" type="text" size="60" /><br />  </p>
<p>Apply for job button  : 
	<input type="checkbox" name="jobCheck" id="jobCheck" value="yes" onclick="toggleForm(this.checked,'jobMail','* Type email to receive job applications *')"/> 
	<input id="jobMail" name="jobMail" type="text" value='* Type email to receive job applications *' onclick="this.value=''" size="50" DISABLED /> 
</p>

<h4>Product and Services page <input type="checkbox" name="productCheck" id="productCheck" value="yes" onclick="toggleForm(this.checked,'','','product')"/> </h4>
<p>Product and Services page title : <input name="productNameID" id="productNameID" type="text" size="60" DISABLED /><br />  </p>
<p>Number of Product and Services categories: 
<input type="radio" id ="productRadioID1" name="productRadio" value="1"  DISABLED  /> 1  
<input type="radio"  id ="productRadioID2" name="productRadio" value="2" DISABLED  /> 2
<input type="radio"  id ="productRadioID3" name="productRadio" value="3" Checked DISABLED  /> 3
</p>
</div>
</p>
	</fieldset>
    
    
	<fieldset>
    	<legend>Social Plugin-ins</legend>

<div id="fbSocialDivPE" style=" position:relative">
</div>

<div id="fbSocialDivCO" style=" position:relative">
<p>Facebook Social Plug-in  : 
	<input type="checkbox" name="fbSocial" id="fbSocial" value="yes" onclick="toggleForm(this.checked,'fbSocialUrl',' * Facebook page URL * ')"/> 
	<input name="fbSocialUrl" id="fbSocialUrl" type="text" value=' * Facebook page URL * ' onclick="this.value=''" size="50" DISABLED /> 
</p>
			
</div>


<p>Facebook Like Button : 
<input type="checkbox" name="fbLikeButton" id="fbLikeButton" value="yes"/> 
</p>

<p>Re-tweet button : 
<input type="checkbox" name="rtwBtnCheck" id="rtwBtnCheck" value="yes" onclick="toggleForm(this.checked,'retwButtonURL','* Default Tweet text *')"/> 
<input id="retwButtonURL" name="retwButtonURL" type="text" value="* Default Tweet text *" onclick="this.value=''" size="50" DISABLED />

</p>

<h4>Social Icons [Footer]</h4>

<p>Twitter icon : 
<input type="checkbox" name="twIcon" id="twIcon" value="yes" onclick="toggleForm(this.checked,'twButtonURL','* Twitter profile URL *')"/> 
<input  id="twButtonURL" name="twButtonURL" type="text" DISABLED onclick="this.value=''" value="* Twitter profile URL *" size="50" />

</p>


<p>Linkedin icon : 
<input type="checkbox" name="ldIcon" id="ldIcon" value="yes" onclick="toggleForm(this.checked,'ldButtonURL','* Linkedin URL *')"/> 
<input id="ldButtonURL" name="ldButtonURL" type="text" DISABLED  onclick="this.value=''" value="* Linkedin URL *" size="50" />

</p>

<p>Google+ icon : 
<input type="checkbox" name="gplusIcon" id="gplusIcon" value="yes" onclick="toggleForm(this.checked,'gplusButtonURL','* Google+ Page URL *')"/> 
<input id="gplusButtonURL" name="gplusButtonURL" type="text" DISABLED  onclick="this.value=''" value="* Google+ Page URL *" size="50" />

</p>

<p>Digg icon : 
<input type="checkbox" name="digIcon" value="yes" /> 
</p>


</fieldset>
    
    
	
    
	<fieldset>
    	<legend>Other settings</legend>
<p>
Footer note :
<input type="text" name="footernote" id="footernote" size="52" maxlength="228" />
</p>   	
    	
<p>Google Analytics <a href="https://www.google.com/support/googleanalytics/bin/answer.py?answer=113500&hl=en_US" target="_blank" > <img src="../img/question_mark.png"></img></a> : 
<input type="checkbox" name="ganalytics" id="ganalytics" value="yes" onclick="toggleForm(this.checked,'ganID','* Google analytics ID *')"/> 
<input name="ganID" type="text" DISABLED id="ganID" onclick="this.value=''" value="* Google analytics ID *" size="50" />
</p>

<div id="tickerDivPE" style="position:relative">
</div>

<div id="tickerDivCO" style="position:relative">
<p>News ticker [sidebar]: 
<input type="checkbox" name="newsCheck" id="newsCheck" value="yes" onclick="toggleForm(this.checked,'newsButtonURL','* URL of rss feed *')"/> 
<input name="newsButtonURL" type="text" DISABLED id="newsButtonURL" onclick="this.value=''" value="* URL of rss feed *" size="50" />
</p>
</div>


<p>Include jquery (1.7.1 min) <a href="http://jquery.com/" target="_blank" > <img src="../img/question_mark.png"></img></a> : 
<input type="checkbox" name="jqueryCheck" value="yes" /> 
</p>
</fieldset>

  <fieldset class="action">
    	<input type="submit" name="submit" id="submit"  class="button"  value="Create Product"/>
    	<div id="creatingProduct"  class="action" style="position:relative; display: none; background: #779977">
		<img src="img/loading.gif"></img>      
</div>
  </fieldset>
</form>

</div>
</body>
</html>
