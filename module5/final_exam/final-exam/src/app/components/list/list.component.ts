import { Component, OnInit } from '@angular/core';
import {IXe} from "../../../model/IXe";
import {IDiaDiem} from "../../../model/IDiaDiem";
import {XeService} from "../../xe.service";
import {MatDialog} from "@angular/material/dialog";
import {DeleteComponent} from "../delete/delete.component";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  public listXe: IXe[];
  public listDiaDiem: IDiaDiem[];
  p = 1;

  constructor(public xeService:XeService,
              private matDialog: MatDialog) { }

  ngOnInit(): void {
    this.xeService.getAllXe().subscribe(
      data => {
        this.listXe = data;
        console.log(this.listXe);
      }
    );
  }

  openDialogDelete(id: any, bienSo: any) {
    const dialogDelete = this.matDialog.open(DeleteComponent, {
      data: {id: id, bienSo: bienSo},
      height: '150px',
      width: '500px'
    });
    dialogDelete.afterClosed().subscribe(
      data => {
        this.xeService.getAllXe().subscribe(
          data => {
            this.listXe = data;
            this.p = 1;
          }
        );
      }
    )
  }
}
