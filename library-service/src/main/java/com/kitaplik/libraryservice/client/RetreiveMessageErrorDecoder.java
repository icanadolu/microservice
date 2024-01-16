package com.kitaplik.libraryservice.client;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import com.kitaplik.libraryservice.exception.BookNotFoundException;
import com.kitaplik.libraryservice.exception.ExceptionMessage;

import feign.Response;
import feign.codec.ErrorDecoder;

//Error Decoder feignden hata aldığımızda kullanıcıya  500 int server error mesajını daha anlamlı hale getirmeye yarar
//feginden alınan hatayı daha controllü bir hata yönetimi haline getiriyoruz
public class RetreiveMessageErrorDecoder implements ErrorDecoder  {
	private final ErrorDecoder errorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		 ExceptionMessage message = null;
		
		 try(InputStream body = response.body().asInputStream()) {
			 message = new ExceptionMessage((String) response.headers().get("date").toArray()[0], response.status(),
					 HttpStatus.resolve(response.status()).getReasonPhrase(), 
					 IOUtils.toString(body,StandardCharsets.UTF_8),//body stream ettik  streamide  stringe çeviriyoruz
					 response.request().url());
			
		} catch (IOException e) {
			return new Exception(e.getMessage());
		}
		 
		 switch (response.status()) {
		case 404: 
			throw new BookNotFoundException(message);
		default:
			return errorDecoder.decode(methodKey, response);
		}
		 
		
	}

}
