import { renderModal, validation } from './modules';
import './styles/index.scss';


document.addEventListener('DOMContentLoaded', () => {
  const path = location.pathname;
  if (path === '/' || path === '/index.html') {
    validation();
  }
  else if( path==='/createtour.html'||path==='/stats.html'||path==='/tournaments.html'){
    console.log('sad')
    renderModal()
  }
});