import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { LoginUser } from 'src/app/model/login-user';
import { User } from 'src/app/model/user';
import { LoginService } from 'src/app/services/login/login.service';
import jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginUser: LoginUser = new LoginUser()
  username: string = ""
  password: string = ""
  user: any

  constructor(private _loginService: LoginService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this._loginService.login({ username: this.username, password: this.password })
      .subscribe(data => {
        localStorage.setItem('jwt', data.body.accessToken)
        let token = this.getDecodedAccessToken(data.body.accessToken)
        this._loginService.getMyInfo(token.sub).subscribe(response => { this.user = response 
        if (this.user.roles[0].name == "ROLE_ADMIN") {
          this.router.navigate(['admin'])
        } else if (this.user.roles[0].name == "ROLE_CLIENT") {
          this.router.navigate(['client'])
        } else if (this.user.roles[0].name == "ROLE_INSTRUCTOR") {
          this.router.navigate(['instructor'])
        } else if (this.user.roles[0].name == "ROLE_SHIP_OWNER") {
          this.router.navigate(['shipOwner'])
        } else {
          this.router.navigate(['cottageOwner'])
        }
      })
      })
  }

  public getDecodedAccessToken(token: string): any {
    try {
      return jwt_decode(token);
    } catch(Error) {
      return null;
    }
  }
}

