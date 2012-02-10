<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>WPL - STATIC PLUGINS</title>

</head>


<body>
<h2>### Facebook Social Plugin  ###</h2>

 <iframe src="http://www.facebook.com/plugins/likebox.php?href=http%3A%2F%2Fwww.facebook.com%2Fpages%2FPiscina-di-Spiazzo%2F206799322676923&amp;width=170&amp;colorscheme=light&amp;show_faces=true&amp;stream=true&amp;header=false&amp;height=320" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:250px; height:365px;" allowTransparency="true"></iframe>

<hr />

<h2>### Facebook like button  ###</h2>

<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) {return;}
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=170806709680213";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<div class="fb-like" data-send="false" data-layout="button_count" data-width="450" data-show-faces="false"></div>


<hr />

<h2> ### Re-tweet  ###</h2>
<a href="https://twitter.com/share" class="twitter-share-button" data-text="Enter text here" data-count="vertical">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
<hr />


<h2>### Social Icons ###</h2>
<p>// ### Linkedin  icon ### </p>

<a href="http://it.linkedin.com/in/nicolopaternoster" target="_blank" ><img src="../img/linkedin.png" /></a>
<p> // ### twitter  icon ###
  
  //</p>


<a href="https://twitter.com/#!/NatGeoTraveler" target="_blank" ><img src="../img/twitter.png" /></a>


<p>//  ### Digg  icon ### </p>

<script type="text/javascript">
(function() {
var s = document.createElement('SCRIPT'), s1 = document.getElementsByTagName('SCRIPT')[0];
s.type = 'text/javascript';
s.async = true;
s.src = 'http://widgets.digg.com/buttons.js';
s1.parentNode.insertBefore(s, s1);
})();
</script>

<a class="DiggThisButton DiggMedium"></a>

<hr />

<h2>### NewsTicker ###</h2>
<p>http://www.blastcasta.com/add-news-ticker.aspx</p>

<div id="TickerBC16594428" class="bc_ticker" style="width: 400px;overflow: auto;overflow-x: hidden;border-style: none;border-width: 0;border-color: #FFFFFF;background-color: #FFFFFF;">
<table width="100%">
	<tr>
		<td width="10" style="vertical-align: top;" style="color: #0000CC; font-size: 10pt; font-family: Arial,Helvetica;"><a id="TickerPrevBC16594428" href="javascript: ;" onclick="PrevTickerBC16594428();" class="bc_tickerarrow" style="text-decoration: none; color: #0000CC;">&laquo;</a></td>
		<td id="TickerContentBC16594428" class="bc_tickercontent" style="vertical-align: top;background-color: #FFFFFF;">
			<a id="TickerLinkBC16594428" href="javascript: ;" class="bc_tickerlink" style="text-decoration: none;" target="_top"><b><span id="TickerTitleBC16594428" class="bc_tickertitle" style="color: #0000CC; font-size: 10pt; font-family: Arial,Helvetica;"></span></b></a>			<span id="TickerSummaryBC16594428" class="bc_tickersummary" style="color: #000000; font-size: 10pt; font-family: Arial,Helvetica;"></span>
		</td>
		<td width="10" style="vertical-align: top;" style="color: #0000CC; font-size: 10pt; font-family: Arial,Helvetica;"><a id="TickerNextBC16594428" href="javascript: ;" onclick="NextTickerBC16594428();" class="bc_tickerarrow" style="text-decoration: none; color: #0000CC;">&raquo;</a></td>
	</tr>
</table>
<!-- DO NOT CHANGE OR REMOVE THE FOLLOWING NOSCRIPT SECTION OR THE BLASTCASTA NEWS TICKER WILL NOT FUNCTION PROPERLY. -->
<noscript><a href="http://www.blastcasta.com/" title="News Ticker by BlastCasta"><img src="http://www.poweringnews.com/images/tp.gif" border="0" /></a></noscript>
</div>

<script id="scr16594428" type="text/javascript"></script>
<script type="text/javascript"> /* <![CDATA[ */ 
setTimeout('document.getElementById(\'scr16594428\').src = (document.location.protocol == \'https:\' ? \'https\' : \'http\') + \'://www.poweringnews.com/ticker-js.aspx?feedurl=http%3A//www.developerdotstar.com/mag/rss/devdotstar.xml&changedelay=5&maxitems=-1&showsummary=0&objectid=16594428\'', 500);
 /* ]]> */ </script>
 
<hr />


<h2>### Google Maps ###</h2>
<iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Via+Tino+di+camaino,+Rome,+Italy&amp;aq=0&amp;vpsrc=0&amp;ie=UTF8&amp;hq=&amp;hnear=Via+Tino+di+Camaino+219,+Rome,Italy&amp;t=m&amp;z=14&amp;output=embed"></iframe><br />
<hr />
<h2>### Google Analytics ###</h2>
Insert right Before closing the head tag
How To Get The analytics ID :  https://www.google.com/support/googleanalytics/bin/answer.py?answer=113500&hl=en_US

<input name="textarea" type="text" value="&lt;script type='text/javascript'&gt;  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-20473439-1']);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();&lt;/script&gt;" size="200" />
</input>





<hr />

<h2>### JQuery  ###</h2>
Insert this in the HEAD of each html file
<input type="text" value="<script language='javascript' type='text/javascript' src='js/jquery.js'></script>" size="100"/></input>
<hr />


</body>
</html>
