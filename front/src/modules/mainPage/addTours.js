export default async function addTours() {
  const res = await fetch('/src/db/tours.json');
  const data = await res.json();
  const tbody = document.querySelector('#toursbody');

  data.forEach(el => {
    tbody.innerHTML += `<tr>
    <td>${el.tourName}</td>
    <td>${el.description}</td>
    <td>${el.place}</td>
    <td>${el.startDate}</td>
    <td>${el.lastRegistration}</td>
    <td>InProgress</td>
    <td>${el.tourLvl}</td>
    <td>${el.players.length}/${el.playerQuantity}</td>
    <td>${el.scenario}</td>
    <td>Actions</td>
  </tr>
`;
  });

}