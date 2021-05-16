import { modal, modalDelete } from '..';
import { deleteModal, settingIpt, settingModal } from '../helpers/constants';
import translateMain from './translateMain';

export default function renderModal() {
    let settingsBtn = document.querySelector('.header__set-img');
    let settingsBox = document.querySelector('.header__settings');

    settingsBtn.addEventListener('click', () => {
        let modalBox = document.createElement('div');

        modalBox.innerHTML = modal;
        settingsBox.appendChild(modalBox);
        let modalSettings = document.querySelector('.header__modal');

        modalSettings.style.display = 'block';
        let modalClose = document.querySelector('.header__close');
        const modalCancel = document.querySelector('.header__cancel');
        const modalBg = document.querySelector('.header__modal');
        translateMain(settingModal, settingIpt);
        modalClose.addEventListener('click', () => {
            modalSettings.style.display = 'none';
        });

        modalCancel.addEventListener('click', () => {
            modalSettings.style.display = 'none';
        });

        modalBg.addEventListener('click', (e) => {
            if (e.target === modalBg) {
                modalSettings.style.display = 'none';
            }
        });
        let avatar = document.querySelector('.header__modal-avatar');
        avatar.addEventListener('mouseenter', () => {
            console.log('here');

        });
    });
}

export function renderDeleteModal() {
    let deleteAll = document.querySelector('.delete-btn');
    let searchBox = document.querySelector('.content-tournaments__search-box');

    deleteAll.addEventListener('click', (e) => {
        let modalBox = document.createElement('div');

        modalBox.innerHTML = modalDelete;
        searchBox.appendChild(modalBox);
        let modalSettings = document.querySelector('.tableTop__modal');

        modalSettings.style.display = 'block';

        let modalClose = document.querySelector('.tableTop__close');
        const modalBg = document.querySelector('.tableTop__modal');
        const modalCancel = document.querySelector('.tableTop__cancel');
        translateMain(deleteModal, []);
        modalClose.addEventListener('click', () => {
            modalSettings.style.display = 'none';
        });

        modalCancel.addEventListener('click', () => {
            modalSettings.style.display = 'none';
        });

        modalBg.addEventListener('click', (e) => {
            if (e.target === modalBg) {
                modalSettings.style.display = 'none';
            }
        });
    });
}