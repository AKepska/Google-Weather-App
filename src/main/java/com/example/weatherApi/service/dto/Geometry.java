package com.example.weatherApi.service.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Geometry implements Serializable {
	private Location location;
}
