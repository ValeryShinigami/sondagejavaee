<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Inscrivez-vous</title>
</head>
<body>
	<h1>Inscrivez-vous en remplissant le formulaire ci-dessous.</h1>
	<form method="POST" action="Ajouter">
		<div>
			<label for="id">Id</label>
		</div>
		<div>
			<input type="text" name="id" id="id">
		</div>
		<div>
			<label for="nom">Nom</label>
		</div>
		<div>
			<input type="text" name="nom" id="nom">
		</div>
		<div>
			<label for="prenom">Prénom</label>
		</div>
		<div>
			<input type="text" name="prenom" id="prenom">
		</div>
		<div>
			<label for="email">Adresse mail</label>
		</div>
		<div>
			<input type="email" name="email" id="email">
		</div>
		<div>
			<label for="age">Âge</label>
		</div>
		<div>
			<input type="number" name="age" id="age">
		</div>
		<div>
			<label for="profession">Profession</label>
		</div>
		<div>
			<input type="text" name="profession" id="profession">
		</div>
		<div>
			<label for="sexe">Sexe</label>
		</div>
		<div>
			<select id="sexe" name="sexe">
				<option value="M">Homme</option>
				<option value="F">Femme</option>
			</select>
		</div>
		<div>
			<button type="submit">Valider</button>
		</div>
	</form>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>