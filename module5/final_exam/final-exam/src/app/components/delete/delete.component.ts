import {Component, Inject, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {XeService} from "../../xe.service";

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  id: number;
  bienSo: string;
  constructor(@Inject(MAT_DIALOG_DATA) data: any,
              private matDialogRef: MatDialogRef<DeleteComponent>,
              private matDialog: MatDialog,
              private xeService: XeService,
              private router: Router){
    this.id = data.id;
    this.bienSo = data.bienSo;
    console.log("ID:" + this.id, "Biển số:" + this.bienSo);
  }

  ngOnInit(): void {
  }

  delete() {
    this.xeService.deleteXe(this.id).subscribe(
      ()=>{
        console.log('delete complete');
        this.router.navigateByUrl('/list');
      },
      error => {
        console.log(error);
      }
    );
  }
}
