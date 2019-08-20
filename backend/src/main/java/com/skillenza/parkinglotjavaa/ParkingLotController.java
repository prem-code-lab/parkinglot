package com.skillenza.parkinglotjavaa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillenza.parkinglotjavaa.ParkingLot;
import com.skillenza.parkinglotjavaa.ParkingLotRepository;

import javax.validation.Valid;

import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ParkingLotController {
	@Autowired
	ParkingLotRepository parkingLotRepository;
	
    @GetMapping("/parkings")
    public ResponseEntity<List<ParkingLot>> index(){
        return ResponseEntity.ok(parkingLotRepository.findAll());
    }
    
    @PostMapping("/parkings")
    public ResponseEntity<ParkingLot> create(@Valid @RequestBody ParkingLot pl){
    	pl.setParking_amount(20);
    	pl.setCreated_at(new Date());
        return ResponseEntity.ok(parkingLotRepository.save(pl));
    }     
    
    @PutMapping("/parkings")
    public ResponseEntity<ParkingLot> update(@Valid @RequestBody ParkingLot pl){
//    	int d = pl.getParking_duration();
//    	double x = 0.333/60;
//    	if(d <= 3600)
//    		pl.setParking_amount(20);
//    	else {
//    		int diff = d - 3600;
//    		int am = (int) (diff*x);
//    		pl.setParking_amount(20+am);
//    	}
    	pl.setUpdated_at(new Date());
    	pl.setCreated_at(pl.getCreated_at());
        return ResponseEntity.ok(parkingLotRepository.save(pl));
    }    
    
    
	
}

