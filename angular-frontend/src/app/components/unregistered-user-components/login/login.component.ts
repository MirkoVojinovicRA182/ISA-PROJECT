import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { LoginUser } from 'src/app/model/login-user';
import { User } from 'src/app/model/user';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginUser: LoginUser = new LoginUser()
  loggedUser: User = new User()
  username: string = ""
  password: string = ""

  constructor(private _loginService: LoginService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
  }

  login(){
    this.username = (<HTMLInputElement>document.getElementById("username")).value;
    this.password = (<HTMLInputElement>document.getElementById("password")).value;
    this.loginUser  = {
      username: this.username,
      password: this.password
    }
    //this._loginService.getUser(this.loginUser).subscribe(response => this.loggedUser = response);
    this._loginService.login(this.loginUser).subscribe(
      data => {
        if (data != null){
          localStorage.setItem("token", JSON.stringify(data))
          this.router.navigate([''])
        } 
      }
      
      );
  }

}
