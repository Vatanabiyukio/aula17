package br.com.prog3.aula17.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.prog3.aula17.domain.Cliente;
import br.com.prog3.aula17.repository.ClienteRepository;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public List<Cliente> findAll(){
        return (List<Cliente>) clienteRepository.findAll();
    }
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
    public List<Cliente> findByIdade(int idade) {
        return clienteRepository.findByIdade(idade);
    }
    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}