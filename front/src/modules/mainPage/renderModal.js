import { modal, modalDelete } from '..';

export default function renderModal() {
    let settingsBtn = document.querySelector('.header__set-img');
    let settingsBox = document.querySelector('.header__settings');

    settingsBtn.addEventListener('click', (e) => {
        let modalBox = document.createElement('div');

        modalBox.innerHTML = modal;
        settingsBox.appendChild(modalBox);
        let modalSettings = document.querySelector('.header__modal');

        modalSettings.style.display = 'block';
        let modalClose = document.querySelector('.header__close');

        modalClose.addEventListener('click', (e) => {
            if (e.target.className == 'header__close') {
                modalSettings.style.display = 'none';
            }
        });
    });
}

<<<<<<< HEAD
=======
export function renderDeleteModal() {
    let deleteAll = document.querySelector('.delete-btn');
    let searchBox = document.querySelector('.content-tournaments__search-box');

    deleteAll.addEventListener('click', (e) => {
        let modalBox = document.createElement('div');
>>>>>>> 4e8af4da7d62e167d21664bc1016fe38d8c4e599

        modalBox.innerHTML = modalDelete;
        searchBox.appendChild(modalBox);
        let modalSettings = document.querySelector('.tableTop__modal');

        modalSettings.style.display = 'block';
        let modalClose = document.querySelector('.tableTop__close');

        modalClose.addEventListener('click', (e) => {
            if (e.target.className == 'tableTop__close') {
                modalSettings.style.display = 'none';
            }
        });
            console.log("here")

    });
}