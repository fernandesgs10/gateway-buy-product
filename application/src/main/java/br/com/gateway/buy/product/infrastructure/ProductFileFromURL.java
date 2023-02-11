package br.com.gateway.buy.product.infrastructure;

import br.com.gateway.buy.product.dto.ProdutoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public final class ProductFileFromURL {

    public static final String URL = "http://www.mocky.io/v2/598b16861100004905515ec7";

    private ProductFileFromURL() {
    }

    @SneakyThrows
    public static ProdutoDto[] downloadProduct() {
        ObjectMapper obje = new ObjectMapper();
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(URL);
        HttpResponse response = client.execute(request);
        String responseXml = EntityUtils.toString(response.getEntity());
        return obje.readValue(responseXml, ProdutoDto[].class);
    }
}