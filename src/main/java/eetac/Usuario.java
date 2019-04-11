package eetac;

import eetac.Pedido;

import java.util.LinkedList;

public class Usuario {
    String idUsuario;
    LinkedList<Pedido> listapedido;

    public Usuario(String idUsuario) {
        this.idUsuario = idUsuario;
        this.listapedido = new LinkedList<Pedido>();
    }

    public void addpedido(Pedido p){
        this.listapedido.add(p);
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LinkedList<Pedido> getListapedido() {
        return listapedido;
    }

    public void setListapedido(LinkedList<Pedido> listapedido) {
        this.listapedido = listapedido;
    }
}
