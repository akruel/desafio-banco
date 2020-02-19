package com.southsystem.banco.controller;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@XmlRootElement(name = "error")
public class ErrorResponse {
    private String message;
    private List<String> details;
}