package helloworld.domain;

public class TokenResponse {

    private String accessToken;
    private String type;

    public TokenResponse() {
    }

    public TokenResponse(String accessToken) {
        this.accessToken = accessToken;
        this.type = "Bearer";
    }

    public TokenResponse(String accessToken, String type) {
        this.accessToken = accessToken;
        this.type = type;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
