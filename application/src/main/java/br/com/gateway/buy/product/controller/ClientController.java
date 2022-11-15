//package br.com.gateway.buy.product.controller;
//
//import br.com.gateway.buy.product.ClientsApi;
//import br.com.gateway.buy.product.SegmentoRamo;
//import br.com.gateway.buy.product.SegmentoSaudeResponseType;
//import br.com.gateway.buy.product.entity.ClientEntity;
//import br.com.gateway.buy.product.ramo.service.ClientService;
//import lombok.AllArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//@RequestMapping("${openapi.gatewayBuyProduct.base-path:/v1/gateway-buy-product}")
//@AllArgsConstructor
//public class ClientController implements ClientsApi {
//
//    private ModelMapper modelMapper;
//    private ClientService clientService;
//
//    @Override
//    @RequestMapping(value = "/clients/recommendation", produces = { "application/json" }, method = RequestMethod.GET)
//    public ResponseEntity<SegmentoSaudeResponseType> clientsRecommendation() {
//        ClientEntity ramoSoap = clientService.clientsRecommendation();
//        SegmentoRamo segmentoRamo = modelMapper.map(ramoSoap, SegmentoRamo.class);
//       // return ResponseEntity.status(HttpStatus.OK).body(RamoMapper.INSTANCE.segmentoRamoResponseType(segmentoRamo));
//        return null;
//    }
//
//    @Override
//    @RequestMapping(value = "/clients/clients-trusty", produces = { "application/json" }, method = RequestMethod.GET)
//    public ResponseEntity<SegmentoSaudeResponseType> clientTrusty() {
//        ClientEntity ramoSoap = clientService.clientTrusty();
//        SegmentoRamo segmentoRamo = modelMapper.map(ramoSoap, SegmentoRamo.class);
//        return null;
//        //return ResponseEntity.status(HttpStatus.OK).body(RamoMapper.INSTANCE.segmentoRamoResponseType(segmentoRamo));
//    }
//}