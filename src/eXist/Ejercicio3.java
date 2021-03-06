package eXist;

import javax.xml.xquery.*;
import net.xqj.exist.ExistXQDataSource;

public class Ejercicio3 {
	public static void main(String[] args){
		try{
			XQDataSource server = new ExistXQDataSource();
			server.setProperty ("serverName", "192.168.56.102");
			server.setProperty ("port","8080");
			server.setProperty ("user","admin");
			server.setProperty ("password","austria");
			XQConnection conn = server.getConnection();
			XQPreparedExpression consulta;
			XQResultSequence resultado;
			consulta = conn.prepareExpression ("for $pr in doc('nueva/productos.xml')/productos/produc[precio > 50] return $pr");
			resultado = consulta.executeQuery();
			int count = 0;
			while (resultado.next()) {
				count++;
			}
			System.out.println(count);
			conn.close();
			
		} catch (XQException ex) {System.out.println("Error al operar " + ex.getMessage());}
	}
}