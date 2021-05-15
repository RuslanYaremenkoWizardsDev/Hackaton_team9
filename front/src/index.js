import { urls, validation, login, registration } from './modules';
import './styles/index.scss';

document.addEventListener('DOMContentLoaded', () => {
  const path = location.pathname;
  if (path === '/' || path === '/index.html') {
    validation(urls.auth, login);
  }
  if (path === '/registration.html') {
    validation(urls.registr, registration, true);
  }
});