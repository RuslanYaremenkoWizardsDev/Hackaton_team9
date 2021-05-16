import {
  urls, validation, login, registration,
  renderModal, support, translateAuth,
  regTranslate, authTranslate, authIpt, regIpt
} from './modules';
import { renderDeleteModal } from './modules/mainPage/renderModal';
import translateMain from './modules/mainPage/translateMain';
import './styles/index.scss';


document.addEventListener('DOMContentLoaded', () => {
  const path = location.pathname;
  if (path === '/' || path === '/index.html') {
    validation(urls.auth, login);
    translateAuth(authTranslate, authIpt);
  }
  else if (path === '/registration.html') {
    translateAuth(regTranslate, regIpt);
    validation(urls.registr, registration, true);
  }
  else if (path === '/createtour.html') {
    renderModal();
    document.querySelector('.startDate').setAttribute('min', support.getDate(new Date));
    document.querySelector('.lastDate').setAttribute('max', support.getDate(new Date));
  }
  else if (path === '/stats.html') {
    renderModal();
  }
  else if (path === '/tournaments.html') {
    renderModal();
    renderDeleteModal();
    translateMain();
  }
});


// fetchWithToken('/account').then(res => res.json()).then(data => console.log(data));


// const body = {
//   login: 'admin1234',
//   password: 'admin1234',
//   confirmPassword: 'admin1234'
// };
// fetch('http://hackatonteam9.herokuapp.com//registration', {
//   method: 'POST',
//   headers: {
//     'Content-Type': 'application/json'
//   },
//   body: JSON.stringify(body)
// })
//   .then(data => data.json())
//   .then(data => console.log(data));