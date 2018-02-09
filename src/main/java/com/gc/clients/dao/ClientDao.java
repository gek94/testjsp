package com.gc.clients.dao;

import com.gc.clients.dto.Client;
import java.util.List;

/**
 *
 * @author george
 */
public interface ClientDao {
    
    /**
     * 
     * @param client
     * @return String
     */
    public String create(Client client);
    
    /**
     * 
     * @param client
     * @return String
     */
    public String update(Client client);
    
    /**
     * 
     * @param id
     * @return String
     */
    public String delete(int id);
    
    /**
     * 
     * @param id
     * @return array
     */
    public Client find(int id);
    
    /**
     * 
     * @return List
     */
    public List<Client> list();
            
}
