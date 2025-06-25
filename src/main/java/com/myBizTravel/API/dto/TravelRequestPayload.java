package com.myBizTravel.API.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelRequestPayload {

	private DeviceDetails deviceDetails;
	private TravellerDetails travellerDetails;
	private RequestorInfo requestorInfo;
	private String tripId;
	
//	public void generateTripId() {
//		this.tripId = UUID.randomUUID().toString();
//	}
}

//Nested Object: DeviceDetails
@Data
@AllArgsConstructor
@NoArgsConstructor
 class DeviceDetails{
	private String osType;
}


@Data
@AllArgsConstructor
@NoArgsConstructor
 class TravellerDetails{
	 private List<PaxDetail> paxDetails;
}


@Data
@AllArgsConstructor
@NoArgsConstructor
 class PaxDetail{
    private String name;
    private String email;
    private boolean isPrimaryPax;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
 class RequestorInfo{
	private String email;
}