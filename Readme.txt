
Propietario:
	- Un propietario no se puede borrar si tiene algun inmueble
	- Propietario:4 digitos entidad, 4 sucursal, 2 control y 10 cuenta.
Comunidad:
	- Seleccionar desde la igu uno de los 4 estados:baja moroso, sin cuadrar,cuadrado;
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
	-Si estan incluidas en una nota no se puede modificar.
	-fecha calculo puede ser vacio.

Emision de recibos:
	-Ver comunidades cuyos estados son "alta" y sus inmublestienen la participacion cuadrada(100%).
Varios:
	- Acabar mapping de president.
	- Afegir avisos al insertar / editar / borrar entrades de la bd
		- El inmoble no deu d'existir (comprobar ESC-PIS-POR)
		- El propietari no deu d'existir (comprobar NIF)
		- La comunitat no deu d'existir (comprobar NOM)	

---------------------------------------------------------------------------------
BUGS:
-opciones predeterminadas salir
-Abrir ventana factura con linea nueva
-arreglar bug linea factura al cerrar y abrir
-arreglar bug factura derecha nota
-titulo de facturas pendientes en ventana notas
-set id recibo de nota informativa
-carta
-revisar excepciones
-en tabla inmuebles mostrar porcentaje
-actualizar tabla factura una vez añadidas las lineas
---------------------------------------------------------------------------------
REVISAR:
	