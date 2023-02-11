package br.com.gateway.buy.product.api;

import java.util.Objects;
import br.com.gateway.buy.product.api.ProductItens;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Product
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-10T23:10:26.064662-03:00[America/Sao_Paulo]")

public class Product   {
  @JsonProperty("id")
  private BigDecimal id;

  @JsonProperty("codigo")
  private String codigo;

  @JsonProperty("data")
  private String data;

  @JsonProperty("valorTotal")
  private BigDecimal valorTotal;

  @JsonProperty("cliente")
  private String cliente;

  @JsonProperty("itens")
  @Valid
  private List<ProductItens> itens = null;

  public Product id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public Product codigo(String codigo) {
    this.codigo = codigo;
    return this;
  }

  /**
   * Get codigo
   * @return codigo
  */
  @ApiModelProperty(value = "")


  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public Product data(String data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @ApiModelProperty(value = "")


  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Product valorTotal(BigDecimal valorTotal) {
    this.valorTotal = valorTotal;
    return this;
  }

  /**
   * Get valorTotal
   * @return valorTotal
  */
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(BigDecimal valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Product cliente(String cliente) {
    this.cliente = cliente;
    return this;
  }

  /**
   * Get cliente
   * @return cliente
  */
  @ApiModelProperty(value = "")


  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public Product itens(List<ProductItens> itens) {
    this.itens = itens;
    return this;
  }

  public Product addItensItem(ProductItens itensItem) {
    if (this.itens == null) {
      this.itens = new ArrayList<>();
    }
    this.itens.add(itensItem);
    return this;
  }

  /**
   * Get itens
   * @return itens
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<ProductItens> getItens() {
    return itens;
  }

  public void setItens(List<ProductItens> itens) {
    this.itens = itens;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.codigo, product.codigo) &&
        Objects.equals(this.data, product.data) &&
        Objects.equals(this.valorTotal, product.valorTotal) &&
        Objects.equals(this.cliente, product.cliente) &&
        Objects.equals(this.itens, product.itens);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, codigo, data, valorTotal, cliente, itens);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    valorTotal: ").append(toIndentedString(valorTotal)).append("\n");
    sb.append("    cliente: ").append(toIndentedString(cliente)).append("\n");
    sb.append("    itens: ").append(toIndentedString(itens)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

