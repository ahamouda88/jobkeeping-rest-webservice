package com.queue.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * This Class is used for serializing the Date datatype when displayed by JSON.
 * @author ahamouda
 *
 */
public class CustomDateSerializer extends JsonSerializer<Date>{
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void serialize(Date date, JsonGenerator jgen, SerializerProvider provider) throws IOException,
			JsonProcessingException {
	    String formattedDate = dateFormat.format(date);
	    jgen.writeString(formattedDate);		
	}
}




