<%@ page import="org.formation.ouafi.service.CagePojo"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>zoo en folie</title><link rel="stylesheet" type="text/css" href="zoo.css"></link></head><body>
<header>
	<img class="logoGauche" alt="" src="images/logo.png"/>
	<img class="logoDroit" alt="" src="images/logo.png"/><p>Le zoo en folie</p>
</header>
<nav>
	<li><a href="/zoo23_Web_exploded/nourrir">Nourrir animaux</a></li>
	<ul>
		<li><a href="#" onclick="document.fzoo.submit();">devorer</a></li>
		<li><a href="/zoophp/org/formation/zoo/controleurs/controleur.php?action=entrer">faire entrer un visiteur</a></li>
		<li><a href="/zoophp/org/formation/zoo/controleurs/controleur.php?action=sortir">faire sortir un visiteur</a></li>
		<li><a href="/zoophp/org/formation/zoo/controleurs/controleur.php?action=fermer">fermer le zoo</a></li>
	</ul>
</nav>
<article>

	<img alt="mon zoo" src="images/plan-zoo.jpg" width="100%" height="100%"/>
	<form name="fzoo" action="/zoo23_Web_exploded/devorer" method="post">
		<input type="hidden" value="devorer" name="action"/>
		<%
			List<CagePojo> animaux = (List<CagePojo>) request.getAttribute("modele");
			for(CagePojo cp :animaux){
				out.println("<div style=\"position:absolute;top:"+cp.getY()+"px;left:"+cp.getX()+"px\">");
				out.println("<img  src=\""+cp.getImage()+"\" class=\"animal\"/>");
				out.println("<div class=\"afficheAnimal\" >"+cp.getPancarde()+"<br/>");
				out.println("<input type=\"radio\" name=\"mangeur\" value="+ animaux.indexOf(cp) +"> Mangeur &nbsp;&nbsp;<input type=\"radio\" name=\"mange\" value=\""+animaux.indexOf(cp)+"\"> Mange<br></div></div>");
			}
		%>



		</div>
		<div id="visiteurs" >
			<img class="visiteur" src="images/visiteur.png"/>
			<img class="visiteur" src="images/visiteur.png"/>
		</div>
	</form>
</article>

<footer class="pied" id="pied">
	<%
			out.println(request.getAttribute("msg"));
	%>
</footer>
</body>
</html>
