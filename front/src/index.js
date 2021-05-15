import { validation } from './modules';
import './styles/index.scss';

document.addEventListener('DOMContentLoaded', () => {
  const path = location.pathname;
  if (path === '/' || path === '/index.html') {
    validation();
  }
});