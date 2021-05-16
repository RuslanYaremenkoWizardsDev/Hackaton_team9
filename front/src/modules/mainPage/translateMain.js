import { support, translateTour, tourPlacholder } from '..';
const { lsGet, lsSet } = support;
export default function translateMain() {
  if (!lsGet('lang')) {
    lsSet('lang', 'en');
  }
  translate();
  const langSelect = document.querySelector('#lang');

  langSelect.addEventListener('change', (e) => {
    lsSet('lang', e.target.value);
    translate();
  });
}
function translate() {
  const lang = lsGet('lang');
  for (const key in translateTour) {
    document.getElementById(key).textContent = translateTour[key][lang];
  }
  for (const key in tourPlacholder) {
    document.getElementById(key).setAttribute('placeholder', tourPlacholder[key][lang]);
  }
}