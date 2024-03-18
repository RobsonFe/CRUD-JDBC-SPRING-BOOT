package com.robson.vendas.domain.repositorio;

import com.robson.vendas.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    //Salvar o cliente na base de dados.
    private static String INSERT = "insert into cliente (nome) values (?) ";

    //Buscar clientes da base de dados
    private static String SELECT_ALL = "SELECT * FROM CLIENTE";
    private static String UPDATE = "update cliente set nome = ? where id =?";
    private static String DELETE = "delete from cliente where id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Salvar cliente no banco de dados
    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(
            INSERT, new Object[]{
                    cliente.getNome()
                }
        );
        return cliente;
    }

    //Buscar clientes no banco de dados
    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, getRowMapper());
    }

    private static RowMapper<Cliente> getRowMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                return new Cliente(id, nome);

            }
        };
    }

    //Atualizar Clientes no banco de dados
    public Cliente atualizar(Cliente cliente){
        jdbcTemplate.update(UPDATE, new Object[]{
                cliente.getNome(), cliente.getId()
        } );
        return cliente;
    }

    //Deletar cliente
    public void deletar(Cliente cliente){
        deletar(cliente.getId());
    }
    public void deletar(Integer id){
        jdbcTemplate.update(DELETE, new Object[]{id});
    }

    //Pesquisar o cliente por nome
    public List<Cliente>buscarPorNome(String nome){
        return jdbcTemplate.query(SELECT_ALL.concat(" where nome like ?"),
                new Object[]{"%" + nome + "%" },
                getRowMapper());
    }
}
