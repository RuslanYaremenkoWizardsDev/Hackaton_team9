const express = require('express');
const { User } = require('./User');
const routes = require('./routes');

const app = express();

app.use(express.json());

app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept, Authorization');
  res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
  next();
});


app.use('/auth', routes);
async function connect() {
  await User.сonnect();
  app.listen(3000, () => console.log('start'));
}
connect();
