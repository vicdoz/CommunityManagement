TODO list:
	-igu amb controladors afegits.
	-Acabar mapping de president.
	- Afegir avisos al insertar / editar / borrar entrades de la bd
		- El inmoble no deu d'existir (comprobar ESC-PIS-POR)
		- El propietari no deu d'existir (comprobar NIF)
		- La comunitat no deu d'existir (comprobar NOM)		
	---------------------------------------------------------------------------------
BUGS:
	- No es pot recuperar concepte, falla al crear una nova línea.
	---------------------------------------------------------------------------------
REVISAR:
	-	Estan fets tots els controladors.En el exemple he probat totes les altes 
	 	i van perfectes.
		Al ser copy&paste supose q les modificacions/baixes,deurien de anar be.Revisar 
		que es aixi.
		Podria haber algun fallo que se me haja escapat en els controladors(copy &paste),
		igual algun nom no es el que toca exacte.	
	- 	Revisar els "recuperarPorX" en teoría en recuperar per Pos es podría fer TOT
	ja que a la taula ho tenim a la posició del controlador
