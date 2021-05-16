import {
  urls, validation, login, registration,
  renderModal, support, translateAuth,
  regTranslate, authTranslate, authIpt, regIpt, translateTour, tourPlacholder,
  translateStats, createIpt, createText, addTours
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
    addTours();
  }
});


// fetchWithToken('/account').then(res => res.json()).then(data => console.log(data));
