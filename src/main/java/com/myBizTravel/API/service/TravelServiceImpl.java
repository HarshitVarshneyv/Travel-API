package com.myBizTravel.API.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.myBizTravel.API.dto.ApprovalRequestPayload;
import com.myBizTravel.API.dto.BookingPushPayload;
import com.myBizTravel.API.dto.ItineraryPushPayload;
import com.myBizTravel.API.dto.MyBizResponsePayload;
import com.myBizTravel.API.dto.TravelRequestPayload;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService{
	
//	@Qualifier("defaultWebClient")
//	private final WebClient webClient;
	
	@Qualifier("webClientWithHeaders")
	private final WebClient webClientWithHeaders;
	@Override
	public MyBizResponsePayload sendCreateRequestToMyBiz(TravelRequestPayload travelRequestPayload) {
		// TODO Auto-generated method stub
		return webClientWithHeaders.post()
				.uri("/corporate/v1/create/partner/travelCardDetails")
				.bodyValue(travelRequestPayload)
				.retrieve()
				.bodyToMono(MyBizResponsePayload.class)
				.block();
	}
	@Override
	public void processreceiveItinerary(ItineraryPushPayload itineraryPushPayload) {
		// TODO Auto-generated method stub
		System.out.println("Itinerary pushed: " + itineraryPushPayload);
	}
	@Override
	public ResponseEntity<String> sendApprovalToMyBiz(ApprovalRequestPayload approvalRequestPayload) {
		// TODO Auto-generated method stub
		String response = webClientWithHeaders.put()
				.bodyValue(approvalRequestPayload)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		return ResponseEntity.ok(response);
	}
	@Override
	public void receiveBooking(BookingPushPayload bookingPushPayload) {
		// TODO Auto-generated method stub
		 System.out.println("Booking pushed: " + bookingPushPayload);
	}
}
