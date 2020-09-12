package com.sum.hr.server.aspects;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gwt.dev.util.collect.HashSet;
import com.sum.hr.server.hrexception.HrException;
import com.sum.hr.server.hrexception.HrValidationException;
import com.sum.hr.server.response.Errors;
import com.sum.hr.server.response.Field;
import com.sum.hr.server.response.Message;
import com.sum.hr.server.response.Response;
import com.sum.hr.shared.ModelColumn;

@ControllerAdvice
public class GlobalHrExceptionHandler {

	@ExceptionHandler(HrValidationException.class)
	public @ResponseBody
	Response<Errors> handleCustomException(HrValidationException ex) {

		Set<ConstraintViolation<Object>> constraintViolations = ex
				.getConstraintViolations();
		Response<Errors> response = new Response<Errors>();
		Errors errors = new Errors();
		Set<Field> erroSet = new HashSet<Field>();
		for (ConstraintViolation<Object> constraintViolation : constraintViolations) {

			Field field = new Field();
			field.setId(constraintViolation.getPropertyPath() + "");
			field.setMsg(constraintViolation.getMessage());
			erroSet.add(field);
		}
		errors.setField(erroSet);
		response.setT(errors);
		return response;
	}

	@ExceptionHandler(HrException.class)
	public @ResponseBody
	Response<Message> handleHrException(HrException ex) {

		Response<Message> response = new Response<Message>();
		Message message = new Message();
		message.setText(ex.getMessage());
		response.setMessage(message);
		return response;
	}
}
