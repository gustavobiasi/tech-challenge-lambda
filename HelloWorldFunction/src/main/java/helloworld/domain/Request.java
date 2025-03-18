package helloworld.domain;

public class Request {

    private String cpfCnpj;

    public Request() {
    }

    public Request(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
}
