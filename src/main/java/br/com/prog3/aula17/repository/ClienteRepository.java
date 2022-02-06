package br.com.prog3.aula17.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.com.prog3.aula17.domain.Cliente;
public interface ClienteRepository extends CrudRepository<Cliente,
        Long>{
    List<Cliente> findByIdade(int idade);
}