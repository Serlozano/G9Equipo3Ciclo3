import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  res:any;

  contenido:any;

  urlapi:string="http://universities.hipolabs.com/search?country=Colombia";

  //FUNCION DE CONTROL DE ERRORES
  handleError(error: HttpErrorResponse) {
    let errorMessage ='Error desconocido!';
    if (error.error instanceof ErrorEvent){
      //Errores del lado del cliente
      errorMessage= `Error: ${ error.error.message}\n ${error.status}`;  
    } else {
      //Errores del lado del servidor
      errorMessage =`Codigo de Error: ${error.status}\nMensaje: ${error.message}`;

    }
    return throwError(errorMessage);
  }
  

  suma: number=0;

  constructor(private objetohttp:HttpClient){}


  ngOnInit(): void {
  }


  
//post
nombre!:string;
correo!:string;
user!:string;
pass!:string;

codigoRespuesta!:number;
  postData(){

    this.objetohttp.post<any>(
      "http://localhost:8080/api/usuarios",
      {
        emailusuario: this.correo,
        nombrecompleto: this.nombre,
        password: this.pass,
        username: this.user
      },
      {observe:'response'}
    ).subscribe(response=>{
      this.codigoRespuesta=response.status;
    });

  }}