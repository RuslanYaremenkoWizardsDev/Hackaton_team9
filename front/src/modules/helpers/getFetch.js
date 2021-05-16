export default function getFetch(url, method = 'GET', body = null) {
  return fetch(`http://hackatonteam9.herokuapp.com${url}`, {
    method,
    body: JSON.stringify(body),
    headers: {
      'Content-Type': 'application/json',
      // 'Authorization': localStorage.getItem('token')
    }
  });
}
