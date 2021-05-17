import { support } from '..';

export default function logOut() {
  const logOut = document.querySelector('#logOut');

  logOut.addEventListener('click', () => {
    location.replace('http://localhost:4200/index.html');
    support.lsSet('token', null);
  });
}