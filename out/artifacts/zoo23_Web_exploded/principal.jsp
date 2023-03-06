<!DOCTYPE html>
<html cmlns:th="http://www.thymleaf.org" >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>zoo en folie</title><link rel="stylesheet" type="text/css" href="zoo.css"></link></head><body>
<header>
	<img class="logoGauche" alt="" src="images/logo.png"/>
	<img class="logoDroit" alt="" src="images/logo.png"/><p>Le zoo en folie</p>
</header>
<nav>
	<ul>
		<li><a href="/zoophp/org/formation/zoo/controleurs/controleur.php?action=manger">nourrir animaux</a></li>
		<li><a href="#" onclick="document.fzoo.submit();">devorer</a></li>
		<li><a href="/zoophp/org/formation/zoo/controleurs/controleur.php?action=entrer">faire entrer un visiteur</a></li>
		<li><a href="/zoophp/org/formation/zoo/controleurs/controleur.php?action=sortir">faire sortir un visiteur</a></li>
		<li><a href="/zoophp/org/formation/zoo/controleurs/controleur.php?action=fermer">fermer le zoo</a></li>
	</ul>
</nav>
<article>
	<img alt="mon zoo" src="images/plan-zoo.jpg" width="100%" height="100%"/>
	<form name="fzoo" action="/zoophp/org/formation/zoo/controleurs/controleur.php" method="post">
		<input type="hidden" value="devorer" name="action"/>

		<div th:each="bete:${modele}"  th:style="${'position:absolute;top:'+bete.y +'px;left:'+bete.x+'px}">
			<img  src="${bete.image}" class="animal"/>
			<div class="afficheAnimal" th:text="${bete.pancarte}" ><br/>
				<input type="radio" name="mangeur" value="0"> Mangeur &nbsp;&nbsp;
				<input type="radio" name="mange" value="0"> Mange<br></div>
		</div>

		<div id="visiteurs" >
			<img class="visiteur" src="images/visiteur.png"/>
			<img class="visiteur" src="images/visiteur.png"/>
		</div>
	</form>
</article>

<footer class="pied" id="pied">
</footer>
</body>
</html>