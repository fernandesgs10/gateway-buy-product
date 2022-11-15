package br.com.gateway.buy.product.infrastructure;

import br.com.gateway.buy.product.dto.ProdutoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URI;

public class ProductFileFromURL {

    public static final String URL="http://www.mocky.io/v2/598b16861100004905515ec7";

    @SneakyThrows
    public static  ProdutoDto[] downloadProduct() {
        URI uri = new URI(URL);
        HttpGet httpget = new HttpGet(uri);
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(httpget);
        String responseXml = EntityUtils.toString(response.getEntity());
        System.out.println(responseXml);
        ObjectMapper obje = new ObjectMapper();

        ProdutoDto[] pojos = obje.readValue(responseXml, ProdutoDto[].class);
        return  pojos;
    }
}