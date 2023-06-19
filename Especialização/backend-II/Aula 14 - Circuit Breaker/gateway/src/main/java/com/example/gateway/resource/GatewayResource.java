package com.example.gateway.resource;

//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
//import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;


//@RestController
//@RequestMapping("/gateway")
//public class GatewayResource {
//
//    @GetMapping("/loginSuccess")
//    public ResponseEntity<Map<String,Object>> getLoginInfo(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient, Authentication auth) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("clientName", authorizedClient.getClientRegistration().getClientName());
//        response.put("accessToken", authorizedClient.getAccessToken());
//        response.put("authName", auth.getDetails());
//        return ResponseEntity.ok(response);
//    }
//}
