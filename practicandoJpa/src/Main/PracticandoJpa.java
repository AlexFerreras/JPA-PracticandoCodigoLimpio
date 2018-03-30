
package Main;

import Models.Entities.Cliente;
import Models.Services.ClienteDAOImpl;
import java.util.List;

/**
 *
 * @author alexf
 */
public class PracticandoJpa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClienteDAOImpl clienteD = new ClienteDAOImpl();
        
        Cliente cliente = new Cliente("Abigail", "Rijo", "La caleta");
        
        clienteD.create(cliente);
        
        
        List<Cliente> lista = clienteD.getAll();
        
        
        for(Cliente c: lista){
        
            System.out.println("Nombre: "+c.getNombre());
            System.out.println("Apellido: "+c.getApellido());
            System.out.println("Direccion: "+c.getDireccion());
            
        }
    }
    
}
