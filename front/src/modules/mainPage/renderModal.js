import {modal} from '..';

export default function renderModal(){
    let settingsBtn=document.querySelector(".header__set-img");
    let settingsBox=document.querySelector('.header__settings');

    settingsBtn.addEventListener("click",(e)=>{
        let modalBox=document.createElement('div')

        modalBox.innerHTML=modal
        settingsBox.appendChild(modalBox)
        let modalSettings = document.querySelector('.header__modal');

        modalSettings.style.display = 'block'
        let modalClose = document.querySelector('.header__close');

        modalClose.addEventListener('click',(e)=>{    
            if (e.target.className == "header__close"){
            modalSettings.style.display = 'none';
            }
        })
    });



}

