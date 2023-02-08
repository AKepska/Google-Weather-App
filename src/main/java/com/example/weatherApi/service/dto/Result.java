package com.example.weatherApi.service.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result implements Serializable {
	private Geometry geometry;
}
