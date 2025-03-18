package helloworld.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import helloworld.domain.TokenResponse;
import helloworld.domain.dto.ClienteDTO;

import javax.xml.crypto.AlgorithmMethod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.util.function.Consumer;

import static helloworld.constants.Constants.ALGORITHM_SECRET;

public class TokenService {

    private ClienteDTO clienteDTO;


    public TokenService(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public TokenResponse createToken(ClienteDTO clienteDTO) {
        Algorithm algorithmSecret = Algorithm.HMAC512(ALGORITHM_SECRET);
        String token = createJWT(algorithmSecret, "FastFood", builder -> {
            builder.withClaim("clienteId", clienteDTO.getId());
            builder.withClaim("nome", clienteDTO.getNome());
            builder.withClaim("cpf", clienteDTO.getCpf());
            builder.withExpiresAt(Instant.now().plusSeconds(3600L));
        });
        return new TokenResponse(token);
    }

    private String createJWT(Algorithm algorithm, String issuer, Consumer<JWTCreator.Builder> adapter) {
        JWTCreator.Builder builder = JWT.create();
        builder.withIssuer(issuer);
        adapter.accept(builder);
        return builder.sign(algorithm);
    }

}
