export default class AuthHelp {
  constructor(isReg) {
    this.loginReg = /^[a-zA-Z0-9]{6,20}$/;
    this.passReg = /^[a-zA-Z0-9!@$^."№;%:?*\(\)-_=+]{6,20}$/;
    this.body = {
      login: null,
      password: null,
      confirmPassword: null
    };
    this.isReg = isReg;
  }

  renderError = (el, message) => {
    el.textContent = message;
    el.classList.add('auth__err-visible');
    setTimeout(() => el.classList.remove('auth__err-visible'), 4000);
  }

  changeBody = (e, id) => {
    if (id === 'login') {
      return this.body.login = e.target.value;
    }
    else if (id === 'password') {
      return this.body.password = e.target.value;
    }
    else if (this.isReg && id === 'confirmPassword') {
      return this.body.confirmPassword = e.target.value;
    }
  }

  sendData = ({ message, errTxt, submit, url }) => {
    if (!this.loginReg.test(this.body.login)) {
      return this.renderError(errTxt, message.invalidLogin.en);
    }
    else if (!this.passReg.test(this.body.password)) {
      return this.renderError(errTxt, message.invalidPass.en);
    }
    else if (!this.passReg.test(this.body.confirmPassword) && this.isReg) {
      return this.renderError(errTxt, message.invalidRepeatPass.en);
    }
    submit(url, this.body);
  }

  showPass = () => {
    // element.addEventListener('click', () => {
    //   if (input.getAttribute('type') === 'password')
    // });
  }
};

