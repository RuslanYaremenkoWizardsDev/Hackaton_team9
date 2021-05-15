import { getFetch, support } from '..';

export async function login(url, body) {
  const sendAuth = await getFetch(url, 'POST', body);
  if (sendAuth.ok) {
    const token = await sendAuth.json();
    support.lsSet(token);
    location.replace('http://localhost:4200/tournaments.html');
  }
}

export async function registration(url, body) {
  const sendAuth = await getFetch(url, 'POST', body);
  if (sendAuth.ok) {
    location.replace('http://localhost:4200/index.html');
  }
}

