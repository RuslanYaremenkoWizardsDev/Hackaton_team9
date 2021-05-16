import { support } from '..';

export default function translateAuth(text, inputs) {
  const lang = support.lsGet('lang');

  for (const key in text) {
    document.getElementById(key).textContent = text[key][lang];
  }
  for (const key in inputs) {
    document.getElementById(key).setAttribute('placeholder', inputs[key][lang]);
  }
}