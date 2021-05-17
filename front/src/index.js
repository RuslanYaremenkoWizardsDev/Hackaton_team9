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

fetch('http://hackatonteam9.herokuapp.com/createtournament',
  {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': localStorage.getItem('token')
    },
    body: JSON.stringify({
      'tourName': 'SuperPuperChampionShip',
      'description': 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Voluptatibus, est aperiam magnam deleniti libero incidunt excepturi, eligendi aliquam voluptates molestiae impedit id delectus repudiandae natus autem facilis recusandae. Natus, nulla.',
      'mode': 'Cup',
      'place': 'Mars',
      'startDate': '12.06.2021',
      'lastRegistration': '10.06.2021',
      'tourLvl': 'beginner',
      'playerQuantity': '128',
      'scenario': 'one-match',
      'players': [
        'admin123',
        'admin1234'
      ]
    })
  })
//   .then(res => res.json())
//   .then(data => console.log(data));

// fetch('http://hackatonteam9.herokuapp.com/gettournaments',
//   {
//     headers: {
//       'Content-Type': 'application/json',
//       'Authorization': localStorage.getItem('token')
//     }
//   })
//   .then(res => res.json())
//   .then(data => console.log(data));