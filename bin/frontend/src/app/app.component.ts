import { Component } from "@angular/core";
import {
  FormGroup,
  FormControl,
  Validators,
  ReactiveFormsModule,
  FormBuilder
} from "@angular/forms";
import { HttpClient } from "@angular/common/http";
import { ParkingLot } from "src/ParkingLot";
import { ParkingServiceService } from "./parking-service.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  errorAlert: boolean = false;
  error_message = "Vehicle already parked";
  parkings = new Array<ParkingLot>();
  vehicleForm: FormGroup;
  constructor(private pService: ParkingServiceService) {
    pService.getAllParking().subscribe(response => {
      this.parkings = response.map(item => {
        return new ParkingLot(
          item.id,
          item.lot,
          item.vehicle_number,
          item.parking_duration,
          item.parking_amount
        );
      });
    });
  }
  ngOnInit() {
    this.vehicleForm = new FormGroup({
      lot: new FormControl(""),
      vehicle_number: new FormControl(""),
      parking_duration: new FormControl(""),
      parking_amount: new FormControl("")
    });
  }
  onSubmit() {
    console.log(this.vehicleForm.value);
    let pl = {
      lot: this.vehicleForm.get("lot").value,
      parking_amount: this.vehicleForm.get("parking_amount").value,
      parking_duration: this.vehicleForm.get("parking_duration").value,
      vehicle_number: this.vehicleForm.get("vehicle_number").value
    };
    this.pService.parkNewvehicle(pl).subscribe(
      data => {
        console.log("POST Request is successful ", data);
      },
      error => {
        this.errorAlert = true;
        console.log("Error", error);
      }
    );
    this.errorAlert = this.pService.errorAlert;
    console.log(this.errorAlert);
  }
  calculateAmount(event) {
    let ts = this.vehicleForm.get("parking_duration").value;
    ts = ts * 60;
    let a = 20;
    let am = 0.333 / 60;
    if (ts > 3600) {
      ts = ts - 3600;
      a = am * ts;
      a = a + 20;
    }
    this.vehicleForm.patchValue({
      parking_amount: Math.round(a)
    });
  }
}
