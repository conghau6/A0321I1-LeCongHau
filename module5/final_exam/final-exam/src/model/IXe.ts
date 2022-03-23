import {IDiaDiem} from "./IDiaDiem";

export interface IXe {
  id: number;
  bienSo: string,
  loaiXe: string;
  tenNhaXe: string;
  diemDi: IDiaDiem;
  diemDen: IDiaDiem;
  soDienThoai: string;
  email: string;
  gioDi: string;
  gioDen: string;
}
