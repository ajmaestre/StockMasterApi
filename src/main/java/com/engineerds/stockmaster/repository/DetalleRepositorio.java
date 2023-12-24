package src.main.java.com.engineerds.stockmaster.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.main.java.com.engineerds.stockmaster.model.Detalle;

public class DetalleRepositorio extends BaseRepository<Detalle>{

	@Override
	public ResultSet GetAll(Connection conexion, String tabla) {
		String query = "SELECT "
				+ "d.idDetalle as 'detalle.id', "
				+ "d.cantidad as 'detalle.cantidad', "
				+ "d.precioUnitario as 'detalle.precioUnitario', "
				+ "d.precioTotal as 'detalle.precioTotal', "
				+ "f.idFactura as 'factura.id', " 
				+ "f.fecha as 'factura.fecha', "
				+ "f.transaccion as 'factura.transaccion', "
				+ "f.estado as 'factura.estado', "
				+ "f.subtotal as 'factura.subtotal', "
				+ "f.impuesto as 'factura.impuesto', "
				+ "f.total as 'factura.total', "
				+ "f.cantidadTotal as 'factura.cantidadTotal', "
				+ "p.idProducto as 'producto.id', "
				+ "p.nombre as 'producto.nombre', "
				+ "p.descripcion as 'producto.descripcion', "
				+ "p.precioUnitario as 'producto.precioUnitario', "
				+ "p.cantidad as 'producto.cantidad' "
				+ "FROM " + tabla + " AS d "
				+ "INNER JOIN Facturas AS f ON d.idFactura = f.idFactura "
				+ "INNER JOIN Productos AS p ON d.idProducto = p.idProducto"
				+ "";
		Statement stmt;
		ResultSet result;
		try {
			stmt = conexion.createStatement();
			result = stmt.executeQuery(query);
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public ResultSet GetAll(Connection conexion, String tabla, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet Get(Connection conexion, String tabla, int id) {
		String query = "SELECT "
				+ "d.idDetalle as 'detalle.id', "
				+ "d.cantidad as 'detalle.cantidad', "
				+ "d.precioUnitario as 'detalle.precioUnitario', "
				+ "d.precioTotal as 'detalle.precioTotal', "
				+ "f.idFactura as 'factura.id', "
				+ "f.fecha as 'factura.fecha', "
				+ "f.transaccion as 'factura.transaccion', "
				+ "f.estado as 'factura.estado', "
				+ "f.subtotal as 'factura.subtotal', "
				+ "f.impuesto as 'factura.impuesto', "
				+ "f.total as 'factura.total', "
				+ "f.cantidadTotal as 'factura.cantidadTotal', "
				+ "p.idProducto as 'producto.id', "
				+ "p.nombre as 'producto.nombre', "
				+ "p.descripcion as 'producto.descripcion', "
				+ "p.precioUnitario as 'producto.precioUnitario', "
				+ "p.cantidad as 'producto.cantidad' "
				+ "FROM " + tabla + " AS d "
				+ "INNER JOIN Facturas AS f ON d.idFactura = f.idFactura "
				+ "INNER JOIN Productos AS p ON d.idProducto = p.idProducto"
				+ " WHERE idDetalle = " + id;
		Statement stmt;
		ResultSet result;
		try {
			stmt = conexion.createStatement();
			result = stmt.executeQuery(query);
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public ResultSet GetByName(Connection conexion, String tabla, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet GetByName(Connection conexion, String tabla, String name, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Insert(Connection conexion, String tabla, Detalle data) {
		String query = "INSERT INTO " + tabla + " (cantidad, precioUnitario, precioTotal, idFactura, idProducto) VALUES ('"+
				data.getCantidad() + 
				"', " + 
				data.getPrecioUnitario() + 
				", " +
				data.getPrecioTotal() + 
				", " +
				data.getFactura().getIdFactura() + 
				", " +
				data.getProducto().getIdProducto() +
				")";
		Statement stmt;
		int result;
		try {
			stmt = conexion.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public int Delete(Connection conexion, String tabla, int id) {
		String query = "DELETE FROM " + tabla + " WHERE idDetalle = " + id;
		Statement stmt;
		int result;
		try {
			stmt = conexion.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public int Update(Connection conexion, String tabla, Detalle data, int id) {
		String query = "UPDATE " + tabla + " SET "+
				"cantidad = '" + data.getCantidad() + "', "
						+ "precioUnitario = " + data.getPrecioUnitario() + ", "
								+ "precioTotal = " + data.getPrecioTotal() + ", "
								+ "idFactura = " + data.getFactura().getIdFactura() + ", "
										+ "idProducto = " + data.getProducto().getIdProducto()
								+ " WHERE idDetalle = " + id;
		Statement stmt;
		int result;
		try {
			stmt = conexion.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public ResultSet GetLastInsert(Connection conexion) {
		String query = "SELECT LAST_INSERT_ID()";
		Statement stmt;
		ResultSet result;
		try {
			stmt = conexion.createStatement();
			result = stmt.executeQuery(query);
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	public ResultSet GetDetallesByCliente(Connection conexion, String tabla, int id) {
		String query = "SELECT "
				+ "d.idDetalle as 'detalle.id', "
				+ "d.cantidad as 'detalle.cantidad', "
				+ "d.precioUnitario as 'detalle.precioUnitario', "
				+ "d.precioTotal as 'detalle.precioTotal', "
				+ "f.idFactura as 'factura.id', "
				+ "f.fecha as 'factura.fecha', "
				+ "f.transaccion as 'factura.transaccion', "
				+ "f.estado as 'factura.estado', "
				+ "f.subtotal as 'factura.subtotal', "
				+ "f.impuesto as 'factura.impuesto', "
				+ "f.total as 'factura.total', "
				+ "f.cantidadTotal as 'factura.cantidadTotal', "
				+ "p.idProducto as 'producto.id', "
				+ "p.nombre as 'producto.nombre', "
				+ "p.descripcion as 'producto.descripcion', "
				+ "p.precioUnitario as 'producto.precioUnitario', "
				+ "p.cantidad as 'producto.cantidad' "
				+ "FROM " + tabla + " AS d "
				+ "INNER JOIN Facturas AS f ON d.idFactura = f.idFactura "
				+ "INNER JOIN Productos AS p ON d.idProducto = p.idProducto"
				+ " WHERE idCliente = " + id;
		Statement stmt;
		ResultSet result;
		try {
			stmt = conexion.createStatement();
			result = stmt.executeQuery(query);
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}	
	}
	
	public ResultSet GetDetallesByFactura(Connection conexion, String tabla, int id){
		String query = "SELECT "
				+ "d.idDetalle as 'detalle.id', "
				+ "d.cantidad as 'detalle.cantidad', "
				+ "d.precioUnitario as 'detalle.precioUnitario', "
				+ "d.precioTotal as 'detalle.precioTotal', "
				+ "d.idFactura as 'detalle.idFactura', "
				+ "f.idFactura as 'factura.id', "
				+ "f.fecha as 'factura.fecha', "
				+ "f.transaccion as 'factura.transaccion', "
				+ "f.estado as 'factura.estado', "
				+ "f.subtotal as 'factura.subtotal', "
				+ "f.impuesto as 'factura.impuesto', "
				+ "f.total as 'factura.total', "
				+ "f.cantidadTotal as 'factura.cantidadTotal', "
				+ "p.idProducto as 'producto.id', "
				+ "p.nombre as 'producto.nombre', "
				+ "p.descripcion as 'producto.descripcion', "
				+ "p.precioUnitario as 'producto.precioUnitario', "
				+ "p.cantidad as 'producto.cantidad' "
				+ "FROM " + tabla + " AS d "
				+ "INNER JOIN Facturas AS f ON d.idFactura = f.idFactura "
				+ "INNER JOIN Productos AS p ON d.idProducto = p.idProducto"
				+ " WHERE d.idFactura = " + id;
		Statement stmt;
		ResultSet result;
		try {
			stmt = conexion.createStatement();
			result = stmt.executeQuery(query);
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	public ResultSet GetLastDetalle(Connection conexion, String tabla){	
		String query = "SELECT "
				+ "d.idDetalle as 'detalle.id', "
				+ "d.cantidad as 'detalle.cantidad', "
				+ "d.precioUnitario as 'detalle.precioUnitario', "
				+ "d.precioTotal as 'detalle.precioTotal', "
				+ "f.idFactura as 'factura.id', "
				+ "f.fecha as 'factura.fecha', "
				+ "f.transaccion as 'factura.transaccion', "
				+ "f.estado as 'factura.estado', "
				+ "f.subtotal as 'factura.subtotal', "
				+ "f.impuesto as 'factura.impuesto', "
				+ "f.total as 'factura.total', "
				+ "f.cantidadTotal as 'factura.cantidadTotal', "
				+ "p.idProducto as 'producto.id', "
				+ "p.nombre as 'producto.nombre', "
				+ "p.descripcion as 'producto.descripcion', "
				+ "p.precioUnitario as 'producto.precioUnitario', "
				+ "p.cantidad as 'producto.cantidad' "
				+ "FROM " + tabla + " AS d "
				+ "INNER JOIN Facturas AS f ON d.idFactura = f.idFactura "
				+ "INNER JOIN Productos AS p ON d.idProducto = p.idProducto"
				+ " ORDER BY idDetalle DESC LIMIT 1";
		Statement stmt;
		ResultSet result;
		try {
			stmt = conexion.createStatement();
			result = stmt.executeQuery(query);
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
