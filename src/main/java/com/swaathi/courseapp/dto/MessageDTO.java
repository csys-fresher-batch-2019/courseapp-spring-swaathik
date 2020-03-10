package com.swaathi.courseapp.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@JsonInclude(Include.NON_NULL)
public class MessageDTO {
	private String infoMessage;
	private String errroMessage;

}
