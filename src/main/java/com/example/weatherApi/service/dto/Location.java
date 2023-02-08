package com.example.weatherApi.service.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location implements Serializable {
	double lat;
	double lng;

	// Result
	// -> results: Geometry[]

	// Geometry
	// -> location: Location

	// Location
	// -> lat: Double
	// -> lng: Double
//	results {
//		"results" : [
//		{
//			"geometry" :{
//			"location" :{
//				"lat" :37.4267861,
//						"lng" :-122.0806032
//			}
//		}
//		}
//
//   ],
//		"status" :"OK"
//	}
}
