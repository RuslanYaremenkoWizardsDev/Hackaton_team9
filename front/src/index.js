import {
  urls, validation, login, registration,
  renderModal, support, translateAuth,
  regTranslate, authTranslate, authIpt, regIpt, translateTour, tourPlacholder,
  translateStats, createIpt, createText
} from './modules';
import { renderDeleteModal } from './modules/mainPage/renderModal';
import translateMain from './modules/mainPage/translateMain';
import './styles/index.scss';


document.addEventListener('DOMContentLoaded', () => {
  const path = location.pathname;
  if (path === '/' || path === '/index.html') {
    translateAuth(authTranslate, authIpt);
    validation(urls.auth, login);
  }
  else if (path === '/registration.html') {
    translateAuth(regTranslate, regIpt);
    validation(urls.registr, registration, true);
  }
  else if (path === '/createtour.html') {
    renderModal();
    translateMain(createText, createIpt);
    document.querySelector('.startDate').setAttribute('min', support.getDate(new Date));
    document.querySelector('.lastDate').setAttribute('max', support.getDate(new Date));
  }
  else if (path === '/stats.html') {
    renderModal();
    translateMain(translateStats, []);
  }
  else if (path === '/tournaments.html') {
    renderModal();
    renderDeleteModal();
    translateMain(translateTour, tourPlacholder);
  }
});


// fetchWithToken('/account').then(res => res.json()).then(data => console.log(data));


const body = {
  login: 'admin1234',
  password: 'admin1234',
  // confirmPassword: 'admin1234'
};
fetch('http://hackatonteam9.herokuapp.com/auth', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(body)
})
  .then(data => {
    console.log(data.headers.get('Authorization'));
    data.json();
  })
  .then(data => console.log(data));