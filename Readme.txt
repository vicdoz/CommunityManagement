Varios:
	- Acabar mapping de president.
	- Afegir avisos al insertar / editar / borrar entrades de la bd
		- El inmoble no deu d'existir (comprobar ESC-PIS-POR)
		- El propietari no deu d'existir (comprobar NIF)
		- La comunitat no deu d'existir (comprobar NOM)	
Propietario:
	- Un propietario no se puede borrar si tiene algun inmueble
	- Propietario->añadir email en la IGU
	- Propietario:4 digitos entidad, 4 sucursal, 2 control y 10 cuenta.
Comunidad:
	- Estados comunidad: Sin cuadrar, cuadrado,baja,moroso
	- Una comunidad no se puede borrar si tiene inmuebles o facturas.En ese caso le
	  ponemos estado “baja” (o “moroso” si hay algún recibo pendiente de cobro).
Inmuebles:
	-restriccion para hacer cambios:No estar en estado de baja o moroso la comunidad.
	-Si se cumple, se puede:
		-añadir inmuebles,
		-cambiar propietario(avisando si hay recibos sin pagar)
		-cambiar % participacion.Si la suma de los de la cumunidad es 100 el estado pasa a cuadrado, sino, sin cuadrar.
		-modificar  datos antiguedad del propietario.
		-borrar inmueble sino tiene recibos
Factura:
	-Añadir numero de factura,cif,fecha de la factura, importe sin iva, iva aplicado,importe del iva, suma factura con iva.
	-Importe factura =total factura con IVA incluido
	-Si estan incluidas en una nota no se puede modificar.
	-fecha calculo puede ser vacio.

Emision de recibos:
	-Ver comunidades cuyos estados son "alta" y sus inmublestienen la participacion cuadrada(100%).
	-
---------------------------------------------------------------------------------
BUGS:
	- 
---------------------------------------------------------------------------------
REVISAR:
	