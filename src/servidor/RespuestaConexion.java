package servidor;

import java.io.Serializable;


/*/Clase creada para diferenciar que tipo conexion se esta realizando:
 *  Si es de tipo usuario quien quiere acceder, entregara un entero igual a 1
 * Si es de tipo Administrador quien quiere acceder, entrega entero igual a 2
 * Si el servidor no identifica la conexion de quien está queriendo acceder al login,
 * de la solicitud que le esta enviando el cliente
 * esto quiere decir si no es Usuario o Admin, entregara un mensaje de error, pero el 
 * tipo de respuesta sera un entero tipo 3 para diferenciarlo de las demas conexiones.
 */

public class RespuestaConexion implements Serializable {


	public int opcion;

}
