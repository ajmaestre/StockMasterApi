package src.main.java.com.engineerds.stockmaster.api;

import com.sun.net.httpserver.HttpServer;

import src.main.java.com.engineerds.stockmaster.api.almacen.AlmacenController;
import src.main.java.com.engineerds.stockmaster.api.categoria.CategoriaController;
import src.main.java.com.engineerds.stockmaster.api.cliente.ClienteController;
import src.main.java.com.engineerds.stockmaster.api.empleado.EmpleadoController;
import src.main.java.com.engineerds.stockmaster.api.factura.FacturaController;
import src.main.java.com.engineerds.stockmaster.api.producto.ProductoController;
import src.main.java.com.engineerds.stockmaster.api.proveedor.ProveedorController;
import src.main.java.com.engineerds.stockmaster.api.root.RootController;
import src.main.java.com.engineerds.stockmaster.api.usuario.UsuarioController;


public class Routes {
	
	HttpServer server;
	
	public Routes(HttpServer server) {
		this.server = server;
		RootController.get(server);
		CategoriaController.getRoutes(server);
		ProveedorController.getRoutes(server);
		ClienteController.getRoutes(server);
		EmpleadoController.getRoutes(server);
		AlmacenController.getRoutes(server);
		UsuarioController.getRoutes(server);
		ProductoController.getRoutes(server);
		FacturaController.getRoutes(server);
		run();
	}
	
	public void run() {
		server.setExecutor(null);
        server.start();
	}

}
