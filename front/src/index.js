import { urls, validation, login, registration, renderModal } from './modules';
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
  if( path==='/createtour.html'){
    console.log('sad');
    renderModal()
  }
  if( path==='/stats.html'){
    console.log('sad');
    renderModal()
  }
  if( path==='/tournaments.html'){
    console.log('sad');
    renderModal();
    renderDeleteModal()
  }
});