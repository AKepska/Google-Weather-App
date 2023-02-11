package com.example.weatherApi.service.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location implements Serializable {
	double lat;
	double lng;
}
