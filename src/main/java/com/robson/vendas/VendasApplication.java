package com.robson.vendas;

import com.robson.vendas.domain.entity.Cliente;
import com.robson.vendas.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes){
		return args -> {

			//Maneira mais verbosa de salvar

//			Cliente cliente = new Cliente();
//			cliente.setNome("Robson");
//			clientes.salvar(cliente);


			//Outra maneira de salvar
//			Cliente cliente2 = new Cliente("Outro Cliente");
//			clientes.salvar(cliente2);



			//Maneira mais limpa de salvar
			System.out.println("Salvando clientes");
			clientes.salvar(new Cliente("Robson"));
			clientes.salvar(new Cliente("Adams"));

			System.out.println("Buscando clientes");
			//Obter todos os clientes
			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando clientes");
			//Atualizar clientes
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " Atualizado");
				clientes.atualizar(c);
			});

			System.out.println("Buscando nome por letras");
			clientes.buscarPorNome("Ada").forEach(System.out::println); //Buscando o nome do cliente pelas iniciais ou letras semelhantes.

			todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			//Deletando Clientes
			System.out.println("Deletando clientes");
			clientes.obterTodos().forEach(
					c -> {
						clientes.deletar(c);
					}
			);

			todosClientes = clientes.obterTodos();
			if (todosClientes.isEmpty()) {
				System.out.println("Nenhum clientes encontrado!");
			}else {
				todosClientes.forEach(System.out::println);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
