import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { ParkingLot } from "src/ParkingLot";

@Injectable({
  providedIn: "root"
})
export class ParkingServiceService {
  constructor(private http: HttpClient) {}
  errorAlert: boolean = false;
  url = "http://localhost:8080/api/parkings";
  public getAllParking(): Observable<ParkingLot[]> {
    return this.http.get<ParkingLot[]>(this.url);
  }

  public parkNewvehicle(vehicle) {
    return this.http.post(this.url, vehicle);
  }
}
