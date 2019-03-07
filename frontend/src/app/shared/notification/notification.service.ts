import { Injectable } from '@angular/core';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material';
@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(
    public snackBar: MatSnackBar
  ) { }

  config: MatSnackBarConfig = {
    duration: 5000,
    horizontalPosition: 'right',
    verticalPosition: 'top'
  }

  error(){
    this.config['panelClass'] = ['notification','error'];
    this.snackBar.open('ข้อมูลไม่ถูกต้อง, กรุณากรอกข้อมูลให้ถูกต้อง !!!','', this.config);
  }
  
  saveSuccess(){
    this.config['panelClass'] = ['notification','success'];
    this.snackBar.open('บันทึกข้อมูลสำเร็จ','', this.config);
  }

}