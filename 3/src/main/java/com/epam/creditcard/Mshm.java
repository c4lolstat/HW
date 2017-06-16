package com.epam.creditcard;

import com.epam.domain.Creditcard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Zoltan_Biro on 6/15/2017.
 */
@Component
public class Mshm implements Payable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Mshm.class);
    private final String HOST = "http://localhost:8085";
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public ResponseEntity<String> pay(Creditcard creditcard) {
        ResponseEntity<String> response = new ResponseEntity<String>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
        try {
            String uri = HOST + "/pay";
            String jsonInput = mapper.writeValueAsString(creditcard);

            RestTemplate restTemplate = new RestTemplate();
            // Add the Jackson message converter
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            // set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(jsonInput, headers);

            // send request and parse result
            response = restTemplate
                    .exchange(uri, HttpMethod.POST, entity, String.class);

            System.out.println(response);
        } catch (JsonProcessingException e) {
            LOGGER.debug("Cannot convert creditcard to json" + e.getMessage());
        }
        return response;
    }
}
