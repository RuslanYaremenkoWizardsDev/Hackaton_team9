export function changeColors(){
let chengeBtn=document.querySelector('.header__color-theme')
// console.log(chengeBtn)

    chengeBtn.addEventListener("click", ()=>{
        if(chengeBtn.classList.contains("moon")){
            chengeBtn.classList.remove('moon')
            chengeBtn.classList.add('sun')
            chengeBtn.innerHTML="&#9728;"
            chengeBtn.style.color="orange"
            // chengeBtn.setAttribute('src','../../assets/icomoon/PNG/sun.png')
        }
        else if(chengeBtn.classList.contains("sun")){
            chengeBtn.classList.remove('sun')
            chengeBtn.classList.add('moon')
            chengeBtn.innerHTML="&#127769;"

            // chengeBtn.setAttribute('src','../../assets/icomoon/PNG/moon.png')
        }
    })
}