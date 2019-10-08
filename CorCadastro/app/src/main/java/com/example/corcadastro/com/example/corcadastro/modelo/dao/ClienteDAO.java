package com.example.corcadastro.com.example.corcadastro.modelo.dao;

import com.example.corcadastro.com.example.corcadastro.modelo.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteDAO {

    private Map<String, Cliente> clientes;


    protected Map ClienteDAO() {

        if (clientes != null) {

            return clientes;

        } else {

            clientes = new HashMap<String, Cliente>();
            return clientes;
        }

    }

    public void salvar(Cliente cliente) {

        clientes.put(cliente.getCpf(), cliente);
        System.out.println("cliente salvo com sucesso");

    }

}
