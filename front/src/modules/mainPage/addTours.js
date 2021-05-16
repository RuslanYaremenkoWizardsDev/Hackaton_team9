export default async function addTours() {
  const res = await fetch('/src/db/tours.json');
  const data = await res.json();
  console.log(data);
}