const { Router } = require('express');
const { User } = require('./User');
const auth = Router();

auth.post(
  '/login',
  async (req, res) => {
    const user = new User();
    user.login(req, res);
  }
);

auth.post(
  '/registration',
  async (req, res) => {
    const user = new User();
    user.registration(req, res);
  }
);

auth.post(
  '/setting',
  // support.authToken,
  // validation.setting,
  (req, res) => {
    const user = new User();
    user.setting(req, res);
  }
);

// auth.get('/login', support.authToken);
module.exports = auth;