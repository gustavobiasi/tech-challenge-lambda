package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import helloworld.config.Connections;
import helloworld.domain.ErrorResponse;
import helloworld.domain.Request;
import helloworld.domain.Response;
import helloworld.domain.TokenResponse;
import helloworld.service.ClienteService;
import helloworld.service.TokenService;
import helloworld.utils.JsonParser;
import helloworld.utils.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App implements RequestHandler<Request, Response> {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    @Override
    public Response handleRequest(Request request, Context context) {
        if (request == null || Strings.isEmpty(request.getCpfCnpj()))
            return new Response(JsonParser.toJson(new ErrorResponse("Campo cpfCnpj está nulo ou inválido!")), 400);

        var c = new Connections().connect();
        var clienteDTO = new ClienteService(c).getCliente(request.getCpfCnpj());
        if (clienteDTO == null)
            return new Response(JsonParser.toJson(new ErrorResponse("Cliente não encontrado")), 400);

        var response = new TokenService(clienteDTO).createToken(clienteDTO);

        return new Response(JsonParser.toJson(response));
    }

}
