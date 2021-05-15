export default function getFetch(url, method = 'GET', body = null) {
  fetch(`http://localhost:3000${url}`, {
    method,
    body: JSON.stringify(body),
    headers: {
      'Content-Type': 'application/json',
      'Authorization': localStorage.getItem('token')
    }
  });
}