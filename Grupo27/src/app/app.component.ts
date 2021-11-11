import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
   
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
    this.suma=45+98

    //utilizando el servicio en la url
    this.res=this.objetohttp.get(this.urlapi).pipe(catchError(this.handleError));
    this.res.subscribe((datos:any[])=>{
      this.contenido=datos;
      console.log(this.contenido);
    });
  
  }
  
  
}
  
  
  
  /*
  
  title = 'Login';

  listausuarios=["diego","sergio","admin","user"];
  listapass=["diego","sergio","admin","user"];


  user_correcto: string = "admininicial";
  pass_correcto: string = "admin123456";

  user: string = "";
  pass: string = "";

  correcto: number=-1;
  comparar() {
    if (this.user === this.user_correcto) {
      this.correcto = 1;
      if (this.pass === this.pass_correcto) {
        this.correcto = 1;
      } else {
        this.correcto = 0;
      }
    } else {
      this.correcto = 0;
    }

  }
  */

