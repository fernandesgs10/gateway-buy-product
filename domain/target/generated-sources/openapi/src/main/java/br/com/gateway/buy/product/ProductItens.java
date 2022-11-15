package br.com.gateway.buy.product;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProductItens
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-14T22:57:23.589966-03:00[America/Sao_Paulo]")

public class ProductItens   {
  @JsonProperty("produto")
  private String produto;

  @JsonProperty("pais")
  private String pais;

  @JsonProperty("categoria")
  private String categoria;

  @JsonProperty("preco")
  private BigDecimal preco;

  @JsonProperty("variedade")
  private String variedade;

  @JsonProperty("safra")
  private BigDecimal safra;

  public ProductItens produto(String produto) {
    this.produto = produto;
    return this;
  }

  /**
   * Get produto
   * @return produto
  */
  @ApiModelProperty(value = "")


  public String getProduto() {
    return produto;
  }

  public void setProduto(String produto) {
    this.produto = produto;
  }

  public ProductItens pais(String pais) {
    this.pais = pais;
    return this;
  }

  /**
   * Get pais
   * @return pais
  */
  @ApiModelProperty(value = "")


  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public ProductItens categoria(String categoria) {
    this.categoria = categoria;
    return this;
  }

  /**
   * Get categoria
   * @return categoria
  */
  @ApiModelProperty(value = "")


  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public ProductItens preco(BigDecimal preco) {
    this.preco = preco;
    return this;
  }

  /**
   * Get preco
   * @return preco
  */
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }

  public ProductItens variedade(String variedade) {
    this.variedade = variedade;
    return this;
  }

  /**
   * Get variedade
   * @return variedade
  */
  @ApiModelProperty(value = "")


  public String getVariedade() {
    return variedade;
  }

  public void setVariedade(String variedade) {
    this.variedade = variedade;
  }

  public ProductItens safra(BigDecimal safra) {
    this.safra = safra;
    return this;
  }

  /**
   * Get safra
   * @return safra
  */
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getSafra() {
    return safra;
  }

  public void setSafra(BigDecimal safra) {
    this.safra = safra;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductItens productItens = (ProductItens) o;
    return Objects.equals(this.produto, productItens.produto) &&
        Objects.equals(this.pais, productItens.pais) &&
        Objects.equals(this.categoria, productItens.categoria) &&
        Objects.equals(this.preco, productItens.preco) &&
        Objects.equals(this.variedade, productItens.variedade) &&
        Objects.equals(this.safra, productItens.safra);
  }

  @Override
  public int hashCode() {
    return Objects.hash(produto, pais, categoria, preco, variedade, safra);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductItens {\n");
    
    sb.append("    produto: ").append(toIndentedString(produto)).append("\n");
    sb.append("    pais: ").append(toIndentedString(pais)).append("\n");
    sb.append("    categoria: ").append(toIndentedString(categoria)).append("\n");
    sb.append("    preco: ").append(toIndentedString(preco)).append("\n");
    sb.append("    variedade: ").append(toIndentedString(variedade)).append("\n");
    sb.append("    safra: ").append(toIndentedString(safra)).append("\n");
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

