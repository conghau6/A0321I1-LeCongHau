import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {IXe} from "../../../model/IXe";
import {IDiaDiem} from "../../../model/IDiaDiem";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {XeService} from "../../xe.service";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  formEdit: FormGroup;
  xe: IXe;
  listDiaDiem: IDiaDiem[];
  constructor(private activeRouter: ActivatedRoute,
              private fb:FormBuilder,
              private router:Router,
              private xeService: XeService) { }

  ngOnInit(): void {
    this.createForm();
    this.getAllDiaDiem();
    this.activeRouter.paramMap.subscribe(
      (param: ParamMap) => {
        const id = param.get('id');
        console.log(id);
        this.xeService.getXeById(id).subscribe(
          (data => {
            this.xe = data;
            this.formEdit.setValue(this.xe);
          })
        );
      })
  }

  createForm(){
    this.formEdit = this.fb.group({
      id: ['',[Validators.required]],
      bienSo:['',[Validators.required]],
      loaiXe: ['',[Validators.required]],
      tenNhaXe: ['',[Validators.required]],
      diemDi: ['',[Validators.required]],
      diemDen: ['',[Validators.required]],
      soDienThoai: ['',[Validators.required, Validators.pattern('^((090)|(093)|(097))[0-9]{7}$')]],
      email: ['',[Validators.required, Validators.email]],
      gioDi: ['',[Validators.required]],
      gioDen: ['',[Validators.required]],
    })
  }

  compareFn(c1: IDiaDiem, c2: IDiaDiem): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  getAllDiaDiem(){
    this.xeService.getAllDiaDiem().subscribe(
      data => {
        this.listDiaDiem = data;
      }
    )
  }

  edit() {
    if(this.formEdit.valid){
      this.xeService.updateXe(this.formEdit.value).subscribe(
        ()=>{
          this.router.navigateByUrl('/list');
        },
        error => {
          console.log(error);
        }
      )
    }
  }

  back() {
    this.router.navigateByUrl('/list');
  }
}
