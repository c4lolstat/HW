package com.epam.creditcard;

import com.epam.domain.Creditcard;
import org.springframework.http.ResponseEntity;

/**
 * Created by Zoltan_Biro on 6/15/2017.
 */
public interface Payable {
    ResponseEntity<String> pay(Creditcard creditcard);
}
