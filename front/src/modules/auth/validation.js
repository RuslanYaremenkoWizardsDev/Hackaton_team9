import { getFetch, message, support } from '..';

export default function validation(url, submit, isReg,) {
  const loginReg = /^[a-zA-Z0-9]{6,20}$/;
  const passReg = /^[a-zA-Z0-9!@$^."№;%:?*\(\)-_=+]{6,20}$/;

  const authBlock = document.querySelector('.auth');
  const errTxt = document.querySelector('#error');

  const body = {
    login: null,
    password: null,
    confirmPass: null
  };

  authBlock.addEventListener('input', (e) => {

    const id = e.target.getAttribute('id');
    if (id === 'login') {
      body.login = e.target.value;
    }
    else if (id === 'password') {
      body.password = e.target.value;
    }
    else if (isReg && id === 'confirmPass') {
      body.confirmPass = e.target.value;
    }
  });

  authBlock.addEventListener('click', async (e) => {
    const id = e.target.getAttribute('id');
    if (id === 'signBtn') {
      if (!loginReg.test(body.login)) {
        errTxt.textContent = message.invalidLogin.en;
        errTxt.classList.add('auth__err-visible');
        setTimeout(() => errTxt.classList.remove('auth__err-visible'), 4000);
        return;
      }
      else if (!passReg.test(body.password)) {
        errTxt.textContent = message.invalidPass.en;
        errTxt.classList.add('auth__err-visible');
        setTimeout(() => errTxt.classList.remove('auth__err-visible'), 4000);
        return;
      }
      else if (!passReg.test(body.confirmPass) && isReg) {
        body.confirmPass = null;
        errTxt.textContent = message.invalidRepeatPass.en;
        errTxt.classList.add('auth__err-visible');
        setTimeout(() => errTxt.classList.remove('auth__err-visible'), 4000);
        return;
      }

      submit(url, body);
      // const sendAuth = await getFetch(url, 'POST', body);
      // if (sendAuth.ok) {
      //   const token = await sendAuth.json();
      //   support.lsSet(token);
      //   location.replace('http://localhost:4200/tournaments.html');
      // }
    }
  });
}
