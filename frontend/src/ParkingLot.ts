export class ParkingLot {
  public id: number;
  public lot: number;
  public vehicle_number: number;
  public parking_duration: number;
  public parking_amount: number;

  constructor(
    id: number,
    lot: number,
    vehicle_number: number,
    parking_duration: number,
    parking_amount: number
  ) {
    this.id = id;
    this.lot = lot;
    this.vehicle_number = vehicle_number;
    this.parking_duration = parking_duration;
    this.parking_amount = parking_amount;
  }
}
