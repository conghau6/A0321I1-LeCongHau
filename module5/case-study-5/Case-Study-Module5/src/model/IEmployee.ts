import {IDegree} from "./IDegree";

export interface IEmployee {
  id: string;
  fullName: string;
  position: string;
  educationDegree: IDegree;
  division: string;
  dateOfBirth: string;
  idCard: string;
  salary: string;
  email: string;
  phone: string;
  address: string;
}
