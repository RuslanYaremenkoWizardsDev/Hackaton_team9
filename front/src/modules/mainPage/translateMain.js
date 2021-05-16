import { support } from '..';
const { lsGet, lsSet } = support;
export default function translateMain(text, ipt) {
  if (!lsGet('lang')) {
    lsSet('lang', 'en');
  }
  translate(text, ipt);
  const langSelect = document.querySelector('#lang');
  langSelect.value = lsGet('lang');

  langSelect.addEventListener('change', (e) => {
    lsSet('lang', e.target.value);
    translate(text, ipt);
  });
}

function translate(text, ipt) {
  const lang = lsGet('lang');
  if (lang === 'ar') {
    document.body.style.direction = 'rtl';
  }
  else {
    document.body.style.direction = 'ltr';
  }
  for (const key in text) {
    document.getElementById(key).textContent = text[key][lang];
  }
  for (const key in ipt) {
    document.getElementById(key).setAttribute('placeholder', ipt[key][lang]);
  }
}