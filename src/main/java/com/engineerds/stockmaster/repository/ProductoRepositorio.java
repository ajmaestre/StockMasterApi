package com.engineerds.stockmaster.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.engineerds.stockmaster.model.Producto;

public class ProductoRepositorio extends BaseRepository<Producto>{

	@Override
	public ResultSet GetAll(Connection conexion, String tabla) {
		String query = "SELECT p.idProducto as 'producto.id', p.nombre as 'producto.nombre', "
				+ "p.descripcion as 'producto.descripcion', p.precioUnitario as 'producto.precioUnitario', "
				+ "p.cantidad as 'producto.cantidad', "
				+ "c.idCategoria as 'categoria.id', c.nombre as 'categoria.nombre', "
				+ "c.descripcion as 'categoria.descripcion' "
				+ "FROM " + tabla + " AS p "
				+ "INNER JOIN Categorias as c "
				+ "ON p.idCategoria = c.idCategoria";
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
		String query = "SELECT p.idProducto as 'producto.id', p.nombre as 'producto.nombre', "
				+ "p.descripcion as 'producto.descripcion', p.precioUnitario as 'producto.precioUnitario', "
				+ "p.cantidad as 'producto.cantidad', "
				+ "c.idCategoria as 'categoria.id', c.nombre as 'categoria.nombre', "
				+ "c.descripcion as 'categoria.descripcion' "
				+ "FROM " + tabla + " AS p "
				+ "INNER JOIN Categorias as c "
				+ "ON p.idCategoria = c.idCategoria "
				+ "WHERE p.idCategoria = " + id;
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
		String query = "SELECT p.idProducto as 'producto.id', p.nombre as 'producto.nombre', "
				+ "p.descripcion as 'producto.descripcion', p.precioUnitario as 'producto.precioUnitario', "
				+ "p.cantidad as 'producto.cantidad', "
				+ "c.idCategoria as 'categoria.id', c.nombre as 'categoria.nombre', "
				+ "c.descripcion as 'categoria.descripcion' "
				+ "FROM " + tabla + " AS p "
				+ "INNER JOIN Categorias as c "
				+ "ON p.idCategoria = c.idCategoria "
				+ "WHERE p.nombre LIKE '%" + name + "%'";
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
	public ResultSet GetByName(Connection conexion, String tabla, String name, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Insert(Connection conexion, String tabla, Producto data) {
		String query = "INSERT INTO " + tabla + " (nombre, descripcion, precioUnitario, cantidad, idCategoria) VALUES ('"+
				data.getNombre() + 
				"', '" + 
				data.getDescripcion() + 
				"', " + 
				data.getPrecioUnitario() + 
				", " + 
				data.getCantidad() +
				", " + 
				data.getCategoria().getIdCategoria() +
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
		String query = "DELETE FROM " + tabla + " WHERE idProducto = " + id;
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
	public int Update(Connection conexion, String tabla, Producto data, int id) {
		String query = "UPDATE " + tabla + " SET "+
				"nombre = '" + data.getNombre() + "', "
						+ "descripcion = '" + data.getDescripcion() + "', "
								+ "precioUnitario = " + data.getPrecioUnitario() + ", "
										+ "cantidad = " + data.getCantidad() + ", "
												+ "idCategoria = " + data.getCategoria().getIdCategoria()
								+ " WHERE idProducto = " + id;
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
	
	public ResultSet GetProductsByCategoria(Connection conexion, String tabla, int id) {	
		String query = "SELECT p.idProducto as 'producto.id', p.nombre as 'producto.nombre', "
				+ "p.descripcion as 'producto.descripcion', p.precioUnitario as 'producto.precioUnitario', "
				+ "p.cantidad as 'producto.cantidad', "
				+ "c.idCategoria as 'categoria.id', c.nombre as 'categoria.nombre', "
				+ "c.descripcion as 'categoria.descripcion' "
				+ "FROM " + tabla + " AS p "
				+ "INNER JOIN Categorias as c "
				+ "ON p.idCategoria = c.idCategoria "
				+ "WHERE c.idCategoria = " + id;
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
	
	public ResultSet Count(Connection conexion, String tabla, int id) {
		String query = "SELECT cantidad FROM " + tabla + " WHERE idProducto = " + id;
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
