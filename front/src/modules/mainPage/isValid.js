export default async function isValid() {
  const response = await fetch('http://hackatonteam9.herokuapp.com/account',
    {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem('token')
      }
    });
  if (!response.ok) {
    location.replace('http://localhost:4200/index.html');
  }

  const data = await response.json();
}