/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Pedido;
import Entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author farfa
 */
@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext(unitName = "SurtiExpressV.3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }

    public void agregarProductoAlPedido(List<Producto> listaProductos, Pedido pedido) {
        for (Producto producto : listaProductos) {
            Query query = em.createNativeQuery("INSERT INTO pedido_producto (Id_Pedido, Id_Producto) VALUES (?1, ?2)");
            query.setParameter(1, pedido.getIdPedido());
            query.setParameter(2, producto.getIdProducto());
            query.executeUpdate();
        }
    }

    public List<Producto> listaPedidos(Pedido pedido) {
        Pedido u = null;
        Query query;
        ProductoFacade pf = new ProductoFacade();
        List<Producto> listaProductos = new ArrayList<Producto>();
        try {
            query = em.createNativeQuery("SELECT Id_Producto FROM pedido_producto WHERE Id_Pedido = ?1");
            query.setParameter(1, pedido.getIdPedido());
            List<Integer> listPro = query.getResultList();
            if (!listPro.isEmpty()) {
                for (Integer i : listPro) {
                    int indice = (int) i;
                    Producto p = new Producto();
                    p = pf.find(indice);
                    listaProductos.add(p);
                }
                return listaProductos;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaProductos;
    }

}
