import { message } from '..';
import AuthHelp from './authHelp';

export default function validation(url, submit, isReg,) {
  const authBlock = document.querySelector('.auth');
  const errTxt = document.querySelector('#error');
  // const eye = document.querySelectorAll('.hidePass');

  const { changeBody, sendData } = new AuthHelp(isReg);

  authBlock.addEventListener('input', (e) => {
    const id = e.target.getAttribute('id');
    changeBody(e, id);
  });

  authBlock.addEventListener('click', async (e) => {
    const id = e.target.getAttribute('id');
    if (id === 'signBtn') {
      sendData({ message, errTxt, submit, url });
    }
    if (id === 'hidePass') {

    }
  });


}
