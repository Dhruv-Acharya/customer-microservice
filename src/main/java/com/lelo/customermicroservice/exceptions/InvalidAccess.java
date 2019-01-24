package com.lelo.customermicroservice.exceptions;/* Made by: mehtakaran9 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Invalid Details")
public class InvalidAccess extends RuntimeException {
}
