package com.gc.clients.daoImpl;

import com.gc.clients.dao.ClientDao;
import com.gc.clients.db.Connection;
import com.gc.clients.dto.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author george
 */
public class ClientDaoImpl extends Connection implements ClientDao {

    public ClientDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    @Override
    public String create(Client client) {
        sql.delete(0, sql.length());
        sql.append("INSERT INTO clientes (cedula,nombres,apellidos)"
                + "values (?,?,?)");
        try {
            java.sql.Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            
            ps.setString(1, client.getCedula());
            ps.setString(2, client.getNombres());
            ps.setString(3, client.getApellidos());
            
            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0) {
                message = "0 filas afectadas";
            } else {
                message = "Cliente creado correctamente";
            }
        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
    }

    @Override
    public String update(Client client) {
        sql.delete(0, sql.length());
        sql.append("UPDATE clientes SET ")
            .append("cedula = ?,")
            .append("nombres = ?,")
            .append("apellidos = ? ")
            .append("WHERE id = ?");
        
        try {
            java.sql.Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            
            ps.setString(1, client.getCedula());
            ps.setString(2, client.getNombres());
            ps.setString(3, client.getApellidos());
            ps.setInt(4, client.getId());
            
            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0) {
                message = "0 filas afectadas";
            } else {
                message = "Cliente actualizado correctamente";
            }
        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
    }

    @Override
    public String delete(int id) {
        sql.delete(0, sql.length());
        sql.append("DELETE FROM clientes WHERE id = ?");
        
        try {
            java.sql.Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            
            ps.setInt(1, id);
            
            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0) {
                message = "0 filas afectadas";
            } else {
                message = "Cliente eliminado con éxito";
            }
        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
    }

    @Override
    public Client find(int id) {
        sql.delete(0, sql.length());
        sql.append("SELECT id, cedula, nombres, apellidos FROM clientes WHERE id = ?");
        Client cli = null;
        
        try {
            java.sql.Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                cli = new Client();
                cli.setId(rs.getInt(1));
                cli.setCedula(rs.getString(2));
                cli.setNombres(rs.getString(3));
                cli.setApellidos(rs.getString(4));
                message = "Operación exitosa";
            } else {
                message = "Sin resultados";
            }
        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return cli;
    }

    @Override
    public List<Client> list() {
        sql.delete(0, sql.length());
        sql.append("SELECT id, cedula, nombres, apellidos "
                + "FROM clientes ORDER BY nombres, apellidos");
        
        List<Client> clientList = new ArrayList<>();
        
        try {
            java.sql.Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Client cli = new Client();
                cli.setId(rs.getInt(1));
                cli.setCedula(rs.getString(2));
                cli.setNombres(rs.getString(3));
                cli.setApellidos(rs.getString(4));
                
                clientList.add(cli);
            }
            message = "Operación exitosa.";
        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return clientList;
    }
    
}
