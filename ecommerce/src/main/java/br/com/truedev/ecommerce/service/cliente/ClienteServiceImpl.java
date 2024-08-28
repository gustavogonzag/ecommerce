package br.com.truedev.ecommerce.service.cliente;

import br.com.truedev.ecommerce.dao.ClienteDAO;
import br.com.truedev.ecommerce.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private ClienteDAO cliDao;

    @Override
    public Cliente cadastrarNovoCliente(Cliente novo) {
        return cliDao.save(novo);
    }

    @Override
    public Cliente alterarCliente(Cliente cliente) {
        return cliDao.save(cliente);
    }

    @Override
    public Cliente recuperarClientePeloId(int id) {
        return cliDao.findById(id).orElse(null);
    }

    @Override
    public Cliente recuperarClientePeloTelefone(String telefone) {
        return cliDao.findByTelefone(telefone);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return (List<Cliente>) cliDao.findAll();
    }
}
