package helloworld.service;

import helloworld.domain.dto.ClienteDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteService {

    private Connection con;

    public ClienteService(Connection con) {
        this.con = con;
    }

    public ClienteDTO getCliente(String cpfCnpj) {
        ClienteDTO cliente = null;
        try {
            String query = "SELECT * FROM cliente WHERE cpf = ? LIMIT 1";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, cpfCnpj);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                var id = rs.getLong("id");
                var nome = rs.getString("nome");
                var cpf = rs.getString("cpf");

                cliente = new ClienteDTO();
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCpf(cpf);
            }

            return cliente;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cliente", e);
        }
    }
}
