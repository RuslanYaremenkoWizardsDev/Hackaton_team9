import { urls, validation, login, registration, renderModal, support } from './modules';
import { renderDeleteModal } from './modules/mainPage/renderModal';
import './styles/index.scss';


document.addEventListener('DOMContentLoaded', () => {
  const path = location.pathname;
  if (path === '/' || path === '/index.html') {
    validation(urls.auth, login);
  }
  if (path === '/registration.html') {
    validation(urls.registr, registration, true);
  }
  if (path === '/createtour.html') {
    renderModal();
    document.querySelector('.startDate').setAttribute("min",support.getDate(new Date));
    document.querySelector('.lastDate').setAttribute("max",support.getDate(new Date));
  }
  if (path === '/stats.html') {
    renderModal();
  }
  if (path === '/tournaments.html') {
    renderModal();
    renderDeleteModal();
  }
});





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