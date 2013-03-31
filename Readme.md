TODO list:
	- Revisar els "recuperarPorX" en teoría en recuperar per Pos es podría fer TOT
	ja que a la taula ho tenim a la posició del controlador
	- Afegir avisos al insertar / editar / borrar entrades de la bd
		- El inmoble no deu d'existir (comprobar ESC-PIS-POR)
		- El propietari no deu d'existir (comprobar NIF)
		- La comunitat no deu d'existir (comprobar NOM)		
	
BUGS:
	- No es pot actualitzar un inmoble, falla al DAOHibernate.
	- No es pot crear / actualitzar un propietari, falla la hora.
	
	
CHANGELOG 30/03/2013 v1:
 - Modificats alguns recuperaX por getX
 - Creada la interfaç VentanaFacturas en la que es podrà donar d'alta Factures i conceptes
 - Creades les classes ModeloTablaFactura i ModeloTablaConcepto. 
 